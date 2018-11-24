<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>


<form action="${pageContext.request.contextPath}/login/loginProcess" name="loginForm" method="post">
	<table align="center" style="width: 50%;">
		<tr>
			<td colspan="4" class="inputs">
				<input id="memberLogin" type="radio" name="role" value="member" checked="checked">
				<label for="memberLogin">회원</label>
				<input id="librarianLogin" type="radio" name="role" value="librarian">
				<label for="librarianLogin">사서</label>
			</td>
		</tr>
		<tr>
			<td colspan="2">ID</td>
			<td colspan="2">
				<input class="form-control form-control-sm" type="text" name="id" required="required" size=10>
			</td>
		</tr>
		<tr>
			<td colspan="2">Password</td>
			<td colspan="2">
				<input class="form-control form-control-sm" type="password" name="pw" required="required" size=10>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input class="btn btn-primary btn-sm" type="submit" value="로그인">
			</td>
		</tr>
	</table>
</form>



<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>