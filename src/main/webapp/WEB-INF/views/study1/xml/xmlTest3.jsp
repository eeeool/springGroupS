<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<title>xmlTest2.jsp</title>
</head>
<jsp:include page="/WEB-INF/views/include/nav.jsp" />
<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
<body>
<p><br/></p>
<div class="container">
	<h2>webSite JDBC ����</h2>
	<div>����̹�: ${vo.driver}</div>
	<div>URL: ${vo.url}</div>
	<div>User: ${vo.user}</div>
	<div>password: ${vo.password}</div>
	<p class="text-center"><a href="xmlMenu" class="btn btn-success">���ư���</a></p>
</div>
<p><br/></p>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>