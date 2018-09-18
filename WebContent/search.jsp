<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>
<body>

	Welcome to Searching
	<p>Search by Flight Name</p>
	<form action = "SearchByFlightAction">
		Enter the flight id:
		<input type = "text" name="searchbyflight"></input>
		<input type = "submit" value = "SUBMIT NOW">
	</form>
	
	<br><br><br>
	
	<p>Search By Destination Point</p>
	<form action = "SearchByDestinationAction">
		Enter the destination point:
		<input type = "text" name="searchbydestination"></input>
		<input type="submit" value = "SUBMIT NOW">
	</form> 
	
	<br><br><br>
	
	<p>Search By Starting Point</p>
	<form action = "SearchByFromAction">
		Enter the starting point:
		<input type = "text" name="searchbyfrom"></input>
		<input type="submit" value = "SUBMIT NOW">
	</form> 
	
	<br><br><br>
	
	
	<p>Search By Passenger Name</p>
	<form action = "SearchByPassengerNameAction">
		Enter the passenger name:
		<input type = "text" name="searchbypassengername"></input>
		<input type="submit" value = "SUBMIT NOW">
	</form> 
	<br><br><br>
	
	
	
	<p>Search By Passenger id</p>
	<form action = "SearchByPassengerIdAction">
		Enter the passenger id:
		<input type = "text" name="searchbypassengerid"></input>
		<input type="submit" value = "SUBMIT NOW">
	</form> 
	<br><br><br>
	
	<p> Search Flight By Starting and Destination point</p>
	<form action = "SearchByFlightFromAndDestinationAction">
	
		Enter the starting point:
		<input type = "text" name="searchbyflightfromanddestination_from"></input><br>
		Enter the destination point:
		<input type = "text" name="searchbyflightfromanddestination_destination"></input><br>
		
		<input type="submit" value = "SUBMIT NOW">
	</form> 
	<br><br><br>
	
	<p> !!!!!!!!!Search Passengers By FlightId!!!!!!!</p>
	<form action = "SearchByFlightIdAction">
	
		Enter the flight id:
		<input type = "text" name="searchbypassengerflightid"></input><br>
		
		<input type="submit" value = "SUBMIT NOW">
	</form> 
	<br><br><br>
	
	<p> Search The Cost for Starting and Destination Point </p>
	<form action = "SearchByCostAction">
	
		Enter the starting point:
		<!-- <select name="searchbycost_from">
			<option value = "chennai">chennai</option>
			<option value = "bangalore"> bangalore</option>
			<option value = "hyderabad"> hyderabad</option>
			<option value = "cochin">cochin</option>
			<option value = "mumbai">mumbai</option>
			<option value = "pune">pune</option>
			<option value = "kashmir">kashmir</option>
			<option value = "srinagar">srinagar</option>
			<option value = "ahmedabad">Ahmedabad</option>
		</select> -->
		<input type = "text" name ="searchbycost_from" >
		<br><br>
		Enter the destination point:
		<!-- <select name="searchbycost_destination">
			<option value = "chennai">chennai</option>
			<option value = "bangalore"> bangalore</option>
			<option value = "hyderabad"> hyderabad</option>
			<option value = "cochin">cochin</option>
			<option value = "mumbai">mumbai</option>
			<option value = "pune">pune</option>
			<option value = "kashmir">kashmir</option>
			<option value = "srinagar">srinagar</option>
			<option value = "ahmedabad">Ahmedabad</option>

		</select> -->
		<input type = "text" name ="searchbycost_destination" >
		<br><br>
		<input type="submit" value = "SUBMIT NOW">
	</form>
	
	
</body>
</html>
