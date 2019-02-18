<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
	padding: 5px;
	height: 80px;
	width: 1100px;
	font-size: 20px;
	text-align: center;
	font-family: inherit;
}
th, td {
	padding: 1px;
	background-color: lightgray;
}
</style>
</head>
<body>
<jsp:include page="menu.jsp" />
<form action="placeOrder">
	<table>
		<tr>
			<th>CART ID</th>
			<th>PRODUCTS</th>
			<th>RESTAURANT NAME</th>
			<th>TOTAL AMOUNT</th>
			<th>ADDRESS</th>
		</tr>
		<%-- <jstl:forEach var="carts" items="${carts}">
			<tr>
				<td>${carts.cartId}</td>
				<td>${carts.products}</td>
				<td>${carts.restaurantName}</td>
				<td>${carts.totalAmount}</td>
				<td>${carts.address}</td>
			</tr>
		</jstl:forEach> --%>
		
			<tr>
				<td>${cart.cartId}</td>
				<td>${cart.products}</td>
				<td>${cart.restaurantName}</td>
				<td>${cart.totalAmount}</td>
				<td>${cart.address}</td>
			</tr>
	</table>
	
	<input type="submit" value= "Place Order">
	</form>
	<h1>${message}</h1>
</body>
</html>