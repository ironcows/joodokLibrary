<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예산 조회</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>

<div class="container">
<h4>예산 조회</h4>
<br/>
<table class="table table-hover">
	<thead>
	<tr class="text-center thead-dark">
		<th><strong>예산번호</strong></th>
		<th><strong>예산구분</strong></th>
		<th><strong>년도</strong></th>
		<th><strong>분기</strong></th>
		<th><strong>할당예산</strong></th>
		<th><strong>잔액</strong></th>
		<th><strong>등록일</strong></th>
	</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${not empty budgetList}">
			<c:forEach var="budget" items="${budgetList}">
				<tr>
					<td class="text-center">${budget.budgetNo}</td>
					<td class="text-center">${budget.budgetClassification}</td>
					<td class="text-center">${budget.year}</td>
					<td class="text-center">${budget.quarter}</td>
					<td class="text-right">${budget.allocation} 원</td>
					<td class="text-right">${budget.remainder} 원</td>
					<td class="text-center">${budget.registeredDate}</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			등록된 예산이 없습니다.
		</c:otherwise>
	</c:choose>
	</tbody>
</table>
</div>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>