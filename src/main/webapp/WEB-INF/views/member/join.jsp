<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <jsp:include page="/WEB-INF/views/include/bs5.jsp" />
  <title>userInput.jsp</title>
  
  <style>
	form {
	    display: flex;
	    flex-direction: column;
	    gap:5px;
	}
	
	.container {
	    max-width: 600px;
	    margin: 30px auto;
	    padding: 20px;
	    background-color: #fff !important;
	    border-radius: 10px;
	}

	label, span {
		display: inline-block;
		width: 80px;
	    margin-bottom: 5px;
	    font-weight: bold;
	    color: #555;
	}
	
	#address3 {
		margin: 0 10px 0 90px;
	}

	.form-control input[type="text"],
	.form-control input[type="password"],
	.form-control input[type="email"],
	.form-control input[type="tel"],
	.form-control input[type="number"],
	.form-control input[type="date"],
	.form-control select {
	    padding: 5px;
	    border-radius: 5px;
	    border: 1px solid #ccc;
	    font-size: 14px;
	}
	.form-control input[type="tel"] {
		width: 100px;
	}

	.form-control input[type="checkbox"],
	.form-control input[type="radio"] {
	    margin-right: 1px;
	}
  </style>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp" />
<jsp:include page="/WEB-INF/views/include/slide2.jsp" />
<p><br/></p>
<div class="container">
  <h2 class="text-center m-3">회 원 가 입</h2>
  <form name="myform" method="get" action="${ctp}/member/join">
 	<div class="form-control">
 		<label for="mid">아이디</label>
 		<input type="text" id="mid" name="mid" placeholder="아이디를 입력하세요" required autofocus />
 		<input class="btn btn-warning" type="button" id="midCheck" name="midCheck" value="아이디 중복 체크" />
 	</div>
 	<div class="form-control">
 		<label for="pwd">비밀번호</label>
 		<input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력하세요" required />
 	</div>
 	<div class="form-control">
 		<label for="nickName">닉네임</label>
 		<input type="text" id="nickName" name="nickName" placeholder="닉네임을 입력하세요" required />
 		<input class="btn btn-warning" type="button" id="nickNameCheck" name="nickNameCheck" value="닉네임 중복 체크" />
 	</div>
 	<div class="form-control">
 		<label for="name">성명</label>
 		<input type="text" id="name" name="name" placeholder="성명을 입력하세요" required />
 	</div>
 	<div class="form-control">
 		<label for="gender">성별</label>
 		<input type="radio" value="남자" id="man" name="gender" />남자
 		<input type="radio" value="여자" id="male" name="gender" />여자
 	</div>
 	<div class="form-control">
 		<label for="birthDay">생일</label>
 		<input type="date" id="birthDay" name="birthDay" />
 	</div>
 	<div class="form-control">
	 	<span>전화번호</span>
	 	<select id="tel1" name="tel1">
	 		<option value="none" selected>선택</option>
	 		<option value="num">010</option>
	 	</select> -
	 	<input type="tel" id="tel2" name="tel2" /> -
	 	<input type="tel" id="tel3" name="tel3" /> 
 	</div>
 	<div class="form-control">
 		<label for="address">주소</label>
 		<input class="m-2" type="number" id="address1" name="address" placeholder="우편주소" />
 		<input type="text" id="address2" name="address" placeholder="주소" /><br/>
 		<input class="" type="text" id="address3" name="address" placeholder="상세주소" />
 		<input class="btn btn-info" type="button" id="addressBtn" name="addressBtn" value="주소검색" />
 	</div>
 	<div class="form-control">
 		<label for="email">이메일</label>
 		<input type="email" id="email" name="email" placeholder="이메일을 입력하세요" required />
 	</div>
 	<div class="form-control">
 		<label for="homePage">홈페이지</label>
 		<input type="text" id="homePage" name="homePage" placeholder="홈페이지를 입력하세요" />
 	</div>
 	<div class="form-control">
 		<label for="job">직업</label>
 		<select id="job" name="job">
 			<option>선택</option>
 			<option>학생</option>
 			<option>공무원</option>
 			<option>자영업</option>
 			<option>회사원</option>
 			<option>상담사</option>
 			<option>회계사</option>
 		</select>
 	</div>
 	<div class="form-control">
 		<label >취미</label>
 		<input type="checkbox" name="hobby" value="스포츠" /> 스포츠
 		<input type="checkbox" name="hobby" value="독서" /> 독서
 		<input type="checkbox" name="hobby" value="낚시" /> 낚시
 		<input type="checkbox" name="hobby" value="등산" /> 등산
 		<input type="checkbox" name="hobby" value="음악" /> 음악
 		<input type="checkbox" name="hobby" value="그림" /> 그림
 	</div>
 	<div class="form-control">
 		<label>프로필 사진</label>
 		<input type="file" id="photo" name="photo" />
 	</div>
 	<div class="form-control">
 		<label for="content">자기소개</label>
 		<input type="text" id="content" name="content" />
 	</div>
 	<div class="form-control">
		<div class="mb-2">회원정보 공개 여부</div>
	   	<div class="radio-group">
	        <input type="radio" id="infoOpen" name="info" />
	        <label for="infoOpen">공개</label>
	
	        <input type="radio" id="infoNo" name="info" />
	        <label for="infoNo">비공개</label>
	    </div>
 	</div>
 	<div class="text-center">
	 	<input class="btn btn-success me-5 mt-2" type="button" value="회원가입" />
	 	<input class="btn btn-warning mt-2" type="button" value="다시작성" onclick="location.reload()" />
 	</div>
  </form>
</div>
<p><br/></p>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>