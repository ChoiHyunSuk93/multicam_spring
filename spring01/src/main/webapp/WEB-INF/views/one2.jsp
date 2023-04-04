<%@page import="com.multi.mvc01.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="bbs.jsp">처음 페이지로</a>
<a href="list2.multi">게시물 전체 목록페이지</a>
<hr color="red">
<%
	//세션에서 값을 꺼내는 방법
	String id = (String)session.getAttribute("id");
//모델에서 값을 꺼내는 방법
// model.addAttribute("vo", vo);
BbsVO vo = (BbsVO)request.getAttribute("vo");
String writer = vo.getWriter();
if(id != null){
if(id.equals(writer)){
%>
<a href="update2"><button style="background: pink;">수정</button></a>
<a href="delete2.multi?no=${vo.no}"><button style="background: pink;">삭제</button></a>
<%} }%>
<hr color="red">
검색된 title은 ${vo.title} <br>
검색된 contents는 ${vo.content} <br>
검색된 writer는 ${vo.writer} <br>
</body>
</html>