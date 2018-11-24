<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 대출</title>
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
		myForm = document.insertBorrowForm;
		
		var memberNo = myForm.memberNo;
		
		if(memberNo.value.length < 7){
			alert("회원을 먼저 검색하십시오.");
			yes = false;
		}else{
			checking = document.querySelector('.checkingNull');

			if(checking != null){
			}else{
				alert("대여할 도서를 추가하십시오.");
				yes = false;
			}
		}
		
		return yes;	
	}
	
	
</script>
</head>
<body>


<div class="container">
<h4>도서 대출</h4>
<br/>
<%-- 회원을 검색하는 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/searchMemberForBorrow" 
      class="form-inline" 
      name="searchMemberForm" method="post">
	<div class="form-group">
		<label for="inputId"><strong>회원 ID</strong>&nbsp;&nbsp;&nbsp;&nbsp;</label>&nbsp;
		<input class="form-control" type="text" name="memberId" required="required">&nbsp;
		<input class="btn btn-default" type="submit" value="검색">
	</div>
</form>

<br/>

<%-- 도서를 검색하는 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/searchBookForBorrow"
      class="form-inline" 
      name="searchBookForm" method="post">
    
    <%-- 회원을 검색한 폼에서 받아온 정보를 hidden 으로 유지 --%>
    <input type="hidden" name="memberNo" value="${memberNo}" required="required">  
    <input type="hidden" name="memberId" value="${memberId}" required="required">  
    <input type="hidden" name="memberName" value="${memberName}" required="required">  
    <input type="hidden" name="dueDate" value="${dueDate}" required="required">  
    
    <%-- 도서를 검색한 폼에서 받아온 정보를 hidden 으로 유지 --%>
    <c:if test="${not empty bookInfos}">
    	<c:forEach var="bookInfo" items="${bookInfos}">
    		<input type="hidden" name="bookDetailNo" value="${bookInfo.bookDetailNo}">
    		<input type="hidden" name="title" value="${bookInfo.title}">
    		<input type="hidden" name="subTitle" value="${bookInfo.subTitle}">
    		<input type="hidden" name="volume" value="${bookInfo.volume}">
    		<input type="hidden" name="applicationMark" value="${bookInfo.applicationMark}">
    	</c:forEach>
    </c:if>
    <div class="form-group">
    	<label for="inputBookDetailNo"><strong>도서 번호</strong></label>&nbsp;
    	<input class="form-control" type="text" name="searchBookDetailNo" required="required">&nbsp;
		<input class="btn btn-default" type="submit" value="추가">
    </div>  
</form>

<br/>

<%-- 위의 두개 폼에서 종합된 정보를 토대로 도서 대출을 실행하기 위한 대출 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/insertBorrow"
      name="insertBorrowForm" method="post"
      onsubmit="return sumbitInsertForm();">
	<table class="table">
		<tr>
			<td class="text-right"><strong>회원 아이디</strong></td>
			<td>${memberId}<input type="hidden" name="memberNo" value="${memberNo}" required="required"></td>
			<td class="text-right"><strong>회원명</strong></td>
			<td>${memberName}</td>
			<td class="text-right"><strong>반납 예정일</strong></td>
			<td>${dueDate}<input type="hidden" name="dueDate" value="${dueDate}" required="required"></td>
		</tr>
		<tr class="text-center strong">
			<th><strong>번호</strong></th>
			<th><strong>도서명</strong></th>
			<th><strong>부제</strong></th>
			<th><strong>권</strong></th>
			<th><strong>청구기호</strong></th>
		</tr>
    <c:if test="${not empty bookInfos}">
    	<c:forEach var="bookInfo" varStatus="status" items="${bookInfos}">
    	<tr>
    		<td class="text-right">${status.index + 1}<input class="checkingNull" type="hidden" name="bookDetailNo" value="${bookInfo.bookDetailNo}"></td>
    		<td class="text-left">${bookInfo.title}</td>
    		<td class="text-left">${bookInfo.subTitle}</td>
    		<td class="text-center">${bookInfo.volume}</td>
    		<td class="text-left">${bookInfo.applicationMark}</td>
    	</tr>
    	</c:forEach>
    </c:if>
	</table>
    <div class="row">
    	<div class="col-md-1 offset-md-9">
    		<input class="btn btn-primary" type="submit" value="대출">
    	</div>
    </div>
</form>


</div>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>