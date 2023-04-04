<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1">
<tr>
<td>번호</td>
<td>제목</td>
<td>내용</td>
<td>작성자</td>
</tr>
<c:forEach items="${list}" var="bag">
<tr>
<td>${bag.no}</td>
<td>${bag.title}</td>
<td>${bag.content}</td>
<td>${bag.writer}</td>
</tr>
</c:forEach>
</table>