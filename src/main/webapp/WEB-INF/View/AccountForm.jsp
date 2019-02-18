<!DOCTYPE html>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>

<body background="./images/pattern2.jpg">
	<jsp:include page="menu.jsp" />
	<div id="login-overlay" class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">Register with
					Annapurna</h4>
				<p>
					To See Restaurants and other things go back to our <a href="/">main
						site</a>.
				</p>
			</div>

			<div class="modal-body">


				<form action="createAccount" method="post">
					<!---form--->
					<div class="form-group">
						<!---input width--->
						<div class="col-xs-6">
							<label for="InputName">Name</label>
							<div class="input-group">
								<input type="text" class="form-control" name="name"
									placeholder="Enter Name" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
							<br> <label for="InputPassword">Enter Password</label>
							<div class="input-group">
								<input type="password" class="form-control" name="password"
									placeholder="Enter Password" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
							<!--------------------------------------separator--------------------------------------------------------------->
							<hr>
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-6">

							<label for="InputName">Username</label>
							<div class="input-group">
								<input type="text" class="form-control" name="userName"
									placeholder="Enter userName" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>

							<br> <label for="InputDOB">Date Of Birth</label>
							<div class="input-group">
								<input type="date" class="form-control" name="dateOfBirth"
									placeholder="Enter Date Of Birth" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>



							<!--------------------------------------separator--------------------------------------------------------------->
							<hr>
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-12">
							<label for="InputEmail">Enter Email</label>
							<div class="input-group">
								<input type="email" class="form-control" name="emailId"
									placeholder="Enter Email" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
							<!----------------------------break------------------------------------------------------------->
							<br>
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-12">
							<label for="InputStreetName">Phone Number</label>
							<div class="input-group">
								<input type="text" class="form-control" name="phoneNumber"
									placeholder="Enter Phone Number" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
							<!----------------------------break------------------------------------------------------------->
							<br>
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-12">
							<label for="InputStreetName">Address</label>
							<div class="input-group">
								<input type="text" class="form-control" name="address.area"
									placeholder="Enter Street Name and Number" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
							<!----------------------------break------------------------------------------------------------->
							<br>
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-6">

							<label for="InputCity">City</label>
							<div class="input-group">
								<input type="text" class="form-control" name="address.city"
									placeholder="Enter City" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>

							<br> <label for="InputPassword">State</label>
							<div class="input-group">
								<input type="text" class="form-control" name="address.state"
									placeholder="Enter state" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
							<!--------------------------------------separator--------------------------------------------------------------->
							<hr>
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-6">

							<label for="InputCity">Country</label>
							<div class="input-group">
								<input type="text" class="form-control" name="address.country"
									placeholder="Enter Country" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>

							<br> <label for="InputPassword">Pincode</label>
							<div class="input-group">
								<input type="text" class="form-control" name="address.pincode"
									placeholder="Enter Pincode" required> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-asterisk"></span></span>
							</div>
							<!----------------------------break------------------------------------------------------------->
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-12">
							<label for="InputStreetName">Gender</label>
							<div class="input-group">
								<input type="radio" name="gender" value="male" checked>
								Male <input type="radio" name="gender" value="female">
								Female
							</div>
							<!--------------------------------------separator--------------------------------------------------------------->
							<hr>
						</div>
					</div>


					<div class="form-group">
						<div class="input-group-addon">
							<input type="submit" name="submit" id="submit" value="Submit"
								class="btn btn-success pull-right">

						</div>
					</div>
				</form>
			</div>
			<!---modal-body--->
		</div>
	</div>


	<script type="text/javascript">
		
	</script>
</body>

</html>
