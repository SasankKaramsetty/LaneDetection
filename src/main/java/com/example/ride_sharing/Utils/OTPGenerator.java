package com.example.ride_sharing.Utils;

import java.util.Random;
import java.lang.String;
public class OTPGenerator {
    public static String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);  // Generate 6-digit OTP
        return String.valueOf(otp);
    }
}
