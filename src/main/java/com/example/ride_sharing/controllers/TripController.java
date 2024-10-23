package com.example.ride_sharing.controllers;
import com.example.ride_sharing.Response;
import com.example.ride_sharing.models.TravelerCompanion;
import com.example.ride_sharing.TripRequest;
import com.example.ride_sharing.models.User;
import com.example.ride_sharing.service.TripService;
import com.example.ride_sharing.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Make sure to import RestController, RequestMapping, PostMapping, and RequestBody
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping("/createTrip")
    public ResponseEntity<?> createRandomTrip(@RequestBody TripRequest tripRequest) {
        // Hardcode trip details
        Trip newTrip = new Trip();
        newTrip.setUsername(tripRequest.getUsername());
        newTrip.setDriverName(tripRequest.getDriverName());
        newTrip.setDriverPhoneNumber(tripRequest.getDriverPhoneNumber());
        newTrip.setCabNumber(tripRequest.getCabNumber());
        newTrip.setTravelerCompanions(tripRequest.getTravelerCompanions());
        newTrip.setStatus(tripRequest.getStatus());
        newTrip.setTripOTP(tripRequest.getTripOTP());
        newTrip.setSourceLatitude(tripRequest.getSourceLatitude());
        newTrip.setSourceLongitude(tripRequest.getSourceLongitude());
        newTrip.setDestinationLatitude(tripRequest.getDestinationLatitude());
        newTrip.setDestinationLongitude(tripRequest.getDestinationLongitude());
        newTrip.setCurrentLatitude(tripRequest.getSourceLatitude());
        newTrip.setCurrentLongitude(tripRequest.getSourceLongitude());
        Trip savedTrip = tripService.createTrip(newTrip); // Use a service method to save the trip
        return ResponseEntity.ok(savedTrip); // Return the saved trip as the response
    }

}
