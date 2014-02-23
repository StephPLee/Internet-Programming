<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/faulty.css" />
<title>Admin Options</title>
</head>
<body>
<div class="main">
<div class="header"
		style="width: 1030px; left: 110px; top: -40px; position: relative; border: white; box-shadow: 0px 0px 0px #888888; background-color: transparent;">
		<a href="${pageContext.request.contextPath}/Index.jsp"><img
			src="images/pterodactyl.png"
			alt="pterodactyl"/></a>
		<h1>Little Dino Fault Reporting</h1>
	</div>
	<form name="viewdevs" action="${pageContext.request.contextPath}/Devs" method="get">
		<input type="submit" name="submit" value="View Developer List" id="submit" style="top:250px; left:360px; position: absolute"><br>
	</form>
	<br>
	<form name="hiredevs" action="${pageContext.request.contextPath}/NewDev.jsp">
		<input type="submit" name="submit" value="Add a New Developer" id="submit" style="top:350px; left:348px; position: absolute"><br>
	</form>
	</div>
	<form name="viewdevs" action="${pageContext.request.contextPath}/Index.jsp">
			<input type="submit" name="submit" value="Log Out" id="submit" style="min-height:25px; border-bottom-left-radius:10px; border-bottom-right-radius:10px; top:435px; left:615px; position: absolute"><br>
		</form>
</body>
</html>