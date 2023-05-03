package com.p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDao {
	public static int save(User user) {
		int status = 0;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO AllDetails values(?,?,?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getGender());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	private static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=jsp;encrypt=false", "sa",
					"Admin@123");
			return conn;
		} catch (Exception e) {

		}
		return conn;

	}

	public static List<User> allEmp(User empl) throws SQLException {
		int status = 0;
		PreparedStatement ps;
		List<User> list = new ArrayList<User>();

		try {
			String sql = "SELECT * FROM AllDetails";
			ps = UserDao.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User e = new User();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPassword(rs.getString(4));
				e.setGender(rs.getString(5));
				list.add(e);
			}
			ps.close();

		} catch (Exception e) {

		}
		return list;
	}

	public static int delete(User user) {
		int status = 0;

		try {
			PreparedStatement ps;
			Connection conn = getConnection();
			ps = conn.prepareStatement("DELETE FROM AllDetails where id = ?");
			ps.setInt(1, user.getId());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	public static int update(User user) {
		int status = 0;
		try {
			PreparedStatement ps;
			Connection conn = getConnection();
			ps = conn
					.prepareStatement("UPDATE AllDetails set name = ?, email = ?, password = ?, gender = ? where id=?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getGender());
			ps.setInt(5, user.getId());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	public static User getId(int id) {

		try {
			PreparedStatement ps;
			Connection conn = getConnection();
			ps = conn.prepareStatement("SELECT * FROM AllDetails WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			User e = new User();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setEmail(rs.getString(3));
			e.setPassword(rs.getString(4));
			e.setGender(rs.getString(5));
			return e;
		} catch (Exception e) {
			System.out.println("exception in get id method");
			e.printStackTrace();
		}
		return null;
	}
	
	public static User Emp(int id) {

		try {
			PreparedStatement ps;
			Connection conn = getConnection();
			ps = conn.prepareStatement("SELECT * FROM AllDetails WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			User e = new User();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setEmail(rs.getString(3));
			e.setPassword(rs.getString(4));
			e.setGender(rs.getString(5));
			return e;
		} catch (Exception e) {
			return null;
		}
		
	}

}
