<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
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

<title>Add Flight Details</title>
</head>
<body background="bg1.jpg">
<div id="page-wrap">
  <img src="planebanner.jpg" width="1000px" height="250px">
<ul id="navlog">
  <li><a href="logout.do">Logout</a></li>
  </ul>
  

<div id="cont">
<br><br>
<center><H2><i>Add Flight</i></H2></center><br>
	<form action="successInsert.do" method="post">
	
	<table border="1" align="center" bgcolor="#D0D0D0">
		<tr>
			<th align="left"><i>Flight Number: </i></th>
			<td><input type="text" name="flightNo" pattern="^[A-Z]{1}[0-9]{1,3}" title="Example:S121" required></td>
		</tr>
		<tr>
			<th align="left"><i>Airline</i></th>
			<td><select name="airLine" required>
					<option value="">Select Airline</option>
					<option value="Indigo">Indigo</option>
					<option value="Spicejet">Spicejet</option>
					<option value="Emirates">Emirates</option>
					<option value="AirIndia">AirIndia</option>
					<option value="TigerAirways">Tiger Airways</option>
					<option value="JetAirways">Jet Airways</option>
					</select></td>
			
		</tr>
		<tr>
			<th align="left"><i>Source</i></th>
			<!-- <td><input type="text" name="src" required></td> -->
			<td><select name="src" required>
					<option value="">Please select</option>
					<option value="Mumbai">Mumbai</option>
					<option value="Pune">Pune</option>
					<option value="Chennai">Chennai</option>
					<option value="Delhi">Delhi</option>
					<option value="Goa">Goa</option>
					<option value="Banglore">Banglore</option>
					<option value="Kolkata">Kolkata</option>
					<option value="NewYork ">New York </option>
					<option value="Srinagar">Srinagar</option>
					<option value="Amsterdam">Amsterdam</option>
				</select></td>
		</tr>	
		<tr>
			<th align="left"><i>Destination:</i></th>
			<!-- <td><input type="text" name="dest" required></td> -->
			<td><select name="dest" required>
					<option value="">Please select</option>
					<option value="Mumbai">Mumbai</option>
					<option value="Pune">Pune</option>
					<option value="Chennai">Chennai</option>
					<option value="Guwahati">Guwahati</option>
					<option value="Banglore">Banglore</option>
					<option value="Kolkata">Kolkata</option>
					<option value="NewYork ">New York </option>
					<option value="Srinagar">Srinagar</option>
					<option value="Amsterdam">Amsterdam</option>
					</select></td>
		</tr>
		<tr>
			<th align="left"><i>Departure Date:</i></th>
			<td><input type="date" name="dDate"  required></td>
		</tr>
		<tr>
			<th align="left"><i>Arrival Date:</i></th>
			<td><input type="date" name="aDate" min="2017-04-06" required ></td>
		</tr>
		<tr>
			<th align="left"><i>Departure Time:</i></th>
			<td><input type="time" name="dTime" required></td>
		</tr>
		<tr>
			<th align="left"><i>Arrival Time:</i></th>
			<td><input type="time" name="aTime" required></td>
		</tr>
		<tr>
			<th align="left"><i>First Class Seats:</i></th>
			<td><input type="text" name="fSeats" pattern="^[1-9]{1}[0-9]{1}" title="Example:50" required></td>
		</tr>
		<tr>
			<th align="left"><i>First Class Seats Fare:</i></th>
			<td><input type="text" name="fSeatsFare" min="1" max="5000" required></td>
		</tr>
		<tr>
			<th align="left"><i>Business Class Seats:</i></th>
			<td><input type="text" name="bSeats" pattern="^[1-9]{1}[0-9]{1}" title="Example:50" required></td>
		</tr>
		<tr>
			<th align="left"><i>Business Class Seats Fare:</i></th>
			<td><input type="text" name="bSeatsFare" min="1" max="10000" required></td>
		</tr>
		<tr>
		<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" name="submit" value="Add Flight"  class="button" align="left"></td>
			<td>
			<input type="submit" name="submit" value="Cancel"  class="button" ></td>
		</tr>
	</table>
	</form><br>
	<center><a href="adminUpdate.do"><font color="black" class="button">Back</font></a></center>
	</div>
<div id="content1"></div>
<br><br><br>
<footer>Copyright &copy; ARS.com</footer>
</div>
</body>
</html>