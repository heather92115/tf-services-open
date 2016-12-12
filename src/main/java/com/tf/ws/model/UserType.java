package com.tf.ws.model;

public enum UserType {

	ADVERTISER("advertiser", Boolean.TRUE),
	ANONYMOUS("guest", Boolean.FALSE),
	BLOGGER("blogger", Boolean.TRUE),
    BUYER("buyer", Boolean.TRUE),
	REGISTERED("registered", Boolean.TRUE),
	SELLER("seller", Boolean.TRUE),
	ADMIN("admin", Boolean.TRUE);

	private String label; // Used with resource bundle.
	private Boolean canSelect;

	UserType(String label, Boolean canSelect) {
		this.label = label;
		this.canSelect = canSelect;
	}

	public String getLabel() {
		return this.label;
	}

	public Boolean getCanSelect()
	{
		return canSelect;
	}
}
