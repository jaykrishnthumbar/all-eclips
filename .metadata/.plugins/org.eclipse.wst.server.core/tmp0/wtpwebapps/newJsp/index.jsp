<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="com.p1.User"%><%@page
	import="com.p1.UserDao"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1 align="center">Choose the option</h1>

	<a href="createAcc.jsp" >1.Create Account</a>
	<br>

	<h3 align="center">All Users..</h3>


	<table border='1' align="center">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Gender</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>

		<%
		User empl = new User();
		List<User> list = UserDao.allEmp(empl);
		for (User e : list) {
		%>
		<tr>
			<td><%=e.getId()%></td>
			<td><a href="getUser.jsp?id=<%=e.getId()%>"><%=e.getName()%></a></td>
			<td><%=e.getEmail()%></td>
			<td><%=e.getPassword()%></td>
			<td><%=e.getGender()%></td>
			<td><a href="deleteUser.jsp?id=<%=e.getId()%>">Delete</a>
			<td><a href="updateUser.jsp?id=<%=e.getId()%>">Update</a>
			<%
			}
			%>
		
	</table>


</body>
</html>