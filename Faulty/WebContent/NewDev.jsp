<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/faulty.css"/>
<title>Welcome</title>
</head>
<body>
<div class="header" style="width: 1030px; left: 110px; top: -40px; position: relative; border: white; box-shadow: 0px 0px 0px #888888; background-color: transparent;">
  <a href="${pageContext.request.contextPath}/Index.jsp"><img
			src="images/pterodactyl.png"
			alt="pterodactyl"/></a>
  <h1>Little Dino Fault Reporting</h1>
</div>
<div align="center" style="top: -30px; width: 450px; left: 400px; position: relative; float: left; overflow: hidden; clear: both;">
<p><b>Submit a New Fault</b></p>
<form name="submitfault" action="${pageContext.request.contextPath}/Devs" method="post">
	Name of Developer: <input type="text" name="name"><br><br>
	Username of Developer: <input type="text" name="username"><br><br>
	Password of Developer: <input type="text" name="password"><br><br>
	Email of Developer: <input type="text" name="email"><br><br>
	<input type="submit" value="Submit">
	${errorMessage}
</form>
</div>
<br>
</body>
</html>