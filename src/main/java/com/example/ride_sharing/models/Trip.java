package com.example.ride_sharing.models;

import com.example.ride_sharing.Feedback;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

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
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Cascade operations and orphan removal
//    private List<TravelerCompanion> travelerCompanions = new ArrayList<>();
    private List<String>travelerCompanions = new ArrayList<>();
    private String status;
    private String tripOTP;
    private boolean linkActive = true;
    private double sourceLatitude;
    private double sourceLongitude;
    private double destinationLatitude;
    private double destinationLongitude;
    private double currentLatitude;
    private double currentLongitude;
    @OneToMany(cascade = CascadeType.ALL) // Cascade operations and orphan removal
    private List<Feedback> feedbacks = new ArrayList<>();
}
