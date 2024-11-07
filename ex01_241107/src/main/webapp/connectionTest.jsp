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
        JdbcConnect jdbc1 = new JdbcConnect();
        jdbc1.close();
    %>
    <h2>JDBC Test 2</h2>
    <hr>
    <%
        String driver = application.getInitParameter("mariaDriver");
        String url = application.getInitParameter("mariaUrl");
        String id = application.getInitParameter("mariaId");
        String pw = application.getInitParameter("mariaPw");

        JdbcConnect jdbc2 = new JdbcConnect(driver, url, id, pw);
        jdbc2.close();
    %>
    <h2>JDBC Test 3</h2>
    <hr>
    <%
        JdbcConnect jdbc3 = new JdbcConnect(application);
        jdbc3.close();
    %>
</body>
</html>