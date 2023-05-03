package Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetEmp")
public class GetEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		Emp empl = new Emp();
		
		out.println("<form action=GetEmp method=post>");
		
		 out.print("Enter email: ");
		 out.print("<input type=text name=email><br>");
		 
		 out.print("Enter password: ");
		 out.print("<input type=text name=password>");
		 
		 out.print("<input type=submit name=submit>");
		 out.print("</form>");
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		Emp empl = new Emp();
		try {
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			empl.setEmail(email);
			empl.setPassword(password);
			List<Emp> list=EmpDao.emp(empl);
			
			 
	        if(email.equals(email) && password.equals(password)) {
	        	
	        	out.print("<table border='1' width='70%'");  
		        out.print("<tr><th>Name</th><th>Email</th><th>Password</th></tr>");
		        
	        	for(Emp e:list){  
		            out.print("<tr><td>"+e.getUser_name()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPassword()+"</td></tr>");  
		           }  
		           out.print("</table>");
	        }
//	        else {
//	        	
//	        	out.println("Enter valid Details");
//	        	
//	        }
		} catch (SQLException e1) {
			out.println("Enter valid Details");
			e1.printStackTrace();
		}
		 
	}

}
