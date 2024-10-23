package com.example.ride_sharing;
//
//import java.util.List;
//
//public class TripRequest {
//
//    // Fields representing trip details
//    private Traveler traveler;
//    private List<TravelerCompanion> companions;
//    private double sourceLatitude;
//    private double sourceLongitude;
//    private double destinationLatitude;
//    private double destinationLongitude;
//
//    // Constructor for initializing the TripRequest object
//    public TripRequest(Traveler traveler, List<TravelerCompanion> companions,
//                       double sourceLatitude, double sourceLongitude,
//                       double destinationLatitude, double destinationLongitude) {
//        this.traveler = traveler;
//        this.companions = companions;
//        this.sourceLatitude = sourceLatitude;
//        this.sourceLongitude = sourceLongitude;
//        this.destinationLatitude = destinationLatitude;
//        this.destinationLongitude = destinationLongitude;
//    }
//
//    // Getters for each field
//    public Traveler getTraveler() {
//        return traveler;
//    }
//
//    public void setTraveler(Traveler traveler) {
//        this.traveler = traveler;
//    }
//
//    public List<TravelerCompanion> getCompanions() {
//        return companions;
//    }
//
//    public void setCompanions(List<TravelerCompanion> companions) {
//        this.companions = companions;
//    }
//
//    public double getSourceLatitude() {
//        return sourceLatitude;
//    }
//
//    public void setSourceLatitude(double sourceLatitude) {
//        this.sourceLatitude = sourceLatitude;
//    }
//
//    public double getSourceLongitude() {
//        return sourceLongitude;
//    }
//
//    public void setSourceLongitude(double sourceLongitude) {
//        this.sourceLongitude = sourceLongitude;
//    }
//
//    public double getDestinationLatitude() {
//        return destinationLatitude;
//    }
//
//    public void setDestinationLatitude(double destinationLatitude) {
//        this.destinationLatitude = destinationLatitude;
//    }
//
//    public double getDestinationLongitude() {
//        return destinationLongitude;
//    }
//
//    public void setDestinationLongitude(double destinationLongitude) {
//        this.destinationLongitude = destinationLongitude;
//    }
//}
import java.util.List;

public class TripRequest {
    private String username;
    private List<String> travelerCompanions;
    private double sourceLatitude;
    private double sourceLongitude;
    private double destinationLatitude;
    private double destinationLongitude;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getTravelerCompanions() {
        return travelerCompanions;
    }

    public void setTravelerCompanions(List<String> travelerCompanions) {
        this.travelerCompanions = travelerCompanions;
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
}
