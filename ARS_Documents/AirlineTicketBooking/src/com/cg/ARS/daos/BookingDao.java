package com.cg.ARS.daos;

import java.sql.Date;
import java.util.List;

import com.cg.ARS.dto.Airport;
import com.cg.ARS.dto.BookingInformation;
import com.cg.ARS.dto.FlightInfo;
import com.cg.ARS.dto.UserClass;
import com.cg.ARS.exceptions.BookingExceptions;



public interface BookingDao {
	
	public List<FlightInfo> showAll() throws BookingExceptions;
	public FlightInfo flightDetails(String flightno) throws BookingExceptions;
	public boolean addBookingDetails(BookingInformation book, String no)throws BookingExceptions;
	public boolean cancelBooking(String bookid) throws BookingExceptions;
	public String showBookingId(String email) throws BookingExceptions;
	public UserClass getUserDetails(String userName) throws BookingExceptions;
/*	public List<BookingInformation> getBookingDetails(int bookid) throws BookingExceptions; 
	boolean insertbookDetails(BookingInformation  bookInfo) throws BookingExceptions;
	Airport getAirportDetails(String Name) throws BookingExceptions;*/
	BookingInformation showBookingDetails(String bookId) throws BookingExceptions;
	boolean updateFlightSeatQuantity(String flightno, int noofpassengers,String seattype) throws BookingExceptions;
	public String getFlightNo(String src,String dest) throws BookingExceptions;
	public boolean validateLogin(String userName) throws BookingExceptions;
	public boolean updateFlightInfo(FlightInfo info) throws BookingExceptions;
	public boolean deleteFlight(String no) throws BookingExceptions;
	public boolean insertFlightDetails(FlightInfo info) throws BookingExceptions;
	public boolean insertUsers(UserClass users) throws BookingExceptions;
	public List<FlightInfo> searchBySrcDest(String src, String dest) throws BookingExceptions;
	int getSeatFare(String flightno, int noofpassengers, String seattype)throws BookingExceptions;
	List<FlightInfo> showFlightByDate(Date date) throws BookingExceptions;
	boolean updateFlightSeatQuantityOnCancellation(String flightno,
			int noofpassengers, String seattype) throws BookingExceptions;
	public List<BookingInformation> showPassengerList(String flightno) throws BookingExceptions;
	
		
}
