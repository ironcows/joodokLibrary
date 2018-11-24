<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>거래처 조회</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>

<div class="container">
<h4>거래처 조회</h4>
<br/>
<table class="table">
	<c:choose>
		<c:when test="${not empty tradeEnterpriseList}">
			<c:forEach var="tradeEnterprise" items="${tradeEnterpriseList}">
				<thead class="text-center thead-dark">
				<tr>
					<th colspan="6"><h5><strong>${tradeEnterprise.name}</strong></h5></th>
				</tr>
				</thead>
				<tbody>
				<tr>
					<td class="text-right"><strong>거래처유형 :</strong></td><td colspan="3">${tradeEnterprise.type}</td>
					<td class="text-right"><strong>교내외구분 :</strong></td><td colspan="3">${tradeEnterprise.category}</td>
				</tr>
				<tr>
					<td class="text-right"><strong>신용등급 :</strong></td><td colspan="3">${tradeEnterprise.creditGrade}</td>
					<td class="text-right"><strong>평균배달소요일 :</strong></td><td colspan="3">${tradeEnterprise.deliveryPeriod}</td>
				</tr>
				<tr>
					<td class="text-right"><strong>대표번호 :</strong></td><td colspan="3">${tradeEnterprise.contactNumber}</td>
					<td class="text-right"><strong>주소 :</strong></td><td colspan="3">${tradeEnterprise.address}</td>
				</tr>
				<tr>
					<td class="text-right"><strong>FAX :</strong></td><td colspan="3">${tradeEnterprise.fax}</td>
					<td class="text-right"><strong>웹 주소 :</strong></td>
					<td colspan="3">
						<c:if test="${not empty tradeEnterprise.webAddress}">
							<a href="${tradeEnterprise.webAddress}">Web Home</a>
						</c:if>
					</td>
				</tr>
				<tr>
					<td class="text-right"><strong>거래은행 :</strong></td><td colspan="3">${tradeEnterprise.bankName}</td>
					<td class="text-right"><strong>계좌번호 :</strong></td><td colspan="3">${tradeEnterprise.account}</td>
				</tr>
				</tbody>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="6">등록된 거래처가 없습니다.</td>
			</tr>
		</c:otherwise>
	</c:choose>
</table>
</div>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>