<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ page import="com.abc.steph.stores.*"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="css/faulty.css" />
<title>Faults List</title>
</head>
<body>
	<div class="main">
		<div class="header"
			style="width: 1030px; left: 110px; top: -40px; position: relative; border: white; box-shadow: 0px 0px 0px #888888; background-color: transparent;">
			<a href="${pageContext.request.contextPath}/Index.jsp"><img
				src="images/pterodactyl.png" alt="pterodactyl" /></a>
			<h1>Little Dino Fault Reporting</h1>
		</div>
		<%
			List<FaultsStore> lFaults = (List<FaultsStore>) request
					.getAttribute("Faults");
			System.out.println(lFaults.size());
			if (lFaults == null) {
		%>
		<p>No faults found</p>
		<%
			} else {
		%>
		<div
			style="top: 110px; left: 100px; width: 755px; position: absolute; float: left; overflow: hidden;">
			<ul>
				<%
					Iterator<FaultsStore> iterator;

						iterator = lFaults.iterator();
						while (iterator.hasNext()) {
							FaultsStore md = (FaultsStore) iterator.next();
				%>
				<a href="${pageContext.request.contextPath}/Faults/<%=md.getFaultid()%>"><li><%=md.getFaultSummary()%></li></a>
				<br />
				<%
					}
					}
				%>
			</ul>
		</div>
		<br>
		<br>
		<form name="viewdevs" action="${pageContext.request.contextPath}/Index.jsp">
			<input type="submit" name="submit" value="Log Out" id="submit" style="top: 950px; left: 445px; position: relative"><br>
		</form>
	</div>
</body>
</html>