package com.example.ride_sharing.service;

import com.example.ride_sharing.config.TwilioConfig;
import com.example.ride_sharing.dto.OTPData;
import com.example.ride_sharing.dto.OTPResponse;
import com.example.ride_sharing.dto.OtpStatus;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.text.DecimalFormat;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class TwilioOTPService {
    @Autowired
    private TwilioConfig twilioConfig;
    Map<String, String> otpMap = new HashMap<>();
    public Mono<OTPResponse> getotpService(OTPData otpData){
        OTPResponse otpResponse = null;
        try {
            PhoneNumber to = new PhoneNumber(otpData.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
            String otp = generateOTP();
            String otpMessage = "Dear Customer , Your OTP is ##" + otp + "##. Use this Passcode to complete your transaction. Thank You.";
            Message message = Message
                    .creator(to, from,
                            otpMessage)
                    .create();
            otpMap.put(otpData.getUserName(), otp);
            otpResponse = new OTPResponse(OtpStatus.DELIVERED, otpMessage);
        } catch (Exception ex) {
            otpResponse = new OTPResponse(OtpStatus.FAILED, ex.getMessage());
        }
        return Mono.just(otpResponse);
    }
    public Mono<String> validateOTP(String userInputOtp, String userName) {
        if (userInputOtp.equals(otpMap.get(userName))) {
            otpMap.remove(userName,userInputOtp);
            return Mono.just("Valid OTP please proceed with your transaction !");
        } else {
            return Mono.error(new IllegalArgumentException("Invalid otp please retry !"));
        }
    }
    private String generateOTP() {
        return new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
    }
}
