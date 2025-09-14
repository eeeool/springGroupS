<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<title>adminLeft.jsp</title>
	
	<script>
	'use strict';
	
	document.addEventListener("DOMContentLoaded", function() {
	  const acc = document.getElementsByClassName("accordion");

	  for (let i = 0; i < acc.length; i++) {
	    acc[i].addEventListener("click", function() {
	      const panel = this.nextElementSibling;
	      const isOpen = panel.style.maxHeight && panel.style.maxHeight != "0px";

	      // 패널 닫기
	      Array.from(document.getElementsByClassName("panel")).forEach(p => {
	          if (p !== panel) {
	            p.style.maxHeight = null;
	            p.previousElementSibling.classList.remove("active");
	          }
	      });

	      if (isOpen) {
	        panel.style.maxHeight = null;
	        this.classList.remove("active");
	      } else {
	        panel.style.maxHeight = panel.scrollHeight + "px";
	        this.classList.add("active");
	      }
        });
	  }
	});
	</script>
		
	<style>
		.accordion {
			 background-color: #eee;
			 color: #444;
			 padding: 10px;
			 cursor: pointer;
			 width: 100%;
			 text-align: left;
			 border: none;
			 outline: none;
			 transition: 0.4s;
		}
		
		.active, .accordion:hover {
		 	background-color: #ccc;
		}
		
		.panel {
			 background-color: white;
			 max-height: 0;
			 overflow: hidden;
			 transition: max-height 0.2s ease;
			 padding: 0 10px;
		 }
		 
		 a {
	 	 	text-decoration: none;
		 }
	</style>
</head>
<body>
<p><br/></p>
<div class="container">
	<h5 class="accordion"><a href="${ctp}/admin/adminMain" target="_top">관리자메뉴</a></h5>
	<p class="accordion"><a href="${ctp}/" target="_top">홈으로</a></p>
	<div>
		<div class="accordion"><b>게시글 관리</b></div>
		<div class="panel">
			<p><a href="${ctp}/admin/guest/adGuestList" target="adminContent">방명록 리스트</a></p>
			<p><a href="">게시판 리스트</a></p>
			<p><a href="">자료실 리스트</a></p>
		</div>
	</div>
	<div>
		<div class="accordion"><b>회원 관리</b></div>
		<div class="panel">
			<p><a href="${ctp}/admin/member/adMemberList" target="adminContent">회원 리스트</a></p>
			<p><a href="">신고 리스트</a></p>
		</div>
	</div>
	<div>
		<div class="accordion"><b>일정 관리</b></div>
		<div class="panel">
			<p><a href="${ctp}/admin/guest/adGuestList">일정 리스트</a></p>
			<p><a href="">일정 게시</a></p>
		</div>
	</div>
	<div>
		<div class="accordion"><b>설문조사 등록</b></div>
		<div class="panel">
			<p><a href="${ctp}/admin/guest/adGuestList">설문조사 등록</a></p>
			<p><a href="">설문조사 리스트</a></p>
			<p><a href="">설문조사 분석</a></p>
		</div>
	</div>
	<div>
		<div class="accordion"><b>상품관리</b></div>
		<div class="panel">
			<p><a href="${ctp}/admin/guest/adGuestList">상품분류 등록</a></p>
			<p><a href="">상품등록 관리</a></p>
			<p><a href="">상품등록 조회</a></p>
			<p><a href="">옵션등록 관리</a></p>
			<p><a href="">주문 관리</a></p>
			<p><a href="">반품 관리</a></p>
			<p><a href="">1:1 문의</a></p>
			<p><a href="">상품 메인이미지 관리</a></p>
		</div>
	</div>
	<div>
		<div class="accordion"><b>기타관리</b></div>
		<div class="panel">
			<p><a href="${ctp}/admin/guest/adGuestList">공지사항 관리</a></p>
			<p><a href="">FAQ 관리</a></p>
			<p><a href="">QnA 관리</a></p>
			<p><a href="">쿠폰 관리</a></p>
			<p><a href="">임시파일 관리</a></p>
			<p><a href="">실시간 상담</a></p>
		</div>
	</div>
</div>
<p><br/></p>
</body>
</html>