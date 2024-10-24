package com.example.ride_sharing.service;
//
//import com.example.ride_sharing.Feedback;
//import com.example.ride_sharing.FeedbackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class FeedbackService {
//
//    @Autowired
//    private FeedbackRepository feedbackRepository;
//
//    // Retrieve all feedbacks
//    public List<Feedback> findAllFeedbacks() {
//        return feedbackRepository.findAll();
//    }
//
//    // Retrieve feedbacks by username
//    public List<Feedback> findFeedbacksByUsername(String username) {
//        return feedbackRepository.findByUsername(username);
//    }
//
//    // Retrieve feedbacks for a specific trip
//    public List<Feedback> findFeedbacksByTripId(Long tripId) {
//        return feedbackRepository.findByTripId(tripId);
//    }
//
//    // Save new feedback
//    public Feedback saveFeedback(Feedback feedback) {
//        return feedbackRepository.save(feedback);
//    }
//}