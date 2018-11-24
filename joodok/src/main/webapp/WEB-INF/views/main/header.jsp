<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header 영역</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>

<div class="container">
	<div class="row">
		<div class="col-12">
		<a href="${pageContext.request.contextPath}/index">
			<img alt="Responsive image" class="img-fluid"
			 src="/resources/img/homeHeader.PNG">
		</a>
		</div>	
	</div>
</div>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>