<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<title>xmlMenu.jsp</title>
</head>
<jsp:include page="/WEB-INF/views/include/nav.jsp" />
<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
<body>
<p><br/></p>
<div class="container">
	<h2>XML�� ���� �� ���� ����</h2>
	<hr/>
	<div>
		<a href="xmlTest1" class="btn btn-success me-2">�����ڷ� ����</a>
		<a href="xmlTest2" class="btn btn-success me-2">�����ڷ� ���</a>
		<a href="xmlTest3" class="btn btn-success me-2">Site JDBC ����1</a>
		<a href="xmlTest4" class="btn btn-success me-2">Site JDBC ����2</a>
	</div>
</div>
<p><br/></p>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>