package com.target.feedbackvalidationservice.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FeedbackValidationServiceResponse {

	private String feedback;
	private boolean publish;
	private String userId;
	private String productId;

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public boolean isPublish() {
		return publish;
	}

	public void setPublish(boolean publish) {
		this.publish = publish;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("feedback", feedback).append("publish", publish)
				.append("userId", userId).append("productId", productId).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(feedback).append(publish).append(userId).append(productId).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof FeedbackValidationServiceResponse) == false) {
			return false;
		}
		FeedbackValidationServiceResponse fvsr = ((FeedbackValidationServiceResponse) other);
		return new EqualsBuilder().append(feedback, fvsr.feedback).append(publish, fvsr.publish)
				.append(userId, fvsr.userId).append(userId, fvsr.userId).isEquals();
	}
}
