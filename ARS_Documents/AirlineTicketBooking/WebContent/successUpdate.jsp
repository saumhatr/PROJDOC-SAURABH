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
	height: 5500px;
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
<br>
<center><p align="center">
<h2>Successfully Updated Flight ${flightNo} </h2>
<a href="flightInfo.do" style="color: black"><h3>View Updated Flight List<h3></h3></a>
</p></div>

<div id="content1"></div>
<br><br><br>
</div>
<!-- <img src="insideplane1.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane2.png" alt="Trolltunga Norway" width="330" height="210"> -->
<footer>Copyright &copy; ARS.com</footer>
</body>
</html>