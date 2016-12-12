package com.tf.ws.model;

import java.io.Serializable;

/**
 * Created by heather on 11/23/16.
 */
public class ClientErrorInformation implements Serializable {
	private static final long serialVersionUID = 97234647217448L;

	public String message;
	public String uri;

	public ClientErrorInformation() {
	}

	public ClientErrorInformation(String message, String uri) {
		this.message = message;
		this.uri = uri;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
