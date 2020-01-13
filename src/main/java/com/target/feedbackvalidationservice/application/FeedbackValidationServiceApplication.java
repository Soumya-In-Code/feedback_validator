package com.target.feedbackvalidationservice.application;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.target.feedbackvalidationservice.service.TernarySearchTree;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author soumya.in.coding
 * 
 */

@SpringBootApplication(scanBasePackages = {"com.target.feedbackvalidationservice"})
@EnableSwagger2
public class FeedbackValidationServiceApplication {

	@Autowired
	private TernarySearchTree ternarySearchTree;
	
	public static void main(String[] args) {
		SpringApplication.run(FeedbackValidationServiceApplication.class, args);
	}
	
	@PostConstruct
    public void loadStrings() { 
		String []words = {"crap", "idiot", "shit", "p**p", "cheap", "shitty", "f*ck", "stupid"};
		for(String word : words) {
			ternarySearchTree.insert(word);
		}
    }
	
}
