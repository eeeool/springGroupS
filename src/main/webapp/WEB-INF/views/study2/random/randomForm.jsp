<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<title>randomForm.jsp</title>
	
	<script>
		'use strict';
		
		let cnt = 0;
		let str = '';
		
		// random() 메소드 사용
		function randomCheck() {
			$.ajax({
				url: '${ctp}/study2/random/randomCheck',
				type: 'post',
				success: (res) => {
					cnt++;
					str += cnt + "(random): " + res + "<br/>";
					$('#demo').html(str);
				},
				error: () => alert('전송 오류')
			});
		}
			
		// UUID 클래스 사용
		function uuidCheck() {
			$.ajax({
				url: '${ctp}/study2/random/uuidCheck',
				type: 'post',
				success: (res) => {
					cnt++;
					str += cnt + "(random): " + res + "<br/>";
					$('#demo').html(str);
				},
				error: () => alert('전송 오류')
			});
		}
			
		// AlphaNumbericCheck 사용
		function AlphaNumbericCheck() {
			$.ajax({
				url: '${ctp}/study2/random/AlphaNumbericCheck',
				type: 'post',
				success: (res) => {
					cnt++;
					str += cnt + "(random): " + res + "<br/>";
					$('#demo').html(str);
				},
				error: () => alert('전송 오류')
			});
		}
	</script>
</head>
<jsp:include page="/WEB-INF/views/include/nav.jsp" />
<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
<body>
<p><br/></p>
<div class="container">
	<h2>무작위수/randomAlphaNumberic</h2>
	<hr/>
	<div>
		<input type="button" value="Numberic" onclick="randomCheck()" class="btn btn-success me-2" />
		<input type="button" value="UUID(16진수)" onclick="uuidCheck()" class="btn btn-primary me-2" />
		<input type="button" value="AlphaNumberic" onclick="AlphaNumbericCheck()" class="btn btn-info" />
	</div>
	<hr/>
	<div>
		<div>출력결과: </div>
		<span id="demo"></span>
	</div>
</div>
<p><br/></p>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>