package com.example.ride_sharing;

import java.util.logging.Logger;
import com.twilio.Twilio;
import com.twilio.credential.ClientCredentialProvider;
import com.twilio.rest.api.v2010.account.Message;

public class NotificationService {
    private static final Logger logger = Logger.getLogger(NotificationService.class.getName());

    // Method to send a notification (via WhatsApp or SMS)
    public static void notify(String toPhoneNumber, String message, boolean isWhatsApp) {
        try {
            if (isWhatsApp) {
                sendWhatsAppMessage(toPhoneNumber, message);
            } else {
                sendSMSMessage(toPhoneNumber, message); // Placeholder for SMS notifications
            }
            logNotification(toPhoneNumber, message);
        } catch (Exception e) {
            logger.severe("Failed to send notification to " + toPhoneNumber + ": " + e.getMessage());
        }
    }

    // Method to send a WhatsApp message
    private static void sendWhatsAppMessage(String toPhoneNumber, String message) {
        // Logic to send a WhatsApp message using Twilio or any other service
        String accountSid = "AC9ff07545ab5c17c3f82563d1065d3156"; // Add your Twilio account SID
        String authToken = "cbad17d0e2afcc5e5acdc10b0c644c84"; // Add your Twilio auth token
        com.twilio.rest.api.v2010.account.Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:" + toPhoneNumber),
                new com.twilio.type.PhoneNumber("whatsapp:+918328596959"), // Your Twilio WhatsApp number
                message).create();

        logger.info("WhatsApp message sent to: " + toPhoneNumber);
    }

    // Method to send an SMS message (if needed in the future)
    private static void sendSMSMessage(String toPhoneNumber, String message) {
        // Logic for sending SMS messages can be added here similarly
        logger.info("SMS message sent to: " + toPhoneNumber);
    }

    // Method to log notifications sent (optional)
    private static void logNotification(String phoneNumber, String message) {
        logger.info("Notification sent to " + phoneNumber + ": " + message);
    }
}
