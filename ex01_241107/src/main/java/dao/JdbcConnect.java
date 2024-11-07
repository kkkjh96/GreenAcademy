package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;

public class JdbcConnect {
	
	public Connection conn;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet rs;

	public JdbcConnect() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost:3306/mydb";
			String uid = "root";
			String upw = "1234";
			conn = DriverManager.getConnection(url, uid, upw);
			System.out.println("DB1 접속 성공!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public JdbcConnect(String driver, String url, String id, String pw) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB2 접속 성공!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public JdbcConnect(ServletContext application) {	// 의존성 주입
		try {
			String driver = application.getInitParameter("mariaDriver");
			String url = application.getInitParameter("mariaUrl");
			String id = application.getInitParameter("mariaId");
			String pw = application.getInitParameter("mariaPw");
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB3 접속 성공!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {		
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			System.out.println("DB 접속 해제..");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
