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
 <ul id="navlog">
  <li><a href="logout.do">Logout</a></li>
  </ul>
  
  
  
 
<div id="cont">
<br><br><br>
<center>
<h2><i>Select the Departure Date</i></h2><br>
<form action="searchByDate.do" method="post">
<font color="black" size="5px"><i>Departure: </i></font><input type="date" name="dateSearch"  required/>


			<input type="submit" name="submit" value="Cancel"  class="button">
</form>


<center><a href="back.do"><font color="black">Back</font></a></center>
</center>


<br><br>
</div>
<!-- <img src="insideplane1.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane2.png" alt="Trolltunga Norway" width="330" height="210"> -->
<footer>Copyright &copy; ARS.com</footer>
</body>
</html>