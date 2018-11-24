<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 신청 글</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>

<div class="container">
	<div class="row">
		<label class="col-md-2 offset-2"><strong>요청번호</strong></label>
		<label class="col-md-6">${resultSet.REQUESTBOOKNO}</label>
	</div>
	<div class="row">
		<label class="col-md-2 offset-2"><strong>작성일</strong></label>
		<label class="col-md-6">${resultSet.REGISTEREDDATE}</label>
	</div>
	<div class="row">
		<label class="col-md-2 offset-2"><strong>제목</strong></label>
		<label class="col-md-6">${resultSet.SUBJECT}</label>
	</div>
	<div class="row">
		<label class="col-md-2 offset-2"><strong>상태</strong></label>
		<label class="col-md-6">${resultSet.STATUS}</label>
	</div>
	<div class="row">
		<label class="col-md-8 offset-2">${resultSet.CONTENT}</label>
	</div>
	<div class="row">
		<div class="col-md-4 offset-4">
			<input class="btn btn-default" type="button" value="목록" onclick="window.location='${pageContext.request.contextPath}/member/toRequestBook'">&nbsp;&nbsp;
			<input class="btn btn-primary" type="button" value="수정" onclick="window.location='${pageContext.request.contextPath}/member/toModifyRequest?requestBookNo=${resultSet.REQUESTBOOKNO}'">
		</div>
	</div>
</div>

<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>