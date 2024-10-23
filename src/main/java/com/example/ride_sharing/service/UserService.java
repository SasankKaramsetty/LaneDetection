package com.example.ride_sharing.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    // This should be replaced with an actual UserRepository for database interaction
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username); // Fetch user by username
    }

    public void save(User user) {
        userRepository.save(user); // Save user changes
    }
}
