package com.target.feedbackvalidationservice.utils;

import com.target.feedbackvalidationservice.model.FeedbackValidationServiceResponse;

/**
 * @author soumya.in.coding
 * 
 */

public class FeedbackValidationServiceUtils {
	
	public static String USER_ID = "U1"; 
	
	public static String PRODUCT_ID = "P1"; 
	
	public static String GOOD_FEEDBACK = "Nice product"; 
	
	public static String BAD_FEEDBACK = "crap"; 
	
	private static boolean PUBLISH = true; 
	
	
	public static FeedbackValidationServiceResponse getFeedbackValidationServiceResponse() {
		FeedbackValidationServiceResponse feedbackValidationServiceResponse = new FeedbackValidationServiceResponse();
		feedbackValidationServiceResponse.setFeedback(GOOD_FEEDBACK);
		feedbackValidationServiceResponse.setProductId(PRODUCT_ID);
		feedbackValidationServiceResponse.setPublish(PUBLISH);
		feedbackValidationServiceResponse.setUserId(USER_ID);
		return feedbackValidationServiceResponse;
	}
	
}
