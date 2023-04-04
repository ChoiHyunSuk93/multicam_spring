<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="resources/img/watch.png" width="300" height="300">
<hr color="red">
<%if(session.getAttribute("id") != null) {%>
<a href="bbb"><button style="background: pink;">공동구매 참여</button></a>
<%} else{%>
<a href="login.jsp"><button style="background: pink;">로그인페이지로</button></a>
<%} %>
</body>
</html>