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
public class KnownBad implements Serializable {

	private static final long serialVersionUID = 5357021940149214248L;

	public KnownBad() {
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
