package com.example.ride_sharing.models;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok annotations to reduce boilerplate code (Optional)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCoordinatesRequest {

    private String username;
    private double currentLatitude;
    private double currentLongitude;

}
