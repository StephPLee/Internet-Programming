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
		<div style="top: 50px; left: 90px; width: 755px; position: relative; float: left; overflow: hidden; padding-bottom:20px; margin-bottom:100px">
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
			
		<form name="viewdevs" action="${pageContext.request.contextPath}/Index.jsp">
			<input type="submit" name="submit" value="Log Out" id="submit" style="min-height:25px; border-bottom-left-radius:10px; border-bottom-right-radius:10px; bottom: 20px; left: 300px; position: relative"><br>
		</form>
		</div>
		<br>
		<br>
	</div>
</body>
</html>