package com.tf.ws.model;

/**
 * Country enum to support select one menus and country
 * dependent logic.
 *
 * Created by heather on 1/4/14.
 */
public enum Country
{
	CANADA("country.Canada", "province", "*9* 9*9", "[A-Z]\\d[A-Z] \\d[A-Z]\\d"),
	MEXICO("country.Mexico", "state", "99999", "\\d{5}"),
	UNITED_KINGDOM("country.UnitedKingdom", "state", "99999", "\\d{5}"),
	UNITED_STATES("country.UnitedStates", "state", "99999?-9999", "^\\d{5}-?\\d{4})?$");

	private String label;
	private String stateOrProvince;
	private String zipCodeMask;
	private String zipCodeRegex;

	private Country(String label, String stateOrProvince, String zipCodeMask, String zipCodeRegex) {
		this.label = label;
		this.stateOrProvince = stateOrProvince;
		this.zipCodeMask = zipCodeMask;
		this.zipCodeRegex = zipCodeRegex;
	}

	public String getLabel() {
		return label;
	}

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public String getZipCodeMask() {
		return zipCodeMask;
	}

	public String getZipCodeRegex()
	{
		return zipCodeRegex;
	}
}
