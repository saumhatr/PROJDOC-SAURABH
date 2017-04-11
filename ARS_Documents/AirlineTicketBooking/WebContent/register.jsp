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
	height: 400px;
	 background: url('cont.jpg');
	 background-repeat:no-repeat;
}
</style>
</head><body background="bg1.jpg">

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
<center>
 <h2 align="center">   <b>   Registration Form </b> </h2> 
 ${msg}
<form action="register.do" method="post">
	<table>
		<tr>
			<td><b>First Name</b></td>
			<td><input type="text" name="uFname" value="${uFname}" pattern="^[A-Z]{1}[a-z]{1,19}" title="Example: Ajay" required></td>
		</tr>
		<tr>
			<td><b>Last Name</b></td>
			<td><input type="text" name="uLname" value="${uLname}" pattern="^[A-Z]{1}[a-z]{1,19}" title="Example: Mehra" required></td>
		</tr>
		<tr>
			<td><b>UserName:</b></td>
			<td><input type="text" name="uName" value="${uName}" pattern="^[A-Za-z]{1,}[0-9]{1,}" title="Example: google123" required></td>
		</tr>


		<tr>
			<td><b>Password:</b></td>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<td><b>Re-enter Password:</b></td>
			<td><input type="password" name="rePassword" required></td>
		</tr>
		<!-- <tr>

			<td><b>Role:</b></td>
			<td><input type="text" name="role" value="user" readonly ></td>
		</tr> -->

		<tr>
			<td><b>Mobile No:</b></td>
			<td><input type="text" name="phone" value="${mobile}" pattern="^[7-9]{1}[0-9]{9}$"
				title="example: 9876543210" required></td>
		</tr>

		<tr>
			<td colspan="2" align="center"><input type="submit" value="Register">
			<input type="reset" value="Cancel"></td>
		</tr>
	</table>

</form>
<a href="home.do"><h4><font color="orange">Back</font></h4></a>
</center>
<div id="content1"></div>
<br><br><br>
</div>
<!-- <img src="insideplane1.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane2.png" alt="Trolltunga Norway" width="330" height="210"> -->
<footer>Copyright &copy; ARS.com</footer>
</body>
</html>