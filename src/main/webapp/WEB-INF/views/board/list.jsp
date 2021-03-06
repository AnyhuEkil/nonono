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
<title>BoardList</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#writeBtn").click(function(){
				// 세션 email(로그인시 사용하는) session으로 설정
				var session = "${sessionScope.email}";
				// email계정이 없을 경우 
				if(session == null || session == ""){
					alert("로그인 하세요");
					alert(session);
				// 있으면 로직 진행
				}else{
					$(location).attr("href", "${path}/board/insert.do");
					alert(session);
				}
		});
	});
	// 페이징 처리후 매 페이지 선택할 때마다 값을 떠넘김
	function list(page){
		$(location).attr("href","${path}/board/list.do?curPage="+page+"&option=${map.option}"+"&keyword=${map.keyword}"+"&auction_id="+auction_id);
	}
</script>
<style type="text/css">

</style>
</head>
<body>
	<!-- header.jsp 인클루드 -->
	<c:import url="../main/header.jsp"/>
	<br><br><br>
	<div class="container">
		<form method="post" action="${path }/board/list.do">
			<input type="hidden" name="auction_id" value="9"/>
			<select name="option">
				<option value="all"
					<c:out value="${map.option=='all'?'selected':'' }"/>>제목+이름+내용</option>
				<option value="board_title"
					<c:out value="${map.option=='board_title'?'selected':'' }"/>>제목</option>
				<option value="board_name"
					<c:out value="${map.option=='board_name'?'selected':'' }"/>>작성자</option>
				<option value="board_content"
					<c:out value="${map.option=='board_content'?'selected':'' }"/>>내용</option>
			</select>
			<input name="keyword" value="${map.keyword }">
			<input type="submit" value="검색">
		</form>
		${map.count }개의 게시물이 있습니다.
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<!-- 게시글 넘버링 처리 및 리스트 불러오기 -->
				<c:forEach var="board" items="${map.list }" varStatus="sts" begin="0" end="${map.list.size() }" step="1">
					<tr>
						<!-- 게시글 넘버링 -->
						<td>${sts.count }</td>
						<!-- 게시글 제목 클릭시 게시글 보기(상세내용) -->
						<td><a href="${path}/board/read.do?board_id=${board.board_id}&board_group=${board.board_group}">${board.board_title}</a></td>
						<td>${board.board_name }</td>
						<td><fmt:formatDate value="${board.board_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td>${board.board_hit }</td>
					</tr>
				</c:forEach>
				<!-- 게시글이 없을 경우 -->
				<c:if test="${map.list.size()==0 }">
					<td colspan="5" style="text-align:center;">작성된 문의가 없습니다!!</td>
				</c:if>
			</tbody>
		</table>
		<hr />
		<a class="btn btn-default pull-right" id="writeBtn">글쓰기</a>
		<div class="text-center">
			<ul class="pagination">
				<!-- **처음페이지로 이동 : 현재 페이지가 1보다 크면  [처음]하이퍼링크를 화면에 출력-->
                <c:if test="${map.boardPage.curPage > 1}">
                    <li><a href="javascript:list('1')">[처음]</a></li>
                </c:if>
                
                <!-- **이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 [이전]하이퍼링크를 화면에 출력 -->
                <c:if test="${map.boardPage.curBlock > 1}">
                    <li><a href="javascript:list('${map.boardPage.prevPage}')">[이전]</a></li>
                </c:if>
                
                <!-- **하나의 블럭에서 반복문 수행 시작페이지부터 끝페이지까지 -->
                <c:forEach var="num" begin="${map.boardPage.blockBegin}" end="${map.boardPage.blockEnd}">
                    <!-- **현재페이지이면 하이퍼링크 제거 -->
                    <c:choose>
                        <c:when test="${num == map.boardPage.curPage}">
                            <li><span style="color: red">${num}</span></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="javascript:list('${num}')">${num}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                
                <!-- **다음페이지 블록으로 이동 : 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 [다음]하이퍼링크를 화면에 출력 -->
                <c:if test="${map.boardPage.curBlock <= map.boardPage.totBlock}">
                    <li><a href="javascript:list('${map.boardPage.nextPage}')">[다음]</a></li>
                </c:if>
                
                <!-- **끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면 [끝]하이퍼링크를 화면에 출력 -->
                <c:if test="${map.boardPage.curPage <= map.boardPage.totPage}">
                    <li><a href="javascript:list('${map.boardPage.totPage}')">[끝]</a></li>
                </c:if>
			</ul>
		</div>
	</div>
</body>
</html>