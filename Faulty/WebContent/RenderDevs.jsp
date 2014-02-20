<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="com.abc.steph.stores.*" %>
<%@ page import="java.util.*" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Devs List</title>
</head>
<body>
<h1>Devs</h1>
<%
System.out.println("In render");
List<DevStore> lDevs = (List<DevStore>)request.getAttribute("Devs");
if (lDevs==null){
 %>
	<p>No developers found</p>
	<% 
}else{
%>


<% 
Iterator<DevStore> iterator;


iterator = lDevs.iterator();     
while (iterator.hasNext()){
	DevStore md = (DevStore)iterator.next();

	%>
	<a href="/ac32007examples/Developer/<%=md.getUsername() %>"><%=md.getName() %></a><br/><%

}
}
%>
</body>
</html>