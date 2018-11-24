<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 메뉴</title>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>

<div class="container">
<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
	<ul class="navbar-nav">
	
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/member/toSearchBook">도서 검색</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/member/toMemberBorrow">대출 목록 조회</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/member/myReservation">예약 목록 조회</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/member/toRequestBook">도서 신청 목록</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/member/myInfo">내 정보 보기</a>
		</li>
	
	</ul>
</nav>
</div>

</body>
</html>