package com.tf.ws.model;

public enum UserStatus {

    ANON("anonymous"),
	NEW("new"),
	ACTIVE("active"),
	LOCKED("locked"),
	RESET_REQUESTED("resetRequested"),
	RESET_MODE("resetMode"),
	BLOCKED("blocked");

	private String label; // Used with resource bundle.

	UserStatus(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

}
