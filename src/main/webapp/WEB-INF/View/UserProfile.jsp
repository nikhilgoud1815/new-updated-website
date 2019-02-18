
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EWallet Transactions</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1>${message}</h1>
	<h1></h1>
	<%-- ${profile} --%>
		<h2><a href="gettingAccountFromId?profileId=${profile.profileId}">View Details</a></h2>
		<h2><a href="updateAccounts?profileId=${profile.profileId}">Edit Details</a></h2>
		<h2><a href="updatePassword?profileId=${profile.profileId}">Update Password</a></h2>
	<br>
	<h1>eWallet</h1>
		<h2><a href="AddMoneyLink?profileId=${profile.profileId}">Add Money</a></h2>
		<h2><a href="currentEWalletBalance?profileId=${profile.profileId}">View Current eWallet Balance</a></h2>
		<h2><a href="statement?profileId=${profile.profileId}">View Transactions</a></h2>	
</body>
</html>




