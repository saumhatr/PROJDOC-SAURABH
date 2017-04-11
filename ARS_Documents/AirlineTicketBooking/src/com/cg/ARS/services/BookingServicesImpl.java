package com.cg.ARS.services;

import java.sql.Date;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.ARS.daos.BookingDao;
import com.cg.ARS.daos.BookingDaoImpl;
import com.cg.ARS.dto.Airport;
import com.cg.ARS.dto.BookingInformation;
import com.cg.ARS.dto.FlightInfo;
import com.cg.ARS.dto.UserClass;
import com.cg.ARS.exceptions.BookingExceptions;



public class BookingServicesImpl implements BookingServices{

	private BookingDao dao;
	public BookingServicesImpl() throws BookingExceptions {
		
		dao=new BookingDaoImpl();
	}
	
	@Override
	public List<FlightInfo> showAll() throws BookingExceptions {	
		return dao.showAll();
	}

	@Override
	public boolean addBookingDetails(BookingInformation book,String no)
			throws BookingExceptions {
		
		return dao.addBookingDetails(book,no);
	}

	@Override
	public boolean cancelBooking(String bookid) throws BookingExceptions {
		
		return dao.cancelBooking(bookid);
	}
	
	@Override
	public UserClass getUserDetails(String userName) throws BookingExceptions {
	
		return dao.getUserDetails(userName);
	}

	@Override
	public boolean isUserAuthenticated(String userName,String password)throws BookingExceptions{
		UserClass user=dao.getUserDetails(userName);         //check db user with that username
		if(password.equals(user.getPassword()))
		{
			return true;
		}
		else
		{	
		return false;
		}
	
	}

	@Override
	public BookingInformation showBookingDetails(String bookId)
			throws BookingExceptions {
		
		return dao.showBookingDetails(bookId);
	}

	@Override
	public boolean updateFlightSeatQuantity(String flightno,
			int noofpassengers, String seattype) throws BookingExceptions {
	
		return dao.updateFlightSeatQuantity(flightno, noofpassengers, seattype);
	}

	@Override
	public String getFlightNo(String src, String dest) throws BookingExceptions {
		return dao.getFlightNo(src, dest);
	}

	@Override
	public boolean validateLogin(String userName) throws BookingExceptions {
		
		return dao.validateLogin(userName);
	}

	@Override
	public boolean deleteFlight(String no) throws BookingExceptions {
	
		return dao.deleteFlight(no);
	}

	@Override
	public boolean insertFlightDetails(FlightInfo info) throws BookingExceptions {
		return dao.insertFlightDetails(info);
		
	}

	@Override
	public boolean insertUser(UserClass users)
			throws BookingExceptions {

		return dao.insertUsers(users);
	}

	@Override
	public List<FlightInfo> searchBySrcDest(String src, String dest)
			throws BookingExceptions {
		
		return dao.searchBySrcDest(src,dest);
	}

	@Override
	public List<FlightInfo> showFlightByDate(Date date)
			throws BookingExceptions {
		
		return dao.showFlightByDate(date);
	}

	@Override
	public boolean updateFlightInfo(FlightInfo info) throws BookingExceptions {
		
		return dao.updateFlightInfo(info);
	}

	@Override
	public String showBookingId(String email) throws BookingExceptions {
		
		return dao.showBookingId(email);
	}

	@Override
	public FlightInfo flightDetails(String flightno) throws BookingExceptions {	
		return dao.flightDetails(flightno);
	}

	@Override
	public boolean updateFlightSeatQuantityOnCancellation(String flightno,
			int noofpassengers, String seattype) throws BookingExceptions {
		
		return dao.updateFlightSeatQuantityOnCancellation(flightno, noofpassengers, seattype);
	}

	@Override
	public List<BookingInformation> showPassengerList(String flightno)
			throws BookingExceptions {
		
		return dao.showPassengerList(flightno);
	}


	
/*
	@Override
	public List<BookingInformation> getBookingDetails(int bookid)
			throws BookingExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airport getAirportDetails(String Name) throws BookingExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	*/
}
