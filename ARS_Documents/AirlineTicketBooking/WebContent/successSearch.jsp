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
	</head>
	<body>
	<div id="page-wrap">
  <img src="planebanner.jpg" width="1000px" height="250px">
<ul id="navlog">
  <li><a href="logout.do">Logout</a></li>
  </ul>

<div id="cont">
<br><br><br>
		<table border="1" align="center">
		<tr>
			<th><i>Flight Number</i></th>
			<th><i>Airline</i></th>
			<!-- <th>Departure Date</th>
			<th>Arrival Date</th>
			<th>Departure Time:</th>
			<th>Arrival Time:</th> -->
			<th><i>First Class Seats</i></th>
		<!-- 	<th>First Class Seats Fare</th> -->
			<th><i>Business Class Seats</i></th>
		<!-- 	<th>Business Class Seats Fare</th> -->
			
			
		</tr>
		<c:forEach items="${ sList }" var="sListt">
		<tr>
			<td>${ sListt.flightno }</td>
			<td>${ sListt.airlinename }</td>
		<%-- 	<td>${ sListt.dep_date }</td>
			<td>${ sListt.arr_date }</td>
			<td>${ sListt.dep_time }</td>
			<td>${ sListt.arr_time }</td> --%>
			<td>${ sListt.firstseats }</td>
		<%-- 	<td>${ sListt.firstseatfare }</td> --%>
			<td>${ sListt.bussseats }</td>
		<%-- 	<td>${ sListt.bussseatfare }</td>	 --%>
			
			
		</tr>
		</c:forEach>
	
	</table><br>
	
	<center><a href="srsDes.do"><font color="black" size="4px" class="button">Back</font></a></center>
	</div>
<div id="content1"></div>
<br><br><br>
</div>
<!-- <img src="insideplane1.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane2.png" alt="Trolltunga Norway" width="330" height="210"> -->
<footer>Copyright &copy; ARS.com</footer>
	</body>
</html>