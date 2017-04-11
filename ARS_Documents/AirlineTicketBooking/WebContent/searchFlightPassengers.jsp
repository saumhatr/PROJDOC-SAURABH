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
<center><h1><i>Search Passengers List</i></h1></center><br>
<form action="passengerListDisplay.do">
<table align="center">
<tr>
<td>
<h2><i>Enter Flight No: </i></h2></td>
<td><input type="text" name="flightNo" required>
</td>
</tr>
<tr>
<td></td>
<td>

<input type="submit" name="submit" value="Search"  class="button" ></td>

</tr>

</table>

</form>
<br>
<center><a href="back.do"><font color="black" size="4px"><i>Back</i></font></a></center>
</div>

<footer>Copyright &copy; ARS.com</footer>
</body>
</html>