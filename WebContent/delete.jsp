<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
        function show()  { document.getElementById('passengerid').style.display = 'block'; }
        function show1() { document.getElementById('countryname').style.display = 'block'; }
        function show2() { document.getElementById('terminaltype').style.display = 'block'; }
        function show3() { document.getElementById('flightid').style.display = 'block'; }
 </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete</title>
</head>
<body>
	<form action = "DeleteAction">
	
	<input type =radio name = "passengers" onclick = "show();" >passengers<br>
	<input type = "text" id = "passengerid" name = "passengerid" style="display: none;"  >
	
	<input type =radio name = "countries" onclick = "show1();" >countries<br>
	<input type = "text" id = "countryname" name = "countryname" style="display: none;" >
	
	<input type =radio name = "terminals" onclick = "show2();" >terminals<br>
	<input type = "text" id = "terminaltype" name = "terminaltype" style="display: none;"  >
	
	<input type =radio name = "flights" onclick = "show3();" >flights<br>
	<input type = "text" id = "flightid" name = "flightid" style="display: none;">
	
	
	<input type = "submit">
	</form>
	
</body>
</html>
