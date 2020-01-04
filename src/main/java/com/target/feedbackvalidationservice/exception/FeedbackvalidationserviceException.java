package com.target.feedbackvalidationservice.exception;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

public class FeedbackvalidationserviceException extends NestedRuntimeException{

	private final HttpStatus status;

	@Nullable
	private final String reason;


	/**
	 * Constructor with a response status.
	 * @param status the HTTP status (required)
	 */
	public FeedbackvalidationserviceException(HttpStatus status) {
		this(status, null, null);
	}

	/**
	 * Constructor with a response status and a reason to add to the exception
	 * message as explanation.
	 * @param status the HTTP status (required)
	 * @param reason the associated reason (optional)
	 */
	public FeedbackvalidationserviceException(HttpStatus status, @Nullable String reason) {
		this(status, reason, null);
	}

	/**
	 * Constructor with a response status and a reason to add to the exception
	 * message as explanation, as well as a nested exception.
	 * @param status the HTTP status (required)
	 * @param reason the associated reason (optional)
	 * @param cause a nested exception (optional)
	 */
	public FeedbackvalidationserviceException(HttpStatus status, @Nullable String reason, @Nullable Throwable cause) {
		super(null, cause);
		Assert.notNull(status, "HttpStatus is required");
		this.status = status;
		this.reason = reason;
	}


	/**
	 * The HTTP status that fits the exception (never {@code null}).
	 */
	public HttpStatus getStatus() {
		return this.status;
	}

	/**
	 * The reason explaining the exception (potentially {@code null} or empty).
	 */
	@Nullable
	public String getReason() {
		return this.reason;
	}

	@Override
	public String getMessage() {
		String msg = this.status + (this.reason != null ? " \"" + this.reason + "\"" : "");
		return NestedExceptionUtils.buildMessage(msg, getCause());
	}

}
