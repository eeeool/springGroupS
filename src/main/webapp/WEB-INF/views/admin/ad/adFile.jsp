<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="/WEB-INF/views/include/bs5.jsp" />
	<title>adFile.jsp</title>
	
	<script>
	'use strict';
	
	$(() => {
		// 전체 선택/해제
		$('#allCheck').on('change', function() {
			$('.fileCheck').prop('checked', $(this).prop('checked'));
		});
		
		// 카테고리 보기
		$('#categorySelect').on('change', function() {
			const category = $(this).val();
			
			$.ajax({
				url: '${ctp}/admin/ad/adFile',
				type: 'post',
				data: {category: category},
				success: (res) => {
					let str = '';
					res.forEach((vo) => {
						 let fileDisplay = vo.fileName || '없음';
						 
						 str += '<tr>'
	                        + '<td><input type="checkbox" class="fileCheck" value="' + vo.fileIdx + '"></td>'
	                        + '<td>' + vo.fileIdx + '</td>'
	                        + '<td>' + vo.uploaderMid + '</td>'
	                        + '<td>' + vo.fileTitle + '</td>'
	                        + '<td>' + vo.fileName + '</td>'
	                        + '<td>' + vo.uploadDate + '</td>'
	                        + '</tr>';
					});
					$('#fileTableBody').html(str);
				},
				error: () => alert('전송 오류')
			});
		});
		$('#categorySelect').trigger('change');
	})
	
	// 선택 삭제
	$('#selectDeleteBtn').on('click', function() {
	  const selected = $('.fileCheck:checked');
	    if (selected.length === 0) {
	      alert('삭제할 파일을 선택하세요.');
	      return;
	    }
		    
		let ans = confirm("선택한 파일을 삭제하시겠습니까?");
	   	if (!ans) return false;
		
		const fileArr = [];
		selected.each(function() {
			fileArr.push($(this).val());
		}); 	
	   	
	   	$.ajax({
	   		url: '${ctp}/admin/ad/fileDelete',
	   		type: 'post',
	   		data: {fileArr: fileArr},
	   		success: (res) => {
	   			if (res != 0) {
	   				alert('파일이 삭제되었습니다.');
	   				location.reload();
	   			}
	   			else {
	   				alert('파일삭제 실패');
	   			}
	   		},
	   		error: () => alert('전송 오류')
	   	});
	})
	</script>
</head>
<body>
<p><br/></p>
<div class="container">
	<h2>파일 관리</h2>
	<select class="me-3" id="categorySelect">
		<option selected>Guest</option>
		<option>Board</option>
		<option>Pds</option>
	</select>
	
	<input id="allCheck" name="allCheck" type="checkBox" />
	<label for="allCheck">전체 선택/해제</label>
	<button class="btn btn-danger btn-sm" id="selectDeleteBtn">삭제</button>
		
	<table class="table table-bordered text-center mt-3">
		<thead>
			<tr>
				<th class="col-1">선택</th>
				<th class="col-1">번호</th>
				<th class="col-2">아이디</th>
				<th class="col-4">제목</th>
				<th class="col-2">파일명</th>
				<th class="col-2">업로드 날짜</th>
			</tr>
		</thead>
		<tbody id="fileTableBody"></tbody>
	</table>
</div>
<p><br/></p>
</body>
</html>