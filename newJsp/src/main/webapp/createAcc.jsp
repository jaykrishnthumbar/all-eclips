<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="com.p1.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create User</title>
</head>
<body>

	<h1>Add New User</h1>

	<form action="addUser.jsp" method="Post">
		<table>

			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="male" />Male <input
					type="radio" name="gender" value="female" />Female</td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>

		</table>
	</form>
	<%
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String gender = request.getParameter("gender");

	User u = new User();
	u.setName(name);
	u.setEmail(email);
	u.setPassword(password);
	u.setGender(gender);
	%>
</body>
</html>