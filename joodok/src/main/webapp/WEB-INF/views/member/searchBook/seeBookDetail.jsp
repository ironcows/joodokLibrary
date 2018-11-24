<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
		   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 상세 정보</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<script type="text/javascript">

function confirm_reservation(){
	var check = confirm("예약 하시겠습니까?")
	return check;
}
</script>
</head>
<body>


<form name="makeReservationForm" action="${pageContext.request.contextPath}/member/makeReservation"
	  onsubmit="return confirm_reservation();" method="post">
<input type="hidden" name="metaBookNo" value="${metaInfo.metaBookNo}">
	<div class="row">
		<p class="form-control-static"><h5><strong>${metaInfo.title}</strong></h5></p>
	</div>
	<div class="row">
		<label class="col-md-2"><strong>부제</strong></label>
		<p class="form-control-static">${metaInfo.subTitle}</p>
	</div>
	<div class="row">
		<label class="col-md-2"><strong>자료유형</strong></label>
		<p class="form-control-static">${metaInfo.bookType}</p>
	</div>
	<div class="row">
		<label class="col-md-2"><strong>자료분류</strong></label>
		<p class="form-control-static">${metaInfo.ddc}</p>
	</div>
	<div class="row">
		<label class="col-md-2"><strong>개인저자</strong></label>
		<p class="form-control-static">${metaInfo.author}</p>
	</div>
	<div class="row">
		<label class="col-md-2"><strong>발행사항</strong></label>
		<p class="form-control-static">${metaInfo.publisher}, ${metaInfo.publishYear}</p>
	</div>
	<div class="row">
		<label class="col-md-2"><strong>페이지</strong></label>
		<p class="form-control-static">${metaInfo.page}</p>
	</div>
	<div class="row">
		<label class="col-md-2"><strong>ISBN</strong></label>
		<p class="form-control-static">${metaInfo.isbn}</p>
	</div>

	<table class="table">
		<thead class="text-center thead-dark">
		<tr>
			<th><strong>등록번호</strong></th>
			<th><strong>청구기호</strong></th>
			<th colspan="2"><strong>소장처</strong></th>
			<th><strong>도서상태</strong></th>
			<th><strong>반납예정일</strong></th>
			<th><strong>예약</strong></th>
		</tr>
		</thead>
		<c:choose>
			<c:when test="${not empty bookDetails}">
				<c:forEach var="bookDetail" items="${bookDetails}">
					<tr>
						<td class="text-center">${bookDetail.BOOKDETAILNO}</td>
						<td class="text-left">${bookDetail.APPLICATIONMARK}</td>
						<td class="text-center">${bookDetail.LOCATIONNAME}</td>
						<td class="text-center">${bookDetail.DETAILLOCATIONNAME}</td>
						<td class="text-center">${bookDetail.BORROWSTATUS}</td>
						<td class="text-center">${bookDetail.DUEDATE}</td>
						<td>
							<c:if test="${bookDetail.BORROWSTATUS ne '대출중'}">
								<input class="btn btn-primary" type="submit" value="예약">
								<input type="hidden" name="bookDetailNo" value="${bookDetail.BOOKDETAILNO}">
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="7">현재 서가에 비치 되어있지 않습니다. 빠른 시일 내로 처리하겠습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</form>


<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>