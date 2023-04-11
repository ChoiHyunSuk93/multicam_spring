<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시글 화면입니다.</h3>
	<hr color="red">



	<h3>게시글 작성.</h3>
	<hr color="red">
	<form action="insert2.multi" method="get">
		title : <input name="title" value="hello"><br> content :
		<input name="content" value="hello world"><br> writer : <input
			name="writer" value="apple"><br>
		<button type="submit">전송</button>
	</form>
	<hr color="red">

	<h3>게시글 수정 화면입니다.</h3>
	<hr color="red">
	<form action="update2.multi" method="get">
		no : <input name="no" value="17"><br> content : <input
			name="content" value="change"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>게시글 삭제 화면입니다.</h3>
	<hr color="red">
	<form action="delete2.multi" method="get">
		no : <input name="no" value="17"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">
	
	<h3>게시글검색 화면입니다.</h3>
	<a href="list2">모든 회원정보 가지고 오기.</a>
	<hr color="red">
	<form action="one2.multi" method="get">
		no : <input name="no" value="10"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">


</body>
</html>