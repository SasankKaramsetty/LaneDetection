package com.example.ride_sharing.models;
public class Location {
    private double latitude;
    private double longitude;

    // Constructor
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    // Distance between two locations using Euclidean distance
    public double distanceTo(Location other) {
        double latDiff = other.latitude - this.latitude;
        double lonDiff = other.longitude - this.longitude;
        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff);
    }

    // toString for easy printing of Location
    @Override
    public String toString() {
        return "Location [latitude=" + latitude + ", longitude=" + longitude + "]";
    }

    // Equals and hashCode for comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location other = (Location) obj;
        return Double.compare(other.latitude, latitude) == 0 &&
               Double.compare(other.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(latitude, longitude);
    }
}
