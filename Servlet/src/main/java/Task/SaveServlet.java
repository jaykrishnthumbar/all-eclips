package Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		 resp.setContentType("text/html");
		 PrintWriter out=resp.getWriter();
		 Emp empl=new Emp();
		 
		 out.print("<form action=SaveServlet method=get>");
		 out.print("Enter user name: ");
		 out.print("<input type=text name=name><br><br>");
		 out.print("Enter email: ");
		 out.print("<input type=text name=email><br><br>");
		 out.print("Enter password: ");
		 out.print("<input type=text name=password><br><br>");
		 out.print("<input type=submit name=submit><br><br>");
		 out.print("</form>");
		 String name=req.getParameter("name");
		 String email=req.getParameter("email");
		 String password=req.getParameter("password");
		
		 empl.setUser_name(name);
		 empl.setEmail(email);
		 empl.setPassword(password);
		 
		 int status=EmpDao.createAcc(empl);
		 if(status>0) {
			 out.print(" Successfull");
		 }
		 else if(status==0 && !name.equals(null)) {
			 out.print(" Failure");
		 } 
		 
	}

}
