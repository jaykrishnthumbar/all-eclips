<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@page import="com.p1.User"%><%@page
	import="com.p1.UserDao"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>

<h3 align="center">Users Details...</h3>




	<table border='1' align="center">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Gender</th>
			</tr>
			<%
		User e = new User();
			int id = Integer.parseInt(request.getParameter("id")); 
		e = UserDao.Emp(id);
		%>
		<tr>
			<td><%=e.getId() %></td>
			<td><%=e.getName() %></td>
			<td><%=e.getEmail() %></td>
			<td><%=e.getPassword() %></td>
			<td><%=e.getGender() %></td>
			
			
		</tr>

		
</table>

</body>
</html>