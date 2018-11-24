<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>검수 등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var serverMsg = '${message}';
		if (serverMsg.length != undefined && serverMsg.length > 0) {
			alert(serverMsg);
		}
	});

	function numkeyCheck(e) { 
		var keyValue = event.keyCode; 
		if( ((keyValue >= 48) && (keyValue <= 57)) ) {
			return true; 			
		}else {
			return false; 			
		}
	}
	
	function sumbitInsertForm() {
		var yes = true;
		
		checking = document.querySelector('.checkingNull');
		
		if(checking != null){
			yes = confirm("검수하시겠습니까?");
		}else{
			alert("검수 내역이 없습니다.");
			yes = false;
		}
		return yes;	
	}
	
</script>
</head>
<body>

<div class="container">
<h4>검수</h4>
<br/>
<%-- 검수하려는 대상을 선택하는 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/addCheckUpList"
	  name="addCheckUpListForm" method="post">
<table class="table">
	<thead class="text-center">
	<tr>
		<td></td>
		<td><strong>번호</strong></td>
		<td><strong>수량</strong></td>
		<td><strong>수서번호</strong></td>
		<td><strong>수서구분</strong></td>
		<td><strong>도서ISBN</strong></td>
		<td><strong>등록일</strong></td>
	</tr>
	</thead>
	<c:choose>
		<c:when test="${not empty unCheckUpList}">
			<c:forEach var="unCheckUpOne" items="${unCheckUpList}" varStatus="status">
				<tr>
					<td><input type="checkbox" name="checkedAcquisitionNo" value="${unCheckUpOne.acquisitionNo}"></td>
					<td class="text-right">${status.index + 1}</td>
					<td><input class="text-right form-control" type="text" name="checkedCount" value="1" onKeyPress="return numkeyCheck(event)"></td>
					<td class="text-center">${unCheckUpOne.acquisitionNo}<input type="hidden" name="acquisitionNo" value="${unCheckUpOne.acquisitionNo}"></td>
					<td class="text-center">${unCheckUpOne.category}<input type="hidden" name="category" value="${unCheckUpOne.category}"></td>
					<td class="text-center">${unCheckUpOne.acquisitionIsbn}<input type="hidden" name="acquisitionIsbn" value="${unCheckUpOne.acquisitionIsbn}"></td>
					<td class="text-center">${unCheckUpOne.registeredDate}<input type="hidden" name="registeredDate" value="${unCheckUpOne.registeredDate}"></td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="6">검수 할 도서가 없습니다.</td>
			</tr>
		</c:otherwise>
	</c:choose>
	
	<%-- 이미 선택된 목록을 hidden 으로 유지한다. --%>
	<c:if test="${not empty checkUpList}">
		<c:forEach var="checkUpOne" items="${checkUpList}" varStatus="status">
			<tr class="table-borderless">
				<td><input type="hidden" name="chAcquisitionNo" value="${checkUpOne.acquisitionNo}"></td>
				<td><input type="hidden" name="chCategory" value="${checkUpOne.category}"></td>
				<td><input type="hidden" name="chAcquisitionIsbn" value="${checkUpOne.acquisitionIsbn}"></td>
				<td><input type="hidden" name="chRegisteredDate" value="${checkUpOne.registeredDate}"></td>
			</tr>		
		</c:forEach>
	</c:if>
</table>
<input class="btn btn-default" type="submit" value="추가">
</form>

<br/><br/>

<form action="${pageContext.request.contextPath}/librarian/checkUp"
	  name="checkUpForm" method="post"
	  onsubmit="return sumbitInsertForm();">
<table class="table">
	<thead class="text-center">
	<tr>
		<td><strong>번호</strong></td>
		<td><strong>수서번호</strong></td>
		<td><strong>수서구분</strong></td>
		<td><strong>도서ISBN</strong></td>
		<td><strong>검수 결과</strong></td>
		<td><strong>비고</strong></td>
	</tr>
	</thead>
	<c:choose>
		<c:when test="${not empty checkUpList}">
			<c:forEach var="checkUpOne" items="${checkUpList}" varStatus="status">
				<c:set var="tempNo" value="${checkUpList[status.index+1].acquisitionNo}"/>
				<tr>
					<td class="text-right">${status.index + 1}</td>
					<td class="text-center">${checkUpOne.acquisitionNo}<input class="checkingNull" type="hidden" name="acquisitionNo" value="${checkUpOne.acquisitionNo}"></td>
					<td class="text-center">${checkUpOne.category}</td>
					<td class="text-center">${checkUpOne.acquisitionIsbn}<input type="hidden" name="checkUpIsbn" value="${checkUpOne.acquisitionIsbn}"></td>
					<td>
						<select class="form-control" name="checkUpResult">
							<option value="합격">합격</option>
							<option value="불합격">불합격</option>
						</select>
					</td>
					<td><input class="form-control" type="text" name="memo" value=" "></td>
				</tr>
				<c:if test="${checkUpOne.acquisitionNo != tempNo}">
					<tr>
						<td colspan="6"><hr noshade="noshade"/></td>
					</tr>
				</c:if>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="6">검수 할 내역을 추가하십시오.</td>
			</tr>
		</c:otherwise>
	</c:choose>
</table>

<div class="row">
	<div class="col-md-1 offset-md-11">
		<input class="btn btn-primary" type="submit" value="검수">
	</div>
</div>
</form>


</div>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>