<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <jsp:include page="/WEB-INF/views/include/bs5.jsp" />
  <title>errorMessage.jsp</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp" />
<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
<p><br/></p>
<div class="container text-center">
  <h2>현재 작업중입니다.(405)</h2>
  <div>(빠른시일내에 복구하겠습니다.)</div>
  <hr class="border-1 border-dark">
  <div><img src="${ctp}/images/errorPage.jpg" width="300px"/></div>
  <hr class="border-1 border-dark">
  <div><a href="${ctp}/error/errorForm" class="btn btn-success">돌아가기</a></div>
</div>
<p><br/></p>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>