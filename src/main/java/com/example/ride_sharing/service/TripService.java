package com.example.ride_sharing.service;

import com.example.ride_sharing.TripRequest;
import com.example.ride_sharing.models.Trip;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

@Service
public class TripService {

    @Autowired
    private UserService userService; // Inject UserService for user operations

    // This should be replaced with an actual TripRepository for database interaction
    private TripRepository tripRepository;

    public Trip createTrip(TripRequest tripRequest) {
        // Generate trip ID, OTP, and set up the Trip object
        Trip newTrip = new Trip();
        newTrip.setUsername(tripRequest.getUsername());
        newTrip.setDriverName("Raj Yadav");
        newTrip.setDriverPhoneNumber("9997186212");
        newTrip.setCabNumber("UP14 AC 5697");
        newTrip.setTravelerCompanions(tripRequest.getTravelerCompanions());
        newTrip.setStatus("ongoing");
        newTrip.setTripOTP(generateOTP());
        newTrip.setSourceLatitude(tripRequest.getSourceLatitude());
        newTrip.setSourceLongitude(tripRequest.getSourceLongitude());
        newTrip.setDestinationLatitude(tripRequest.getDestinationLatitude());
        newTrip.setDestinationLongitude(tripRequest.getDestinationLongitude());
        newTrip.setCurrentLatitude(tripRequest.getSourceLatitude());
        newTrip.setCurrentLongitude(tripRequest.getSourceLongitude());

        // Save the new trip to the repository
        tripRepository.save(newTrip);
        return newTrip;
    }

    private String generateOTP() {
        return String.valueOf(100000 + new Random().nextInt(900000)); // Generate a 6-digit OTP
    }
}

