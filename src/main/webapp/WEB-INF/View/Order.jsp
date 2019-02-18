
<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
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
<form action="http://localhost:8686/PassMoneyLink">
	<table>
		<tr>
			<th>ORDER ID</th>
			<!-- <th>DATE</th> -->
			<th>MODE OF PAYMENT</th>
			<th>STATUS</th>
			<th>PRODUCTS</th>
			<th>TOTAL AMOUNT</th>
			<th>USER ID</th>
		</tr>

	
		
			<tr>
			<td>${Order.orderId}</td>
			<%-- <td>${Order.date}</td> --%>
			<td>${Order.modeOfPayment}</td>
			<td>${Order.status}</td>
			<td>${Order.products}</td>
			<td>${Order.totalAmount}</td>
			<td>${Order.cartId}</td>
		</tr>

	</table>
	<!-- <input type="submit" value="Make Payment"> -->
</form>
<h1>${message}</h1>
</body>
</html>