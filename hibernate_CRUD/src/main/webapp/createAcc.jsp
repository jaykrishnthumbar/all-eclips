<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="com.source.User"%>
	<%@page import="org.hibernate.cfg.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
</head>
<body>
	<form action="adduser" method="post">
		<h1 align="center">Create Your Account...</h1>

		<table align="center">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>