<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회의 인원 등록하기</h3>
	<form action="insert4.multi">
		<table>
			<tr>
				<td>번호 :</td>
				<td><input name="rank" value="99"></td>
			</tr>
			<tr>
				<td>이름 :</td>
				<td><input name="name" value="Hong Gil Dong"></td>
			</tr>
			<tr>
				<td>전화 :</td>
				<td><input name="phone" value="123-456-7890"></td>
			</tr>
			<tr>
				<td>참석여부(true/false) :</td>
				<td><input name="boolean2" value="true"></td>
			</tr>
			<tr>
				<td>시간 :</td>
				<td><input name="time" value="11:00 AM"></td>
			</tr>
		</table>
		<button>등록하기</button>
	</form>

	<hr color="red">
	<h3>인원 정보 수정하기</h3>
	<form action="update4.multi">
		<table>
			<tr>
				<td>수정할 번호 :</td>
				<td><input name="rank" value="99"></td>
			</tr>
			<tr>
				<td>수정할 전화번호 :</td>
				<td><input name="phone" value="987-654-3210"></td>
			</tr>
		</table>
		<button>수정하기</button>
	</form>

	<hr color="red">
	<h3>인원 정보 삭제하기</h3>
	<form action="delete4.multi">
		<table>
			<tr>
				<td>삭제할 번호 :</td>
				<td><input name="rank" value="99"></td>
			</tr>
		</table>
		<button>삭제하기</button>
	</form>

	<hr color="red">
	<h3>인원 정보 검색하기</h3>
	<a href="list4.multi">전체 인원 정보 검색하기</a>
	<br>
	<form action="one4.multi">
		<table>
			<tr>
				<td>검색할 번호 :</td>
				<td><input name="rank" value="99"></td>
			</tr>
		</table>
		<button>검색하기</button>
	</form>
</body>
</html>