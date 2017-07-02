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
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#item").dblclick(function(){
			$(location).attr("href","${path}/board/list.do");
		});
	});
</script>
<style type="text/css">
* {
  font-family: "Roboto";
  list-style: none;
  margin: 0;
  padding: 0;
  text-decoration: none;
  letter-spacing: 1px;
  box-sizing: border-box;
}
body {
  background: #f9fafa;
  padding: 20px;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: center;
      -ms-flex-pack: center;
          justify-content: center;
  -ms-flex-wrap: wrap;
      flex-wrap: wrap;
}
.block {
  margin: 20px;
  border-radius: 4px;
  width: 280px;
  min-height: 430px;
  background: #fff;
  padding: 23px;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
      -ms-flex-direction: column;
          flex-direction: column;
  box-shadow: 0 2px 55px rgba(0,0,0,0.1);
}
.top {
  border-bottom: 1px solid #e5e5e5;
  padding-bottom: 10px;
}
.top ul {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: justify;
      -ms-flex-pack: justify;
          justify-content: space-between;
}
.top a {
  color: #9e9e9e;
}
.top a:hover {
  color: #c7ccdb;
}
.converse {
  padding: 2px 10px;
  border-radius: 20px;
  text-transform: uppercase;
  font-size: 14px;
}
.middle {
  margin-bottom: 40px;
}
.middle img {
  width: 100%;
}
.bottom {
  text-align: center;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
      -ms-flex-direction: column;
          flex-direction: column;
  -webkit-box-pack: justify;
      -ms-flex-pack: justify;
          justify-content: space-between;
  -webkit-box-flex: 1;
      -ms-flex-positive: 1;
          flex-grow: 1;
}
.heading {
  font-size: 17px;
  text-transform: uppercase;
  margin-bottom: 5px;
  letter-spacing: 0;
}
.info {
  font-size: 14px;
  color: #969696;
  margin-bottom: 10px;
}
.style {
  font-size: 16px;
  margin-bottom: 20px;
}
.old-price {
  color: #f00;
  text-decoration: line-through;
}

</style>
</head>
<body>
	<c:import url="header.jsp"/>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<c:choose>
		<%-- 서버단에서 받은 값이 insert면 물품 등록창 나옴 --%>
		<c:when test="${item == 'insert' }">
			<br><br><br><br><br><br>
			<c:import url="../item/insert.jsp"/>
		</c:when>
		<%-- 그외는 list화면 --%>
		<c:otherwise>
			<c:import url="../item/list.jsp"/>
		</c:otherwise>
	</c:choose>
</body>
</html>