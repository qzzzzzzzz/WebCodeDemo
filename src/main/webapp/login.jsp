<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h2>Login here</h2>

	<form action="login" method="POST">
		<input type="text" name="username" placeholder="type username here">
		<input type="password" name="password" placeholder="enter password">
		<input type="submit" value="Click Me!!!">
	</form>
	<span style="color: red;">${success_msg}</span>
	<span style="color: red;">${fail_msg}</span>
	
	<a href = "index">back to main page</a>
</body>
</html>