<%@page import="com.p1.UserDao"%>
<jsp:useBean id="user" class="com.p1.User"></jsp:useBean>
<jsp:setProperty property="*" name="user" />

<%
int i = UserDao.save(user);
if (i > 0) {
	response.sendRedirect("success.jsp");
} else {
	response.sendRedirect("error.jsp");
}
%>
