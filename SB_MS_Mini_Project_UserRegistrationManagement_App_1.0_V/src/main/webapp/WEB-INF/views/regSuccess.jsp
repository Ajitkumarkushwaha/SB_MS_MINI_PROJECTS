<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To KBM Group</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link rel="stylesheet" href="../bootstrap/css/font-awesome-5.8.1.css">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="../bootstrap/css/mdb.css">
<link rel="stylesheet" href="../bootstrap/css/style.css">
<link rel="stylesheet" href="../css/styles.css">
</head>
<body>

	<h1></h1>

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
						</div>
					</div>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</section>
	
	<!-- Error Message -->	
</body>
</html>