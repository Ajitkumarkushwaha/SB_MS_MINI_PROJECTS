<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<style type="text/css">
.fourOne {
	color: green;
	font-size: 35px;
	text-align: center;
}

.zero {
	color: red;
	font-size: 45px;
	text-align: center;
	text-align: center;
}

.fourTwo {
	color: gray;
	font-size: 35px;
	text-align: center;
}

h1 {
	color: orangered;
	font-size: 30px;
	text-align: center;
	font-family: cursive;
}

.oops {
	color: orange;
}

div {
	text-align: center;
}

.errimg-div {
	text-align: center;
}

img {
	height: 350px;
	width: 900px;
	border: none;
	outline: none;
	border-radius: 5px;
	box-shadow: 0 0 15px red;
}

h2 {
	color: maroon;
	text-align: center;
	font-family: monospace;
}
hr{
width: 600px;
color: teal;
}
</style>
</head>
<body>
	<div>
		<h1>Are Ya<span style="color: olive;">aR</span><span style="color: orangered"> Phir </span>
		<span class="fourOne">4</span><span class="zero">0</span><span
			class="fourTwo">4</span><span style="color: green"> Aa Gya</span></h1>
	</div>
	<h1>
		<span class="oops">Oop's</span> Resource Not Found !!!
	</h1>
	<hr>
	<h2>
		Try To Find Correct Resource Address...<br> <span
			style="color: orangered;">Or,</span><br> Contact To Service
		Provider..!!!
	</h2>
	<div class="errimg-div">
		<img alt="404 Page" src="../img/error404.jpg">
	</div>
</body>
</html>