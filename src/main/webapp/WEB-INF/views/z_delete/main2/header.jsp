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
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var id = "${sessionScope.id}";
		$("#insert").click(function(){
			alert(id);
		})
	});
</script>
<style type="text/css">

</style>
</head>
<body>
 <nav class="navbar  navbar-inverse  navbar-fixed-top">
  <div class="container">
  <button type="button" class="navbar-toggle" data-toggle="collapse"  data-target=".navbar-collapse"
  >
  <span class="sr-only"> Toggle navigation</span>
  <span class="icon-bar"> </span>
  <span class="icon-bar"> </span>
  <span class="icon-bar"> </span>
  </button>
  
   <a class="navbar-brand" href="${path }/main.do">AUCTION</a>
   
       <div class="navbar-collapse collapse">
           <ul class="nav navbar-nav navbar-right">
           <c:choose>
           		<%-- 만약 email 세션이 없다면 로그인과 회원가입 나오게 --%>
           		<c:when test="${sessionScope.mem.email == null }"> 
           			 <li class=""><a href="${path }/member/login.do">Login</a></li>
           			 <li class=""><a href="${path }/member/insert.do">Sign-Up</a></li>
           		</c:when>
           		<%-- 있을경우 ~~~님 환영합니다, 물품등록, 정보수정, 로그아웃 나오게 --%>
           		<c:otherwise>
           			 <li style="color:white;">${sessionScope.mem.user_name }님 환영합니다.</li>
           			 <li style="color:white;">${sessionScope.id}님 환영합니다.</li>
           			 
           			 <li class=""><a href="${path }/member/info.do">회원정보수정</a> </li>
           			 <li class=""><a href="${path }/member/logout.do">로그아웃</a> </li>
           		</c:otherwise>
           </c:choose>
		   </ul> 
       </div>
  </div>
</nav>
</body>
</html>