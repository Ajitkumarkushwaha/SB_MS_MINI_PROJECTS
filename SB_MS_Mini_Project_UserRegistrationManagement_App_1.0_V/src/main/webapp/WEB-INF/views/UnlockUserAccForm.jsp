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
</head>
<body>


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

							<form:form action="unlockUserAccount" method="POST"
								modelAttribute="unlockAccount">
								
								<div class="form-group">
								<label>Welcome Your Email Is :<span class="text-success"> ${userEmail}</span></label>
								</div>
								<div class="form-group">
									<label for="password">Enter Your Temporary Password</label>
									<form:input class="form-control" id="tempPassword" path="temporaryPassword"
										placeholder="Temporary Password" type="password"
										required="required" />
										<span id="invalidTempPwd" class="text-danger"></span>
								</div>
								<div class="form-group">
									<label for="password">Enter Your New Password</label>
									<form:input class="form-control" path="newPassword"
										placeholder="New Password" type="password" required="required" />
								</div>
								<div class="form-group">
									<label for="password">Confirm Password</label>
									<form:input class="form-control" path="confirmPassword"
										placeholder="Confirm Password" type="password"
										required="required" />
								</div>


								<input type="reset" value="RESET" class="btn btn-warning">
								<input type="submit" value="UNLOCK ACCOUNT"
									class="btn btn-success">
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
				$("#tempPassword").blur(
						function() {
							$("#invalidTempPwd").text('');
							var uPwd = $("#tempPassword").val();
							$.ajax({
								type : "GET",
								url : "validateTempPwd?tempPwd=" + uPwd,
								success : function(data) {
									if (data == 'INVALID_TEMP_PWD') {
										$("#invalidTempPwd").text(
												'INVALID TEMPORARY PASSWORD');
										$("#tempPassword").focus();
									}
								}
							});
						});
			});
</script>
</html>