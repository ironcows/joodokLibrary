<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
		   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수서 등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var serverMsg = '${message}';
		if (serverMsg.length != undefined && serverMsg.length > 0) {
			alert(serverMsg);
		}
	});
	
	
	function submitAddAcquisitionForm(){
		var yes = true;
		myForm = document.addAcquisitionForm;
		
		var addIsbn = myForm.addIsbn;
		
		if(addIsbn.value.length == 10 || addIsbn.value.length == 13){
			// addIsbn 에 입력된 값의 길이가 10, 13자리인 경우 아무 것도 안함.
		}else{
			// 입력된 값의 길이가 조건을 만족하지 않을 경우, 메시지 출력
			alert("10자리 또는 13자리 ISBN 을 입력하십시오.");
			yes = false;
		}
		
		return yes;	
	}
	
	function submitInsertAcquisitionForm() {
		var yes = true;

		checking = document.querySelector('.checkingNull');

		if(checking != null){
			yes = confirm("수서 등록하시겠습니까?");
		}else{
			alert("수서할 도서를 추가하십시오.");
			yes = false;
		}
		
		return yes;	
	}

</script>
</head>
<body>

<div class="container">
<h4>수서</h4>
<br/>
<%-- 수서를 목록에 추가하는 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/addAcquisition"
	  class="form-inline"
	  name="addAcquisitionForm" method="post"
	  onsubmit="return submitAddAcquisitionForm();">
	<div class="form-group">
		<label><strong>도서 ISBN</strong></label>&nbsp;	
		<input class="form-control" type="text" name="addIsbn" required="required"/>&nbsp;
		<label><strong>수서 구분</strong></label>&nbsp;	
		<select class="form-control" name="addCategory">
			<option>선정</option>
			<option>요청</option>
			<option>기증</option>
		</select>&nbsp;
		<input class="btn btn-default" type="submit" value="추가">
	</div>
	
	<%-- 이 폼에서 추가한 내용을 hidden 으로 유지 --%>
	<c:if test="${not empty acquisitionInfos}">
		<c:forEach var="acquisitionInfo" items="${acquisitionInfos}">
			<input type="hidden" name="acquisitionIsbn" value="${acquisitionInfo.acquisitionIsbn}">
			<input type="hidden" name="category" value="${acquisitionInfo.category}">
		</c:forEach>
	</c:if>
</form>

<br/><br/>

<%-- 위의 폼에서 추가된 정보를 토대로 수서를 실행하기 위한 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/acquisition"
	  name="insertAcquisitionForm" method="post"
	  onsubmit="return submitInsertAcquisitionForm();">

	<table class="table">
		<thead class="text-center">
		<tr>
			<td><strong>번호</strong></td>
			<td><strong>도서 ISBN</strong></td>
			<td><strong>수서 구분</strong></td>
		</tr>
		</thead>
		<c:if test="${not empty acquisitionInfos}">
			<c:forEach var="acquisitionInfo" items="${acquisitionInfos}" varStatus="status">
				<tr>
					<td class="text-right">${status.index +1}</td>
					<td class="text-center">
						${acquisitionInfo.acquisitionIsbn}
						<input class="checkingNull" type="hidden" name="acquisitionIsbn" value="${acquisitionInfo.acquisitionIsbn}">
					</td>
					<td class="text-center">
						${acquisitionInfo.category}
						<input type="hidden" name="category" value="${acquisitionInfo.category}">
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>

<div class="row">
	<div class="col-md-2 offset-md-10">
		<input class="btn btn-primary" type="submit" value="수서 등록">
	</div>
</div>
</form>

</div>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>