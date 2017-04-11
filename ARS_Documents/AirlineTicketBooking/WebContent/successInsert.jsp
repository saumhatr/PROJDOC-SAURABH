<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<!-- <ul id="nav">
	<li><a href="Home.html">Home</a></li>
	<li><a href="#">About Us</a></li>
	<li><a href="#">Login</a></li>
	<li><a href="#">Contact Us</a></li>
	
</ul> -->
  
<ul id="navlog">
  <li><a href="logout.do">Logout</a></li>
  </ul>
  
<div id="cont">
<br><br>
<center>
<h1><i>Successfully Added New Flight</i></h1>
<h3><i>Details:</i></h3>
<h3><i>Flight No: ${flightNo}</i></h3>
<h3><i>Airline Name: ${airLine}</i></h3>
<h3><a href="flightInfo.do" color="black"><i>View Updated Flight List</i></a></h3></center>

</div>
<footer>Copyright &copy; ARS.com</footer>

</div>
<!-- <img src="insideplane1.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane2.png" alt="Trolltunga Norway" width="330" height="210"> -->

</body>
</html>