 package com.cg.ARS.dto;

public class BookingInformation {

	private String booking_id;
	private String cust_email;
	private int no_of_passenger;
	private String class_type;
	private int total_fare;
	private int seat_number;
	private String creditcard_info;
	private String src_city;
	private String dest_city;
	private String flightno;
	
	public BookingInformation(String booking_id, String cust_email,
			int no_of_passenger, String class_type, int total_fare,
			int seat_number, String creditcard_info, String src_city,
			String dest_city,String flightno) {
		super();
		this.booking_id = booking_id;
		this.cust_email = cust_email;
		this.no_of_passenger = no_of_passenger;
		this.class_type = class_type;
		this.total_fare = total_fare;
		this.seat_number = seat_number;
		this.creditcard_info = creditcard_info;
		this.src_city = src_city;
		this.dest_city = dest_city;
		this.flightno = flightno;
	}

	
	public BookingInformation() {
		super();
	}

	
	public String getFlightno() {
		return flightno;
	}


	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}


	public String getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public int getNo_of_passenger() {
		return no_of_passenger;
	}

	public void setNo_of_passenger(int no_of_passenger) {
		this.no_of_passenger = no_of_passenger;
	}

	public String getClass_type() {
		return class_type;
	}

	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}

	public int getTotal_fare() {
		return total_fare;
	}

	public void setTotal_fare(int total_fare) {
		this.total_fare = total_fare;
	}

	public int getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(int seat_number) {
		this.seat_number = seat_number;
	}

	public String getCreditcard_info() {
		return creditcard_info;
	}

	public void setCreditcard_info(String creditcard_info) {
		this.creditcard_info = creditcard_info;
	}

	public String getSrc_city() {
		return src_city;
	}

	public void setSrc_city(String src_city) {
		this.src_city = src_city;
	}

	public String getDest_city() {
		return dest_city;
	}

	public void setDest_city(String dest_city) {
		this.dest_city = dest_city;
	}

	@Override
	public String toString() {
		return "BookingInformation [booking_id=" + booking_id + ", cust_email="
				+ cust_email + ", no_of_passenger=" + no_of_passenger
				+ ", class_type=" + class_type + ", total_fare=" + total_fare
				+ ", seat_number=" + seat_number + ", creditcard_info="
				+ creditcard_info + ", src_city=" + src_city + ", dest_city="
				+ dest_city + ", flightno=" + flightno + "]";
	}
	
	
	
	
	
}
