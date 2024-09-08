package com.meet5.services;

import org.springframework.stereotype.Service;

@Service
public class FraudDetectionService {

    private final VisitService visitService;
    private final LikeService likeService;

    // constructor-based dependency injection
    public FraudDetectionService(VisitService visitService, LikeService likeService) {
        this.visitService = visitService;
        this.likeService = likeService;
    }

    // returns true if the user is flagged for suspicious activity, false otherwise */
    public boolean isUserFraudulent(Long userId) {

        int recentVisits = visitService.getRecentVisitCount(userId);
        int recentLikes = likeService.getRecentLikeCount(userId);

        int fraudThreshold = 100; // max attempts

        // check if the total recent interactions exceed the fraud threshold
        return (recentVisits + recentLikes) > fraudThreshold;
    }
}
