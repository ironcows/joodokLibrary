<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
		   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 반납</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var serverMsg = '${message}';
		if (serverMsg.length != undefined && serverMsg.length > 0) {
			alert(serverMsg);
		}
	});

	function sumbitInsertForm() {
		var yes = true;
		
		checking = document.querySelector('.checkingNull');
		if(checking != null){
		}else{
			alert("반납할 도서를 추가하십시오.");
			yes = false;
		}
		
		return yes;	
	}
	
</script>
</head>
<body>


<div class="container">
<h4>도서 반납</h4>
<br/>
<%-- 반납할 도서를 추가하는 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/addReturnBook"
	  class="form-inline" 
	  name="addReturningBook" method="post">
	    <div class="form-group">
	  		<label><strong>반납 도서</strong></label>&nbsp;
	  	    <input class="form-control" type="text" name="returningBookDetailNo" required="required">&nbsp; 
		 	<input class="btn btn-default" type="submit" value="추가">
	    </div>
		<%-- 추가한 대출 정보(도서, 회원)를 hidden 유지한다. --%>
		<c:if test="${not empty borrowInfos}">
			<c:forEach var="borrowInfo" items="${borrowInfos}">
				<input type="hidden" name="borrowNo" value="${borrowInfo.borrowNo}">
				<input type="hidden" name="bookDetailNo" value="${borrowInfo.bookDetailNo}">
				<input type="hidden" name="title" value="${borrowInfo.title}">
				<input type="hidden" name="subTitle" value="${borrowInfo.subTitle}">
				<input type="hidden" name="volume" value="${borrowInfo.volume}">
				<input type="hidden" name="applicationMark" value="${borrowInfo.applicationMark}">
				<input type="hidden" name="borrowDay" value="${borrowInfo.borrowDay}">
				<input type="hidden" name="memberNo" value="${borrowInfo.memberNo}">
				<input type="hidden" name="memberId" value="${borrowInfo.memberId}">
				<input type="hidden" name="memberName" value="${borrowInfo.memberName}">
			</c:forEach>
		</c:if>
</form>

<br/><br/>

<%-- 위 폼에서 추가된 도서와 회원 정보를 토대로 도서 반납을 실행하기 위한 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/returnBook" 
	  name="returnBook" method="post"
	  onsubmit="return sumbitInsertForm();">
	<table class="table">
		<thead class="text-center">
		<tr>
			<td><strong>번호</strong></td>
			<td><strong>도서명</strong></td>
			<td><strong>부제</strong></td>
			<td><strong>권</strong></td>
			<td><strong>청구기호</strong></td>
			<td><strong>대여일</strong></td>
			<td><strong>회원 아이디</strong></td>
			<td><strong>이름</strong></td>
		</tr>
		</thead>
	<c:if test="${not empty borrowInfos}">
		<c:forEach var="borrowInfo" items="${borrowInfos}" varStatus="status">
			<tr>
				<td class="text-right">${status.index + 1}</td>
				<td class="text-left">${borrowInfo.title}</td>
				<td class="text-left">${borrowInfo.subTitle}</td>
				<td class="text-center">${borrowInfo.volume}</td>
				<td class="text-left">${borrowInfo.applicationMark}</td>
				<td class="text-center">${borrowInfo.borrowDay}</td>
				<td class="text-center">${borrowInfo.memberId}</td>
				<td class="text-center">${borrowInfo.memberName}</td>
				<td>
					<input type="hidden" name="bookDetailNo" value="${borrowInfo.bookDetailNo}">
					<input class="checkingNull" type="hidden" name="borrowNo" value="${borrowInfo.borrowNo}">
				</td>
			</tr>		
		</c:forEach>
	</c:if>
	</table>
    <div class="row">
    	<div class="col-md-1 offset-md-10">
			<input class="btn btn-primary" type="submit" value="반납">
		</div>	
	</div>		
</form>


</div>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>