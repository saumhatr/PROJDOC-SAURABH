<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<!-- <script>
function validate(){
var username = document.getElementById("uname").value;
var password = document.getElementById("psw").value;
if ( username == "bank" && password == "bank123"){
alert ("Login successfully");
window.location = "AdminLoginSuccess.html"; // Redirecting to other page.
return false;
}
else
{
alert("Please Enter Correct Username and Password");
return false;
}
}
</script> -->
</head>
<body>
	<body background="bg1.jpg">
  <div id="page-wrap">
  <img src="planebanner.jpg" width="1000px" height="250px">
<ul id="nav">
	<li><a href="home.do">Home</a></li>
	<li><a href="#">About Us</a></li>
	<li><a href="#">Login</a></li>
	<li><a href="#">Contact Us</a></li>
</ul>
 
<div id="content1">
<br>
<center><img src="user1.png" width="50px" height="50px"></center>
	<center>

		<form action="successLogin.do" method="post">
			<table>
				<tr>
					<td>User Name :</td>
					<td><input type="text" name="userNm"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Login" class="button"/></td>
				</tr>
				<tr><td>New User?   <a href="Register"> Register</a></td></tr>
				
				</table>
				</form>
<br><br></center>
</div>

 
<img src="insideplane1.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="insideplane.jpg" alt="Trolltunga Norway" width="330" height="210">
<img src="food.jpg" alt="Trolltunga Norway" width="330" height="210">
<footer>Copyright &copy; ARS.com</footer>

</div>		

		

</body>
</html>