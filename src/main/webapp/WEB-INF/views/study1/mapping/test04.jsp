<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<title>test4.jsp</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp" />
<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
<p><br/></p>
<div class="container">
	<h2>이곳은 Test4 입니다</h2>
	<hr />
	<div>아이디: ${mid}</div>
	<div>비밀번호: ${pwd}</div>
	<div>이름: ${name}</div>
	<!-- 성별 변수는 sex에 1/2/3/4를 담아서 넘긴다. 이때 set = 1 또는 3은 남자, 2또는 4는 여자로 출력 -->
	<div>성별: ${gender}</div>
	<hr />
	<div><a href="menu" class="btn btn-warning">돌아가기</a></div>
</div>
<p><br/></p>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>