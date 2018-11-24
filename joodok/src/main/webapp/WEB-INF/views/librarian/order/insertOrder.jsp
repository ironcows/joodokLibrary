<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
		   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 주문</title>
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
		}else 
			return false; 
		}


	
	function sumbitInsertForm() {
		var yes = true;
		
		checking = document.querySelector('.checkingNull');
		
		
		if(checking != null){
			yes = confirm("주문하시겠습니까?");
		}else{
			alert("주문 내역이 없습니다.");
			yes = false;
		}
		return yes;	
	}
	
</script>
</head>
<body>

<div class="container">
<h4>도서 주문</h4>
<br/>
<%-- 주문하려는 도서를 선택하는 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/addOrderList"
	  name="addOrderListForm" method="post">
<table class="table">
	<thead class="text-center">
	<tr>
		<td></td>
		<td><strong>번호</strong></td>
		<td><strong>수서번호</strong></td>
		<td><strong>수서구분</strong></td>
		<td><strong>도서ISBN</strong></td>
		<td><strong>등록일</strong></td>
	</tr>
	</thead>
	<c:choose>
		<c:when test="${not empty unOrderedList}">
			<c:forEach var="unOrderedOne" items="${unOrderedList}" varStatus="status">
				<tr>
					<td><input type="checkbox" name="checkedAcquisitionNo" value="${unOrderedOne.acquisitionNo}"></td>
					<td class="text-right">${status.index + 1}</td>
					<td class="text-center">${unOrderedOne.acquisitionNo}<input type="hidden" name="acquisitionNo" value="${unOrderedOne.acquisitionNo}"></td>
					<td class="text-center">${unOrderedOne.category}<input type="hidden" name="category" value="${unOrderedOne.category}"></td>
					<td class="text-center">${unOrderedOne.acquisitionIsbn}<input type="hidden" name="acquisitionIsbn" value="${unOrderedOne.acquisitionIsbn}"></td>
					<td class="text-center">${unOrderedOne.registeredDate}<input type="hidden" name="registeredDate" value="${unOrderedOne.registeredDate}"></td>
				</tr>		
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="6">주문 할 도서가 없습니다.</td>
			</tr>
		</c:otherwise>
	</c:choose>

	<%-- 이미 선택된 목록을 hidden 으로 유지한다. --%>
	<c:if test="${not empty orderList}">
		<c:forEach var="orderOne" items="${orderList}">
			<tr class="table-borderless">
				<td><input type="hidden" name="orAcquisitionNo" value="${orderOne.acquisitionNo}"></td>
				<td><input type="hidden" name="orCategory" value="${orderOne.category}"></td>
				<td><input type="hidden" name="orAcquisitionIsbn" value="${orderOne.acquisitionIsbn}"></td>
				<td><input type="hidden" name="orRegisteredDate" value="${orderOne.registeredDate}"></td>
			</tr>		
		</c:forEach>
	</c:if>
</table>
<input class="btn btn-default" type="submit" value="추가">
</form>

<br/><br/>
	
<%-- 위 폼에서 전달된 정보를 토대로 주문을 최종적으로 실행하기 위한 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/order"
	  name="orderForm" method="post"
	  onsubmit="return sumbitInsertForm();">
<table class="table">
	<tr>
		<td class="text-right"><strong>거래처</strong></td>
		<td>
			<select class="form-control" name="tradeEnterpriseInfo">
				<c:forEach var="trader" items="${tradeEnterpriseList}"> 
					<option value="${trader.tradeEnterpriseNo}">${trader.name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td class="text-center"><strong>번호</strong></td>
		<td class="text-center"><strong>수서번호</strong></td>
		<td class="text-center"><strong>수서구분</strong></td>
		<td class="text-center"><strong>도서ISBN</strong></td>
		<td class="text-center"><strong>수량</strong></td>
	</tr>
	<c:choose>
		<c:when test="${not empty orderList}">
			<c:forEach var="orderOne" items="${orderList}" varStatus="status">
				<tr>
					<td class="text-right">${status.index + 1}</td>
					<td class="text-center">${orderOne.acquisitionNo}</td>
					<td class="text-center">${orderOne.category}</td>
					<td class="text-center">${orderOne.acquisitionIsbn}<input class="checkingNull" type="hidden" name="orderIsbn" value="${orderOne.acquisitionIsbn}"></td>
					<td><input class="text-right form-control" type="text" name="orderCount" value="1" onKeyPress="return numkeyCheck(event)"></td>
				</tr>			
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="6">주문 할 내역을 추가하십시오.</td>
			</tr>
		</c:otherwise>
	</c:choose>
</table>
<div class="row">
	<div class="col-md-1 offset-md-11">
		<input class="btn btn-primary" type="submit" value="주문">
	</div>
</div>
</form>


</div>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>