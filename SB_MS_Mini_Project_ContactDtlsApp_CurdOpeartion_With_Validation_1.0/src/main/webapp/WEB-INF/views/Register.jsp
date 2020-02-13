<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h2, h3 {
	text-align: center;
}
form{
 text-align: center;
}
</style>
</head>
<body>


	<h2>REGISTER HERE</h2>

	<h2>Welcome ${username}</h2>
	<h3>${msg}</h3>

	<form:form action="saveContact" method="POST" modelAttribute="contact">
		<table>
			<tr>
				<td>Contact Name</td>
				<td><form:input path="contactName"/></td>
			</tr>
			<tr>
				<td>Contact Email</td>
				<td><form:input path="contactEmail" /></td>
			</tr>
			<tr>
				<td>Contact NUMBER</td>
				<td><form:input path="contactNum" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="RESET"></td>
				<td><input type="submit" value="SUBMIT"></td>
			</tr>

		</table>
	</form:form>
	<h3>
		<a href="getAllContacts">View All Contacts</a>
	</h3>

</body>
</html>