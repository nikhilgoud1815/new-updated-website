<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Annapurna</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<table>
		<tr>
			<th>profileId</th>
			<th>profileImage</th>
			<th>name</th>
			<th>userName</th>
			<th>dateOfBirth</th>
			<th>area</th>
			<th>city</th>
			<th>state</th>
			<th>country</th>
			<th>pincode</th>

			<th>cartId</th>
			<th>emailId</th>
			<th>phoneNumber</th>
			<th>gender</th>
		</tr>

		<tr>
			<td>${profile.profileId}</td>
			<td>${profile.profileImage}</td>
			<td>${profile.name}</td>
			<td>${profile.userName}</td>
			<td>${profile.dateOfBirth}</td>
			<td>${profile.address.area}</td>
			<td>${profile.address.city}</td>
			<td>${profile.address.state}</td>
			<td>${profile.address.country}</td>
			<td>${profile.address.pincode}</td>
			<td>${profile.cartId}</td>
			<td>${profile.emailId}</td>
			<td>${profile.phoneNumber}</td>
			<td>${profile.gender}</td>
	</table>
	<h1>${message}</h1>
</body>
</html>



