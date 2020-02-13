<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2> Welcome ${msg}  </h2>

<h2>Create The New Contact</h2>

<form action="saveContact" method="POST">
<label>Contact Name</label><input type="text" name="contactName" required="required" >
<label>Contact Email</label><input type="text" name="contactEmail" required="required" >
<label>Contact Number</label><input type="text" name="contactNo" required="required" >
<input type="submit" value="Add New Contact">
</form>
<h3><a href="getAllContacts">View All Contacts</a></h3>

</body>
</html>