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
게시글검색 처리 요청이 완료되었습니다.<br>
<table>
<tr>
<td>번호</td>
<td>제목</td>
<td>내용</td>
<td>글쓴이</td>
</tr>
<c:forEach items="${list}" var="vo">
<tr>
<td>${vo.no}</td>
<td><a href="one2.multi?no=${vo.no}">${vo.title}</a></td>
<td>${vo.content}</td>
<td>${vo.writer}</td>
</tr>
</c:forEach>
</table>
</body>
</html>