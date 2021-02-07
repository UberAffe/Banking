<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="first.css">
		<script src=".\js\Login.js"></script>
		<title>Banking</title>
	</head>
	<body>
	<nav>
	</nav>
		<h2>This is the login page.</h2>
		<br>
		<form onsubmit="submit()">
			<select class="option">
				<option class="option" value="login">Login</option>
				<option class="option" value="regiser">Register</option>
			</select><br>
			Username:<input type="text" class="username"><br>
			Password:<input type="password" class="password"><br>
			<input type="submit" id="loginButton" value="Login">
		</form>
	</body>
</html>