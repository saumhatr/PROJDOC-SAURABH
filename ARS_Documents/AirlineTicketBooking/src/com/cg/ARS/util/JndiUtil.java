package com.cg.ARS.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.ARS.exceptions.BookingExceptions;

public class JndiUtil {
	private DataSource dataSource;

	public JndiUtil() throws BookingExceptions {
		try {
			Context ctx = new InitialContext(); // get reference to remote JNDI.
			dataSource = (DataSource) ctx.lookup("java:/OracleDS");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new BookingExceptions("Failed to get JNCI context", e);
		}
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
