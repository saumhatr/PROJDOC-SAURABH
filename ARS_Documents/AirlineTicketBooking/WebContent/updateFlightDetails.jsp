<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><link rel="stylesheet" type="text/css" href="style.css">
<style>

#cont {
	float: left;
	width: 100%;
	background-color:DeepSkyBlue ;
	height: 550px;
	 background: url('cont.jpg');
	 background-repeat:no-repeat;
}
</style>
</head>
<body background="bg1.jpg">

<div id="page-wrap">
  <img src="planebanner.jpg" width="1000px" height="250px">
<ul id="navlog">
  <li><a href="logout.do">Logout</a></li>
  </ul>
  

<div id="cont">

	<form action="updatedFlightDetails.do" method="post">
	<table border="1" align="center" bgcolor="#D0D0D0">
		<tr>
			<th><i>Flight Number:</i> </th>
			<td><input type="text" name="flightNo" value="${ flight.flightno }" readonly></td>
		</tr>
		<tr>
			<th><i>Airline:</i></th>
			<td><input type="text" name="airLine" value="${ flight.airlinename }" readonly></td>
		</tr>
		<tr>
			<th><i>Source:</i></th>
			<td><input type="text" name="src" value="${ flight.dept_city }" required></td>
		</tr>	
		<tr>
			<th><i>Destination:</i></th>
			<td><input type="text" name="dest" value="${ flight.arr_city }" required></td>
		</tr>
		<tr>
			<th><i>Departure Date:</i></th>
			<td><input type="date" name="dDate" value="${ flight.dep_date }" required></td>
		</tr>
		<tr>
			<th><i>Arrival Date:</i></th>
			<td><input type="date" name="aDate" value="${ flight.arr_date }" required></td>
		</tr>
		<tr>
			<th><i>Departure Time:</i></th>
			<td><input type="time" name="dTime" value="${ flight.dep_time }" required></td>
		</tr>
		<tr>
			<th><i>Arrival Time:</i></th>
			<td><input type="time" name="aTime" value="${ flight.arr_time }" required></td>
		</tr>
		<tr>
			<th><i>First Class Seats:</i></th>
			<td><input type="text" name="fSeats" value="${ flight.firstseats }"  pattern="^[1-9]{1}[0-9]{1}" title="Example:50"  required></td>
		</tr>
		<tr>
			<th><i>First Class Seats Fare:</i></th>
			<td><input type="text" name="fSeatsFare" value="${ flight.firstseatfare }" pattern="^[1-9]{1}[0-9]{1,5}" title="Example:20000" required></td>
		</tr>
		<tr>
			<th><i>Business Class Seats:</i></th>
			<td><input type="text" name="bSeats" value="${ flight.bussseats }"  pattern="^[1-9]{1}[0-9]{1}" title="Example:50"  required></td>
		</tr>
		<tr>
			<th><i>Business Class Seats Fare:</i></th>
			<td><input type="text" name="bSeatsFare" value="${ flight.bussseatfare }" pattern="^[1-9]{1}[0-9]{1,5}" title="Example:20000" required></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Update" class="button">
			<input type="reset" value="Cancel" class="button"></td>
		</tr>
	</table>
	</form>
	<!-- <a href="flightInfo.do"><font color="orange">Back</font></a> -->
	<center><a href="flightInfo.do"><font color="black" size="3px" class="button">Back</font></a></center>
	
	<div id="content1"></div>
<br><br><br>
</div>
<!-- <img src="insideplane1.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane2.png" alt="Trolltunga Norway" width="330" height="210"> -->
<footer>Copyright &copy; ARS.com</footer>
</body>
</html>