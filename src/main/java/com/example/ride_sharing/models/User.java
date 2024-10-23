package com.example.ride_sharing.models;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private boolean isTraveler;
    private String phoneNo;
    private boolean isTravelerCompanion;
    private List<String> travelerCompanionFor;

    public User() {
        this.travelerCompanionFor = new ArrayList<>();
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isTraveler() {
        return isTraveler;
    }

    public void setTraveler(boolean traveler) {
        isTraveler = traveler;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public boolean isTravelerCompanion() {
        return isTravelerCompanion;
    }

    public void setTravelerCompanion(boolean travelerCompanion) {
        isTravelerCompanion = travelerCompanion;
    }

    public List<String> getTravelerCompanionFor() {
        return travelerCompanionFor;
    }

    public void setTravelerCompanionFor(List<String> travelerCompanionFor) {
        this.travelerCompanionFor = travelerCompanionFor;
    }
}
