<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<title>adMemberList.jsp</title>
	
	<script>
		'use strict'
		
		function levelItemCheck() {
			let pageSize = $('#pageSizeItem select').val();
			let level = $('#levelItem').val();
			location.href = 'adMemberList?pag=1&pageSize=' + pageSize + '&level='+level;
		}
		
		$(() => {
			$('#pageSizeItem select').on('change', function() {
				const pageSize = $(this).val();
				const level = $('#levelItem').val();
				location.href = '${ctp}/admin/member/adMemberList?pag=1&pageSize=' + pageSize + '&level='+level;
			})
		});
	</script>
</head>
<body>
<p><br/></p>
<div class="container">
	<h2 class="text-center mb-3">회 원 리 스 트</h2>
	<div class="row mb-2">
		<div class="col">
			<select name="level" id="levelItem" onchange="levelItemCheck()">
				<option value="99" ${level == 99 ? 'selected' : ''}>전체회원</option>
				<option value="1" ${level == 1 ? 'selected' : ''}>우수회원</option>
				<option value="2" ${level == 2 ? 'selected' : ''}>정회원</option>
				<option value="3" ${level == 3 ? 'selected' : ''}>준회원</option>
				<option value="999" ${level == 999 ? 'selected' : ''}>탈퇴신청회원</option>
				<option value="0" ${level == 0 ? 'selected' : ''}>관리자</option>
			</select>
		</div>
		<div class="col text-end" id="pageSizeItem">
			<select name="pageSize" >
	            <option value="5" <c:if test="${pageSize == 5}">selected</c:if>>5개씩 보기</option>
	            <option value="10" <c:if test="${pageSize == 10}">selected</c:if>>10개씩 보기</option>
	            <option value="15" <c:if test="${pageSize == 15}">selected</c:if>>15개씩 보기</option>
	            <option value="20" <c:if test="${pageSize == 20}">selected</c:if>>20개씩 보기</option>
            </select>
		</div>
	</div>
	<table class="table table-hover text-center">
		<tr class="table-secondary">
			<th>번호</th>
			<th>아이디</th>
			<th>닉네임</th>
			<th>이름</th>
			<th>생일</th>
			<th>성별</th>
			<th>최종방문일</th>
			<th>회원등급</th>
		</tr>
		<c:forEach var="vo" items="${vos}" varStatus="st">
			<tr>
				<td>${vo.idx}</td>
				<td>${vo.mid}</td>
				<td>${vo.nickName}</td>
				<td>${vo.name}</td>
				<td>${fn:substring(vo.birthday, 0, 10)}</td>
				<td>${vo.gender}</td>
				<td>${fn:substring(vo.lastDate, 0, 16)}</td>
				<td>${vo.todayCnt}</td>
				<td>
					<c:if test="${vo.userDel == 'NO'}">활동중</c:if>
					<c:if test="${vo.userDel == 'OK'}">탈퇴신청중</c:if>
				</td>
				<td>
					<select name="level" id="level" onchange="levelChange(this)">
						<option value="1" ${vo.level == 1 ? 'selected' : ''}>우수회원</option>
						<option value="2" ${vo.level == 2 ? 'selected' : ''}>정회원</option>
						<option value="3" ${vo.level == 3 ? 'selected' : ''}>준회원</option>
						<option value="0" ${vo.level == 0 ? 'selected' : ''}>관리자</option>
						<option value="999" ${vo.level == 999 ? 'selected' : ''}>탈퇴신청회원</option>
					</select>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="container mt-4">
  	<ul class="pagination justify-content-center">
    	<c:if test="${curBlock > 0}"><li class="page-item"><a class="page-link" href="${ctp}/admin/member/adMemberList?pag=${(curBlock-1)*blockSize+1}&pageSize=${pageSize}&level=${level}">이전페이지</a></li></c:if>
  		<c:forEach var="i" begin="${(curBlock*blockSize)+1}" end="${(curBlock*blockSize)+blockSize}">
	        <c:if test="${i <= totPage}">
	            <li class="page-item ${i == pag ? 'active' : ''}">
	                <a class="page-link" href="${ctp}/admin/member/adMemberList?pag=${i}&pageSize=${pageSize}&level=${level}">
	                    ${i}
	                </a>
	            </li>
	        </c:if>
    	</c:forEach>
	    <c:if test="${curBlock < lastBlock}"><li class="page-item"><a class="page-link" href="${ctp}/admin/member/adMemberList?pag=${(curBlock+1)*blockSize+1}&pageSize=${pageSize}&level=${level}">다음페이지</a></li></c:if>
  	</ul>
	</div>
</div>
<p><br/></p>
</body>
</html>