package com.cg.ARS.tests;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.ARS.daos.BookingDao;
import com.cg.ARS.daos.BookingDaoImpl;
import com.cg.ARS.dto.FlightInfo;
import com.cg.ARS.exceptions.BookingExceptions;

public class InsertFlight {

	BookingDao dao=null;
	FlightInfo flight=null;
	
	private static final Logger mylogger=
			Logger.getLogger(InsertFlight.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		dao= new BookingDaoImpl();
		flight  = new FlightInfo();
		
		
		flight.setFlightno("A100");
		
		flight.setAirlinename("Kingfisher");
		flight.setDept_city("Mumbai");
		flight.setArr_city("arr_city");
		
		String date = "2017-05-11";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1 = sdf1.parse(date);
		/*java.sql.Date sqldeptDate = new Date(date.getTime());
		System.out.println(sqldeptDate);
		info.setDep_date(sqldeptDate);*/
		
		
		flight.setDep_date((Date) date1);
		//flight.setArr_date("arr_date");
		flight.setDep_time("07:00PM");
		flight.setArr_time("11:00PM");
		flight.setFirstseats(10);
		flight.setFirstseatfare(5000);
		flight.setBussseats(20);
		flight.setBussseatfare(3000);
		
	}

	@After
	public void tearDown() throws Exception {
		dao=null;
		flight=null;
	}

	@Test
	public void testinsertFlightDetails() {
		try {
			assertTrue(dao.insertFlightDetails(flight));
			mylogger.info("In test case of purchaseDao insertFlightDetails function working ");
		} catch (BookingExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
