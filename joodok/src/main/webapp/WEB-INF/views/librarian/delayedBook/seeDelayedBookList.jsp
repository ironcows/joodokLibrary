<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>연체 도서 목록 조회</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>

<div class="container">
<h4>연체 내역 조회</h4>
<br/>
<table class="table table-hover">
	<thead class="text-center thead-dark">
	<tr>
		<th><strong>번호</strong></th>
		<th><strong>대출번호</strong></th>
		<th><strong>서명</strong></th>
		<th><strong>부제</strong></th>
		<th><strong>회원ID</strong></th>
		<th><strong>회원명</strong></th>
		<th><strong>대여일</strong></th>
		<th><strong>반납예정일</strong></th>
		<th><strong>연체일수</strong></th>
	</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${not empty delayedBookList}">
			<c:forEach var="delayedBook" items="${delayedBookList}" varStatus="status">
				<tr>
					<td class="text-right">${status.index + 1}</td>	
					<td class="text-center"><small>${delayedBook.BORROWNO}</small></td>
					<td class="text-left"><small>${delayedBook.TITLE}</small></td>
					<td class="text-left"><small>${delayedBook.SUBTITLE}</small></td>
					<td class="text-center"><small>${delayedBook.ID}</small></td>
					<td class="text-center"><small>${delayedBook.NAME}</small></td>
					<td class="text-center"><small>${delayedBook.REGISTEREDDATE}</small></td>
					<td class="text-center"><small>${delayedBook.DUEDATE}</small></td>
					<td class="text-center">${delayedBook.DELAYDAY}</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="9">연체중인 도서가 없습니다.</td>
			</tr>
		</c:otherwise>
	</c:choose>
	</tbody>
</table>
</div>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>