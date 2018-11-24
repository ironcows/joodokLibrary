<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>


<div class="container">
<form action="${pageContext.request.contextPath}/member/modifyRequest" method="post" name="modifyRequest">
<table class="table">
	<tr>
		<td class="text-right">제목</td>
		<td>
			<input type="hidden" name="requestBookNo" value="${resultSet.REQUESTBOOKNO}">
			${resultSet.SUBJECT}
		</td>
	</tr>
	<tr>
		<td class="text-right">요청도서 ISBN</td>
		<td>
			<input type="text" name="requestIsbn" size="50" maxlength="13"
				   value="${resultSet.REQUESTISBN}">
		</td>
	</tr>
	<tr>
		<td class="text-center"colspan="2">
			<textarea rows="13" cols="50" name="content">${resultSet.CONTENT}</textarea>
		</td>
	</tr>
	<tr class="text-center">
		<td colspan="2">
			<input class="btn btn-primary" type="submit" value="수정">
			<input class="btn btn-default" type="reset" value="취소" OnClick="javascript:history.back(-1)">
		</td>
	</tr>
</table>
</form>



</div>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>