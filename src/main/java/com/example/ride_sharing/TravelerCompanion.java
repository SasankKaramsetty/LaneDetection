package com.example.ride_sharing;

import java.util.UUID;

public class TravelerCompanion {
    private UUID id; // Unique identifier for the companion
    private String name;
    private String phoneNumber;

    // Constructor
    public TravelerCompanion(String name, String phoneNumber) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

//    // Check if the companion exists in the database
//    public boolean exists() {
//        // Logic to check if the companion exists (e.g., querying the database)
//        // For this example, we'll assume they always exist.
//        return true; // Replace this with actual existence check logic
//    }

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
}
