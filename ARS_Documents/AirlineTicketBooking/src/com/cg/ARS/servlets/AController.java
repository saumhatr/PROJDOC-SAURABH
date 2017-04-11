package com.cg.ARS.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.ARS.dto.BookingInformation;
import com.cg.ARS.dto.FlightInfo;
import com.cg.ARS.dto.UserClass;
import com.cg.ARS.exceptions.BookingExceptions;
import com.cg.ARS.services.BookingServices;
import com.cg.ARS.services.BookingServicesImpl;



@WebServlet("*.do")
public class AController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingServices services;
	private ServletContext ctx;

	public void init() throws ServletException {
		
		ctx=super.getServletContext();
		services=(BookingServices)ctx.getAttribute("services");
		try {
			services = new BookingServicesImpl();
		} catch (BookingExceptions e) {
			System.out.println(e);
		}
	}
	
/*	public AController() throws BookingExceptions {
		
		ctx=super.getServletContext();
		services=(BookingServices)ctx.getAttribute("services");
		services = new BookingServicesImpl();
	}
	*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
		
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String cmd = request.getServletPath();
		System.out.println(cmd);
		String nextJsp = null;
		RequestDispatcher dispatcher = null;
		switch (cmd) {
		
		case "/home.do":
			nextJsp="home.jsp";
			break;
		
		case "aboutus.do":
			nextJsp="aboutUs.jsp";
			break;
		case "/login.do":
				nextJsp="login.jsp";
				break;
				
		
	
			
		case "/successLogin.do":
			String userName = request.getParameter("userNm");
			String password = request.getParameter("password");
			try {
				//boolean result=services.validateAdmin(userName);
				boolean result=services.isUserAuthenticated(userName,password);
				System.out.println("Authentic user"+result);
				/*nextJsp="adminHome.jsp";*/
				String admin="admin";
				String executive="executive";
				if(result)
				{
					if(userName.equals(admin)){
						HttpSession session=request.getSession(true);
						System.out.println("session id:"+session.getId());
						session.setAttribute("user", admin);
						ctx.log("Valid user session started with id"+session.getId());
						request.setAttribute("user", userName);
						nextJsp="adminHome.jsp";
					}else if(userName.equals(executive)){
						HttpSession session=request.getSession(true);
						System.out.println("session id:"+session.getId());
						session.setAttribute("user", executive);
						ctx.log("Valid user session started with id"+session.getId());
						String eUserName = "Executive";
						request.setAttribute("user", eUserName);
						nextJsp="airLineExecutive.jsp";
					}else{
						HttpSession session=request.getSession(true);
						System.out.println("session id:"+session.getId());
						session.setAttribute("user",userName);
						ctx.log("Valid user session started with id"+session.getId());
						request.setAttribute("user", userName);
						nextJsp="userFunctions.jsp";
					}
				}
				else
				{
					String errMsg="Wrong Credentials";
					request.setAttribute("error",errMsg);
					nextJsp = "error.jsp";
				}
				
			} catch (BookingExceptions e) {
				String errMsg="Wrong Credentials";
				request.setAttribute("error",errMsg);
				nextJsp = "error.jsp";
				//System.out.println("Wrong Credentials");
			}
			
			
			break;
			
		case "/back.do":
			{
				HttpSession session = request.getSession(false);
				String userLog=(String) session.getAttribute("user");
				System.out.println(userLog);
				if(userLog==null){
					nextJsp = "login.jsp";
					break;
				}else if(userLog.equals("admin")){
					//String user = "admin";
					request.setAttribute("user", userLog);
					nextJsp="adminHome.jsp";
					break;
				}else if(userLog.equals("executive")){
					//String executive="executive";
					request.setAttribute("executive", userLog);
					nextJsp = "airLineExecutive.jsp";
					break;
				}
			}
			
		case "/flightInfo.do":
			{
				List<FlightInfo> fList=null;
			
			try {
				fList = services.showAll();
				
			} catch (BookingExceptions e) 
			{
			
				String errMsg="Data not found.";
				request.setAttribute("error",errMsg);
				nextJsp = "error.jsp";
				//System.out.println("Data not found.");
			}
			request.setAttribute("fList", fList);
			nextJsp="flightInfo.jsp";
			break;
			}
		case "/addFlight.do":
		{
			HttpSession session = request.getSession(false);
			nextJsp="addFlight.jsp";
	
			break;
		}
		
		
		case "/successInsert.do":
		{
			HttpSession session = request.getSession(false);
			FlightInfo info = new FlightInfo();
			info.setFlightno(request.getParameter("flightNo"));
			info.setAirlinename(request.getParameter("airLine"));
			info.setDept_city(request.getParameter("src"));
			info.setArr_city(request.getParameter("dest"));
			
			try {
				String d=request.getParameter("dDate").toString();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = sdf1.parse(d);
				java.sql.Date sqldeptDate = new Date(date.getTime());
				System.out.println(sqldeptDate);
				info.setDep_date(sqldeptDate);
				
				String a=request.getParameter("aDate").toString();
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date1 = sdf2.parse(d);
				java.sql.Date sqlarrDate = new Date(date1.getTime());
				System.out.println(sqlarrDate);
				info.setArr_date(sqlarrDate);
			} catch (ParseException e1) {
				
				System.out.println("Date parsing error");
			}
			
			info.setDep_time(request.getParameter("dTime"));
			info.setArr_time(request.getParameter("aTime"));
			
			String fseat=request.getParameter("fSeats");
			info.setFirstseats(Integer.parseInt(fseat));
			
			String fSeatFare=request.getParameter("fSeatsFare");
			info.setFirstseatfare(Integer.parseInt(fSeatFare));
			
			String bseat=request.getParameter("bSeats");
			info.setBussseats(Integer.parseInt(bseat));
			
			String bSeatfare=request.getParameter("bSeatsFare");
			info.setBussseatfare(Integer.parseInt(bSeatfare));
			
			try {
				services.insertFlightDetails(info);
				String flightCode=request.getParameter("flightNo");
				String flightName=request.getParameter("airLine");
				request.setAttribute("flightNo", flightCode);
				request.setAttribute("airLine", flightName);
				nextJsp = "successInsert.jsp";
			} catch (BookingExceptions e1) {
				String errMsg="Flight Data not inserted";
				request.setAttribute("error",errMsg);
				nextJsp = "error.jsp";
				//System.out.println("Insert calling failed in controller");
			}
			break;
		}
		
		case "/updateFlightDetails.do":
		{
			HttpSession session = request.getSession(false);
			{
				String id = request.getParameter("id");
				try {
					FlightInfo flight=services.flightDetails(id);
					System.out.println("flight info"+flight);
					/*	request.setAttribute("flightNo", id);
					String airLine = request.getParameter("name");
					request.setAttribute("airline", airLine);*/
					request.setAttribute("flight", flight);
					System.out.println(id);
					nextJsp = "updateFlightDetails.jsp";
				} catch (BookingExceptions e) {
					String errMsg="Flight Details Not Updated ";
					request.setAttribute("error",errMsg);
					nextJsp = "error.jsp";
				}
		
				break;
			}
		}
				
		case "/updatedFlightDetails.do":
		{
			HttpSession session = request.getSession(false);
			FlightInfo updateInfo = new FlightInfo();
			updateInfo.setFlightno(request.getParameter("flightNo"));
			updateInfo.setAirlinename(request.getParameter("airLine"));
			updateInfo.setDept_city(request.getParameter("src"));
			updateInfo.setArr_city(request.getParameter("dest"));
			
			try {
				String d=request.getParameter("dDate").toString();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = sdf1.parse(d);
				java.sql.Date sqldeptDate = new Date(date.getTime());
				System.out.println(sqldeptDate);
				updateInfo.setDep_date(sqldeptDate);
				
				String a=request.getParameter("aDate").toString();
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date1 = sdf2.parse(d);
				java.sql.Date sqlarrDate = new Date(date1.getTime());
				System.out.println(sqlarrDate);
				updateInfo.setArr_date(sqlarrDate);
			} catch (ParseException e1) {
				
				System.out.println("Date parsing error");
			}
			
			updateInfo.setDep_time(request.getParameter("dTime"));
			updateInfo.setArr_time(request.getParameter("aTime"));
			
			String updateFseat=request.getParameter("fSeats");
			updateInfo.setFirstseats(Integer.parseInt(updateFseat));
			
			String updatefSeatFare=request.getParameter("fSeatsFare");
			updateInfo.setFirstseatfare(Integer.parseInt(updatefSeatFare));
			
			String updateBseat=request.getParameter("bSeats");
			updateInfo.setBussseats(Integer.parseInt(updateBseat));
			
			String updateBSeatfare=request.getParameter("bSeatsFare");
			updateInfo.setBussseatfare(Integer.parseInt(updateBSeatfare));
			
			try {
					boolean update=services.updateFlightInfo(updateInfo);
					if(update)
					{	
					String f=request.getParameter("flightNo");
					request.setAttribute("flightNo", f);
					nextJsp="successUpdate.jsp";
					}
					else
					{
						String errMsg="Failed to update flight information";
						request.setAttribute("error",errMsg);
						nextJsp = "error.jsp";
					}
				
			} catch (BookingExceptions e2) {
				String errMsg="Failed to update flight information";
				request.setAttribute("error",errMsg);
				nextJsp = "error.jsp";
				//System.out.println("Failed to update flight information"+e2);
			}
			break;
			
		}
		
		case "/deleteFlights.do":
		{
			//HttpSession session = request.getSession(false);
			
			try {
				String no1 = request.getParameter("id");
				System.out.println(no1);
				boolean status=	services.deleteFlight(no1);
				System.out.println("Cancel flight in Admin"+status);
				if(status==true){
				nextJsp = "successDelete.jsp";
				}
				else
				{
					String errMsg="Flight information not deleted";
					request.setAttribute("error",errMsg);
					nextJsp = "error.jsp";
				}
			} catch (BookingExceptions e) {
				String errMsg="Flight information not deleted";
				request.setAttribute("error",errMsg);
				nextJsp = "error.jsp";
				
			}
			
			break;
		}
		
		
		case "/srsDes.do":
		{
			HttpSession session = request.getSession(false);
			String user=(String) session.getAttribute("user");
			session.setAttribute("user", user);
			nextJsp="searchBySrcDes.jsp";
			break;
		}	
		
		
		case "/seacrchFlight.do":
		{
			HttpSession session = request.getSession(false);
			String src= request.getParameter("source");
			String dest=request.getParameter("destination");
			List<FlightInfo> searchList;
			try {
				searchList = services.searchBySrcDest(src,dest);
				System.out.println(searchList);
				if(searchList.isEmpty()){
					String errMsg="No flights available for this Source and Destination";
					request.setAttribute("error",errMsg);
					nextJsp = "error.jsp";
				
				}
				else{
					request.setAttribute("sList", searchList);
					nextJsp="successSearch.jsp";
				}
			} catch (BookingExceptions e1) {
				
				String errMsg="No flights available for this Source and Destination";
				request.setAttribute("error",errMsg);
				nextJsp = "error.jsp";
				
			}
			catch(Exception e){
				String errMsg="No flights available for this Source and Destination";
				request.setAttribute("error",errMsg);
				nextJsp = "error.jsp";
			}
			
			
			break;
		}
		
		case "/passengerList.do":{
			nextJsp="searchFlightPassengers.jsp";
			break;
		}
		
		case "/passengerListDisplay.do":{
			HttpSession session = request.getSession(false);
			String flightno= request.getParameter("flightNo");
			List<BookingInformation> passengerList=null;
			try {
				passengerList = services.showPassengerList(flightno);
				if(passengerList.isEmpty())
				{	
				/*request.setAttribute("flightNo", flightno);
				request.setAttribute("pList", passengerList);
				nextJsp="passengerList.jsp";*/
				String errMsg="No Passengers found for this flight";
				request.setAttribute("error",errMsg);
				nextJsp = "error.jsp";
				}
				else
				{
					request.setAttribute("flightNo", flightno);
					request.setAttribute("pList", passengerList);
					nextJsp="passengerList.jsp";
					
				}
				
			} catch (BookingExceptions e1) {
				
				String errMsg="No Passengers found for this flight";
				request.setAttribute("error",errMsg);
				nextJsp = "error.jsp";
				
			}
			
			break;
		}
		
			
		case "/executive.do":
		{
			HttpSession session = request.getSession(false);
			nextJsp = "executive.jsp";
			break;
		}
		
		case "/register.do":
		{
			HttpSession session = request.getSession(false);
			System.out.println("resister....do");
			
			String uFname=request.getParameter("uFname");
			String uLname=request.getParameter("uLname");
			String uName=request.getParameter("uName");
			String pass=request.getParameter("password");
			String rePassword=request.getParameter("rePassword");
			String role="user";
			String mobile=request.getParameter("phone");
			if(pass.equals(rePassword)){
				UserClass users=new UserClass();
				users.setFirstName(uFname);
				users.setLastName(uLname);
				users.setUsername(uName);
				users.setPassword(pass);
				users.setRole(role);
				users.setMobile_no(mobile);
				try {
					boolean insert=services.insertUser(users);
					System.out.println(insert);
					if(insert==true){
						request.setAttribute("uName", uName);
						request.setAttribute("mobile", mobile);
						nextJsp="RegisteredUser.jsp";
					}
				} catch (BookingExceptions e) {
	
					String errMsg="Registration Failed";
					request.setAttribute("error",errMsg);
					nextJsp = "error.jsp";
					//System.out.println("Error in insert"+e);
				}
			}else{
				String msg="Password does not match with Re-enter Password. Please enter again";
				request.setAttribute("msg", msg);
				request.setAttribute("uFname", uFname);
				request.setAttribute("uLname", uLname);
				request.setAttribute("uName", uName);
				request.setAttribute("mobile", mobile);
				nextJsp="register.jsp";
			}
			break;
		}
		
		
		case "/user.do":
		{
			HttpSession session = request.getSession(false);
			/* try {
					
					List<FlightInfo> flightList = services.showAll();
					System.out.println(flightList);
					request.setAttribute("flist",flightList);
					//nextJsp="flightDetails.jsp";
					
					
				} catch (BookingExceptions e) {
					
					e.printStackTrace();
				}*/
			nextJsp = "userFunctions.jsp";
			break;
		}
		
		case "/getAllFlightDetails.do":
		{
			HttpSession session = request.getSession(false);
			 try {
				
				List<FlightInfo> flightList = services.showAll();
				System.out.println(flightList);
				request.setAttribute("flist",flightList);
				nextJsp="flightDetails.jsp";
				
				
			} catch (BookingExceptions e) {
				
				String errMsg="No Flights Found";
				request.setAttribute("error",errMsg);
				nextJsp = "error.jsp";
			}
			 break;
		}
		
		case"/searchDate.do":{
			HttpSession session = request.getSession(false);
			String user=(String) session.getAttribute("user");
			session.setAttribute("user", user);
			nextJsp="searchByDate.jsp";
			break;
		}
		
		case "/searchByDate.do":
		
			
		{
			HttpSession session = request.getSession(false);
			List<FlightInfo> infoList;
			try {
				String d=request.getParameter("dateSearch").toString();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = sdf1.parse(d);
				java.sql.Date sqldeptDate = new Date(date.getTime());	
				infoList =  services.showFlightByDate(sqldeptDate);	
				request.setAttribute("fList", infoList);
				System.out.println("In controller of searchByDate"+infoList);
				nextJsp="searchFlights.jsp";
			} catch (ParseException | BookingExceptions e1) {
				String errMsg="No Flights Found for selected Date";
				request.setAttribute("error",errMsg);
				nextJsp = "error.jsp";
				//System.out.println(e1);
			}	
			
			//nextJsp="searchFlights.jsp";
			break;
			
		}	
		
			 
		case "/bookFlightDetails.do":
		{
			HttpSession session = request.getSession(false);
			String flightId=request.getParameter("id");
			String flightSrc=request.getParameter("src");
			String flightDest=request.getParameter("dest");
			request.setAttribute("flightCode", flightId);
			request.setAttribute("flightSrc", flightSrc);
			request.setAttribute("flightDest", flightDest);
			nextJsp="book.jsp";
			break;
		}
		
		case "/booked.do":
			{
				HttpSession session = request.getSession(false);
				try {
				BookingInformation book = new BookingInformation();
				String no=request.getParameter("flightNo");
				String source=request.getParameter("src");
				book.setSrc_city(source);
				String des=request.getParameter("dest");
				book.setDest_city(des);
				String mailId=request.getParameter("mail");
				String noOfPassenger=request.getParameter("noOfPassenger");
				int passengerNo=Integer.parseInt(noOfPassenger);
				String classType=request.getParameter("type");
				String cardNo=request.getParameter("creditCardNo");
				book.setCust_email(mailId);
				book.setNo_of_passenger(passengerNo);
				book.setClass_type(classType);
				book.setCreditcard_info(cardNo);
		
				boolean booked=services.addBookingDetails(book,no);
				boolean flightSeatUpdate=services.updateFlightSeatQuantity(no, passengerNo, classType);
				String bookingid=services.showBookingId(mailId);
				request.setAttribute("bookid", bookingid);
				request.setAttribute("flight", no);
				request.setAttribute("bookedticket", booked);
				nextJsp="successBooking.jsp";
			} catch (BookingExceptions e) {
				String errMsg="Booking Failed";
				request.setAttribute("error",errMsg);
				nextJsp = "error.jsp";
				//System.out.println(e);
			}
			
			
			break;	
			}
			
		case "/bookingDetails.do":
		{
			HttpSession session = request.getSession(false);
			String bookid=request.getParameter("id");
			BookingInformation bookedDetails=null;
			try {
				bookedDetails=services.showBookingDetails(bookid);
				request.setAttribute("bookedDetails", bookedDetails);
				nextJsp="bookingDetails.jsp";
			} catch (BookingExceptions e) {
				String errMsg="No Booking Details Found";
				request.setAttribute("error",errMsg);
				nextJsp = "error.jsp";
				//System.out.println(e);
			}
			//BookingInformation book =services.showBookingDetails(bookId);
			break;	
		}
		
		case "/cancelBooking.do":
		{
			HttpSession session = request.getSession(false);
			String bookid=request.getParameter("id");
			String seatType=request.getParameter("name");
			System.out.println("Cancel id"+bookid);
			
			try {
				BookingInformation bookedDetails=services.showBookingDetails(bookid);
				boolean update=services.updateFlightSeatQuantityOnCancellation(bookedDetails.getFlightno(),bookedDetails.getNo_of_passenger(),seatType);
				boolean canceledTicket=services.cancelBooking(bookid);
				
				
				System.out.println("Flight Seats updated on cancel"+update);
				request.setAttribute("bookid", bookid);
				nextJsp="successCancel.jsp";
			} catch (BookingExceptions e) {
				String errMsg="Cancellation Failed ";
				request.setAttribute("error",errMsg);
				nextJsp = "error.jsp";
				//System.out.println(e);
			}
			break;	
		}
		
		case "/logout.do" :
		   {
				HttpSession session=request.getSession(false);//to close session or get the old session and not create new session
				session.invalidate();//Destroys a session.
				ctx.log("session invalidated");
				nextJsp="home.jsp";
				//RequestDispatcher req=request.getRequestDispatcher("/login.jsp");
				//req.forward(request, response);
				
			}//end of case for logout.do
			
		 

		default:
			break;
		}
			
		dispatcher = request.getRequestDispatcher(nextJsp);
		dispatcher.forward(request, response);
	}
	  public void destroy() {
			services=null;
			ctx.log("In destroy");
		}

}
