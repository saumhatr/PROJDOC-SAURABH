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
	</head>
	<body background="bg1.jpg">
	<div id="page-wrap">
  <img src="planebanner.jpg" width="1000px" height="250px">
 <ul id="navlog">
  <li><a href="logout.do">Logout</a></li>
  </ul>
  

<div id="cont">
<br><br><br>
		<form action="seacrchFlight.do" align="center">
			<table>
				<tr>
					<td align="left"><font size="5px"><i>Enter Source:</i></font></td>
					<!-- <input type="text" name="source" >  -->
					<td><select name="source" required>
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
					<td><font size="5px"><i>Enter Destination:</i></font></td>
					<!-- <td><input type="text" name="destination"></td> -->
					<td><select name="destination" required>
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
					<td colspan="2" align="center"><input type="submit" name="submit" value="Search"  class="button" ></td>
				</tr>			
			</table>		
		</form>
		
		<center><a href="back.do"><font color="white" size="4px"><i>Back</i></font></a></center>
		<div id="content1"></div>
<br><br><br>
</div>
<!-- <img src="insideplane1.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane2.png" alt="Trolltunga Norway" width="330" height="210"> -->
<footer>Copyright &copy; ARS.com</footer>
	</body>
</html>