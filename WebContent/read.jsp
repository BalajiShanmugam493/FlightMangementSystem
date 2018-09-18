<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Read</title>
</head>
<body>
	String str="";
	<form action = "ReadAction">
		<select name="readtype">
			<option value = "passengers">1. To read passengers</option>
			<option value = "flight"> 2. To read flights</option>
			<option value = "country"> 3. To read countries</option>
			<option value = "terminals">4. To read terminals</option><br>
		</select>
		<input type="submit"></input>
		
			
		<li>
			<%= request.getAttribute("details") %>
 
        </li>
		
		
	</form>
</body>
</html>