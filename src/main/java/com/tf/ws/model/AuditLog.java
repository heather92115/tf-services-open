package com.tf.ws.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Heather
 * Date: 6/25/14
 */
@Document
public class AuditLog implements Serializable {

	private static final long serialVersionUID = -2915668330393652660L;

	public AuditLog() {
	}

	@Id
	private String id;

	private String webUserId;
	private String adminUserId;
	private String userName;
	private String adminUserName;
	private String remoteAddress;
	private String comment;
	private Date eventDate;
	private WebEvent webEvent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWebUserId() {
		return webUserId;
	}

	public void setWebUserId(String webUserId) {
		this.webUserId = webUserId;
	}

	public String getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(String adminUserId) {
		this.adminUserId = adminUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public WebEvent getWebEvent() {
		return webEvent;
	}

	public void setWebEvent(WebEvent webEvent) {
		this.webEvent = webEvent;
	}
}
