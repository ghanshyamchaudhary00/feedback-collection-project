//package com.shelfex.feedback.controller;
//
//import com.shelfex.feedback.dto.FeedbackRequest;
//import com.shelfex.feedback.model.Feedback;
//import com.shelfex.feedback.service.FeedbackService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController // Marks this class as a REST controller
//@RequestMapping("/api/feedback") // Base path for all endpoints in this controller
//@CrossOrigin(origins = "http://localhost:3000") // Allows requests from your React frontend during development
//public class FeedbackController {
//
//    @Autowired // Injects the FeedbackService instance
//    private FeedbackService feedbackService;
//
//    @PostMapping // Handles POST requests to /api/feedback
//    public ResponseEntity<Feedback> submitFeedback(@Valid @RequestBody FeedbackRequest feedbackRequest) {
//        // @Valid triggers validation based on annotations in FeedbackRequest DTO
//        // @RequestBody converts JSON request body into FeedbackRequest object
//        Feedback savedFeedback = feedbackService.submitFeedback(feedbackRequest);
//        return new ResponseEntity<>(savedFeedback, HttpStatus.CREATED); // Return 201 Created status
//    }
//}




package com.shelfex.feedback.controller;

import com.shelfex.feedback.dto.FeedbackRequest;
import com.shelfex.feedback.model.Feedback;
import com.shelfex.feedback.model.WebSocketMessage;
import com.shelfex.feedback.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate; // Inject SimpMessagingTemplate
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate; // For sending WebSocket messages

    @PostMapping
    public ResponseEntity<Feedback> submitFeedback(@Valid @RequestBody FeedbackRequest feedbackRequest) {
        Feedback savedFeedback = feedbackService.submitFeedback(feedbackRequest);

        // Send a WebSocket message to /topic/newFeedback
        messagingTemplate.convertAndSend("/topic/newFeedback", new WebSocketMessage("newFeedback", savedFeedback));

        return new ResponseEntity<>(savedFeedback, HttpStatus.CREATED);
    }
}