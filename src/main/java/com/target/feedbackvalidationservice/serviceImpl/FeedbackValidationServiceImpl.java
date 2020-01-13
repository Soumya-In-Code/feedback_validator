package com.target.feedbackvalidationservice.serviceImpl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.target.feedbackvalidationservice.exception.FeedbackvalidationserviceException;
import com.target.feedbackvalidationservice.model.FeedbackValidationServiceResponse;
import com.target.feedbackvalidationservice.service.FeedbackValidationService;
import com.target.feedbackvalidationservice.service.TernarySearchTree;

/**
 * @author soumya.in.coding
 * 
 */

@Service
public class FeedbackValidationServiceImpl implements FeedbackValidationService {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FeedbackValidationServiceImpl.class);
	
	@Autowired
	private TernarySearchTree ternarySearchTree;
	
	@Override
	public FeedbackValidationServiceResponse feedbackValidator(String userId, String feedback, String productId){
		
		FeedbackValidationServiceResponse feedbackValidationServiceResponse = new FeedbackValidationServiceResponse();
		try {
			if(!ternarySearchTree.search(feedback)) {
				feedbackValidationServiceResponse.setPublish(true);
				feedbackValidationServiceResponse.setFeedback(feedback);
			}else {
				feedbackValidationServiceResponse.setFeedback("");
			}
			feedbackValidationServiceResponse.setUserId(userId);
			feedbackValidationServiceResponse.setProductId(productId);
			logger.info("Abusive ? : "+feedbackValidationServiceResponse.isPublish());
		}catch(Exception ex) {
			logger.debug(ex.getMessage());
			throw new FeedbackvalidationserviceException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
		return feedbackValidationServiceResponse;
	}

}
