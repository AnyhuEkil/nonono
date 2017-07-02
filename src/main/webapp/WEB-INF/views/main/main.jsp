<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="UTF-8" />
<c:set var="path" value="${pageContext.request.contextPath}" />
<%	request.setCharacterEncoding("UTF-8");	String path = request.getContextPath();%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MainMain</title>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(document).ready(function(){
			$("#item").dblclick(function(){
				$(location).attr("href","${path}/board/list.do");
			});
		});
	});
</script>
</head>
<body>
		<c:import url="header.jsp" />
	<br/>
	<br/>
	<br/>
	<div>
		<h1>카테고리(작업후삭제)</h1>
	</div>
	<div>
		<h1>상단슬라이드(작업후삭제)</h1>
		<!-- 쿼리문으로 이미지 조건 만든후 삽입. -->
		<div>
			<img src="${slideImg1}" alt="TODO 경로,파일,CSS" />
		</div>
		<div>
			<img src="${slideImg2}" alt="mainSideImg02" />
		</div>
		<div>
			<img src="${slideImg3}" alt="mainSideImg03" />
		</div>
		<div>
			<img src="${slideImg4}" alt="mainSideImg04" />
		</div>
	</div>
	<div>
		<h1>item list 분류해서 가져오기(list형태로 값만 불러오면됨.)</h1>
		<c:forEach var="mainThree" items="${mainItem }">
			<div>
				<!-- TODO 클릭시 상품화면 이동 -->
				<div>
					<img src="${mainThree.picture_location}" alt="itemImg01" />
				</div>
				<div>이름 : ${mainThree.item_name}</div>
				<div>가격 : ${mainThree.current_bid_amount }</div>
				<div>마감시간 : ${mainThree.end_date }</div>
			</div>
		</c:forEach>
		<c:import url="../item/list.jsp"/>
		<c:if test="${item == 'insert' }">
			<br><br><br><br><br><br>
			<c:import url="../item/insert.jsp"/>
		</c:if>
	</div>
	<div>
		<h1>사이트맵(작업후삭제)</h1>
	</div>


</body>
</html>