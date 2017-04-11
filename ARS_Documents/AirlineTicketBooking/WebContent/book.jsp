<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
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
		<title>Booking Page</title>
	</head>
	<body background="bg1.jpg">
	<div id="page-wrap">
  <img src="planebanner.jpg" width="1000px" height="250px">


<ul id="navlog">
  <li><a href="logout.do">Logout</a></li>
  </ul>
  
  <br><br>
<div id="cont">
<br><br><br>
		<form action="booked.do" method="post" align="center">
	<table border="1" bgcolor="#D0D0D0">
		<tr>
			<th>Flight Number: </th>
			<td><input type="text" name="flightNo" value="${ flightCode }" readonly></td>
		</tr>
		
		<tr>
			<th>Source:</th>
			<td><input type="text" name="src" value="${ flightSrc }" readonly></td>
		</tr>	
		<tr>
			<th>Destination:</th>
			<td><input type="text" name="dest" value="${ flightDest }"  readonly></td>
		</tr>
		<tr>
			<th>Email:</th>
			<td><input type="text" name="mail" pattern="^[A-za-z0-9]{1,}[@]{1}[a-z]{1,}[.]{1}[a-z]{1,3}" title="Example: abc@gmail.com" required></td>
		</tr>
		<tr>
			<th>No of Passenger:</th>
			<td><input type="text" name="noOfPassenger" min="1" max="5" required></td>
		</tr>
		<tr>
			<th>Class Type:</th>
			<td>
				<select name="type" required>
					<option>Select Class</option>
					<option value="First">First Class</option>
					<option value="Business">Business Class</option>
				</select>
			</td>
		</tr>
	<tr>
			<th>Credit Card No:</th>
			<td><input type="text" name="creditCardNo" pattern="[0-9]{15}" title="Number should contain 15 digits" required></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Book" class="button">
			<input type="reset" value="Cancel" class="button"></td>
		</tr>
		

	</table><br>
	</form>
	<center><a href="getAllFlightDetails.do"  class="button" colspan="2">Back</a></center>
	<div id="content1"></div>
<br><br><br>
</div>
<footer>Copyright &copy; ARS.com</footer>
	</body>
</html>