<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/faulty.css" />
<title>New Fault</title>
<h1>Please Enter Details of the Fault</h1>
</head>
<body>
<form name="submitfault" action="${pageContext.request.contextPath}/Fault" method="post">
	Summary of Fault: <input type="text" name="summary"><br><br>
	Description of Fault: <br> <textarea rows="10" cols="50" name="description"></textarea><br><br>
	Name: <input type="text" name="name"><br><br>
	Choose a section:
	<select name="catagory">
  		<option value="Cassandra">Cassandra</option>
 		<option value="Hadoup">Hadoup</option>
  		<option value="Debian">Debian</option>
	</select><br><br>
	<input type="submit" value="Submit">
</form>
</body>
</html>