package com.target.feedbackvalidationservice;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.target.feedbackvalidationservice.exception.FeedbackvalidationserviceException;
import com.target.feedbackvalidationservice.service.FeedbackValidationService;
import com.target.feedbackvalidationservice.utils.FeedbackValidationServiceUtils;

public class FeedbackValidationServiceControllerTest extends FeedbackValidationServiceApplicationTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@MockBean
	private FeedbackValidationService feedbackValidationService;

	@InjectMocks
	FeedbackValidationServiceUtils utils;

	/**
	 * for setting mockMvc before @Test starts
	 */
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	/**
	 * Success scenario - unit tests. This happy scenario tests if the controller is
	 * returning expected response if the service layers return valid response. In
	 * this case the API should return 200 Status code.
	 */
	@Test
	public void validateFeedbackSuccessTest() throws Exception {
		Mockito.when(feedbackValidationService.feedbackValidator(Mockito.anyString(), Mockito.anyString(),
				Mockito.anyString())).thenReturn(utils.getFeedbackValidationServiceResponse());

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/v1/validateFeedback/userId/U1?feedback=Nice product&productId=P1");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	/**
	 * @throws Exception
	 *             This method tests negative scenario. If the poNumber is missing
	 *             in the request then the method should catch an exception. As
	 *             poNumber is a mandatory field. In this case the API should return
	 *             400 status code.
	 */
	@Test
	public void retrieveDocumentTrackingInfoBadRequest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/validateFeedback/userId/?feedback=Nice product&productId=P1");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
	}

}
