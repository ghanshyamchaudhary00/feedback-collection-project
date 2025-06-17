//package com.shelfex.feedback.dto;
//
//import lombok.Data;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Email;
//
//@Data // Lombok annotation
//public class FeedbackRequest {
//
//    private String name;
//
//    @Email(message = "Invalid email format") // Basic email validation
//    private String email;
//
//    @NotBlank(message = "Feedback text cannot be empty") // Ensures the field is not null, empty, or whitespace only
//    private String feedbackText;
//
//    @NotNull(message = "Rating cannot be null") // Ensures rating is provided
//    @Min(value = 1, message = "Rating must be at least 1")
//    @Max(value = 5, message = "Rating must be at most 5")
//    private Integer rating;
//
//    // For simplicity, we'll hardcode a productId for now or make it optional for initial setup
//    private String productId; // This can be null for anonymous overall feedback, or required for specific product feedback
//}

//package com.shelfex.feedback.dto;
//
//import lombok.Data;
//// Remove validation imports
//// import jakarta.validation.constraints.Max;
//// import jakarta.validation.constraints.Min;
//// import jakarta.validation.constraints.NotBlank;
//// import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank; // Keep this for feedbackText
//
//@Data
//public class FeedbackRequest {
//    private String name;
//    @Email(message = "Invalid email format")
//    private String email;
//    @NotBlank(message = "Feedback text cannot be empty") // Keep feedbackText as mandatory
//    private String feedbackText;
//    // Removed @NotNull, @Min, @Max for rating
//    private Integer rating; // Make rating optional
//    private String productId;
//}


package com.shelfex.feedback.dto;

import lombok.Data;
import jakarta.validation.constraints.Max; // Re-add this import
import jakarta.validation.constraints.Min; // Re-add this import
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull; // Re-add this import
import jakarta.validation.constraints.Email;

@Data
public class FeedbackRequest {
    private String name;
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Feedback text cannot be empty")
    private String feedbackText;
    @NotNull(message = "Rating cannot be null") // Re-add
    @Min(value = 1, message = "Rating must be at least 1") // Re-add
    @Max(value = 5, message = "Rating must be at most 5") // Re-add
    private Integer rating;
    private String productId;
}