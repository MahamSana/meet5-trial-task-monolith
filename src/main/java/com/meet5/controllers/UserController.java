package com.meet5.controllers;

import com.meet5.services.VisitService;
import com.meet5.services.LikeService;
import com.meet5.services.FraudDetectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final VisitService visitService;
    private final LikeService likeService;
    private final FraudDetectionService fraudDetectionService;

    // constructor-based dependency injection
    public UserController(VisitService visitService, LikeService likeService, FraudDetectionService fraudDetectionService) {
        this.visitService = visitService;
        this.likeService = likeService;
        this.fraudDetectionService = fraudDetectionService;
    }

    // response indicating that the visit was recorded or flagged as fraudulent.
    @PostMapping("/visit")
    public ResponseEntity<String> recordVisit(@RequestParam Long visitorId, @RequestParam Long visitedId) {

        if (fraudDetectionService.isUserFraudulent(visitorId)) {
            return ResponseEntity.badRequest().body("Fraudulent activity detected. Visit not recorded.");
        }

        visitService.recordVisit(visitorId, visitedId);
        return ResponseEntity.ok("Visit recorded successfully.");
    }

    // response indicating that the like was recorded or flagged as fraudulent.
    @PostMapping("/like")
    public ResponseEntity<String> recordLike(@RequestParam Long likerId, @RequestParam Long likedId) {

        if (fraudDetectionService.isUserFraudulent(likerId)) {
            return ResponseEntity.badRequest().body("Fraudulent activity detected. Like not recorded.");
        }

        likeService.recordLike(likerId, likedId);
        return ResponseEntity.ok("Like recorded successfully.");
    }
}
