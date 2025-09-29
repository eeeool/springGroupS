<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ede6ada917859580feb1c2bdabe42efe"></script>
	<title>kakaomap.jsp</title>
</head>
<jsp:include page="/WEB-INF/views/include/nav.jsp" />
<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
<body>
	<p><br/></p>
	<div class="container">
		<h2>Kakao Map 지도 연습</h2>
		<div id="map" style="width:100%; height:500px;"></div>
		<script>
			var container = document.getElementById('map');
			var options = {
				center: new kakao.maps.LatLng(33.450701, 126.570667),
				level: 3
			};
	
			var map = new kakao.maps.Map(container, options);	
		</script>
		<hr class="border border-dark"/>
		<jsp:include page="kakaoMenu.jsp" />
	</div>
	
	<p><br/></p>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>