<%@page import="com.multi.mvc200.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.6.4.js"></script>
<script type="text/javascript">
	$(function() {
		$('#b1').click(function() {
			// 1. 화면을 이동하지 않고, 서버에 insert해달라고 요청
			content = $('#reply').val()
			writer = "apple"
			$.ajax({
				url: "insert4",
				data: {
					bbsno : ${vo.no},
					content : content,
					writer : writer 
				},
				success: function() {
					alert('성공')
					$('#result').append("- " + content + ", " + writer + "<br>")
					$('#reply').val('')
				}
			})
			// 2. 성공하면, result아래에 append
		})
	})
</script>
</head>
<body>
	<a href="bbs.jsp">처음 페이지로</a>
	<a href="list2.multi">게시물 전체 목록페이지</a>
	<hr color="red">
	<%
		//세션에서 값을 꺼내는 방법
	String id = (String) session.getAttribute("id");
	//모델에서 값을 꺼내는 방법
	// model.addAttribute("vo", vo);
	BbsVO vo = (BbsVO) request.getAttribute("vo");
	String writer = vo.getWriter();
	if (id != null) {
		if (id.equals(writer)) {
	%>
	<a href="update2"><button style="background: pink;">수정</button></a>
	<a href="delete2.multi?no=${vo.no}"><button
			style="background: pink;">삭제</button></a>
	<%
		}
	}
	%>
	<hr color="red">
	검색된 title은 ${vo.title}
	<br> 검색된 contents는 ${vo.content}
	<br> 검색된 writer는 ${vo.writer}
	<br>

	<hr color="red">
	댓글달기
	<input id="reply">
	<button id="b1">댓글달기</button>
	<br>
	<hr color="red">
	<div id="result">
		<c:forEach items="${list}" var="vo">
		- ${vo.content}, ${vo.writer}<br>
		</c:forEach>
	</div>
</body>
</html>