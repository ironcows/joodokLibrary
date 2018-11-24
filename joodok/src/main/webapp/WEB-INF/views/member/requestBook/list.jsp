<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	       uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"
		   uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 신청 목록</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<script type="text/javascript">
function goPage(pages, lines){
	location.href = '?' + "pages=" + pages;
}
</script>

</head>
<body>

<div class="container">
<h4>도서 신청 목록</h4>
<br/>
<table class="table">
	<thead class="text-center thead-dark">
	<tr>
		<th><strong>번호</strong></th>
		<th><strong>제목</strong></th>
		<th><strong>작성일</strong></th>
		<th><strong>상태</strong></th>
	</tr>
	</thead>
	<c:choose>
		<c:when test="${empty myRequestList}">
			<tr>
				<td colspan="4">
					신청한 도서가 없습니다.
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="myRequest" items="${myRequestList}">
				<tr>
					<td class="text-right">${myRequest.RNUM}</td>
					<td class="text-left">
						<a href="${pageContext.request.contextPath}/member/seeRequestBook?requestBookNo=${myRequest.REQUESTBOOKNO}">
							${myRequest.SUBJECT}
						</a>
					</td>
					<td class="text-center">${myRequest.REGISTEREDDATE}</td>
					<td class="text-center">${myRequest.STATUS}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>

<div class="row">
	<div class="col-md-10">
	</div>
	<div class="col-md-2">
		<input class="btn btn-primary" type="button" value="신청하기" onclick="window.location='${pageContext.request.contextPath}/member/toWriteRequest'">
	</div>

</div>


<c:choose>
	<c:when test="${paging.numberOfRecords ne NULL and paging.numberOfRecords ne '' and paging.numberOfRecords ne 0}">
	<div class="row">
		<div class="col-md-4 offset-md-4">
		<ul class="pagination">
			<c:if test="${paging.currentPageNo gt 5}">
				<li class="page-item">
					<a class="page-link" href="javascript:goPage(${paging.prevPageNo}, ${paging.maxPost})">이전</a>
				</li>
			</c:if>
			<c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
				<c:choose>
					<c:when test="${i eq paging.currentPageNo}">
						<li class="active page-item">
							<a class="page-link" href="javascript:goPage(${i}, ${paging.maxPost})">${i}</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page-item">
							<a class="page-link" href="javascript:goPage(${i}, ${paging.maxPost})">${i}</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<fmt:parseNumber var="currentPage" integerOnly="true" value="${(paging.currentPageNo-1)/5}"/>
			<fmt:parseNumber var="finalPage" integerOnly="true" value="${(paging.finalPageNo-1)/5}"/>
			<c:if test="${currentPage < finalPage}">
				<li class="page-item">
					<a class="page-link" href="javascript:goPage(${paging.nextPageNo}, ${paging.maxPost})">다음</a>
				</li>
			</c:if>
		</ul>
		</div>
	</div>
	</c:when>
</c:choose>
</div>


<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>