package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/mydb";
		String uid = "root";
		String upw = "1234";
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, uid, upw);
			if(conn != null) {
				System.out.println("DB 접속 성공!!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
