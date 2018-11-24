<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
		   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>한남대학교 도서관리시스템</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>


<div class="container">
	<!-- loginHeader 영역 -->
	<div class="row">
		<div class="col-lg-12">
			<jsp:include page="/WEB-INF/views/main/headerMenu.jsp"/>
		</div>
	</div>
	
	<!-- header 영역 -->
	<div class="row">
		<div class="col-lg-12">
			<jsp:include page="/WEB-INF/views/main/header.jsp"/>
		</div>
	</div>
	
	<!-- menu 영역 -->
	<div class="row">
		<div class="col-lg-12">
			<c:if test="${role == 'member'}">
				<jsp:include page="/WEB-INF/views/main/memberMenu.jsp"/>
			</c:if>
			<c:if test="${role == 'librarian'}">
				<jsp:include page="/WEB-INF/views/main/librarianMenu.jsp"/>
			</c:if>
			<c:if test="${empty id}">
				<jsp:include page="/WEB-INF/views/main/defaultMenu.jsp"/>
			</c:if>
		</div>
	</div>
	<br/>
	<!-- main content 영역 -->
	<div class="row">
		<div class="col-lg-1"></div>
		<div class="col-lg-10">
			<c:choose>
				<c:when test="${empty content}">
					<jsp:include page="/WEB-INF/views/main/defaultContent.jsp"/>
				</c:when>
				<c:otherwise>
					<jsp:include page="${content}"/>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="col-lg-1"></div>
	</div>
	
	<br/>
	<hr>
	
	<!-- footer 영역 -->
	<div class="row">
		<div class="col-lg-12">
			<jsp:include page="/WEB-INF/views/main/footer.jsp"/>
		</div>
	</div>

</div>


</body>
</html>