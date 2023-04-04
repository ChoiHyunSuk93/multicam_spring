<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<table class="table table-dark table-hover">
<tr>
<td>번호</td>
<td>이름</td>
<td>전화번호</td>
<td>참석여부</td>
<td>시간</td>
</tr>
<c:forEach items="${list}" var="vo">
<tr>
	<td>${vo.rank}</td>
	<td>${vo.name}</td>
	<td>${vo.phone}</td>
	<td>${vo.boolean2}</td>
	<td>${vo.time}</td>
</tr>
</c:forEach>
</table>
</body>
</html>