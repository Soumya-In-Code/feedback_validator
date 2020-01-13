package com.target.feedbackvalidationservice.service;

import com.target.feedbackvalidationservice.model.FeedbackValidationServiceResponse;

/**
 * @author soumya.in.coding
 * 
 */

public interface FeedbackValidationService {

	public FeedbackValidationServiceResponse feedbackValidator(String userId, String feedback, String productId);
	
}
