package com.cg.ARS.tests;
import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.ARS.daos.BookingDao;
import com.cg.ARS.daos.BookingDaoImpl;
import com.cg.ARS.exceptions.BookingExceptions;

public class BookingShow {
	
	BookingDao dao;
	private static final Logger mylogger=
			Logger.getLogger(BookingShow.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao= new BookingDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		dao=null;
	}

	@Test
	public void test() {
		try {
			assertNotNull(dao.showBookingDetails("ARS25"));
			mylogger.info("In testcase of BookingShow function working ");
			System.out.println(dao.showBookingDetails("ARS25"));
		} catch (BookingExceptions e) {
			// TODO Auto-generated catch block
			mylogger.error(" Data Not found in testcase of BookingShow "+e.getMessage());
			e.printStackTrace();
		}
		
	}

}
