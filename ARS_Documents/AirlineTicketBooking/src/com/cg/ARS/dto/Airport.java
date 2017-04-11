package com.cg.ARS.dto;

public class Airport {
	
	private String airportname;
	private String abbreviation;
	private String state;
	private String city;
	private int zipcode;
	
	public Airport() {
		super();
	}

	public Airport(String airportname, String abbreviation, String state,
			String city, int zipcode) {
		super();
		this.airportname = airportname;
		this.abbreviation = abbreviation;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getAirportname() {
		return airportname;
	}

	public void setAirportname(String airportname) {
		this.airportname = airportname;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Airport [airportname=" + airportname + ", abbreviation="
				+ abbreviation + ", state=" + state + ", city=" + city
				+ ", zipcode=" + zipcode + "]";
	}
	
	
	
	
	
}