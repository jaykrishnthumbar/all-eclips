<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
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
.submit{

}
</style>


	<form action="UserServlet?operation=save" method="post">
		<h1 align="center">Create Your Account...</h1>

		
<div class="container">
		<table align="center">

			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" required></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" required></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" required></td>
			</tr>

			<tr>
				<td><button class="submit" type="submit" >Submit</button></td>
			</tr>
		</table>
		
		<h3 align="center">
			<a href=login.jsp>Alredy have Account</a>
		</h3>
		</div>
	</form>
</body>
</html>