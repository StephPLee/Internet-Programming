<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<h1>Welcome to Faulty Towers</h1>
</head>
<body>
<p><b>Developer Login</b></p>
<form name="devlogin" action="${pageContext.request.contextPath}/Fault" method="get">
Username: <input type="text" name="username"><br>
Password: <input type="text" name="password"><br>
<input type="submit" value="Login" id="devLog"><br>
</form>
<p><b>Admin Login</b></p>
<form name="adminlogin" action="${pageContext.request.contextPath}/Developer" method="get">
Username: <input type="text" name="adusername"><br>
Password: <input type="text" name="adpassword"><br>
<input type="submit" value="Login" id="adLog"><br>
</form>
<br>
<form name="submitnewfault" action="NewFault.jsp">
<input type="submit" value="Submit a new fault" id="viewAll">
</form>
</body>
</html>