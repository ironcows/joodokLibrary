<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
		   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 검색</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>


<!-- 도서 검색 부분 -->
<form action="${pageContext.request.contextPath}/member/searchBook" name="searchBook" method="get">
	<table>
		<tr>
			<td>
				<select class="form-control" name="type">
					<option value="title" selected="selected">서명</option>
					<option value="author">저자</option>
					<option value="publisher">출판사</option>
				</select>
			</td>
			<td>
				<input class="form-control" type="text" size="40" name="value" required="required"/>
			</td>
			<td>
				<input class="btn btn-default" type="submit" value="검색">
			</td>
		</tr>
	</table>
</form>
<br/>
<!-- 검색 결과 출력 부분 -->
<table class="table">
	<c:forEach var="book" items="${searchList}">
		<thead class="thead-light">
		<tr>
			<th>
				<a href="${pageContext.request.contextPath}/member/seeBookDetail?metaBookNo=${book.METABOOKNO}">
					${book.TITLE}
				</a>
				<c:if test="${not empty book.SUBTITLE}">
					: ${book.SUBTITLE}	
				</c:if>
			</th>
		</tr>
		</thead>
		<tr>
			<td colspan="2">
				${book.AUTHOR}
			</td>
		</tr>
		<tr>
			<td colspan="2">
				${book.PUBLISHER}
			</td>
		</tr>
		<tr>
			<td colspan="2">
				${book.PUBLISHYEAR}
			</td>
		</tr>
		<tr>
			<td colspan="2">
				${book.BOOKTYPE}
			</td>
		</tr>
		<tr>
			<td colspan="2">
				${book.DDC}
			</td>
		</tr>
	</c:forEach>
</table>


<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>