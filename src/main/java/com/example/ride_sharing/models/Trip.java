package com.example.ride_sharing.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the ID
    private Long id;  // Trip ID (changed to Long)

    private String username;
    private String driverName;
    private String driverPhoneNumber;
    private String cabNumber;
    private List<String> travelerCompanions;
    private String status;
    private String tripOTP;
    private double sourceLatitude;
    private double sourceLongitude;
    private double destinationLatitude;
    private double destinationLongitude;
    private double currentLatitude;
    private double currentLongitude;

    // You can add constructors if necessary
}
