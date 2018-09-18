<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create</title>
</head>
<body>
		<b>Welcome to create</b><br>
		<form action="CreateEntryPassengerAction.action" >
			1. To create new Passenger<br>
			<!-- Enter passenger id <input type="text" name = "passengerid"><br> -->
			Enter passenger name<input type="text" name = "passengername"> <br>
			flightid<input type="text" name="flightid_passenger"> <br><br>
			<input type="submit"></input><br><br>
		</form>
			
		<form action="CreateEntryCountryAction.action" >
			2. To create new country<br>
			Enter country name<input type="text" name="countryname"> <br><br>
			<input type="submit"></input><br><br>
		</form>
			
		<form action="CreateEntryFlightAction.action" >
			3. To create new flight<br>
			Enter flight id <input type="text" name="flightid"><br>
			from<input type="text" name="fromflight" > <br>
			destination <input type="text" name="destinationflight"><br><br>
			<input type="submit"></input><br><br>
		</form>
			
		<form action="CreateEntryTerminalAction.action" >
			4. To create new Terminals<br>
			Enter terminal type
			<select name="terminaltype">
				  <option value="domestic">Domestic</option>
				  <option value="international">International</option>
				  <option value="cargo">Cargo</option>
			</select>
   			<br>
			flightid <input type="text" name="flightid_terminal"> <br>
			location <input type="text" name="location"> <br>
			<input type="submit"></input><br><br>
		</form>
		
		<form action = "CreateNewLocationAction.action">
			5.To create New location<br><br>
			Enter the new Location
			<input type = "text" name = "newlocation"></input><br><br>
			Enter the distance details
			<br><br>
			<%
			int num = 0;
			try{
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bala","bala","bala");
				if(con == null) System.out.print("not connected");
				Statement st = con.createStatement();
				String myStatement = "select count(*) as total from locations";
				ResultSet rs = st.executeQuery(myStatement);
				
				while(rs.next()){
					num = (rs.getInt(1));
				}
				
			}
			catch(Exception e){
				System.out.println(e);	
			}
			request.setAttribute("numberofvalues" ,(num+1));
			
			%>
			Enter <%=request.getAttribute("numberofvalues") %>  values
			<input type = "text" name = "distance"><br>
			<input type = "submit">  <br>
		</form>			
</body>
</html>