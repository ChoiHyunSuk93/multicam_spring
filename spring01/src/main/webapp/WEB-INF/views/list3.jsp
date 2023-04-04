<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>
</head>
<body>
게시글검색 처리 요청이 완료되었습니다.<br>

<c:forEach items="${list}" var="vo">
<table>
<tr>
	<td>${vo.id}</td>
</tr>
<tr>	
	<td>${vo.name}</td>
</tr>
<tr>	
	<td><a href="${vo.url}">${vo.url}</a></td>
</tr>
<tr>	
	<td><img src="resources/img/${vo.img}" width="200" height="200"></td>
</tr>
</table>
</c:forEach>
</body>
</html>