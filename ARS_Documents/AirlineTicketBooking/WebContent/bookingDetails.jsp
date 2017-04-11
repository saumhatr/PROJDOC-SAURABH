<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Booking Details</title>

</head>
<body background="bg1.jpg">
 <div id="page-wrap">
  <img src="planebanner.jpg" width="1000px" height="250px">


<ul id="navlog">
  <li><a href="logout.do">Logout</a></li>
  </ul>
  

<div id="cont">
<br><br>
<center><h2><i>SHOWING BOOKING DETAILS</i></h2></center><br>

	<TABLE border="1" align="center" bgcolor="#D0D0D0">
		<tr>
			<th><i>Booking ID</i></th>
			<th><i>Email</i></th>
			<th><i>Flight No</i></th>
			<th><i>Source</i> </th>
			<th><i>Destination</i></th>
			<th><i>Seat Type</i></th>
			<th><i>Total Seats</i></th>
			<th><i>Total Fare</i></th>
			<th><i>Cancel Booking</i></th>
		</tr>
		
		<%-- <a:forEach var="bookedDetails" items="${bookedDetails}"> --%>
			<tr>
				<td>${bookedDetails.booking_id }</td>
				<td>${bookedDetails.cust_email }</td>
				<td>${bookedDetails.flightno }</td>
				<td>${bookedDetails.src_city }</td>
				<td>${bookedDetails.dest_city }</td>
				<td>${bookedDetails.class_type }</td>
				<td>${bookedDetails.no_of_passenger }</td>
				<td>${bookedDetails.total_fare }</td>
		
				<td><a href="cancelBooking.do?id=${bookedDetails.booking_id}&name=${bookedDetails.class_type }" style="color:white"><i>Cancel Booking</i></a></td>
			</tr>



		<%-- </a:forEach> --%>

	</TABLE>
	<br><br>
	
	<%-- <h4><a href="user.do"><font color="orange">Back</font></a></h4> --%>
	<center><a href="user.do" class="button"><font color="black"><i>Back</i></font></a></center>
<div id="content1"></div>
<br><br><br>
</div>

<footer>Copyright &copy; ARS.com</footer>
</body>
</html>



