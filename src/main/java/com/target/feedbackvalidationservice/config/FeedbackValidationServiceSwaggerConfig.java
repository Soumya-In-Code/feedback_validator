package com.target.feedbackvalidationservice.config;

import static java.util.Collections.singletonList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author soumya.in.coding
 * 
 */

@Configuration
public class FeedbackValidationServiceSwaggerConfig {

	@Bean
	public Docket api() {

		final String securityRealm = "Target";
		final SecurityScheme basicAuthSecurityScheme = new BasicAuth(securityRealm);
		final SecurityContext securityContext = SecurityContext.builder()
				.securityReferences(singletonList(new SecurityReference(securityRealm, new AuthorizationScope[0])))
				.build();

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.target.feedbackvalidationservice"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo()).forCodeGeneration(true)
				.securitySchemes(singletonList(basicAuthSecurityScheme))
				.securityContexts(singletonList(securityContext));
	}

	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Feedback Validation Service").description("").build();
	}

}
