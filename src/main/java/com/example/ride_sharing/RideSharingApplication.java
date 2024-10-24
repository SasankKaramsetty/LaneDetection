package com.example.ride_sharing;

import com.example.ride_sharing.config.TwilioConfig;
import com.twilio.Twilio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
@SpringBootApplication
public class RideSharingApplication {
	@Autowired
	private TwilioConfig twilioConfig;

	@PostConstruct
	public void initTwilio(){
		Twilio.init(twilioConfig.getAccountSid(),twilioConfig.getAuthToken());
	}
	public static void main(String[] args) {
		 SpringApplication.run(RideSharingApplication.class, args);
		System.out.println("server started!!");
	}
}
