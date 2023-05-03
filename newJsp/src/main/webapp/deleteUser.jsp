<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="com.p1.UserDao"%>
<jsp:useBean id="user" class="com.p1.User"></jsp:useBean>
<jsp:setProperty property="*" name="user" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete User Details</title>
</head>
<body>

	<%
	UserDao.delete(user);
	response.sendRedirect("index.jsp");
	%>

</body>
</html>