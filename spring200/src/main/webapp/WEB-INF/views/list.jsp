<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1">
	<tr>
		<td>id</td>
		<td>pw</td>
		<td>name</td>
		<td>tel</td>
	</tr>
	<c:forEach items="${list}" var="vo">
		<tr>
			<td>${vo.id}</td>
			<td>${vo.pw}</td>
			<td>${vo.name}</td>
			<td>${vo.tel}</td>
		</tr>
	</c:forEach>
</table>