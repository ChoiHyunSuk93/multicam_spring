<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

이번 주말 맑음. 꽃놀이 가기 좋음.
<hr color="red">
<%if(session.getAttribute("id") != null) {%>
<form action="aaa">
댓글 : <input name="reply"><button>댓글달기</button>
</form>
<%} %>
</body>
</html>