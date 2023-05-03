package Task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 resp.setContentType("text/html");
		 PrintWriter out=resp.getWriter();
		 Emp empl=new Emp();
		 
		 out.println("<form action=DeleteServlet method=get>");
		 out.print("Enter email: ");
		 out.print("<input type=text name=email>");
		 String email=req.getParameter("email");
		 out.print("Enter password: ");
		 out.print("<input type=text name=password>");
		 String password=req.getParameter("password");
		 out.print("<input type=submit name=submit>");
		 
		 empl.setEmail(email);
		 empl.setPassword(password);
		 
		 int status=EmpDao.deleteAcc(empl);
		 
		 if(status>1) {
			 out.print(" Delete Successfull");
		 }
		 else if(status==0 && !email.equals(null)) {
			 out.print(" Failure");
		 }
	}

}
