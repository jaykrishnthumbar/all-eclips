<%@page import="com.user.UserDao"%>
<%@page import="com.user.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>



<style>
html, body {
	height: 100%;
}

body {
	margin: 0;
	background: linear-gradient(45deg, #49a09d, #5f2c82);
	font-family: sans-serif;
	font-weight: 100;
}

.container {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

table {
	width: 800px;
	border-collapse: collapse;
	overflow: hidden;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

th, td {
	padding: 15px;
	background-color: rgba(255, 255, 255, 0.2);
	color: #fff;
}

th {
	text-align: left;
}

thead {th { background-color:#55608f;
	
}

}
tbody {tr { &:hover {
			background-color : rgba(255, 255, 255, 0.3);
	
}

}
td {
	position: relative; &: hover { & : before { 
				 content : "";
	position: absolute;
	left: 0;
	right: 0;
	top: -9999px;
	bottom: -9999px;
	background-color: rgba(255, 255, 255, 0.2);
	z-index: -1;
}
}
}
}
</style>
</head>
<body>

	<h1 align="center">Welcome....</h1>

	<h3 align="center">
		<a href=createAcc.jsp>1.Create New Account</a>
	</h3>

	<div class="container">
		<table>

			<tr>
				<td>User ID</td>
				<td>Name</td>
				<td>Email</td>
				<td>Password</td>
				<td>Delete</td>
				<td>Update</td>
			</tr>

			<%
			List<User> list = UserDao.allEmp();
			for (User u : list) {
			%>
			<tr>
				<td><a href="UserServlet?operation=OneEmp&id=<%=u.getId()%>"><%=u.getId()%></td>
				<td><%=u.getName()%></td>
				<td><%=u.getEmail()%></td>
				<td><%=u.getPassword()%></td>
				<td><a href="UserServlet?operation=delete&id=<%=u.getId()%>">Delete</a></td>
				<td><a href="UserServlet?operation=update1&id=<%=u.getId()%>">Update</a></td>

			</tr>
			<%
			}
			%>

		</table>
	</div>

</body>
</html>