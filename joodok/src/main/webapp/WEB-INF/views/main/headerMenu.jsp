<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>headerMenu 영역</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>

<div class="row">
	<div class="col-lg-8">
	</div>
	<div class="col-lg-1">
		<c:if test="${not empty id}">
			<small>${name} 님</small>
		</c:if>
	</div>
	<div class="col-lg-1">
		<c:choose>
		<%-- 로그인한 경우 --%>
			<c:when test="${not empty id}">
				<a href="${pageContext.request.contextPath}/login/logout">
					<input class="btn btn-outline-secondary btn-sm" type="button" value="로그아웃">
				</a>
			</c:when>
			
			<%-- 로그인하지 않은 경우 --%>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/login/toLogin">
					<input class="btn btn-outline-secondary btn-sm" type="button" value="로그인">
				</a>	
			</c:otherwise>
		</c:choose>
	</div>
	<div class="col-lg-1">
		<a href="http://www.hannam.ac.kr/main/"><small>대표 Home</small></a>
	</div>
	<div class="col-lg-1">
		<a href="https://portal.hannam.ac.kr/wps/index.jsp"><small>하이포탈</small></a>
	</div>
</div>

<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>