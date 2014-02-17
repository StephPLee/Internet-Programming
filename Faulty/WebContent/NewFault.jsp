<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Fault</title>
<h1>Please Enter Details of the Fault</h1>
</head>
<body>
<form>
	First name: <input type="text" name="firstname"><br>
	<br>
	Last name: <input type="text" name="lastname"><br>
	<br>
	Title of Fault: <input type="text" name="title"><br><br>
	Description of Fault: <br> <textarea rows="10" cols="50"></textarea><br><br>
	Define the rarity of the fault:
	<select>
  		<option value="rare">Rare</option>
 		<option value="uncommon">Uncommon</option>
  		<option value="common">Common</option>
  		<option value="veryCommon">Very Common</option>
	</select><br><br>
	Define the severity of the fault:
	<select>
  		<option value="mildannoyance">Mild Annoyance</option>
 		<option value="causessomeproblem">Causes Some Problem</option>
  		<option value="causeslotstrouble">Causes a lot of Problems</option>
  		<option value="softwarebreaking">Software Breaking</option>
	</select><br><br>
	<input type="submit" value="Submit">
	
</form>
</body>
</html>