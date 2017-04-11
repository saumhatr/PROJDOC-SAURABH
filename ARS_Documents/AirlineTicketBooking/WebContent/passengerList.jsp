<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<!DOCTYPE html>
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
<h2><i>SHOWING PASSENGER LIST FOR FLIGHT NO:${flightNo} <i></i></h2><br>

	<TABLE border="1" align="center" gcolor="#D0D0D0">
		<tr>
			<th><i>Booking ID</i></th>
			<th><i>Email</i></th>			
			<th><i>Seat Type</i></th>
			<th><i>No of Seats</i></th>
		</tr>
		
		<a:forEach var="pList" items="${pList}">
			<tr>
				<td>${pList.booking_id }</td>
				<td>${pList.cust_email }</td>				
				<td>${pList.class_type }</td>
				<td>${pList.no_of_passenger }</td>				
			</tr>
		</a:forEach>

	</TABLE>
	<br><br>


	<center><a href="passengerList.do"><font color="black">Back</font></a></center>
	
	<div id="content1"></div>
<br><br><br>
</div>
<!-- <img src="insideplane1.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane2.png" alt="Trolltunga Norway" width="330" height="210"> -->
<footer>Copyright &copy; ARS.com</footer>
</body>
</html>