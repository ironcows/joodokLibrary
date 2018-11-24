<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
	 	   uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 개인의 대출 조회</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>

<div class="container">
<h4>대출 목록 조회</h4>
<br/>
<table class="table">
	<thead class="thead-dark">
	<tr>
		<th><strong>번호</strong></th>
		<th><strong>서명</strong></th>
		<th><strong>부제</strong></th>
		<th><strong>청구번호</strong></th>
		<th><strong>대여일</strong></th>
		<th><strong>반납예정일</strong></th>
		<th><strong>상태</strong></th>
	</tr>
	</thead>
	<c:if test="${empty borrowList}">
		<tr>
			<td colspan="6">
				현재 대출 내역이 없습니다.			
			</td>
		</tr>
	</c:if>
	<c:forEach var="borrow" items="${borrowList}" varStatus="status">
		<tr>
			<td class="text-left">${status.index + 1}</td>
			<td class="text-left">${borrow.TITLE}</td>
			<td class="text-left">${borrow.SUBTITLE}</td>
			<td class="text-left">${borrow.APPLICATIONMARK}</td>
			<td class="text-center">${borrow.REGISTEREDDATE}</td>
			<td class="text-center">${borrow.DUEDATE}</td>
			<td class="text-center">${borrow.STATUS}</td>
		</tr>
	</c:forEach>
</table>
</div>

<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>