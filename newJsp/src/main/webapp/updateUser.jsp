<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="com.p1.UserDao"%>
<%@page import="com.p1.User"%>
<%@page import="com.p1.UserDao"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User Details</title>
</head>
<body>
	<%
	String userId = request.getParameter("id");
	int id = Integer.parseInt(userId);
	
	%>
	<form action="getUpdateRecords.jsp" method="Post">
		<table>

			<tr>
				<td>Id:</td>
				<td><input type="text" name="id" value=<%= id%> readonly /></td>
			<tr>
				<td>Name:</td>
				<td><input type="name" name="name" /></td>
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
				<td><input type="radio" name="gender" />Male <input type="radio" name="gender" />Female</td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
			</tr>

		</table>
	</form>

</body>
</html>