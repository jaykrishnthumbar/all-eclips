package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		User u = new User();
		String operation = req.getParameter("operation");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		switch (operation) {

		case "save":

			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String password = req.getParameter("password");


			u.setName(name);
			u.setEmail(email);
			u.setPassword(password);

			UserDao.save(u);
			res.sendRedirect("home.jsp");
			out.close();
			break;

		case "delete":
			String id = req.getParameter("id");
			int sid = Integer.parseInt(id);

			u = UserDao.getUserById(sid);
			UserDao.delete(u);
			res.sendRedirect("home.jsp");
			break;

		case "update1":
			id = req.getParameter("id");
			sid = Integer.parseInt(id);
			u = UserDao.getUserById(sid);
			req.setAttribute("User", u);
			req.getRequestDispatcher("Update.jsp").forward(req, res);
			break;

		case "update2":

			id = req.getParameter("id");
			name = req.getParameter("name");
			email = req.getParameter("email");
			password = req.getParameter("password");

			sid = Integer.parseInt(id);
			u.setId(sid);
			u.setName(name);
			u.setEmail(email);
			u.setPassword(password);

			UserDao.update(u);
			res.sendRedirect("home.jsp");
			break;

		case "OneEmp":
			req.getRequestDispatcher("OneEmp.jsp").forward(req, res);			
			break;
			
		default:
			System.exit(0);
		}
		

	}

}
