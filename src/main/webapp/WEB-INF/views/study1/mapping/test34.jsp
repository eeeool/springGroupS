<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<title>test34.jsp</title>
	
	<script>
		'use strict';
		
		if ('${message}' != '') alert('${message}');
	</script>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp" />
<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
<p><br/></p>
<div class="container">
	<h2>�̰��� Test34 �Դϴ�</h2>
	<hr />
	<div>���̵�: ${vo.mid}</div>
	<div>��й�ȣ: ${vo.pwd}</div>
	<div>�̸�: ${vo.name}</div>
	<div>����: ${vo.strGender}</div>
	<div>����: ${vo.age}</div>
	<div>����: ${vo.nickName}</div>
	<hr />
	<div><a href="${ctp}/study1/mapping/menu" class="btn btn-warning">���ư���</a></div>
</div>
<p><br/></p>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>