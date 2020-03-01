<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html lang="en">
<head>
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
<script type="text/javascript">
	function confirmDelete() {
		return confirm("Are you sure, you want to delete?");
	}
</script>
<title>Kushwaha Group</title>
</head>
<body>

	<!-- Main Navbar -->
	<nav class="navbar navbar-dark bg-dark navbar-expand-sm">
		<div class="container">
			<a href="index.html" class="navbar-brand text-warning"> <i
				class="fa fa-snowflake"></i> Kushwaha
			</a>
			<button class="navbar-toggler">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="uiNavbar">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link "
						href="register"> <i class="fa fa-chart-bar text-muted"></i>
							Dashboard
					</a></li>
					<li class="nav-item"><a class="nav-link" href="register">
							<i class="fa fa-users text-muted"></i> Add New Contact
					</a></li>
					<li class="nav-item"><a class="nav-link" href="getAllContacts">
							<i class="fa fa-users text-muted"></i> Contact List
					</a></li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item dropdown"><a href="#" class="nav-link"
						data-toggle="dropdown"> <i
							class="fa fa-sign-in-alt text-muted"></i> Ajit <i
							class="fa fa-caret-down"></i></a>
						<div class="dropdown-menu px-2">
							<a href="#" class="dropdown-item"> <i
								class="fa fa-user-circle"></i> Profile
							</a> <a href="#" class="dropdown-item"> <i class="fa fa-cogs"></i>
								Settings
							</a>
						</div></li>
					<li class="nav-item"><a class="nav-link" href="#"> <i
							class="fa fa-sign-out-alt text-muted"></i> LogOut
					</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Dashboard section -->
	<section class="p-2 bg-teal text-white">
		<div class="container">
			<div class="row">
				<div class="col animated flipInX">
					<h1>
						<i class="fa fa-chart-bar"></i> Dashboard
					</h1>
				</div>
			</div>
		</div>
	</section>

	<!-- Main Content For All Active Content Section -->
	<div class="container">
	<div class="row">
		<div class="col-md-12">
			<span class="text-success">${successMsg}</span> <span
				class="text-denger">${errorMsg}</span>
		</div>
	</div>
	</div>


	<section class="p-3">
		<div class="row">
			<div class="col-md-9">
				<div class="card animated jello">
					<div class="card-header bg-primary text-white">
						<h2>Current Active Contacts</h2>
					</div>
					<div class="card-body bg-light">
						<table class="table text-center table-hover">
							<thead class="bg-success text-white">
								<tr>
									<th>Contact Id</th>
									<th>Contact Name</th>
									<th>Contact Email</th>
									<th>Contact No</th>
									<th colspan="3">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${contact}" var="ob">
									<tr>
										<td>${ob.contactId}</td>
										<td>${ob.contactName}</td>
										<td>${ob.contactEmail}</td>
										<td>${ob.contactNum}</td>
										<td><a
											class="btn btn-outline-danger btn-sm
												text-danger"
											href="deleteContact?contactId=${ob.contactId}"
											onclick="return confirmDelete()">DELETE</a>&nbsp; <a
											class="btn btn-outline-info btn-sm
												text-info"
											href="getContactById?contactId=${ob.contactId}">EDIT</a>
											&nbsp; <a
											class="btn btn-outline-success btn-sm
												text-info"
											href="viewContactById?contactId=${ob.contactId}">VIEW</a>
											
											</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-3">

				<div class="row">
					<div class="col-md-12  mb-4">

						<a href="register" class="btn btn-primary btn-block"> <i
							class="fa fa-plus-circle"></i> Add New Employee
						</a>
					</div>
					<div class="col-md-12">
						<a href="getAllContacts" class="btn btn-warning btn-block"> <i
							class="fa fa-plus-circle"></i> Get All Active Employee
						</a>
					</div>


				</div>
			</div>
		</div>
	</section>

	<!-- Main Footer -->
	<footer class="p-3 bg-dark text-white text-center">
		<div class="container">
			<div class="row">
				<div class="col">
					<h3>Copyright &copy; 2020 , Kushwaha.com</h3>
					<h6>All Rights Reserved</h6>
					<h6>
						Developed & Maintained by <a class="text-warning"
							href="https://github.com/Ajitkumarkushwaha" target="_blank">
							<i class="fa fa-users"></i> Kushwaha Group
						</a>
					</h6>
				</div>
			</div>
		</div>
	</footer>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<!-- BODY ENDS -->
	<script src="../bootstrap/js/jquery-3.3.1.min.js"></script>
	<script src="../bootstrap/js/popper.min.js"></script>
	<script src="../bootstrap/js/bootstrap.min.js"></script>
	<script src="../bootstrap/js/mdb.min.js"></script>
</body>
</html>

