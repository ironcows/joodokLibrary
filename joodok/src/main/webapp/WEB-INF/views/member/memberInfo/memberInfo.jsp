<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원의 개인 정보</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">

</head>
<body>

<div class="container">
<h4>내 정보 보기</h4>
<br/>
<div class="row">
	<label class="col-md-2"><strong>아이디</strong></label>
	<p class="form-control-static">${myInfo.ID}</p>
</div>
<div class="row">
	<label class="col-md-2"><strong>이름</strong></label>
	<p class="form-control-static">${myInfo.NAME}</p>
</div>
<div class="row">
	<label class="col-md-2"><strong>신분</strong></label>
	<p class="form-control-static">${myInfo.POSITION}</p>
</div>
<div class="row">
	<label class="col-md-2"><strong>대여가능일수</strong></label>
	<p class="form-control-static">${myInfo.POSSIBLEBORROWDAY}</p>
</div>
<div class="row">
	<label class="col-md-2"><strong>연락처</strong></label>
	<p class="form-control-static">${myInfo.CONTACTNUMBER}</p>
</div>
<div class="row">
	<label class="col-md-2"><strong>이메일</strong></label>
	<p class="form-control-static">${myInfo.EMAIL}</p>
</div>
</div>

<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>