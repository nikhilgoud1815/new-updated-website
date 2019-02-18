<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.jsp" />
	<form action="/cart/submitAddress">
		<h1>DELIVERY ADDRESS</h1>
		Flat Number: <input type="number" name="houseNumber"><br>
		<br> Street Name: <input type="text" name="streetName"><br>
		<br> City: <input type="text" name="city"><br> <br>
		Pin Code: <input type="number" name="pinCode"><br> <br>
		State: <select name="state">
			<option value="Maharashtra">MAHARASHTRA</option>
			<option value="JAMMU & KASHMIR">JAMMU & KASHMIR</option>
			<option value="RAJASTHAN">RAJASTHAN</option>
		</select><br> <br> Country: <select name="country">
			<option value="INDIA">INDIA</option>
		</select> <br> <input type="submit" value="submit">
	</form>
	<h1>${message}</h1>
</body>
</html>