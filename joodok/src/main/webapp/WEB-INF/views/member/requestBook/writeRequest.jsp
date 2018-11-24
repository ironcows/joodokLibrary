<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 신청하기</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>

<div class="container">
<form action="${pageContext.request.contextPath}/member/saveRequestBook" 
	  method="post" name="writeRequest">
	  
	<div class="row">
		<label class="col-md-2"><strong>제목</strong></label>
		<input class="col-md-6 form-control" type="text" name="subject" size="50" maxlength="200" required="required">
	</div>
	<div class="row">
		<label class="col-md-2"><strong>요청도서 ISBN</strong></label>
		<input class="col-md-6 form-control" type="text" name="requestIsbn" size="50" maxlength="13">
	</div>
	<div class="row">
		<label class="col-md-2"><strong>내용</strong></label>
		<textarea class="col-md-6 form-control" rows="13" cols="50" name="content"></textarea>
	</div>
	<div class="row">
		<div class="col-md-4 offset-4">
			<input class="btn btn-primary" type="submit" value="신청">
			<input class="btn btn-default" type="reset" value="취소" OnClick="javascript:history.back(-1)">
		</div>
	</div>

</form>
</div>

<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>