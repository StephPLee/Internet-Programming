<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/faulty.css" />
<title>Developer Options</title>
</head>
<body>
<div class="header"
		style="width: 1030px; left: 110px; top: -40px; position: relative; border: white; box-shadow: 0px 0px 0px #888888; background-color: transparent;">
		<a href="${pageContext.request.contextPath}/Index.jsp"><img
			src="images/pterodactyl.png"
			alt="pterodactyl"/></a>
		<h1>Little Dino Fault Reporting</h1>
	</div>
	<form name="viewfaults" action="${pageContext.request.contextPath}/Faults" method="get">
		<input type="submit" value="View Faults" id="devview"><br>
	</form>
	<br>
	<form name="editfaults" action="${pageContext.request.contextPath}/Faults" method="get">
		<input type="submit" value="Edit/Delete Faults" id="devedit"><br>
	</form>
</body>
</html>