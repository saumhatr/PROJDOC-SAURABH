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
<p align="center">
<h1>Successfully Added New User</h1>
<h4>Details:</h4>
<h4>User Name: ${uName}</h4>
<h4>Mobile No: ${mobile}</h4>
<h5><a href="login.do">Login to Continue</a></h5>
</p>
<footer>Copyright &copy; ARS.com</footer>
</body>
</html>