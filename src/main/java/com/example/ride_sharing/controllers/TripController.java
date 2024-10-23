package com.example.ride_sharing.controllers;

import com.example.ride_sharing.Response;
import com.example.ride_sharing.TripRequest;
import com.example.ride_sharing.service.TripService;
import com.example.ride_sharing.service.UserService;
import com.example.ride_sharing.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Make sure to import RestController, RequestMapping, PostMapping, and RequestBody
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    @Autowired
    private UserService userService;

    @Autowired
    private TripService tripService;

    @PostMapping("/createTrip")
    public ResponseEntity<?> createTrip(@RequestBody TripRequest tripRequest) {
        try {
            User user = userService.findByUsername(tripRequest.getUsername());
            if (user.isTraveler()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("You already have an ongoing trip", false, null));
            }

            List<String> companions = tripRequest.getTravelerCompanions();
            for (String companionUsername : companions) {
                User companion = userService.findByUsername(companionUsername);
                if (companion == null) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Travel companion " + companionUsername + " doesn't exist.", false, null));
                }
            }

            // Create a new trip using the tripService
            Trip newTrip = tripService.createTrip(tripRequest);

            // Logic for sending messages using Twilio or another messaging service can be added here

            return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Trip created successfully", true, newTrip.getId()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("Internal Server Error", false, null));
        }
    }
}
