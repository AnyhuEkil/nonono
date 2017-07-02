<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="UTF-8" />
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>auctioneerPageNav</title>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>
<style type="text/css"></style>
</head>
<body>
	<h1>판매자페이지 네비</h1>
	<div>
		<a href="${path }auctionInfo.do">입찰정보</a>
		<!-- TODO 입찰중인 상품 갯수 -->
	</div>
	<div>
		<a href="${path }message.do">쪽지함</a>
	</div>
	<div>
		<a href="${path }getInfo.do">낙찰/배송</a>
		<!-- TODO 입찰중인 상품 갯수 -->
	</div>
	<div>
		<a href="${path }ocationInfo.do">주소지등록</a>
	</div>
	<div>
		<a href="${path }/menuPageLoc.do?pl=myPage/userPayment">신용카드</a>
	</div>
		<div>
		<a href="${path }userInfo.do">회원개인정보</a>
	</div>
</body>
</html>