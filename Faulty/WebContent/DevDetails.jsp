<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ page import="com.abc.steph.stores.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/faulty.css" />
<title>Dev Details</title>
</head>
<body>
<div class="main">
<div class="header" style="width: 1030px; left: 110px; top: -40px; position: relative; border: white; box-shadow: 0px 0px 0px #888888; background-color: transparent;">
  <a href="${pageContext.request.contextPath}/Index.jsp"><img
			src="${pageContext.request.contextPath}/images/pterodactyl.png"
			alt="pterodactyl"/></a>
  <h1>Little Dino Fault Reporting</h1>
</div>
<%
		DevStore developer = (DevStore) request
				.getAttribute("Devs");
		if (developer == null) {
	%>
	<div style="top: -70px; left: 400px; width: 475px; position: relative; float: left; overflow: hidden; clear: both;">No faults found</div>
	<%
		} else {
	%>
	<div style="top: 230px; left: 240px; width: 475px; position:absolute; float: left; overflow: hidden; clear: both;">
	Name: <%=developer.getName()%><br><br>
	Username: <%=developer.getUsername()%><br><br>
	Password: <%=developer.getPassword()%><br><br>
	Email: <%=developer.getEmail()%><br>
	</div>
	<form name="viewdevs" action="${pageContext.request.contextPath}/Devs" method="get">
		<input type="button" name="submit" value="Back" id="submit" style="top:450px; left:460px; position: absolute" onclick="history.go(-1);"><br>
	</form>
	<br />
	<%
		}
		
	%>
	</div>
</body>
</html>