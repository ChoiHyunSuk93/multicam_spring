<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h3>콘서트 정보 입력</h3>
	<hr color="red">
	<form action="insert" method="get">
		제목 : <input	name="title" value="로미오와 줄리엣"><br> 
		장르 : <input name="genre" value="뮤지컬"><br>
		장소 : <input name="place" value="서울"><br>
		<button type="submit">전송</button>
	</form>
	<hr color="red">

	<h3>콘서트 정보 수정</h3>
	<hr color="red">
	<form action="update" method="get">
		번호 : <input name="no" value="1"><br>
		수정할 장소 : <input
			name="place" value="부산"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>콘서트 정보 삭제</h3>
	<hr color="red">
	<form action="delete" method="get">
		삭제할 번호 : <input name="no" value="1"><br>
		<button type="submit">서버로 전송</button>
	</form>
	<hr color="red">

	<h3>콘서트 정보 검색</h3>
	<a href="list">모든 콘서트 정보 가지고 오기.</a>
	<hr color="red">
	<form action="one" method="get">
		검색할 번호 : <input name="no" value="1"><br>
		<button type="submit">서버로 전송</button>
	</form>
	
</body>
</html>