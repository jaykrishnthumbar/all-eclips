package Task;
import java.util.*;


import java.sql.*;  

public class EmpDao {
	public static Connection getConnection() {
		Connection conn=null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=newEmployee;encrypt=false","sa","Admin@123");
		}
		catch(Exception e) {
			
		}
		return conn;  
	}
	
	public static int createAcc(Emp emp) {
		int status=0;
		
		
		PreparedStatement ps;
		try {
			String sql = "INSERT INTO EmpDetails VALUES(?,?,?)";
			ps=EmpDao.getConnection().prepareStatement(sql);
			ps.setString(1,emp.getUser_name());
			ps.setString(2,emp.getEmail());
			ps.setString(3,emp.getPassword());
			status=ps.executeUpdate();
			System.out.println(status);
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return status;
	}
		 public static int deleteAcc(Emp emp) {
			 int status=0;
			 PreparedStatement ps;
			 try {
			    String sql = "DELETE FROM EmpDetails WHERE email = ? and password = ?";
				ps=EmpDao.getConnection().prepareStatement(sql);
				ps.setString(1,emp.getEmail());
				ps.setString(2,emp.getPassword());
				status=ps.executeUpdate();
				System.out.println(status);
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
			return status;
		 }
		 
		 public static List<Emp> allEmp(Emp emp) throws SQLException {
			 int status=0;
			 PreparedStatement ps;
			 List<Emp> list=new ArrayList<Emp>();
			 
			 
			 
			 try {
				    String sql = "SELECT * FROM EmpDetails";
				    ps=EmpDao.getConnection().prepareStatement(sql);
				    ResultSet rs = ps.executeQuery();
				    while(rs.next()) {
				    	Emp e=new Emp(); 
				    	e.setUser_name(rs.getString(1));
				    	e.setEmail(rs.getString(2));
				    	e.setPassword(rs.getString(3));
				    	list.add(e);
				    }
				    ps.close();
				    
			 }
			 catch(Exception e) {
				 
			 }
			return list;
			 }
		 
		 public static List<Emp> emp(Emp emp) throws SQLException {
			 int status=0;
			 PreparedStatement ps;
			 List<Emp> list=new ArrayList<Emp>();
			 try {
				    String sql = "SELECT * FROM EmpDetails WHERE email = ? and password = ?";
				    ps=EmpDao.getConnection().prepareStatement(sql);
				    ps.setString(1,emp.getEmail());
					ps.setString(2,emp.getPassword());
				    ResultSet rs = ps.executeQuery();
				    while(rs.next()) {
				    	Emp e=new Emp(); 
				    	e.setUser_name(rs.getString(1));
				    	e.setEmail(rs.getString(2));
				    	e.setPassword(rs.getString(3));
				    	list.add(e);
				    }
				    ps.close();
				    
			 }
			 catch(Exception e) {
				 
			 }	
			return list; 
		 }
		 
		 public static int Update(Emp emp) throws SQLException {
			 int status=0;
			 PreparedStatement ps;
			 
			 String sql = "UPDATE EmpDetails WHERE user_name = ? and password = ?";
			    ps=EmpDao.getConnection().prepareStatement(sql);
			    ps.setString(1,emp.getUser_name());
				ps.setString(2,emp.getPassword());
			    ResultSet rs = ps.executeQuery();
			    while(rs.next()) {
			    	Emp e=new Emp(); 
			    	e.setUser_name(rs.getString(1));
//			    	e.setEmail(rs.getString(2));
			    	e.setPassword(rs.getString(3));
			 }
				return status;
	}
}