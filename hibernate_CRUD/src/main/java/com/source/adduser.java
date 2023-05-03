package com.source;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/adduser")
public class adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public adduser() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
		
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		User u = new User();

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		u.setName(name);
		u.setEmail(email);
		u.setPassword(password);

	
		Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(u);
        tx.commit();
        
        session.close();
		
	}

}
