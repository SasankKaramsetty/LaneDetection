//package com.example.ride_sharing.controllers;
//
//import com.example.ride_sharing.service.TwilioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/twilio")
//public class TwilioController {
//
//    @Autowired
//    private TwilioService twilioService;
//
//    @PostMapping("/send-sms")
//    public String sendSms(@RequestParam String to, @RequestParam String body) {
//        twilioService.sendSms(to, body);
//        return "SMS sent successfully!";
//    }
//}