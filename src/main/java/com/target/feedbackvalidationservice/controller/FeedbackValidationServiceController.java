package com.target.feedbackvalidationservice.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.target.feedbackvalidationservice.model.FeedbackValidationServiceResponse;
import com.target.feedbackvalidationservice.service.FeedbackValidationService;

import io.swagger.annotations.Api;

@Api(tags = "Feedback validation controller")
@RestController
@RequestMapping("/v1")
public class FeedbackValidationServiceController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FeedbackValidationServiceController.class);

	@Autowired
	FeedbackValidationService feedbackValidationService;

	@GetMapping(value = "/validateFeedback/userId/{userId}")
	public FeedbackValidationServiceResponse validateFeedback(@PathVariable("userId") final String userId,
			@RequestParam("feedback") String feedback, @RequestParam("productId") String productId) {
		logger.info("feedback : "+feedback);
		return feedbackValidationService.feedbackValidator(userId, feedback, productId);
	}
}
