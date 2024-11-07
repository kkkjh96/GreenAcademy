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
    <table border="1">
        <thead>
            <th>제목</th>
            <th>작성자</th>
            <th>이미지</th>
        </thead>
        <tbody>
            <c:forEach var="list" items="${list}">
            <tr>
                <td>${list.title}</td>
                <td>${list.writer}</td>
                <td><img src="images/${list.title}"></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>