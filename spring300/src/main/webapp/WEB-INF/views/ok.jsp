<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background: yellow;
}
</style>
</head>
<body>
${id}님! 로그인 처리 요청이 완료되었습니다.<br>
<a href="bbs.jsp">
<button style="background: pink;">게시판 화면으로 go</button>
</a>
<a href="news.jsp"><button style="background: pink;">뉴스 사이트로</button></a>
<a href="cafe.jsp"><button style="background: pink;">카페 사이트로</button></a>
<img src="resources/img/yes.jpg" width="200" height="200">
</body>
</html>