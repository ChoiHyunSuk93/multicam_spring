<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>북마크 등록</h3>
<hr color="red">
<form action="insert3.multi" method="get">
이름 : <input name="name" value="test"> <br>
url : <input name="url" value="http://www.test.com"> <br>
img : <input name="img" value="book1.png."> <br>
<button>책 등록</button>
</form>
<hr color="red">

<h3>북마크 수정</h3>
<hr color="red">
<form action="update3.multi" method="get">
수정할 id : <input name="id" value="1"> <br>
수정할 이름 : <input name="name" value="change"> <br> 
<button>수정하기</button>
</form>
<hr color="red">

<h3>북마크 삭제</h3>
<hr color="red">
<form action="delete3.multi" method="get">
삭제할 id : <input name="id" value="1"> <br>
<button>삭제하기</button>
</form>
<hr color="red">

<h3>북마크 검색</h3>
<a href="list3.multi">전체 목록 검색</a>
<form action="one3.multi">
검색할 책 id : <input name="id" value="1"><br>
<button>검색</button>
</form>


</body>
</html>