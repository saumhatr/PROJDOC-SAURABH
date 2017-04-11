<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<br>
<center>
<h1><font color="white">Welcome Admin</font></h1><br></center>
<center><a href="flightInfo.do" style="color: black"><h3><i>Manage Flight Information</i></h3></a><br>
<a href="searchDate.do" style="color: black"><h3><i>Search Flight By Date</i></h3></a><br>
<a href="srsDes.do" style="color: black"><h3><i>Search Flight By Source and Destination</i></h3></a><br>
<a href="passengerList.do" style="color: black"><h3><i>Search Persons List By Flight Number</i></h3></a><br>


<br><br>

</div><br><br><br>

<footer>Copyright &copy; ARS.com</footer>

</body>
</html>