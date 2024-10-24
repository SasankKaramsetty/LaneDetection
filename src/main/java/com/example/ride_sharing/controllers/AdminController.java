package com.example.ride_sharing.controllers;

import com.example.ride_sharing.Response;
import com.example.ride_sharing.models.Trip;
import com.example.ride_sharing.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private TripService tripService;

    // Method 1: /viewAllTrips
    @GetMapping("/viewAllTrips")
    public ResponseEntity<?> viewAllTrips() {
        try {
            List<Trip> allTrips = tripService.findAllTrips();

            if (allTrips.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new Response("No trips found", false, null));
            }

            List<Map<String, Object>> tripDetails = allTrips.stream().map(trip -> {
                Map<String, Object> tripMap = new HashMap<>();
                tripMap.put("driverName", trip.getDriverName());
                tripMap.put("driverPhoneNumber", trip.getDriverPhoneNumber());
                tripMap.put("cabNumber", trip.getCabNumber());
                tripMap.put("status", trip.getStatus());
                tripMap.put("sourceLatitude", trip.getSourceLatitude());
                tripMap.put("sourceLongitude", trip.getSourceLongitude());
                tripMap.put("destinationLatitude", trip.getDestinationLatitude());
                tripMap.put("destinationLongitude", trip.getDestinationLongitude());
                return tripMap;
            }).collect(Collectors.toList());

            return ResponseEntity.ok(
                    new Response("All trips retrieved successfully", true, Map.of("trips", tripDetails))
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new Response("Internal Server Error", false, null));
        }
    }

    // Method 2: /viewTrip/{tripId}
    @GetMapping("/viewTrip/{tripId}")
    public ResponseEntity<?> viewTrip(@PathVariable Long tripId) {
        try {
            Optional<Trip> tripOptional = tripService.findById(tripId);
            if (tripOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new Response("Trip not found", false, null));
            }

            Trip trip = tripOptional.get();
            if ("completed".equals(trip.getStatus())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new Response("This link has expired because the trip is completed", false, null));
            }

            return ResponseEntity.ok(new Response("Trip details retrieved successfully", true, trip));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new Response("Internal Server Error", false, null));
        }
    }
}
