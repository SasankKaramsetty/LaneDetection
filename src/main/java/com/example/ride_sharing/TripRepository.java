package com.example.ride_sharing;

import com.example.ride_sharing.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    // You can define custom query methods if needed, like finding trips by status or username
}
