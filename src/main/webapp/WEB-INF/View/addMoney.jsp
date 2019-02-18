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
<%-- <h1>${message}</h1> --%>
<form action="AddMoneyForm" method="post">
	<!-- Enter profileId:  --><input type="hidden" value="${profileId}" name="profileId"/><br/>
	Enter Amount : <input name="amount"/><br/>
	<input type="submit"/>
</form>
<h1>${message}</h1>
</body>
</html>