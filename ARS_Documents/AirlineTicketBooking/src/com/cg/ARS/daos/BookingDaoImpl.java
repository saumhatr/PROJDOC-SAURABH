package com.cg.ARS.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.ARS.dto.Airport;
import com.cg.ARS.dto.BookingInformation;
import com.cg.ARS.dto.FlightInfo;
import com.cg.ARS.dto.UserClass;
import com.cg.ARS.exceptions.BookingExceptions;
import com.cg.ARS.util.JndiUtil;



public class BookingDaoImpl implements BookingDao {


	Connection conn;
	PreparedStatement stmt;
	private JndiUtil util;
	
	public BookingDaoImpl() throws BookingExceptions {
		util = new JndiUtil();
	}
	
	@Override
	public boolean validateLogin(String userName) throws BookingExceptions {
		String query="SELECT PASSWORD FROM USERS WHERE USERNAME=?";
		ResultSet res;
		try {
			conn=util.getConnection();
			stmt=conn.prepareStatement(query);
			stmt.setString(1, userName);
			res=stmt.executeQuery();
			if(res.next()){
				return true;
			}
		} catch (SQLException e) {
			
			throw new BookingExceptions("UserName Does not exist");
		}
		
		return false;
	}

	@Override
	public List<FlightInfo> showAll() throws BookingExceptions{
		
		String query="select flightno,airline,dep_city,arr_city,dep_date,arr_date,dep_time,arr_time,firstseats,firstseatfare,bussseats,BussSeatsFare from flight_information";

		List<FlightInfo> flightlistshow;
		
		try {
			flightlistshow =new ArrayList<FlightInfo>();
			conn=util.getConnection();
			stmt=conn.prepareStatement(query);
			ResultSet res=stmt.executeQuery();
			
			System.out.println("ResultSet res"+res.toString());
				while(res.next())
				{
					
					FlightInfo flight=new FlightInfo();
					System.out.println("flightno"+res.getString("flightno"));
					String fno=res.getString("flightno");
					flight.setFlightno(fno);
					String aname=res.getString("airline");
					flight.setAirlinename(aname);
					flight.setDept_city(res.getString("dep_city"));
					flight.setArr_city(res.getString("arr_city"));
					flight.setDep_date(res.getDate("dep_date"));
					flight.setArr_date(res.getDate("arr_date"));
					flight.setDep_time(res.getString("dep_time"));
					flight.setArr_time(res.getString("arr_time"));
					flight.setFirstseats(res.getInt("firstseats"));
					flight.setFirstseatfare(res.getInt("firstseatfare"));
					flight.setBussseats(res.getInt("bussseats"));
					flight.setBussseatfare(res.getInt("BussSeatsFare"));
					System.out.println(flight.toString());
					flightlistshow.add(flight);
				}
					
		 } catch (SQLException e) {
			System.out.println("Query Fabrication error in List All Flights");
			return null;
			
		}finally
		{
			   try {
					stmt.close();
					conn.close();
				  } catch (SQLException e) {
					System.out.println("Connection closing failed"+e);	
				}
			}

		return flightlistshow;
	}

	private int getBookingId() {
		int bookingId = 0;
	 
			
			try {
				conn=util.getConnection();
				String query="Select Booking_Id_Seq1.NEXTVAL from dual";
				stmt=conn.prepareStatement(query);
				ResultSet rs=stmt.executeQuery();
				if(rs.next())
				{	
					bookingId=rs.getInt(1);
					
				}
				
			

			} catch (SQLException e) {
				
				System.out.println("SQLException while generating BookingID");
			
			}finally
			{
				   try {
						stmt.close();
						conn.close();
					  } catch (SQLException e) {
						System.out.println("Connection closing failed"+e);	
					}
				}
		   
			return bookingId;
	}
	
	public boolean addBookingDetails(BookingInformation book,String flightno)throws BookingExceptions{
		
		int bookid=getBookingId();
		String id=Integer.toString(bookid);
		String bid="ARS".concat(id);
		//String flightno=getFlightNo(book.getSrc_city(),book.getDest_city());
		
		System.out.println("Flight no in booking"+flightno);
		int nop=book.getNo_of_passenger();
		String seatType= book.getClass_type();
		int totalfare=getSeatFare(flightno,nop,seatType);
		
	    int rec;
		String query="INSERT INTO bookingInformation VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			conn=util.getConnection();
			stmt=conn.prepareStatement(query);
			stmt.setString(1,bid);
			stmt.setString(2,book.getCust_email());
			stmt.setInt(3,book.getNo_of_passenger());
			//stmt.setString(4,book.getClass_type());
			stmt.setString(4,seatType);
			stmt.setInt(5,totalfare);
			stmt.setInt(6,book.getSeat_number());
			stmt.setString(7,book.getCreditcard_info());
			stmt.setString(8,book.getSrc_city());
			stmt.setString(9,book.getDest_city());
			stmt.setString(10,flightno);
			rec=stmt.executeUpdate();
			
			if(rec!=0)
			{
				System.out.println("Data Inserted in booking table");
				//mylogger.info("Data Inserted in purchase table with purchaseid "+pid);
				return true;	
			}
			
		} catch (SQLException e) {
			
			//mylogger.error("Data not updated in purchase table");
			throw new BookingExceptions("Data not Inserted in booking table"); 
		}finally
		{
			   try {
					stmt.close();
					conn.close();
				  } catch (SQLException e) {
					System.out.println("Connection closing failed"+e);	
				}
			}
		
		return false;
	}
		

	public boolean cancelBooking(String bookid) throws BookingExceptions {
		
		String query="DELETE FROM bookingInformation WHERE booking_id=?";
		int rec=0;
		
		try {
			conn=util.getConnection();
			stmt=conn.prepareStatement(query);
			stmt.setString(1, bookid);
			rec=stmt.executeUpdate();
			if(rec>0)
				{
				System.out.println("Data deleted with booking id"+bookid);
			   // mylogger.info("Data deleted with mobile id"+bookid);
				return true;
				}
			else
				System.out.println("Invalid booking Id");
			
		} catch (SQLException e) {
			//mylogger.error(" Data Not found with id "+mobileid);
			System.out.println("Invalid booking Id");
			throw new BookingExceptions("Data not deleted"); 
			
		}
		finally
		{
		   try {
				stmt.close();
				conn.close();
			  } catch (SQLException e) {
				  System.out.println("Connection closing failed"+e);
			}
		}
		
		
		return false;
	}

	@Override
	public UserClass getUserDetails(String userName) throws BookingExceptions {
		
		ResultSet rs=null;
		String qry="SELECT password from users where username=?";
		try {
			
			conn =util.getConnection();
			stmt=conn.prepareStatement(qry);
			stmt.setString(1,userName);
			
			rs=stmt.executeQuery();
			if(rs.next())             //username  min one record should be there
			{
			
				String password=rs.getString("password");
				
				
				UserClass user=new UserClass(userName,password);
				return user;
			}
			else
			{
				throw new BookingExceptions("UserName wrong");
			}
			
		} catch (SQLException e) {
			throw new BookingExceptions("JDBC Failed",e);      //exception chaining
			
		}
		finally
		{
			try {
				if(rs!=null)
				{	
				   rs.close();
				}
				if(stmt!=null)
				{
				 stmt.close();
					
				}
				if(conn!=null)
				{
					conn.close();
				}
			} catch (SQLException e) {
				
				throw new BookingExceptions("JDBC connection closing Failed");
			}
		}
		
	}
	

	@Override
	public BookingInformation showBookingDetails(String bookId) throws BookingExceptions {
		
		BookingInformation bookingDet=new BookingInformation();
		
		String query="SELECT flightno, booking_id, cust_email,no_of_passengers, class_type,  total_fare,seat_numbers, creditcard_info,  src_city,dest_city FROM bookingInformation WHERE booking_id=?";
		try {
			conn =util.getConnection();
			stmt=conn.prepareStatement(query);
			stmt.setString(1,bookId);
			ResultSet res=stmt.executeQuery();
			while(res.next()){
				bookingDet.setBooking_id(bookId);
				bookingDet.setCust_email(res.getString("cust_email"));
				bookingDet.setNo_of_passenger(res.getInt("no_of_passengers"));
				bookingDet.setClass_type(res.getString("class_type"));
				bookingDet.setTotal_fare(res.getInt("total_fare"));
				bookingDet.setSeat_number(res.getInt("seat_numbers"));
				bookingDet.setCreditcard_info(res.getString("creditcard_info"));
				bookingDet.setSrc_city(res.getString("src_city"));
				bookingDet.setDest_city(res.getString("dest_city"));
				bookingDet.setFlightno(res.getString("flightno"));
				
			}
		} catch ( SQLException e) {
			
			throw new BookingExceptions("Data Not found");
		}finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Connection closing failed"+e);
			}
		}
		
		return bookingDet;
	}


	@Override
 	public boolean updateFlightSeatQuantity(String flightno, int noofpassengers,String seattype) throws BookingExceptions {
 		
 		String query = null;
		if(seattype.equals("Business"))
		{
 		   query="UPDATE flight_information set bussseats=bussseats-? where flightno=? ";
		}
		else if(seattype.equals("First"))
		{
		  query="UPDATE flight_information set firstseats=firstseats-? where flightno=? ";
		}

 		int rec=0;
 		try {
 			conn =util.getConnection();
 			stmt=conn.prepareStatement(query);
 			stmt.setInt(1,noofpassengers);
 			stmt.setString(2,flightno);	
 			rec=stmt.executeUpdate();
 			
 			if(rec>0)
 				{
 				 System.out.println("flight seats table updated");
 				 return true;
 				}
 			
 		} catch (SQLException e) {
 			System.out.println(e);
 				
 			throw new BookingExceptions("Data not updated in Flight table"+e.getMessage()); 
 		}finally
		{
 		   try {
 				stmt.close();
 				conn.close();
 			  } catch (SQLException e) {
 				e.printStackTrace();	
 			}
 		}
 		
 		return false;
 	}
	
	
	public String getFlightNo(String src,String dest) throws BookingExceptions
	{
		String query="select flightno from flight_information where dep_city=? and arr_city=? ";
		ResultSet res;
		String flightNo = null;
			try {
				conn =util.getConnection();
				stmt=conn.prepareStatement(query);
				stmt.setString(1, src);
				stmt.setString(2, dest);
				res=stmt.executeQuery();
				if(res.next())
					{
					 flightNo=res.getString("flightno");
					 System.out.println("flightNo"+flightNo);
					}
				return flightNo;
			} catch (SQLException e) {
				throw new BookingExceptions("No flight available with given source and destination"+e.getMessage()); 
			}finally
			{
				   try {
						stmt.close();
						conn.close();
					  } catch (SQLException e) {
						e.printStackTrace();	
					}
				}
		
	}

	@Override
	public boolean updateFlightInfo(FlightInfo info) throws BookingExceptions {
		String query = "UPDATE FLIGHT_INFORMATION SET dep_city=?, arr_city=?,dep_date=?,arr_date=?,dep_time=?,arr_time=?,firstseats=?,firstseatfare=?,bussseats=?,bussseatsfare=? WHERE flightno=?";
		int updateRecord;
		try {
			conn=util.getConnection();
			stmt=conn.prepareStatement(query);
			stmt.setString(1, info.getDept_city());
			stmt.setString(2, info.getArr_city());
			stmt.setDate(3, info.getDep_date());
			stmt.setDate(4, info.getArr_date());
			stmt.setString(5, info.getDep_time());
			stmt.setString(6, info.getArr_time());
			stmt.setInt(7, info.getFirstseats());
			stmt.setInt(8, info.getFirstseatfare());
			stmt.setInt(9, info.getBussseats());
			stmt.setInt(10, info.getBussseatfare());
			stmt.setString(11, info.getFlightno());
			updateRecord=stmt.executeUpdate();
			if(updateRecord>0){
				return true;
			}
			
		} catch (SQLException e) {
			throw new BookingExceptions("Update method failed");
		}
		
		
		return false;
	}

	@Override
	public boolean deleteFlight(String no) throws BookingExceptions {
		
		boolean updateStatus=updateCancelFlight(no);
		//if(updateStatus){
			String query="DELETE FROM FLIGHT_INFORMATION WHERE flightno=?";
			int rec=0;
			
			try {
				conn=util.getConnection();
				stmt=conn.prepareStatement(query);
				System.out.println(no);
				stmt.setString(1, no);
				rec=stmt.executeUpdate();
				if(rec>0)
					{
					System.out.println("Data deleted with Flight no"+no);
					return true;
					}
				else
					{
					System.out.println("Invalid Flight No in Else DB");
					}
			} catch (SQLException e) {
				
				System.out.println("Invalid Flight No");
				throw new BookingExceptions("Data not deleted"); 
				
			}
			finally
			{
			   try {
				 
					stmt.close();
					conn.close();
					
				  } catch (SQLException e) {
					e.printStackTrace();	
				}
			}
			return false;
	}
		
	

	@Override
	public boolean insertFlightDetails(FlightInfo flight)
			throws BookingExceptions {
		
		
	    int rec=0;
		String query="INSERT INTO FLIGHT_INFORMATION VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn=util.getConnection();
			stmt=conn.prepareStatement(query);
		
			stmt.setString(1,flight.getFlightno());
			stmt.setString(2,flight.getAirlinename());
			stmt.setString(3,flight.getDept_city());
			stmt.setString(4,flight.getArr_city());
			stmt.setDate(5,flight.getDep_date());
			stmt.setDate(6,flight.getArr_date());
			stmt.setString(7,flight.getDep_time());
			stmt.setString(8,flight.getArr_time());
			stmt.setInt(9, flight.getFirstseats());
			stmt.setInt(10, flight.getFirstseatfare());
			stmt.setInt(11, flight.getBussseats());
			stmt.setInt(12,flight.getBussseatfare());
			rec=stmt.executeUpdate();
			
			if(rec!=0)
			{
				System.out.println("Data Inserted in flight table");
				//mylogger.info("Data Inserted in purchase table with purchaseid "+pid);
				return true;
			
			}
			
		} catch (SQLException e) {
				//e.printStackTrace();
			//mylogger.error("Data not updated in purchase table");
			throw new BookingExceptions("Data not Inserted in flight table"); 
		}finally
		{
			   try {
					stmt.close();
					conn.close();
				  } catch (SQLException e) {
					e.printStackTrace();	
				}
			}
		
		return false;
	}

	@Override
	public boolean insertUsers(UserClass users)
			throws BookingExceptions {
		String query="INSERT INTO USERS VALUES (?,?,?,?,?,?)";
		int record=0;
		try {
			conn=util.getConnection();
			stmt=conn.prepareStatement(query);
			
			stmt.setString(1, users.getUsername());
			stmt.setString(2, users.getPassword());
			stmt.setString(3, users.getRole());
			stmt.setString(4, users.getMobile_no());
			stmt.setString(5, users.getFirstName());
			stmt.setString(6, users.getLastName());
			record=stmt.executeUpdate();
			if(record!=0)
			{
				System.out.println("User Inserted successfully");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BookingExceptions("User Not Registered");
		}
		finally
		{
		   try {
				stmt.close();
				conn.close();
			  } catch (SQLException e) {
				e.printStackTrace();	
			}
		}
		return false;
	}

	@Override
	public List<FlightInfo> searchBySrcDest(String src, String dest)
			throws BookingExceptions {
		String query="SELECT FLIGHTNO,AIRLINE,DEP_CITY,ARR_CITY,DEP_DATE,ARR_DATE,DEP_TIME,ARR_TIME,FIRSTSEATS,FIRSTSEATFARE,BUSSSEATS,BUSSSEATSFARE FROM FLIGHT_INFORMATION WHERE DEP_CITY=? AND ARR_CITY=?";
		List<FlightInfo> flightlistshow = new ArrayList<FlightInfo>();
		ResultSet res;
		try {
			conn=util.getConnection();
			stmt=conn.prepareStatement(query);
			stmt.setString(1, src);
			stmt.setString(2, dest);
			res=stmt.executeQuery();
			
			while(res.next()){
				FlightInfo flight=new FlightInfo();
				//System.out.println("flightno"+res.getString("FLIGHTNO"));
				String fno=res.getString("FLIGHTNO");
				flight.setFlightno(fno);
				String aname=res.getString("AIRLINE");
				flight.setAirlinename(aname);
				flight.setDept_city(res.getString("DEP_CITY"));
				flight.setArr_city(res.getString("ARR_CITY"));
				flight.setDep_date(res.getDate("DEP_DATE"));
				flight.setArr_date(res.getDate("ARR_DATE"));
				flight.setDep_time(res.getString("DEP_TIME"));
				flight.setArr_time(res.getString("ARR_TIME"));
				flight.setFirstseats(res.getInt("FIRSTSEATS"));
				flight.setFirstseatfare(res.getInt("FIRSTSEATFARE"));
				flight.setBussseats(res.getInt("BUSSSEATS"));
				flight.setBussseatfare(res.getInt("BUSSSEATSFARE"));
				//System.out.println(flight.toString());
				flightlistshow.add(flight);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally
		{
			   try {
					stmt.close();
					conn.close();
				  } catch (SQLException e) {
					e.printStackTrace();	
				}
			}
		return flightlistshow;
	}


	@Override
 	public int getSeatFare(String flightno,int noofpassengers,String seatType) throws BookingExceptions {
 		
 		String query = null;
 		String fare=null;
 		ResultSet res;
		if(seatType.equals("Business"))
		{
 		   query="SELECT bussseatsfare FROM flight_information where flightno=? ";
 		   fare="bussseatsfare";
		}
		else if(seatType.equals("First"))
		{
		  query="SELECT firstseatfare FROM flight_information where flightno=?  ";
		  fare="firstseatfare";
		}

 		int rec=0;
 		try {
 			conn =util.getConnection();
 			stmt=conn.prepareStatement(query);
 			stmt.setString(1,flightno);	
 			res=stmt.executeQuery();
			
			if(res.next()){
 				 System.out.println("flight seats fare");
 				 int flightfare= res.getInt(fare);
 				 int totalfare=noofpassengers*flightfare;
 				 return totalfare;
 				}
 			
 		} catch (SQLException e) {
 			System.out.println(e);
 				
 			throw new BookingExceptions("Fare not in Flight table"+e.getMessage()); 
 		}finally
		{
 		   try {
 				stmt.close();
 				conn.close();
 			  } catch (SQLException e) {
 				e.printStackTrace();	
 			}
 		}
		return 0;
 		
 	}
	
	@Override
	public List<FlightInfo> showFlightByDate(Date date)throws BookingExceptions {
		String query = "SELECT FLIGHTNO,AIRLINE,DEP_CITY,ARR_CITY,DEP_DATE,DEP_TIME,FIRSTSEATS,FIRSTSEATFARE,BUSSSEATS,BUSSSEATSFARE,ARR_DATE,ARR_TIME FROM FLIGHT_INFORMATION WHERE DEP_DATE=?";
		List<FlightInfo> infoList = new ArrayList<FlightInfo>();
		ResultSet res;

		try {
			conn = util.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setDate(1,date);
			res=stmt.executeQuery();
			while(res.next()){
				FlightInfo info = new FlightInfo();
				info.setFlightno(res.getString("FLIGHTNO"));
				info.setAirlinename(res.getString("AIRLINE"));
				info.setDept_city(res.getString("DEP_CITY"));
				info.setArr_city(res.getString("ARR_CITY"));
				info.setDep_date(res.getDate("DEP_DATE"));
				info.setDep_time(res.getString("DEP_TIME"));
				info.setFirstseatfare(res.getInt("FIRSTSEATFARE"));
				info.setFirstseats(res.getInt("FIRSTSEATS"));
				info.setBussseats(res.getInt("BUSSSEATS"));
				info.setBussseatfare(res.getInt("BUSSSEATSFARE"));
				info.setArr_date(res.getDate("ARR_DATE"));
				info.setArr_time(res.getString("ARR_TIME"));
				infoList.add(info);
				System.out.println(infoList);
			}
		} catch (SQLException e) {
			
			throw new BookingExceptions("No Flight Available for this Date"+e.getMessage());
		}
		finally
		{
			try {
				
				if(stmt!=null)
				{
				 stmt.close();
					
				}
				if(conn!=null)
				{
					conn.close();
				}
			} catch (SQLException e) {
				
				throw new BookingExceptions("JDBC connection closing Failed");
			}
		}
		return infoList;
	}

	@Override
	public String showBookingId(String email) throws BookingExceptions {
	
		String query="SELECT BOOKING_ID FROM BOOKINGINFORMATION WHERE CUST_EMAIL=?";
		ResultSet res;
		try {
			conn=util.getConnection();
			stmt=conn.prepareStatement(query);
			stmt.setString(1, email);
			res=stmt.executeQuery();
			if(res.next()){
				String bookid=res.getString("BOOKING_ID");
				return bookid;
			}
		} catch (SQLException e) {
			
			throw new BookingExceptions("Booking Does not exist for this user");
		}
		
		return null;
	}

	@Override
	public FlightInfo flightDetails(String flightno) throws BookingExceptions {
		
		String query="SELECT FLIGHTNO,AIRLINE,DEP_CITY,ARR_CITY,DEP_DATE,DEP_TIME,FIRSTSEATS,FIRSTSEATFARE,BUSSSEATS,BUSSSEATSFARE,ARR_DATE,ARR_TIME FROM FLIGHT_INFORMATION WHERE flightno=?";
		int rec=0;
		
		try {
			conn=util.getConnection();
			stmt=conn.prepareStatement(query);
			stmt.setString(1,flightno);
			System.out.println(flightno);
			
			FlightInfo flight=new FlightInfo();
			ResultSet res = stmt.executeQuery();
			if(res.next())
				{
					
				String fno=res.getString("FLIGHTNO");
				flight.setFlightno(fno);
				String aname=res.getString("AIRLINE");
				flight.setAirlinename(aname);
				flight.setDept_city(res.getString("DEP_CITY"));
				flight.setArr_city(res.getString("ARR_CITY"));
				flight.setDep_date(res.getDate("DEP_DATE"));
				flight.setArr_date(res.getDate("ARR_DATE"));
				flight.setDep_time(res.getString("DEP_TIME"));
				flight.setArr_time(res.getString("ARR_TIME"));
				flight.setFirstseats(res.getInt("FIRSTSEATS"));
				flight.setFirstseatfare(res.getInt("FIRSTSEATFARE"));
				flight.setBussseats(res.getInt("BUSSSEATS"));
				flight.setBussseatfare(res.getInt("BUSSSEATSFARE"));
				return flight;
				}
			else
				System.out.println("Invalid Flight No");
			
		} catch (SQLException e) {
			
			System.out.println("Invalid Flight No");
			throw new BookingExceptions("Data not found for given FlightNo"); 
			
		}
		finally
		{
		   try {
			 
				stmt.close();
				conn.close();
				
			  } catch (SQLException e) {
				  System.out.println(e.getMessage());
			}
	}
		return null;
	}
	
	
	@Override
 	public boolean updateFlightSeatQuantityOnCancellation(String flightno, int noofpassengers,String seattype) throws BookingExceptions {
 		
 		String query = null;
 		System.out.println(seattype);
		if(seattype.equals("Business"))
		{
			
 		   query="UPDATE flight_information set bussseats=bussseats+? where flightno=? ";
		}
		else if(seattype.equals("First"))
		{
		  query="UPDATE flight_information set firstseats=firstseats+? where flightno=? ";
		}

 		int rec=0;
 		try {
 			conn =util.getConnection();
 			stmt=conn.prepareStatement(query);
 			stmt.setInt(1,noofpassengers);
 			stmt.setString(2,flightno);	
 			rec=stmt.executeUpdate();
 			
 			if(rec>0)
 				{
 				 System.out.println("flight seats table updated");
 				 return true;
 				}
 			
 		} catch (SQLException e) {
 			System.out.println(e);
 			throw new BookingExceptions("Data not updated in Flight table"+e.getMessage()); 
 		}finally
		{
 		   try {
 				stmt.close();
 				conn.close();
 			  } catch (SQLException e) {
 				System.out.println(e.getMessage());
 			}
 		}
 		
 		return false;
 	}

	@Override
	public List<BookingInformation> showPassengerList(String flightno)
			throws BookingExceptions {
		String query="SELECT flightno,booking_id,cust_email,no_of_passengers,class_type FROM bookingInformation WHERE flightno=?";
		
		List<BookingInformation> passengerList;
		
		try {
			passengerList =new ArrayList<BookingInformation>();
			conn=util.getConnection();			
			stmt=conn.prepareStatement(query);
			System.out.println(flightno);
			stmt.setString(1, flightno);
			ResultSet res=stmt.executeQuery();
			
			System.out.println("ResultSet res"+res.toString());
				while(res.next())
				{
					
					BookingInformation bookingDet=new BookingInformation();
					bookingDet.setBooking_id(res.getString("booking_id"));
					bookingDet.setCust_email(res.getString("cust_email"));
					bookingDet.setNo_of_passenger(res.getInt("no_of_passengers"));
					bookingDet.setClass_type(res.getString("class_type"));
					/*bookingDet.setTotal_fare(res.getInt("total_fare"));
					bookingDet.setSeat_number(res.getInt("seat_numbers"));
					bookingDet.setCreditcard_info(res.getString("creditcard_info"));
					bookingDet.setSrc_city(res.getString("src_city"));
					bookingDet.setDest_city(res.getString("dest_city"));*/
					bookingDet.setFlightno(res.getString("flightno"));
					passengerList.add(bookingDet);
				}
					
		 } catch (SQLException e) {
				throw new BookingExceptions("Data Not found");
			
			
		}finally
		{
			   try {
					stmt.close();
					conn.close();
				  } catch (SQLException e) {
					System.out.println("Connection closing failed"+e);	
				}
			}

		return passengerList;
	}
	
	public boolean updateCancelFlight(String no) throws BookingExceptions{
		String query="UPDATE BOOKINGINFORMATION set flightno=null where flightno=? ";
		int newFlightNoValue;
		try {
			conn=util.getConnection();			
			stmt=conn.prepareStatement(query);
			System.out.println(no);
			stmt.setString(1, no);
			newFlightNoValue=stmt.executeUpdate();
			if(newFlightNoValue>0){
				return true;
			}
		} catch (SQLException e) {
			
			throw new BookingExceptions("FlightNo not present databsae");
		}
		return false;
	}
}








