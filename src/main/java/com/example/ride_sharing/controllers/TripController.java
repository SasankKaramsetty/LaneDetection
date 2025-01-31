package com.example.ride_sharing.controllers;
import com.example.ride_sharing.Feedback;
import com.example.ride_sharing.Response;
import com.example.ride_sharing.models.TravelerCompanion;
import com.example.ride_sharing.TripRequest;
import static java.lang.Math.*;
import com.example.ride_sharing.models.UpdateCoordinatesRequest;
import com.example.ride_sharing.models.User;
import com.example.ride_sharing.service.TripService;
import com.example.ride_sharing.Utils.OTPGenerator;
import com.example.ride_sharing.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Make sure to import RestController, RequestMapping, PostMapping, and RequestBody
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.lang.*;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    @Autowired
    private TripService tripService;
    private static final Logger logger = LoggerFactory.getLogger(TripController.class);

    @PostMapping("/createTrip")
    public ResponseEntity<?> createRandomTrip(@RequestBody TripRequest tripRequest) {
        Trip newTrip = new Trip();
        newTrip.setUsername(tripRequest.getUsername());
        newTrip.setDriverName(tripRequest.getDriverName());
        newTrip.setDriverPhoneNumber(tripRequest.getDriverPhoneNumber());
        newTrip.setCabNumber(tripRequest.getCabNumber());
        newTrip.setTravelerCompanions(tripRequest.getTravelerCompanions());
        newTrip.setStatus("active");

        // Generate a random OTP and store it
        String otp = String.valueOf(new Random().nextInt(999999));
        newTrip.setTripOTP(otp);

        // Set initial coordinates
        newTrip.setSourceLatitude(tripRequest.getSourceLatitude());
        newTrip.setSourceLongitude(tripRequest.getSourceLongitude());
        newTrip.setDestinationLatitude(tripRequest.getDestinationLatitude());
        newTrip.setDestinationLongitude(tripRequest.getDestinationLongitude());
        newTrip.setCurrentLatitude(tripRequest.getSourceLatitude());
        newTrip.setCurrentLongitude(tripRequest.getSourceLongitude());

        // Save the trip and generate the URL
        Trip savedTrip = tripService.createTrip(newTrip);
        String tripUrl = "http://localhost:8081/api/trips/" + savedTrip.getId();

        // Return the trip details and the dynamic URL with OTP
        Map<String, Object> response = new HashMap<>();
        response.put("trip", savedTrip);
        response.put("url", tripUrl);
        response.put("otp", otp);  // Send OTP in the response

        return ResponseEntity.ok(new Response("Trip created successfully", true, response));
    }


    //    public ResponseEntity<?> createRandomTrip(@RequestBody TripRequest tripRequest) {
////        System.out.println(tripRequest);
//        Trip newTrip = new Trip();
//        newTrip.setUsername(tripRequest.getUsername());
//        newTrip.setDriverName(tripRequest.getDriverName());
//        newTrip.setDriverPhoneNumber(tripRequest.getDriverPhoneNumber());
//        newTrip.setCabNumber(tripRequest.getCabNumber());
//        newTrip.setTravelerCompanions(tripRequest.getTravelerCompanions());
//        newTrip.setStatus(tripRequest.getStatus());
//        newTrip.setTripOTP(tripRequest.getTripOTP());
//        newTrip.setSourceLatitude(tripRequest.getSourceLatitude());
//        newTrip.setSourceLongitude(tripRequest.getSourceLongitude());
//        newTrip.setDestinationLatitude(tripRequest.getDestinationLatitude());
//        newTrip.setDestinationLongitude(tripRequest.getDestinationLongitude());
//        newTrip.setCurrentLatitude(tripRequest.getSourceLatitude());
//        newTrip.setCurrentLongitude(tripRequest.getSourceLongitude());
//        Trip savedTrip = tripService.createTrip(newTrip); // Use a service method to save the trip
//        return ResponseEntity.ok(savedTrip); // Return the saved trip as the response
//    }
//    @GetMapping("/{tripId}")
//    public ResponseEntity<?> viewTrip(@PathVariable Long tripId) {
//        try {
//            Optional<Trip> tripOptional = tripService.findById(tripId);
//            if (tripOptional.isEmpty()) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                        new Response("Trip not found", false, null));
//            }
//
//            Trip trip = tripOptional.get();
//            if ("completed".equals(trip.getStatus())) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
//                        new Response("This link has expired because the trip is completed", false, null));
//            }
//
//            return ResponseEntity.ok(new Response("Trip details retrieved successfully", true, trip));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
//                    new Response("Internal Server Error", false, null));
//        }
//    }
    @GetMapping("/{tripId}")
    public ResponseEntity<?> viewTrip(@PathVariable Long tripId) {
        Optional<Trip> tripOptional = tripService.findById(tripId);

        if (tripOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new Response("Trip not found", false, null));
        }

        Trip trip = tripOptional.get();

        // Check if the trip is already completed
        if ("completed".equals(trip.getStatus())) {
            return ResponseEntity.status(HttpStatus.GONE).body(
                    new Response("This link has expired as the trip is completed", false, null));
        }

        return ResponseEntity.ok(new Response("Trip details retrieved successfully", true, trip));
    }

    @PostMapping("/viewAllTrips")
    public ResponseEntity<?> viewAllTrips(@RequestBody Map<String, String> request) {
        String username = request.get("username");

        try {
            List<Trip> trips = tripService.findTripsByUsername(username);

            if (trips.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new Response("No trips found for the given username", false, null));
            }

            List<Map<String, Object>> tripDetails = trips.stream().map(trip -> {
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
            }).toList();

            return ResponseEntity.ok(
                    new Response("Trips retrieved successfully", true, Map.of("trips", tripDetails))
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new Response("Internal Server Error", false, null));
        }
    }
    @PostMapping("/{tripId}/addFeedback")
    public ResponseEntity<?> addFeedbackToTrip(@PathVariable Long tripId,
                                               @RequestBody Map<String, String> request) {
        String username = request.get("username");
        String feedback = request.get("feedback");
        System.out.println(feedback);
        // Check if username or feedback is null
        if (username == null || feedback == null) {
            return ResponseEntity.badRequest().body(new Response("Username and feedback must not be null", false, null));
        }

        try {
            // Find the trip by ID
            Optional<Trip> optionalTrip = tripService.findById(tripId);
            if (optionalTrip.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new Response("Trip not found", false, null));
            }

            Trip trip = optionalTrip.get();

            // Add feedback to the trip
            trip.getFeedbacks().add(new Feedback(username, feedback));

            // Save the updated trip
            tripService.saveTrip(trip);

            // Log feedback addition
            System.out.println("Feedback added successfully to trip with trip ID " + tripId + " by " + username + ".");

            return ResponseEntity.ok(new Response("Feedback added successfully", true, trip));
        } catch (Exception e) {
            System.err.println("Error adding feedback to trip: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new Response("Internal Server Error", false, null));
        }
    }

//    @PutMapping("/update-coordinates")
//    public ResponseEntity<?> updateLiveCoordinates(@RequestBody UpdateCoordinatesRequest request) {
//        try {
//            Trip updatedTrip = tripService.updateLiveCoordinates(
//                    request.getUsername(),
//                    request.getCurrentLatitude(),
//                    request.getCurrentLongitude()
//            );
//
//            return ResponseEntity.ok(new Response(
//                    "Coordinates updated successfully", true, updatedTrip
//            ));
//        } catch (Exception e) {
//            logger.error("Error updating coordinates: {}", e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
//                    new Response("Failed to update coordinates: " + e.getMessage(), false, null)
//            );
//        }
//    }


    @PutMapping("/update-coordinates")
    public ResponseEntity<?> updateLiveCoordinates(@RequestBody UpdateCoordinatesRequest request) {
        try {
            Long tripId = request.getTripId();  // Ensure this getter is available

            Optional<Trip> optionalTrip = tripService.findById(tripId);

            if (optionalTrip.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new Response("Trip not found", false, null));
            }

            Trip trip = optionalTrip.get();

            // Calculate the distance to the destination
            double distance = calculateDistance(
                    trip.getDestinationLatitude(), trip.getDestinationLongitude(),
                    request.getCurrentLatitude(), request.getCurrentLongitude());

            if (distance <= 0.5 && trip.getTripOTP().equals(request.getOtp())) {
                trip.setStatus("completed");
                tripService.saveTrip(trip);

                return ResponseEntity.ok(new Response("Trip completed successfully", true, trip));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new Response("Invalid OTP or destination not reached", false, null));
            }
        } catch (Exception e) {
            logger.error("Error updating coordinates: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response("Failed to update coordinates", false, null));
        }
    }
    // Helper method to calculate the distance between two coordinates
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the Earth in kilometers
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Distance in kilometers
    }
}