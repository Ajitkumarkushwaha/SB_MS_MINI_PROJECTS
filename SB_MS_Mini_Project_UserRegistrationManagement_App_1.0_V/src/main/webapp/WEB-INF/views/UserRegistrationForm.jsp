<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kushwaha Group</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link rel="stylesheet" href="../bootstrap/css/font-awesome-5.8.1.css">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="../bootstrap/css/mdb.css">
<link rel="stylesheet" href="../bootstrap/css/style.css">
<link rel="stylesheet" href="../css/styles.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
</head>
<body>

	<%-- <!-- Success Message -->

	<section>
		<div class="container-fluid">
			<div class="row mt-5">
				<div class="col-md-2"></div>
				<div class="col-md-8 text-center">
					<div class="card text-center">
						<div class="card-header bg-success">Welcome To KBM Group</div>
						<div class="card-body">
							<h3 class="text-success text-cenetr">${successMsg}</h3>
							<h3 class="text-denger text-center">${errorMsg}</h3>
							<h3 class="text-center text-warning">
								Unlock Your Account <br>Verify Your Email Id And Complete
								Your Registration
							</h3>
						</div>
					</div>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</section> --%>

	<!-- Registration Form -->

	<section>
		<div class="container-fluid">
			<div class="row text-center">
				<div class="col-md-3"></div>
				<div class="col-md-6 p-3">
					<div class="card mt-4">
						<div class="card-header bg-secondary p-4">Welcome To KBM
							GROUP</div>
						<div class="card-body">
							<h1 class="text-primary text-center"></h1>

							<form:form action="saveUser" method="POST"
								modelAttribute="userAccount">
								<div class="form-group">
									<label for="firstName">Enter Your First Name</label>
									<form:input class="form-control" path="firstName"
										placeholder="First  Name" type="text" required="required" />
								</div>
								<div class="form-group">
									<label for="lastName">Enter Your Last Name</label>
									<form:input class="form-control" path="lastName"
										placeholder="Last  Name" type="text" required="required" />
								</div>
								<div class="form-group">
									<label for="email">Enter Your Email</label>
									<form:input class="form-control" path="email"
										placeholder="Email Id" type="email" required="required" />
									<span id="duplicateEmaliMsg" class="text-danger"></span>
								</div>
								<div class="form-group">
									<label for="dob">Date Of Birth</label>
									<form:input class="form-control" path="dob"
										placeholder="Date Of Birth" id="datepicker" type="text"
										required="required" />
								</div>

								<div class="form-group">
									<label for="gender">GENDER</label>
									<form:radiobutton path="gender" value="MALE" />
									MALE
									<form:radiobutton path="gender" value="FEMALE" />
									FEMALE
								</div>
								<div class="form-group">
									<label for="country">SELECT COUNTRY</label>
									<form:select class="form-control" id="countryId" path="country"
										placeholder="COUNTRY" required="required">
										<form:option value="">SELECT</form:option>
										<form:options items="${ac}"></form:options>
									</form:select>

								</div>
								<div class="form-group">
									<label for="state">SELECT STATE</label>
									<form:select class="form-control" id="stateId" path="state"
										placeholder="STATE" required="required">
									</form:select>
								</div>
								<div class="form-group">
									<label for="city">SELECT CITY</label>
									<form:select class="form-control" id="cityId" path="city"
										placeholder="CITY" required="required">

									</form:select>
								</div>

								<input type="reset" value="RESET" class="btn btn-warning">
								<input type="submit" value="REGISTER" class="btn btn-success">
							</form:form>

						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</section>

</body>

<script>
	$(document).ready(
			function(event) {
				$("#email").blur(
						function() {
							$("#duplicateEmaliMsg").text('');
							var emailId = $("#email").val();
							$.ajax({
								type : "GET",
								url : "validateEmail?email=" + emailId,
								success : function(data) {
									if (data == 'DUPLICATE') {
										$("#duplicateEmaliMsg").text(
												' DUPLICATE EMAIL ID ');
										$("#email").focus();
									}
								}
							});
						});

				$("#countryId").change(
						function() {
							$("#stateId").find("option").remove();
							$('<option>').val('').text("SELECT").appendTo(
									"#stateId");
							$("#cityId").find("option").remove();
							$('<option>').val('').text("SELECT").appendTo(
									"#cityId");
							var countryId = $("#countryId").val();
							$.ajax({
								type : "GET",
								url : "getStates?countryId=" + countryId,
								success : function(data) {
									$.each(data, function(key, value) {
										$('<option>').val(key).text(value)
												.appendTo("#stateId");
									});
								}
							});
						});

				$("#stateId").change(
						function() {
							$("#cityId").find("option").remove();
							$('<option>').val('').text("SELECT").appendTo(
									"#cityId");
							var stateId = $("#stateId").val();
							$.ajax({
								type : "GET",
								url : "getCities?stateId=" + stateId,
								success : function(data) {
									$.each(data, function(key, value) {
										$('<option>').val(key).text(value)
												.appendTo("#cityId");
									});

								}
							});
						});

			});
</script>
</html>