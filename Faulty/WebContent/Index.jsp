<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/faulty.css" />
<title>Welcome</title>
</head>
<body>
<div class="main", clear:both;>
<div class="header"
		style="width: 1030px; left: 110px; top: -40px; position: relative; border: white; box-shadow: 0px 0px 0px #888888; background-color: transparent;">
		<a href="${pageContext.request.contextPath}/Index.jsp"><img
			src="images/pterodactyl.png" alt="pterodactyl" /></a>
		<h1>Little Dino Fault Reporting</h1>
	</div>
	<div align="center"
		style="top: 110px; width: 455px; left: 110px; position: absolute; float: left; overflow: hidden; clear: both;">
		<p>
			<b>Submit a New Fault</b>
		</p>
		<form name="submitfault"
			action="${pageContext.request.contextPath}/Faults" method="post">
			Summary of Fault: <input type="text" name="summary"><br>
			<br> Description of Fault: <br>
			<textarea rows="10" cols="50" name="description"></textarea>
			<br> <br> Name: <input type="text" name="name"><br>
			<br> Choose a section: <select name="catagory">
				<option value="1">Cassandra</option>
				<option value="2">Hadoup</option>
				<option value="3">Debian</option>
			</select><br><br> 
			<input type="submit" value="Submit" id="index"><br>
			<font color="green"><font size="3px">${postMessage}</font></font>
		</form>
	</div>
	<div align="center"
		style="top: 110px; left: 615px; position: absolute; float: left; overflow: hidden;">
		<p>
			<b>Dev Login</b>
		</p>
		<form name="devlogin"
			action="${pageContext.request.contextPath}/DevLogin" method="get">
			Username: <input type="text" name="username"><br>
			Password: <input type="password" name="password"><br> 
			<input type="submit" value="Login" id="index"><br>
			<font color="red"><font size="3px">${errorMessage}</font></font>
		</form>
	</div>
	<div align="center"
		style="top: 368px; left: 615px; position: absolute; float: left; overflow: hidden;">
		<p>
			<b>Admin Login</b>
		</p>
		<form name="adminlogin"
			action="${pageContext.request.contextPath}/AdminLogin" method="get">
			Username: <input type="text" name="adusername"><br>
			Password: <input type="password" name="adpassword"><br>
			<input type="submit" value="Login" id="index"><br>
			<font color="red"><font size="3px">${adminError}</font></font>
		</form>
	</div>
	<br>
	</div>
</body>
</html>