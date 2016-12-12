package com.tf.ws.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * WebUser: Heather
 * Date: 6/25/14
 */
@Document
public class KnownSafe implements Serializable {

	private static final long serialVersionUID = -1715864669375136181L;

	public KnownSafe() {
	}

	@Id
	private String id;

	private String remoteAddress;
	private Date createdDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
