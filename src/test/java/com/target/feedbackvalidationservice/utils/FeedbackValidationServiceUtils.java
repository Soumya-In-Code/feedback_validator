package com.target.feedbackvalidationservice.utils;

import com.target.feedbackvalidationservice.model.FeedbackValidationServiceResponse;

public class FeedbackValidationServiceUtils {
	
	private static String USER_ID = "U1"; 
	
	private static String PRODUCT_ID = "P1"; 
	
	private static String FEEDBACK = "Nice product"; 
	
	private static boolean PUBLISH = true; 
	
	
	public static FeedbackValidationServiceResponse getFeedbackValidationServiceResponse() {
		FeedbackValidationServiceResponse feedbackValidationServiceResponse = new FeedbackValidationServiceResponse();
		feedbackValidationServiceResponse.setFeedback(FEEDBACK);
		feedbackValidationServiceResponse.setProductId(PRODUCT_ID);
		feedbackValidationServiceResponse.setPublish(PUBLISH);
		feedbackValidationServiceResponse.setUserId(USER_ID);
		return feedbackValidationServiceResponse;
	}
	
}
