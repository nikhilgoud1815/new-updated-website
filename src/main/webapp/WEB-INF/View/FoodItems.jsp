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
	height: 175px;
	overflow: hidden;
}
body {
	background-color: #F2F1F1;
}
</style>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1>${message}</h1>

	<div class="container">
		<div class="row">
			<core:forEach var="foodItems" items="${restaurant.foodItems}">
				<div class="col-md-3">
					<div class="thumbnail">
						<core:forEach var="photos" items="${foodItems.foodPhotos}" varStatus="status">
							<core:if test="${status.index==0}">
								<div class='box'>
								<img class="img" alt="image" src="${photos}" width="100%">
								</div>
							</core:if>
						</core:forEach>
						<h4><b>${foodItems.foodName}</b></h4>
						<core:if test="${foodItems.veg}">Veg-food </core:if>
						<core:if test="${foodItems.veg==false}">NonVeg-food </core:if>
							<h5>
								Rs.${foodItems.price} &nbsp; &nbsp; &nbsp;
								<a href="/cart/addCart?restaurantName=${restaurant.name}&foodName=${foodItems.foodName}&price=${foodItems.price}&quantity=1" >ADD</a>
							</h5>
							
						</div>
					</div>
			</core:forEach>
		</div>
	</div>

</body>
</html>