package com.example.ride_sharing.service;

import com.example.ride_sharing.TripRepository;
import com.example.ride_sharing.models.Trip;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Random;
import java.util.List;

@Service
public class TripService {

    @Autowired

    // This should be replaced with an actual TripRepository for database interaction
    private TripRepository tripRepository;

    public Trip createTrip(Trip trip) {

        // Save the new trip to the repository
        tripRepository.save(trip);
        return trip;
    }

    private String generateOTP() {
        return String.valueOf(100000 + new Random().nextInt(900000)); // Generate a 6-digit OTP
    }
    public Optional<Trip> findById(Long id) {
        return tripRepository.findById(id);
    }
    public List<Trip> findTripsByUsername(String username) {
        return tripRepository.findByUsername(username);
    }
    public Trip saveTrip(Trip trip) {
        return tripRepository.save(trip);
//        return trip;
    }
}

