<%@page import="java.sql.PreparedStatement"%>
<%@page import="dao.DBconnPool"%>
<%@page import="dao.JdbcConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>JDBC Test 1</h2>
    <hr>
    <%
        DBconnPool db1 = new DBconnPool();
        String sql = "INSERT INTO board_241107 VALUES (null, ?, ?, ?)";
        PreparedStatement pstmt = db1.conn.prepareStatement(sql);
        pstmt.setString(1, "test8");
        pstmt.setString(2, "test8 content");
        pstmt.setString(3, "user8");
        int result1 = pstmt.executeUpdate();
        out.print(result1 + "행이 추가되었습니다.");
    	db1.close();
    %>
    <h2>JDBC Test 1</h2>
    <hr>
    <%
        DBconnPool db = new DBconnPool();
        String query = "INSERT INTO board_241107 VALUES (null, ?, ?, ?)";
        db.pstmt = db.conn.prepareStatement(query);
        db.pstmt.setString(1, "test9");
        db.pstmt.setString(2, "test9 content");
        db.pstmt.setString(3, "user9");
        int result = db.pstmt.executeUpdate();
        out.print(result + "행이 추가되었습니다.");
    	db.close();
    %>
</body>
</html>