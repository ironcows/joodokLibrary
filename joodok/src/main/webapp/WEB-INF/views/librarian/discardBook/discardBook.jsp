<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	       uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 폐기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
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
			var yes = confirm("정말 폐기하시겠습니까?");
		}else{
			alert("폐기할 도서를 추가하십시오.");
			yes = false;
		}
		
		return yes;	
	}
	
</script>
</head>
<body>


<div class="container">
<h4>도서 폐기</h4>
<br/>
<%-- 폐기할 도서를 추가하는 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/addDiscardBook" 
	  class="form-inline"
	  name="addDiscardBook" method="post">
	<div class="form-group">
		<label for="inputBookDetailNo"><strong>폐기 도서</strong></label>&nbsp;
		<input class="form-control" type="text" name="discardingBookDetailNo" required="required">&nbsp;
		<input class="btn" type="submit" value="추가">
	</div>
	<c:if test="${not empty discardBookInfos}">
		<c:forEach var="discardBook" items="${discardBookInfos}">
			<input type="hidden" name="bookDetailNo" value="${discardBook.bookDetailNo}">
			<input type="hidden" name="title" value="${discardBook.title}">
			<input type="hidden" name="subTitle" value="${discardBook.subTitle}">
			<input type="hidden" name="volume" value="${discardBook.volume}">
			<input type="hidden" name="applicationMark" value="${discardBook.applicationMark}">			
		</c:forEach>
	</c:if>
</form>
<br/>

<%-- 위 폼에서 추가된 도서 정보를 토대로 폐기를 실행하기 위한 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/discardBook" 
	  name="discardBook" method="post"
	  onsubmit="return sumbitInsertForm();">
<table class="table">
	<thead class="text-center">
	<tr>
		<td><strong>번호</strong></td>
		<td><strong>도서 등록번호</strong></td>
		<td><strong>도서명</strong></td>
		<td><strong>부제</strong></td>
		<td><strong>권</strong></td>
		<td><strong>청구기호</strong></td>
		<td><strong>폐기 사유</strong></td>
	</tr>
	</thead>
	<c:if test="${not empty discardBookInfos}">
		<c:forEach var="discardBook" items="${discardBookInfos}" varStatus="status">
			<tr>
				<td class="text-right">${status.index +1}</td>
				<td class="text-center">${discardBook.bookDetailNo}</td>
				<td>${discardBook.title}</td>
				<td>${discardBook.subTitle}</td>
				<td class="text-center">${discardBook.volume}</td>
				<td>${discardBook.applicationMark}</td>
				<td><input class="form-control" type="text" name="discardReason" placeholder="ex)훼손"
						   required="required"></td>
				<td>
					<input class="checkingNull" type="hidden" name="bookDetailNo" value="${discardBook.bookDetailNo}">
				</td>
			</tr>		
		</c:forEach>
	</c:if>
</table>
<div class="row">
	<div class="col-md-1 offset-md-10">
		<input class="btn btn-danger" type="submit" value="폐기">
	</div>
</div>	
</form>

</div>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>