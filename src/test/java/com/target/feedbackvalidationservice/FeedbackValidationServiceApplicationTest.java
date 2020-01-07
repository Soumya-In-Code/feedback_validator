package com.target.feedbackvalidationservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.target.feedbackvalidationservice.application.FeedbackValidationServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = FeedbackValidationServiceApplication.class)
public class FeedbackValidationServiceApplicationTest {

	@Test
	public void contextLoads() {
	}

}
