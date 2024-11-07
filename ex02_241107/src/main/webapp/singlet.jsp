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
    <h1>업로드할 파일을 선택하세요</h1>
    <hr>
    <form action="singleUpload" method="post" enctype="multipart/form-data">
        작성자 : <input type="text" name="author"><br><br>
        업로드 파일 : <input type="file" name="filename"><br><br>
        <input type="submit" value="업로드">
    </form>
</body>
</html>