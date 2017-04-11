<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head> <link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="style.css">
<style>

#cont{
	float: left;
	width: 100%;
	background-color:DeepSkyBlue ;
		height: 550px;
	 background: url('cont.jpg');
	 background-repeat:no-repeat;
}
</style>
		<title>User Function</title>
	</head>
	<body background="bg1.jpg">
		<div id="page-wrap">
  <img src="planebanner.jpg" width="1000px" height="250px">
<ul id="nav">
	<li><a href="Home.html">Home</a></li>
	<li><a href="#">About Us</a></li>
	<li><a href="#">Login</a></li>
	<li><a href="#">Contact Us</a></li>
	
</ul>
  
  <br><br>
<div id="cont">
<br><br><br>
		<h2>Welcome ${user}</h2>
		<h4><a href="getAllFlightDetails.do"><font color="orange">Show all</font></a></h4><br>
		<h4><a href="logout.do"><font color="orange">Logout</font></a></h4>
		</div>
<div id="content1">
<br><br><br>
</div>
<!-- <img src="insideplane1.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane2.png" alt="Trolltunga Norway" width="330" height="210"> -->
<footer>Copyright &copy; ARS.com</footer>
	</body>
</html>
