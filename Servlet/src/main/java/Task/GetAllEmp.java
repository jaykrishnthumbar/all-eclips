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

@WebServlet("/GetAllEmp")
public class GetAllEmp extends HttpServlet {
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		Emp empl = new Emp();
		
		try {
			List<Emp> list=EmpDao.allEmp(empl);
			
			out.print("<table border='1' width='70%'");  
	        out.print("<tr><th>Name</th><th>Email</th><th>Password</th></tr>"); 
	        
			for(Emp e:list){  
	            out.print("<tr><td>"+e.getUser_name()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPassword()+"</td></tr>");  
	           }  
	           out.print("</table>");  
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
