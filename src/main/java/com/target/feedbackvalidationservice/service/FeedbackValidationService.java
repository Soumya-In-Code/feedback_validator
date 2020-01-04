package com.target.feedbackvalidationservice.service;

import com.target.feedbackvalidationservice.model.FeedbackValidationServiceResponse;

public interface FeedbackValidationService {

	public FeedbackValidationServiceResponse feedbackValidator(String userId, String feedback, String productId);
	
}
