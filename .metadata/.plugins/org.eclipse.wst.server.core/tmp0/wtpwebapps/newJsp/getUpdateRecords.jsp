<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.p1.User"%>
<%@page import="com.p1.UserDao"%>
<%@ page import="java.sql.ResultSet"%>
<jsp:useBean id="user" class="com.p1.User"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

	<% 
	UserDao.update(user);
	response.sendRedirect("index.jsp");
	 %>
