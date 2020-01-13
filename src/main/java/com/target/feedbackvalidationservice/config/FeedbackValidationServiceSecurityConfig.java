package com.target.feedbackvalidationservice.config;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author soumya.in.coding
 * 
 */

//@Configuration
//@EnableWebSecurity
public class FeedbackValidationServiceSecurityConfig {

	/* LDAP basic spring security can be implemented based on Roles. */

	// private static final String FEEDBACK_ROLE = "ROLE_FEEDBACKSERVICE";

	/*@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers*///("**/feedbackValidationService/v1/documenttracking/**").permitAll()
	/*			.anyRequest().authenticated().anyRequest().hasAuthority(FEEDBACK_ROLE).and().httpBasic();
	}*/

}
