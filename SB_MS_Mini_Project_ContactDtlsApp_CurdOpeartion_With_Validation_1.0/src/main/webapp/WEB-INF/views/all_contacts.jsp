<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

table {
	width: 720px;
	border: none;
	box-shadow: 0 0 15px black;
	text-align: center;
	margin: auto;
}
thead {
	background-color: orangered;
	color: white;
	font-size: 22px;
	text-align: center;
	height: 35px;
}
tbody {
	background-color: lime;
	color: red;
	text-align: center;
	font-size: 19px;
	height: 32px;
}
th , td{
 width: 160px;
}
</style>
</head>
<body>

	<h3><a href="register">Add New Contacts</a></h3>
	<h1>Your Product Details</h1>

	<c:choose>
		<c:when test="${!empty allActiveContacts}">
			<table>
				<thead>
					<tr>
						<th>Contact ID</th>
						<th>Contact NAME</th>
						<th>Contact EMAIL</th>
						<th>Contact NUMBER</th>
						<th>ACTIONS</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allActiveContacts}" var="ob">
						<tr>
							<td>${ob.contactId}</td>
							<td>${ob.contactName}</td>
							<td>${ob.contactEmail}</td>
							<td>${ob.contactNum}</td>
							<td><a href="removeContact?contactId=${ob.contactId}">DELETE</a>
							<a  href="updateContact?contactId=${ob.contactId}">EDIT</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<h4>NO DATA FOUND</h4>
		</c:otherwise>
	</c:choose>


</body>
</html>