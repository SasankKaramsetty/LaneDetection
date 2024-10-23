package com.example.ride_sharing.models;

//import java.util.ArrayList;
import java.util.List;
//import java.util.UUID;
//
//public class Trip {
//
//    // Trip details
//    private UUID tripId;
//    private String driverName;
//    private String driverPhoneNumber;
//    private String cabNumber;
//    private Location startLocation;
//    private Location endLocation;
//    private Location currentLocation;
//    private TripStatus status;
//    private Traveler traveler;
//    private List<TravelerCompanion> companions;
//    private List<String> feedback;
//    private String tripOTP; // Added for OTP
//
//    // Constructor
//    public Trip(Location start, Location end, String driverName, String driverPhoneNumber,
//                String cabNumber, Traveler traveler) {
//        this.tripId = UUID.randomUUID(); // Generate unique ID
//        this.startLocation = start;
//        this.endLocation = end;
//        this.currentLocation = start;
//        this.driverName = driverName;
//        this.driverPhoneNumber = driverPhoneNumber;
//        this.cabNumber = cabNumber;
//        this.status = TripStatus.NOT_STARTED;
//        this.traveler = traveler;
//        this.companions = new ArrayList<>();
//        this.feedback = new ArrayList<>();
//        this.tripOTP = generateTripOTP(); // Generate OTP upon trip creation
//    }
//
//    // Method to create a trip
//    public static Trip createTrip(Traveler traveler, List<TravelerCompanion> travelerCompanions,
//                                  double sourceLatitude, double sourceLongitude,
//                                  double destinationLatitude, double destinationLongitude) {
//        // Check if the traveler already has an ongoing trip
//        if (traveler.isTraveler()) {
//            System.out.println("You already have an ongoing trip.");
//            return null;
//        }
//
//        // Validate traveler companions
//        for (TravelerCompanion companion : travelerCompanions) {
//            if (!companion.exists()) {
//                System.out.println("Travel companion " + companion.getName() + " doesn't exist.");
//                return null;
//            }
//        }
//
//        // Create trip details
//        String driverName = "Raj Yadav";
//        String driverPhoneNumber = "9997186212";
//        String cabNumber = "UP14 AC 5697";
//
//        // Create a new trip instance
//        Trip newTrip = new Trip(
//                new Location(sourceLatitude, sourceLongitude),
//                new Location(destinationLatitude, destinationLongitude),
//                driverName,
//                driverPhoneNumber,
//                cabNumber,
//                traveler
//        );
//
//        // Add companions to the trip
//        newTrip.companions.addAll(travelerCompanions);
//
//        // Notify companions
//        String tripLink = "http://localhost:5000/api/trips/viewTrip/" + newTrip.getTripId();
//        for (TravelerCompanion companion : travelerCompanions) {
//            NotificationService.notify(companion.getPhoneNumber(),
//                    "Your friend " + traveler.getName() + " has started a trip with us. View details: " + tripLink,
//                    true);
//        }
//
//        System.out.println("Trip for " + traveler.getName() + " with trip ID " + newTrip.getTripId() + " created successfully.");
//
//        return newTrip;
//    }
//
//    // Getters for trip details
//    public UUID getTripId() { return tripId; }
//    public TripStatus getStatus() { return status; }
//    public Location getCurrentLocation() { return currentLocation; }
//    public List<String> getFeedback() { return feedback; }
//    public String getTripOTP() { return tripOTP; }
//
//    // New Getter for Companions
//    public List<TravelerCompanion> getCompanions() {
//        return companions;
//    }
//
//    // Method to start the trip
//    public void startTrip() {
//        if (status != TripStatus.NOT_STARTED) {
//            System.out.println("Trip already started or completed.");
//            return;
//        }
//        this.status = TripStatus.IN_PROGRESS;
//        AuditTrailService.logTripEvent(traveler.getId(), "Trip started.");
//        System.out.println("Trip started from: " + startLocation);
//    }
//
//    // Method to add feedback to the trip
//    public void addFeedback(String feedback) {
//        this.feedback.add(feedback);
//        System.out.println("Feedback added: " + feedback);
//    }
//
//    // Method to generate a trip OTP
//    private String generateTripOTP() {
//        return String.valueOf(100000 + (int)(Math.random() * 900000));
//    }
//}
public class Trip {
    private String id;  // Trip ID
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

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }

    public String getCabNumber() {
        return cabNumber;
    }

    public void setCabNumber(String cabNumber) {
        this.cabNumber = cabNumber;
    }

    public List<String> getTravelerCompanions() {
        return travelerCompanions;
    }

    public void setTravelerCompanions(List<String> travelerCompanions) {
        this.travelerCompanions = travelerCompanions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTripOTP() {
        return tripOTP;
    }

    public void setTripOTP(String tripOTP) {
        this.tripOTP = tripOTP;
    }

    public double getSourceLatitude() {
        return sourceLatitude;
    }

    public void setSourceLatitude(double sourceLatitude) {
        this.sourceLatitude = sourceLatitude;
    }

    public double getSourceLongitude() {
        return sourceLongitude;
    }

    public void setSourceLongitude(double sourceLongitude) {
        this.sourceLongitude = sourceLongitude;
    }

    public double getDestinationLatitude() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(double destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }

    public double getDestinationLongitude() {
        return destinationLongitude;
    }

    public void setDestinationLongitude(double destinationLongitude) {
        this.destinationLongitude = destinationLongitude;
    }

    public double getCurrentLatitude() {
        return currentLatitude;
    }

    public void setCurrentLatitude(double currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    public double getCurrentLongitude() {
        return currentLongitude;
    }

    public void setCurrentLongitude(double currentLongitude) {
        this.currentLongitude = currentLongitude;
    }
}
