<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<link rel="stylesheet" type="text/css" href="style.css">
<style>

#cont {
	float: left;
	width: 100%;
	background-color:DeepSkyBlue ;
	height: 400px;
	 background: url('cont.jpg');
	 background-repeat:no-repeat;
}
</style>
<title>All Flights Details</title>
</head>
<body background="bg1.jpg">
<div id="page-wrap">
  <img src="planebanner.jpg" width="1000px" height="250px">
<ul id="navlog">
  <li><a href="logout.do">Logout</a></li>
  </ul>
  
 
<div id="cont">
<br><br>
	<center><H2>WELCOME TO AIRLINE RESERVATION SYSTEM</H2></center>
	<center><h2><i>SHOWING FLIGHT DETAILS</i></h2></center><br>

	<TABLE border="1" align="center">
		<tr>
			<th><i>Flight No</i></th>
			<th><i>Airline Name</i></th>
			<th><i>Source</i></th>
			<th><i>Destination</i></th>
			<th><i>Departure Date</i></th>
			<th><i>Arrival Date</i></th>
			<th><i>Departure Time</i></th>
			<th><i>Arrival Time</i></th>
			<th><i>First Class Seats</i></th>
			<th><i>First Class Fare</i></th>
			<th><i>Business Class Seats</i></th>
			<th><i>Business Class Fare</i></th>
			<th><i>Book Ticket</i></th>
		</tr>
		
		<a:forEach var="flist" items="${flist}">
			<tr>
				<td>${flist.flightno }</td>
				<td>${flist.airlinename }</td>
				<td>${flist.dept_city }</td>
				<td>${flist.arr_city }</td>
				<td>${flist.dep_date }</td>
				<td>${flist.arr_date }</td>
				<td>${flist.dep_time }</td>
				<td>${flist.arr_time }</td>
				<td>${flist.firstseats }</td>
				<td>${flist.firstseatfare }</td>
				<td>${flist.bussseats }</td>
				<td>${flist.bussseatfare }</td>


				<td><a href="bookFlightDetails.do?id=${flist.flightno }&src=${flist.dept_city }&dest=${flist.arr_city }" style="color:white"><i>Book</i></a></td>
					
			</tr>



		</a:forEach>

	</TABLE>
	<br><br>
	<%-- <a href="bookingDetails.do">Show Booking Details</a> --%>
	<%-- <b><a href="user.do">Back</a></b> --%>
	<center><a href="user.do"><font color="black" size="4px"><i>Back</i></font></a></center>
</div>

<footer>Copyright &copy; ARS.com</footer>

</body>
</html>