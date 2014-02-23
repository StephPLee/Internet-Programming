<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ page import="com.abc.steph.stores.*"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="css/faulty.css" />
<title>Devs List</title>
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
	<%
		List<DevStore> lDevs = (List<DevStore>) request
				.getAttribute("Devs");
		if (lDevs == null) {
	%>
	<p>No developers found</p>
	<%
		} else {
	%>
	<div style="top: 110px; left: 100px; width: 755px; position: absolute; float: left; overflow: hidden; padding-bottom:20px; margin-bottom:100px">
		<ul>
			<%
				Iterator<DevStore> iterator;

					iterator = lDevs.iterator();
					while (iterator.hasNext()) {
						DevStore md = (DevStore) iterator.next();
			%>
			<a href="${pageContext.request.contextPath}/Dev/<%=md.getID()%>"><li><%=md.getName()%></li></a>
			<br />
			<%
				}
				}
			%>
		</ul>
			<input type="button" name="submit" value="Back" id="submit" style="min-height:25px; border-bottom-left-radius:10px; border-bottom-right-radius:10px; bottom: 20px; left: 330px; position: relative" onclick="history.go(-1);"><br>
	</div>
	<br><br>
	</div>
</body>
</html>