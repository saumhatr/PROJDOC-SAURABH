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

public class ARSDelete {

	BookingDao bookdao;
	private static final Logger mylogger=Logger.getLogger(ARSDelete.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		bookdao= new BookingDaoImpl();
	}


	@Test
	public void testDelete() {
		try {
			assertFalse(bookdao.deleteFlight("B100"));
			
			mylogger.info("In test case delete Flight function working ");
		} catch (BookingExceptions e) {
			mylogger.error(" Data Not deleted in test case "+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() throws Exception {
		bookdao=null;
	}

}
