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

public class ARSShowAll {

	BookingDao dao;
	private static final Logger mylogger=
			Logger.getLogger(ARSShowAll.class);
	
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
			assertNotNull(dao.showAll());
			mylogger.info("In testcase of ARSShowAll function working ");
		} catch (BookingExceptions e) {
			// TODO Auto-generated catch block
			mylogger.error(" Data Not found in testcase of ARSShowAll "+e.getMessage());
			e.printStackTrace();
		}
	}

}
