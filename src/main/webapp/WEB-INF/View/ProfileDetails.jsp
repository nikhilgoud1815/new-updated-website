<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Annapurna</title>

<style type="text/css">
/* body {
	background-image:url(https://images.unsplash.com/photo-1531415074968-036ba1b575da?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=472642856008b6ddb3e596e45ca4263d&auto=format&fit=crop&w=1494&q=80);
	background-size: 1500px 800px;
} */

table {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 0px;
}

th {
	padding: 10px;
	border: 1px solid black;
}

td {
	padding: 10px;
	border: 1px solid black;
	text-align: left;
}

tr:nth-child(even) {
	background-color: white;
}

tr:nth-child(odd) {
	background-color: #eee;
}
</style>
</head>
<body>
	<jsp:include page="menu.jsp" />

	<div align="center">
		<caption>
			<h2>
				<ins>
					<i>User Profile Details</i>
				</ins>
			</h2>
		</caption>
	</div>
	<table style="width: 65%; height: 90%;" align="center">
		<tr>
			<th align="center" colspan="11"
				style="background-color: #5E1D55; color: white;"><h3>Profile</h3></th>
		</tr>

		<tr style="background-color: #32A9EE; color: white;">
			
			<th>name</th>
			<th>userName</th>
			<th>dateOfBirth</th>
			<th>area</th>
			<th>city</th>
			<th>state</th>
			<th>country</th>
			<th>pincode</th>
			<th>emailId</th>
			<th>phoneNumber</th>
			<th>gender</th>
		</tr>


		<tr>
			<td>${profile.name}</td>
			<td>${profile.userName}</td>
			<td>${profile.dateOfBirth}</td>
			<td>${profile.address.area}</td>
			<td>${profile.address.city}</td>
			<td>${profile.address.state}</td>
			<td>${profile.address.country}</td>
			<td>${profile.address.pincode}</td>
			<td>${profile.emailId}</td>
			<td>${profile.phoneNumber}</td>
			<td>${profile.gender}</td>
		</tr>


	</table>
</body>
</html>