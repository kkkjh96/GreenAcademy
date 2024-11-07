<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DBconnPool"%>
<%@page import="dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        DBconnPool db = new DBconnPool();
        
            List<Board> list = new ArrayList<>();
            String query = "SELECT * FROM board_241107 ORDER BY no DESC";
            try{
                db.pstmt = db.conn.prepareStatement(query);
                db.rs = db.pstmt.executeQuery();
                while(db.rs.next()){
                    int no = db.rs.getInt("no");
                    String title = db.rs.getString("title"); 
                    String content = db.rs.getString("content"); 
                    String writer = db.rs.getString("writer");
                    
                    list.add(new Board(no, title, content, writer));
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        request.setAttribute("list", list);
        db.close();
    %>
    <table border="1">
        <thead>
            <th>번호</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성자</th>
        </thead>
        <tbody>
            <c:forEach var="list" items="${list}">
            <tr>
                <td>${list.no}</td>
                <td>${list.title}</td>
                <td>${list.content}</td>
                <td>${list.writer}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>