<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 신청 글 조회</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>

<div class="container">

<table class="table">
	<thead class="text-center">
	<tr>
		<td colspan="2">도서요청</td>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td class="text-right">요청번호</td>
		<td>${resultSet.REQUESTBOOKNO}</td>
	</tr>
	<tr>
		<td class="text-right">작성일</td>
		<td>${resultSet.REGISTEREDDATE}</td>
	</tr>
	<tr>
		<td class="text-right">제목</td>
		<td>${resultSet.SUBJECT}</td>
	</tr>
	<tr>
		<td class="text-right">신청자</td>
		<td>${resultSet.ID}, ${resultSet.NAME}</td>
	</tr>
	<tr>
		<td class="text-right">상태</td>
		<td>${resultSet.STATUS}</td>
	</tr>
	<tr class="text-center">
		<td colspan="2">내용</td>
	</tr>
	<tr>
		<td colspan="2">
			${resultSet.CONTENT}
		</td>
	</tr>
	<tr class="text-right">
		<td colspan="2">
			<input class="btn btn-primary" type="button" value="목록" onclick="window.location='${pageContext.request.contextPath}/librarian/toRequestBookList'">
		</td>
	</tr>
	</tbody>
</table>
</div>

<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>