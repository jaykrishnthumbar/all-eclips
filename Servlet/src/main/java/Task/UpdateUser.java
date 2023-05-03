package Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		Emp empl = new Emp();
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		empl.setEmail(email);
		empl.setPassword(password);
		
		
		out.print("Enter email: ");
		out.print("<input type=text name=email><br>");
 
		out.print("Enter password: ");
		out.print("<input type=text name=password>");
 
		out.print("<input type=submit name=submit>");
		
		 empl.setEmail(email);
		 empl.setPassword(password);
		
		
		if(email.equals(email) && password.equals(password)){
		
			out.println("<form action=UpdateUser method=post>");
			out.print("</form>");
			
			
			
		}
			
		
//			if(email.equals(email) && password.equals(password)) {
//				out.print("Enter new user name: "); 
//	        	out.print("<input type=text name=name>");
//	        	out.print("Enter new password: "); 
//	        	out.print("<input type=text name=password>");
//	        	out.print("<input type=submit name=submit>");
//	        	
//				}
//			else if(!email.equals(null)){
//				out.print(" Failure");
//			}
//		}
		else{
			out.print(" Failure");
			}
		}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		Emp empl = new Emp();
		try {
			String user_name=req.getParameter("user_name");
//			String email=req.getParameter("email");
			String password=req.getParameter("password");
//			empl.setEmail(email);
			empl.setPassword(password);
			List<Emp> list=EmpDao.emp(empl);
			
			 
//	        if(email.equals(email) && password.equals(password)) {
	        	
	        	out.print("Enter new user name: "); 
	        	out.print("<input type=text name=name>");
	        	out.print("Enter new password: "); 
	        	out.print("<input type=text name=password>");
	        	out.print("<input type=submit name=submit>");
	        	
	        	empl.setUser_name(user_name);
				empl.setPassword(password);
	        	int status=EmpDao.Update(empl);
	        	
	        	 if(status>1) {
	    			 out.print(" Update Successfull");
	    		 }
	    		 else {
	    			 out.print(" Failure");
	    		 }	        	
//	        }
	}
		catch(Exception e) {
			out.print(" Failure");
			}
		}

}
