<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<fmt:requestEncoding value="UTF-8"/> 
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%request.setCharacterEncoding("UTF-8"); 
  String path=request.getContextPath();	
%>    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BoardRead</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#listBtn").click(function(){
			$(location).attr("href","${path}/board/list.do?auction_id="+auction_id);
		});
		$("#delBtn").click(function(){
			if (confirm("삭제하시겠습니까?")){
				$("form").attr("action", "${path}/board/delete.do");
				$("form").submit();
			}
		});
		$("#uptBtn").click(function() {
			$(location).attr("href","${path}/board/update.do?board_id=${read.board_id}&auction_id="+auction_id);
		});
		$("#replyBtn").click(function(){
			alert("${sessionScope.id}");
			alert("${sessionScope.name}");
			$(location).attr("href","${path}/board/reply.do?board_id=${read.board_id}&auction_id="+auction_id);
			
		})
	});
</script>
<style type="text/css">

</style>
</head>
<body>
	<!-- header 삽입 -->
	<c:import url="../main/header.jsp" />
	<h2>게시글 보기</h2>
	<form method="post">
		<div>
			작성일자: <fmt:formatDate value="${read.board_date}" pattern="yyyy-MM-dd a HH:mm:ss" />
		</div>
		<div>
			조회수 : ${read.board_hit}
			이름: ${read.board_name }
		</div>
		<div>
			제목 : ${read.board_title}
		</div>
		<div>
			내용
			<textarea id="board_content" rows="4" cols="80" readonly="readonly">${read.board_content}</textarea>
		</div>
		<div style="width: 650px; text-align: center;">
			<input type="hidden" name="board_id" value="${read.board_id}">
			<!-- 유저 id와 글쓴 id가 같을 경우 수정, 삭제 가능-->
			<c:if test="${sessionScope.id == read.board_writer_id }">
				<button type="button" id="uptBtn">수정</button>
				<button type="button" id="delBtn">삭제</button>			
			</c:if>
			<input type="button" id="listBtn" value="목록"/>
			<!-- 유저id와 판매자 id가 같을 경우 답글 작성 가능 -->
			<c:if test="${sessionScope.id==sessionScope.auctioneer_id}">
				<input type="button" id="replyBtn" value="댓글 작성"/>
			</c:if>
		</div>
	</form>
</body>
</html>