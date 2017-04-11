<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
		<style>
body{
 background-image: url('plane.jpg');
  background-repeat: no-repeat;
}
a{
align:center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Flights Executive</title>
</head>
<body background="bg1.jpg">
	<table border="1" align="center">
		<tr>
			<th>Flight Number</th>
			<th>Airline</th>
			<th>Source</th>
			<th>Destination</th>
		
			<th>First Class Seats</th>
	
			<th>Business Class Seats</th>
			<!-- 	<th>Departure Date</th>
			<th>Arrival Date</th>
			<th>Departure Time:</th>
			<th>Arrival Time:</th> -->
			<!-- 		<th>First Class Seats Fare</th> -->
			<!-- <th>Business Class Seats Fare</th>	 -->
		</tr>
		<c:forEach items="${ fList }" var="fList">
		<tr>
			<td>${ fList.flightno }</td>
			<td>${ fList.airlinename }</td>
			<td>${ fList.dept_city }</td>
			<td>${ fList.arr_city }</td>
		
			<td>${ fList.firstseats }</td>
			<td>${ fList.bussseats }</td>
			<%-- 	<td>${ fList.dep_date }</td>
			<td>${ fList.arr_date }</td>
			<td>${ fList.dep_time }</td>
			<td>${ fList.arr_time }</td> --%>
		<%-- 	<td>${ fList.firstseatfare }</td> --%>
		<%-- 	<td>${ fList.bussseatfare }</td> --%>		
		</tr>
		</c:forEach>
	</table>
	<a href="searchDate.do"><font color="orange">Back</font></a>
</body>
</html>