<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><link rel="stylesheet" type="text/css" href="style.css">
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
<title>List of Flights</title>
</head>
<body background="bg1.jpg">
<div id="page-wrap">
  <img src="planebanner.jpg" width="1000px" height="250px">
<ul id="navlog">
  <li><a href="logout.do">Logout</a></li>
  </ul>
  
  
<div id="cont">
<br>
	<table border="1" align="center" color="#A9A9A9">
		<tr>
			<th><i>Flight Number</i></th>
			<th><i>Airline</i></th>
			<th><i>Source</i></th>
			<th><i>Destination</i></th>
			<th><i>Departure Date</i></th>
			<th><i>Arrival Date</i></th>
			<th><i>Departure Time:</i></th>
			<th><i>Arrival Time:</i></th>
			<th><i>First Class Seats</i></th>
			<th><i>First Class Seats Fare</i></th>
			<th><i>Business Class Seats</i></th>
			<th><i>Business Class Seats Fare</i></th>
			<th><colspan="2"><i>Actions</i></th>
			
		</tr>
		<c:forEach items="${ fList }" var="fList">
		<tr>
			<td>${ fList.flightno }</td>
			<td>${ fList.airlinename }</td>
			<td>${ fList.dept_city }</td>
			<td>${ fList.arr_city }</td>
			<td>${ fList.dep_date }</td>
			<td>${ fList.arr_date }</td>
			<td>${ fList.dep_time }</td>
			<td>${ fList.arr_time }</td>
			<td>${ fList.firstseats }</td>
			<td>${ fList.firstseatfare }</td>
			<td>${ fList.bussseats }</td>
			<td>${ fList.bussseatfare }</td>	
			<td><a href="updateFlightDetails.do?id=${fList.flightno}" style="color:white"><i>Update</i></a>	
				<a href="deleteFlights.do?id=${ fList.flightno }" style="color:white"><i>Cancel</i></a></td>
			
		</tr>
		</c:forEach>
	
	</table><br>
	<!-- <a href="addFlight.do">Insert New Flight</a><br> --><center><a href="addFlight.do" style="color:black" class="button"><font size="3px" color="black">Insert New Flight</font></a></center><br/>
	<center><a href="back.do"><font color="black" size="3px" class="button">Back</font></a></center>
	<div id="content1"></div>
<br><br><br>


</div>
<footer>Copyright &copy; ARS.com</footer>
</body>
</html>