package com.target.feedbackvalidationservice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.target.feedbackvalidationservice.model.FeedbackValidationServiceResponse;
import com.target.feedbackvalidationservice.service.TernarySearchTree;
import com.target.feedbackvalidationservice.serviceImpl.FeedbackValidationServiceImpl;
import com.target.feedbackvalidationservice.utils.FeedbackValidationServiceUtils;

/**
 * @author soumya.in.coding
 * 
 */

public class FeedbackValidationServiceTest extends FeedbackValidationServiceApplicationTest {
	
	@Autowired
	private FeedbackValidationServiceImpl feedbackValidationServiceImpl;
	
	@Mock
	private TernarySearchTree ternarySearchTree;

	@InjectMocks
	private FeedbackValidationServiceUtils utils;

	@Test(expected = Exception.class)
	public void feedbackValidatorFail() throws Exception {
		Mockito.when(ternarySearchTree.search(Mockito.anyString()))
				.thenThrow(Exception.class);
		feedbackValidationServiceImpl.feedbackValidator(Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
	}	
	
	@Test
	public void retrieveDocumentTrackingInfoSuccess() throws Exception {
		try {
			FeedbackValidationServiceResponse feedbackValidationServiceResponse = feedbackValidationServiceImpl.feedbackValidator(FeedbackValidationServiceUtils.USER_ID, FeedbackValidationServiceUtils.GOOD_FEEDBACK, FeedbackValidationServiceUtils.PRODUCT_ID);
			assertEquals(feedbackValidationServiceResponse.isPublish(), true);
			FeedbackValidationServiceResponse feedbackValidationServiceResponse2 = feedbackValidationServiceImpl.feedbackValidator(FeedbackValidationServiceUtils.USER_ID, FeedbackValidationServiceUtils.BAD_FEEDBACK, FeedbackValidationServiceUtils.PRODUCT_ID);
			assertEquals(feedbackValidationServiceResponse2.isPublish(), false);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
