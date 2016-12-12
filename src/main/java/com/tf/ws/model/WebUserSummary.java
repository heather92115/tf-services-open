package com.tf.ws.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * WebUser: Heather
 * Date: 6/22/13
 * Time: 10:49 AM
 */
@Document
public class WebUserSummary implements Serializable {
    private static final long serialVersionUID = -78347838502590112L;

    public WebUserSummary() {}

    @Id
    private String id;

	private String userName;
	private String emailAddress;
	private String firstName;
	private String lastName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
