<%@page import="com.user.UserDao"%>
<%@page import="com.user.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Data</title>
</head>
<body>

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


	<h1 align="center">Your Data....</h1>

	<h3 align="center">
		<a href=home.jsp>Home</a>
	</h3>
<div class="container">
	<table border="1" align="center">

		<tr>
			<td>User ID</td>
			<td>Name</td>
			<td>Email</td>
			<td>Password</td>

		</tr>

		<%
		String id = request.getParameter("id");
		int sid = Integer.parseInt(id);
		User u = UserDao.getUserById(sid);
		%>
		<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getName()%></td>
			<td><%=u.getEmail()%></td>
			<td><%=u.getPassword()%></td>

		</tr>
		<%

		%>
		</table>
		</div>
	
</body>
</html>