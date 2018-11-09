<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h2>Register here</h2>
	
	<form action="register" method = "POST">
		<input type = "text" name = "username" placeholder = "type username here">
		<input type = "text" name = "password" placeholder = "enter password">
		<input type = "submit" value = "submit">
	</form>
	<span style="color: red;">${fail_msg}</span>
	
	<h6>Your password should:</h6>
	<h6>at least 8 characters long</h6>
	<h6>contain at least ONE capital letter</h6>
	<h6>contain at least ONE lowercase letter</h6>
	<h6>contain at least ONE number</h6>
	<h6>contain at least ONE special symbol</h6>
	
	<a href = "index">back to main page</a>
	
</body>
</html>