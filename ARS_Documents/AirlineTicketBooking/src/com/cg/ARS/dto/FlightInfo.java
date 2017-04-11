package com.cg.ARS.dto;

import java.sql.Date;
import java.sql.Time;

public class FlightInfo {
	
	private String flightno;
	private String airlinename;
	private String dept_city;
	private String arr_city;
	private Date dep_date;
	private Date arr_date;
	private String dep_time;
	private String arr_time;
	private int firstseats;
	private int firstseatfare;
	private int bussseats;
	private int bussseatfare;
	
	
	public FlightInfo() {
		super();
	}


	public FlightInfo(String flightno, String airlinename, String dept_city,
			String arr_city, Date dep_date, Date arr_date, String dep_time,
			String arr_time, int firstseats, int firstseatfare, int bussseats,
			int bussseatfare) {
		super();
		this.flightno = flightno;
		this.airlinename = airlinename;
		this.dept_city = dept_city;
		this.arr_city = arr_city;
		this.dep_date = dep_date;
		this.arr_date = arr_date;
		this.dep_time = dep_time;
		this.arr_time = arr_time;
		this.firstseats = firstseats;
		this.firstseatfare = firstseatfare;
		this.bussseats = bussseats;
		this.bussseatfare = bussseatfare;
	}


	public String getFlightno() {
		return flightno;
	}


	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}


	public String getAirlinename() {
		return airlinename;
	}


	public void setAirlinename(String airlinename) {
		this.airlinename = airlinename;
	}


	public String getDept_city() {
		return dept_city;
	}


	public void setDept_city(String dept_city) {
		this.dept_city = dept_city;
	}


	public String getArr_city() {
		return arr_city;
	}


	public void setArr_city(String arr_city) {
		this.arr_city = arr_city;
	}


	public Date getDep_date() {
		return dep_date;
	}


	public void setDep_date(Date dep_date) {
		this.dep_date = dep_date;
	}


	public Date getArr_date() {
		return arr_date;
	}


	public void setArr_date(Date arr_date) {
		this.arr_date = arr_date;
	}


	public String getDep_time() {
		return dep_time;
	}


	public void setDep_time(String dep_time) {
		this.dep_time = dep_time;
	}


	public String getArr_time() {
		return arr_time;
	}


	public void setArr_time(String arr_time) {
		this.arr_time = arr_time;
	}


	public int getFirstseats() {
		return firstseats;
	}


	public void setFirstseats(int firstseats) {
		this.firstseats = firstseats;
	}


	public int getFirstseatfare() {
		return firstseatfare;
	}


	public void setFirstseatfare(int firstseatfare) {
		this.firstseatfare = firstseatfare;
	}


	public int getBussseats() {
		return bussseats;
	}


	public void setBussseats(int bussseats) {
		this.bussseats = bussseats;
	}


	public int getBussseatfare() {
		return bussseatfare;
	}


	public void setBussseatfare(int bussseatfare) {
		this.bussseatfare = bussseatfare;
	}


	@Override
	public String toString() {
		return "FlightInfo [flightno=" + flightno + ", airlinename="
				+ airlinename + ", dept_city=" + dept_city + ", arr_city="
				+ arr_city + ", dep_date=" + dep_date + ", arr_date="
				+ arr_date + ", dep_time=" + dep_time + ", arr_time="
				+ arr_time + ", firstseats=" + firstseats + ", firstseatfare="
				+ firstseatfare + ", bussseats=" + bussseats
				+ ", bussseatfare=" + bussseatfare + "]";
	}
	
	
	
	

}
