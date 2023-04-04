<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	현재 게시물 조회수 ${count}<br>
	<%
		if (session.getAttribute("id") != null) {
	%>
	<h3>게시글 작성</h3>
	<hr color="red">
	<form action="insert2.multi" method="get">
		no : <input name="no" value="1"><br> title : <input
			name="title" value="test1"><br> content : <input
			name="content" value="test1"><br> writer : <input
			name="writer" value="${id}"><br>
		<button type="submit">전송</button>
	</form>
	<hr color="red">
	<h3>게시글 수정</h3>
	<hr color="red">
	<form action="update2.multi" method="get">
		no : <input name="no" value="1"><br> content : <input
			name="content" value="test1"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>게시글 삭제</h3>
	<hr color="red">
	<form action="delete2.multi" method="get">
		no : <input name="no" value="1"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<%
		} else {
	%>
	<a href="login.jsp">
		<button style="background: pink;">로그인</button>
	</a>
	<%
		}
	%>
	<hr color="red">

	<h3>게시글 검색</h3>
	<a href="list2.multi">게시글 전체 검색</a>
	<hr color="red">
	<a href="one2.multi?no=2">2번 게시글 검색</a>
	<a href="one2.multi?no=3">3번 게시글 검색</a>
	<form action="one2.multi" method="get">
		no : <input name="no" value="1"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">
	<button type="button">먹통버튼</button>

</body>
</html>