package com.example.ride_sharing.models;
import java.util.UUID;

public class Traveler {
    private UUID id; // Unique identifier for the traveler
    private String name;
    private String phoneNumber;
    private boolean isTraveler; // Indicates if the traveler is currently on a trip

    // Constructor
    public Traveler(String name, String phoneNumber) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isTraveler = false; // Initially, the traveler is not on a trip
    }

    // Method to mark the traveler as being on a trip
    public void startTrip() {
        this.isTraveler = true;
    }

    // Method to mark the traveler as not being on a trip
    public void endTrip() {
        this.isTraveler = false;
    }

    // Check if the traveler is currently on a trip
    public boolean isTraveler() {
        return isTraveler;
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

//    // Add companion trip ID
//    public void addCompanionTrip(UUID tripId) {
//        travelerCompanionFor.add(tripId);
//    }
}
