<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사서 메뉴</title>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>

<div class="container">
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<ul class="navbar-nav">
		<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#"
			   id="navbardrop" data-toggle="dropdown">
				대출/반납
			</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${pageContext.request.contextPath}/librarian/toBorrow">대출</a>			
				<a class="dropdown-item" href="${pageContext.request.contextPath}/librarian/toReturnBook">반납</a>		
			</div>
		</li>
		
		<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#"
			   id="navbardrop" data-toggle="dropdown">
				도서 등록/폐기
			</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${pageContext.request.contextPath}/librarian/toRegisterMetaBook">도서 공통정보 등록</a>
				<a class="dropdown-item" href="${pageContext.request.contextPath}/librarian/toRegisterBookDetail">도서 상세정보 등록</a>
				<a class="dropdown-item" href="${pageContext.request.contextPath}/librarian/toDiscardBook">폐기</a>
			</div>
		</li>
		
		<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#"
			   id="navbardrop" data-toggle="dropdown">
				수서/검수
			</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${pageContext.request.contextPath}/librarian/toAcquisition">수서</a>
				<a class="dropdown-item" href="${pageContext.request.contextPath}/librarian/toCheckUp">검수</a>
			</div>
		</li>
		
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/librarian/toOrder">도서 주문</a>
		</li>
		
		<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#"
			   id="navbardrop" data-toggle="dropdown">
				조회 업무
			</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="${pageContext.request.contextPath}/librarian/toRequestBookList">도서 요청 조회</a>
				<a class="dropdown-item" href="${pageContext.request.contextPath}/librarian/toDelayedBookList">연체 내역 조회</a>
				<a class="dropdown-item" href="${pageContext.request.contextPath}/librarian/toBudget">예산 조회</a>
				<a class="dropdown-item" href="${pageContext.request.contextPath}/librarian/toTradeEnterprise">거래처 조회</a>
			</div>
		</li>
		
		
	</ul>
</nav>
</div>


</body>
</html>