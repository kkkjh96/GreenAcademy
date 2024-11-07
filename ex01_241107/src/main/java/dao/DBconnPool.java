package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBconnPool {
	public Connection conn;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet rs;

	public DBconnPool() {
		try {
			Context initCtx = new InitialContext();
			Context ctx = (Context) initCtx.lookup("java:comp/env");	// 상수 서버가 데이터를 관리하는 경로
			DataSource source = (DataSource) ctx.lookup("dbcp_maria"); // DataSource가 없으면 connection객체를 얻을 수 없다.

			conn = source.getConnection();

			System.out.println("DB 커넥션 풀 연결 성공..");
		} catch (Exception e) {
			System.out.println("DB 커넥션 풀 연결 실패..");
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {		
			if(rs != null) {
				System.out.println("rs 종료..");
				rs.close();
			}
			if(stmt != null) {
				System.out.println("stmt 종료..");
				stmt.close();
			}
			if(pstmt != null) {
				System.out.println("pstmt 종료..");
				pstmt.close();
			}
			if(conn != null) {
				System.out.println("conn 접속 해제..");
				conn.close();
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
