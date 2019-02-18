<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<title>Annapurna</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
.box {
	height: 250px;
	overflow: hidden;
}

body {
	background-color: #F2F1F1;
}
</style>
</head>
<body>
	<jsp:include page="menu.jsp" />
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form action="search">
					Search : <input name="search"
						placeholder="Search By Food or Restaurant"> <input
						type="submit" value="Search">
				</form>
			</div>
		</div>
		<br>
		<div class="row">
			<core:forEach var="restaurant" items="${list}">
				<div class="col-md-4">
					<div class="thumbnail">
						<a href="/foodItems?restaurantId=${restaurant.restaurantId}">
							<core:forEach var="photos" items="${restaurant.photos}"
								varStatus="status">
								<core:if test="${status.index==0}">
									<div class='box'>
										<img class="img" alt="image" src="${photos}" width="100%">
									</div>
								</core:if>
							</core:forEach>
							<h4>
								<a href="/foodItems?restaurantId=${restaurant.restaurantId}">${restaurant.name}</a>
							</h4>
							<h5>${restaurant.type}</h5>
						</a>
					</div>
				</div>
			</core:forEach>
		</div>
	</div>

</body>
</html>