<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Flight</title>
</head>
<body>
	<form action="UpdateFlightAction">
	Enter the flight id you wish to change
	<input type = "text" name="flightid"><br>
	Enter the new flight id
	<input type = "text" name="newflightid"><br>
	Enter the new from
	<input type = "text" name="newfrom"><br>
	Enter the new destination
	<input type = "text" name="newdestination"><br>
	<input type="submit">
	</form>
</body>
</html>