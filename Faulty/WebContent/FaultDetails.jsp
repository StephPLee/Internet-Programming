<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ page import="com.abc.steph.stores.*"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/faulty.css" />
<title>Fault Details</title>
</head>
<body>
<div class="main">
	<div class="header"
		style="width: 1030px; left: 110px; top: -40px; position: relative; border: white; box-shadow: 0px 0px 0px #888888; background-color: transparent;">
		<a href="${pageContext.request.contextPath}/Index.jsp"><img
			src="${pageContext.request.contextPath}/images/pterodactyl.png" alt="pterodactyl" /></a>
		<h1>Little Dino Fault Reporting</h1>
	</div>
	<%
		FaultsStore Fault = (FaultsStore) request.getAttribute("Faults");
		if (Fault == null) {
	%>
	<p>No faults found</p>
	<%
		} else {
	%>
	<div
		style="top: 230px; left: 240px; width: 475px; position:absolute; float: left; overflow: hidden; clear: both;">
		Fault Summary:
		<%=Fault.getFaultSummary()%><br><br> Detailed Description of Fault:
		<%=Fault.getFaultDetails()%><br><br> Section Fault Relates to:
		<%=Fault.getFaultSection()%><br><br> Author of the Fault:
		<%=Fault.getFaultAuthor()%><br>
	</div>
			<input type="button" name="submit" value="Log Out" id="submit" style="top:1000px; left:460px; position: absolute" onclick="index.jsp"><br>
	<br />
	<%
		}
	%>
	</div>

</body>
</html>