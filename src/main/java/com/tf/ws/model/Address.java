package com.tf.ws.model;

import java.io.Serializable;

/**
 * WebUser: Heather
 * Date: 6/22/13
 * Time: 10:55 AM
 */
public class Address implements Serializable {
    private static final long serialVersionUID = 4953114751942291862L;

    public Address() {
	    country = Country.UNITED_STATES;
    }

	private String addressLabel;
	private Boolean isNew;
	private Boolean toBeDeleted = Boolean.FALSE;
    private String street1;
    private String street2;
    private String city;
    private StateProvince state;
    private String zipCode;
    private Country country;
    private Double longitude;
    private Double latitude;

	public Boolean isComplete() {
		if (addressLabel == null || street1 == null || city == null || country == null || state == null || zipCode == null) {
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	public String getAddressLabel()
	{
		return addressLabel;
	}

	public void setAddressLabel(String addressLabel)
	{
		this.addressLabel = addressLabel;
	}

	public Boolean getIsNew()
	{
		return isNew;
	}

	public void setIsNew(Boolean isNew)
	{
		this.isNew = isNew;
	}

	public Boolean getToBeDeleted()
	{
		return toBeDeleted;
	}

	public void setToBeDeleted(Boolean toBeDeleted)
	{
		this.toBeDeleted = toBeDeleted;
	}

	public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public StateProvince getState() {
        return state;
    }

    public void setState(StateProvince state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
