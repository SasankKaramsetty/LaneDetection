package com.example.ride_sharing.models;
import java.lang.*;


//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//// Lombok annotations to reduce boilerplate code (Optional)
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class UpdateCoordinatesRequest {
//
//    private String username;
//    private double currentLatitude;
//    private double currentLongitude;
//
//}
public class UpdateCoordinatesRequest {
    private Long tripId;
    private Double currentLatitude;
    private Double currentLongitude;
    private String otp;

    // Getters and setters
    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Double getCurrentLatitude() {
        return currentLatitude;
    }

    public void setCurrentLatitude(Double currentLatitude) {
        this.currentLatitude = currentLatitude;
    }

    public Double getCurrentLongitude() {
        return currentLongitude;
    }

    public void setCurrentLongitude(Double currentLongitude) {
        this.currentLongitude = currentLongitude;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
