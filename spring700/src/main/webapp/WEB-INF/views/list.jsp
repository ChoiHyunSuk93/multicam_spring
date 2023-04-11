<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
콘서트 정보 전체 목록
<hr color="red">
<table border="1">
<tr>
<td>번호</td>
<td>제목</td>
<td>장르</td>
<td>장소</td>
</tr>
<c:forEach items="${list}" var="bag">
<tr>
<td>${bag.no}</td>
<td>${bag.title}</td>
<td>${bag.genre}</td>
<td>${bag.place}</td>
</tr>
</c:forEach>
</table>
</body>
</html>