package com.example.ride_sharing;

import com.example.ride_sharing.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    // You can define custom query methods if needed, like finding trips by status or username
    List<Trip> findByUsername(String username);
//    Optional<Trip> findByUsernameAndStatus(String username, String status);
}
