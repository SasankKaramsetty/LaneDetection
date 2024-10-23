package com.example.ride_sharing;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
public class AuditTrailService {
    private static final Map<UUID, String> auditLog = new HashMap<>();

    public static void logTripEvent(UUID travelerId, String message) {
        // Log the event with traveler ID and the corresponding message
        auditLog.put(travelerId, message);
        System.out.println("Audit Log: Traveler ID " + travelerId + " - " + message);
    }

    // Method to get logs (can be extended further)
    public static Map<UUID, String> getAuditLog() {
        return auditLog;
    }
}
