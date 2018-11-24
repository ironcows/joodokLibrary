<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 상세정보 등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<script type="text/javascript">
	$(document).ready(function() {
		var serverMsg = '${message}';
		if (serverMsg.length != undefined && serverMsg.length > 0) {
			alert(serverMsg);
		}
	});



	// 상세위치 정보를 javascript 에 미리 받아둔다. 
	var detailLocationNos = new Array(); 
	var detailLocationNames = new Array();
	var locationNos = new Array();
	
	<c:forEach items="${detailLocationInfo}" var="item">
		detailLocationNos.push("${item.DETAILLOCATIONNO}");
	</c:forEach>
	<c:forEach items="${detailLocationInfo}" var="item">
		detailLocationNames.push("${item.DETAILLOCATIONNAME}");
	</c:forEach>
	<c:forEach items="${detailLocationInfo}" var="item">
		locationNos.push("${item.LOCATIONNO}");
	</c:forEach>

	//도서의 소장처가 선택될 때마다 소장처에 해당하는 상세위치를 변경하여 detailLocationSelect 에 반영해준다. 
	function changeItem(value) {		
		$('#detailLocationSelect').empty();
		for (var i = 0; i < locationNos.length; i++) {
			if(locationNos[i] == value){
				var op = new Option();
				op.value = detailLocationNos[i];
				op.text = detailLocationNames[i];
				
				$('#detailLocationSelect').append(op);
			}
		}
	}
	
	
	function submitSelectUnRegisteredBookForm(){
		var yes = true;
		
		checking = document.querySelector('.formOneCheckingNull');
		
		if(checking != null){
		}else{
			alert("추가할 도서가 없습니다.");
			yes = false;
		}
		
		return yes;	
	}
	
	
	function submitAddPreRegisterBookDetailForm(){
		var yes = true;
		formTwo = document.addPreRegisterBookDetailForm;
		
		var checkUpResult = formTwo.getElementsByName('checkUpResult').value;
 		
	    checkingNull = document.querySelector('.formTwoCheckingNull'); 
	    
		if(checkingNull.length > 0){
			if(checkUpResult.value == "합격"){
				// checkUpResult이 합격인 경우, 아무 것도 안하고 정상 진행.
			}else{
				// checkUpResult 가 불합격인 경우, 메시지 출력
				alert("불합격 도서는 등록할 수 없습니다.");
				yes = false;
			}
		}else{
			alert("등록할 도서가 없습니다.");
			return false;
		}
		
		return yes;	
	}
	

	function sumbitRegisterBookDetailForm() {

		var yes = confirm("도서 상세정보를 등록하시겠습니까?");

		return yes;	
	}
	
	
	

</script>
</head>
<body>


<div class="container">
<h4>도서 상세정보 등록</h4>
<br/>
<%-- 1. 검수가 끝나고, 도서 등록대기 중인 목록을 보여주고 그 중 하나를 선택하는 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/selectUnRegisterBookDetail"
	  name="selectUnRegisteredBookForm" method="post"
	  onsubmit="return submitSelectUnRegisteredBookForm();">
<table class="table">
	<thead class="text-center">
	<tr>
		<th></th>
		<th><strong>권수</strong></th>	
		<th><strong>ISBN</strong></th>	
		<th><strong>서명</strong></th>	
		<th><strong>저자</strong></th>	
		<th><strong>출판사</strong></th>	
	</tr>
	</thead>
	<c:choose>
		<c:when test="${not empty unRegisteredBookList}">
			<c:forEach var="unRegisteredOne" items="${unRegisteredBookList}" varStatus="status">
				<tr>
					<c:choose>
						<c:when test="${status.first}">
							<td>
								<input type="radio" class="formOneCheckingNull" name="checkedIsbn" checked="checked" value="${unRegisteredOne.checkUpIsbn}">
							</td>						
						</c:when>
						<c:otherwise>
							<td>
								<input type="radio" class="formOneCheckingNull" name="checkedIsbn" value="${unRegisteredOne.checkUpIsbn}">
							</td>						
						</c:otherwise>
					</c:choose>
					<td class="text-center">
						${unRegisteredOne.num}권
						<input type="hidden" name="num" value="${unRegisteredOne.num}">
					</td>
					<td class="text-center">
						${unRegisteredOne.checkUpIsbn}
						<input type="hidden" name="checkUpIsbn" value="${unRegisteredOne.checkUpIsbn}">
					</td>
					<td class="text-left">
						${unRegisteredOne.title}
						<input type="hidden" name="title" value="${unRegisteredOne.title}">
					</td>
					<td class="text-left">
						${unRegisteredOne.author}
						<input type="hidden" name="author" value="${unRegisteredOne.author}">
					</td>
					<td class="text-center">
						${unRegisteredOne.publisher}
						<input type="hidden" name="publisher" value="${unRegisteredOne.publisher}">
					</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="6">미등록 도서가 없습니다.</td>
			</tr>
		</c:otherwise>
	</c:choose>
	
	<%-- 이미 추가한 대상을 hidden 으로 유지한다. --%>
	<c:if test="${not empty checkedUnRegisterOne}">
		<tr class="table-borderless">
			<td><input type="hidden" name="chNum" value="${checkedUnRegisterOne.num}"></td>
			<td><input type="hidden" name="chCheckUpIsbn" value="${checkedUnRegisterOne.checkUpIsbn}"></td>
			<td><input type="hidden" name="chTitle" value="${checkedUnRegisterOne.title}"></td>
			<td><input type="hidden" name="chAuthor" value="${checkedUnRegisterOne.author}"></td>
			<td><input type="hidden" name="chPublisher" value="${checkedUnRegisterOne.publisher}"></td>
		</tr>		
	</c:if>
	
</table>
<input class="btn btn-default" type="submit" value="추가">
</form>

<br/>
<br/>

<%-- 2. 도서 상세정보를 등록하려는 대상을 선택하는 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/addPreRegisterBookDetail"
	  name="addPreRegisterBookDetailForm" method="post"
	  onsubmit="return submitAddPreRegisterBookDetailForm();">

<table class="table">
	<thead class="text-center">
	<tr>
		<th></th>
		<th class="text-right"><strong>번호</strong></th>	
		<th class="text-center"><strong>검수번호</strong></th>	
		<th class="text-center"><strong>ISBN</strong></th>	
		<th class="text-left"><strong>서명</strong></th>	
		<th class="text-left"><strong>저자</strong></th>	
		<th class="text-left"><strong>출판사</strong></th>	
		<th class="text-center"><strong>검수결과</strong></th>	
	</tr>
	</thead>
	<c:choose>
		<c:when test="${not empty preRegisterDetailList}">
			<c:forEach var="preRegisterDetail" items="${preRegisterDetailList}" varStatus="status">
				<tr>
					<c:choose>
						<c:when test="${status.first}">
							<td>
								<input type="radio" name="checkedNo" checked="checked" value="${preRegisterDetail.checkUpListNo}">					
							</td>						
						</c:when>
						<c:otherwise>						
							<td>
								<input type="radio" name="checkedNo" value="${preRegisterDetail.checkUpListNo}">					
							</td>						
						</c:otherwise>
					</c:choose>
					<td class="text-right">
						${status.index +1}
					</td>	
					<td class="text-center">
						${preRegisterDetail.checkUpListNo}
						<input class="formTwoCheckingNull" type="hidden" name="checkUpListNo" value="${preRegisterDetail.checkUpListNo}">
					</td>	
					<td class="text-center">
						${preRegisterDetail.checkUpIsbn}
						<input type="hidden" name="checkUpIsbn" value="${preRegisterDetail.checkUpIsbn}">
					</td>	
					<td class="text-left">
						${preRegisterDetail.title}
						<input type="hidden" name="title" value="${preRegisterDetail.title}">
					</td>	
					<td class="text-left">
						${preRegisterDetail.author}
						<input type="hidden" name="author" value="${preRegisterDetail.author}">
					</td>	
					<td class="text-left">
						${preRegisterDetail.publisher}
						<input type="hidden" name="publisher" value="${preRegisterDetail.publisher}">
					</td>	
					<td class="text-center">
						${preRegisterDetail.checkUpResult}
						<input type="hidden" name="checkUpResult" value="${preRegisterDetail.checkUpResult}">
						<input type="hidden" name="metaBookNo" value="${preRegisterDetail.metaBookNo}">
					</td>
				</tr>
			</c:forEach>
		</c:when>	
		<c:otherwise>
			<tr>
				<td colspan="8">추가된 등록 대기 도서가 없습니다.</td>
			</tr>
		</c:otherwise>
	</c:choose>
	
	<%-- 이미 선택한 대상을 hidden 으로 유지한다. --%>
	<c:if test="${not empty checkedPreRegisterOne}">
		<tr class="table-borderless">
			<td><input type="hidden" name="chCheckUpListNo" value="${checkedPreRegisterOne.checkUpListNo}"></td>
			<td><input type="hidden" name="chCheckUpIsbn" value="${checkedPreRegisterOne.checkUpIsbn}"></td>
			<td><input type="hidden" name="chTitle" value="${checkedPreRegisterOne.title}"></td>
			<td><input type="hidden" name="chAuthor" value="${checkedPreRegisterOne.author}"></td>
			<td><input type="hidden" name="chPublisher" value="${checkedPreRegisterOne.publisher}"></td>
			<td><input type="hidden" name="chCheckUpResult" value="${checkedPreRegisterOne.checkUpResult}"></td>
			<td><input type="hidden" name="chMetaBookNo" value="${checkedPreRegisterOne.metaBookNo}"></td>
		</tr>		
	</c:if>
	
	<%-- 1번 폼에 표시될 값들을 hidden 으로 유지한다. --%>
	<%-- 추가 대상 목록 --%>
	<c:if test="${not empty unRegisteredBookList}">
		<c:forEach var="unRegisteredOne" items="${unRegisteredBookList}">
			<tr class="table-borderless">
				<td><input type="hidden" name="formOneNum" value="${unRegisteredOne.num}"></td>
				<td><input type="hidden" name="formOneCheckUpIsbn" value="${unRegisteredOne.checkUpIsbn}"></td>
				<td><input type="hidden" name="formOneTitle" value="${unRegisteredOne.title}"></td>
				<td><input type="hidden" name="formOneAuthor" value="${unRegisteredOne.author}"></td>
				<td><input type="hidden" name="formOnePublisher" value="${unRegisteredOne.publisher}"></td>
			</tr>
		</c:forEach>
	</c:if>
	<%-- 추가된 대상 --%>
	<c:if test="${not empty checkedUnRegisterOne}">
		<tr class="table-borderless">
			<td><input type="hidden" name="formOneChNum" value="${checkedUnRegisterOne.num}"></td>
			<td><input type="hidden" name="formOneChCheckUpIsbn" value="${checkedUnRegisterOne.checkUpIsbn}"></td>
			<td><input type="hidden" name="formOneChTitle" value="${checkedUnRegisterOne.title}"></td>
			<td><input type="hidden" name="formOneChAuthor" value="${checkedUnRegisterOne.author}"></td>
			<td><input type="hidden" name="formOneChPublisher" value="${checkedUnRegisterOne.publisher}"></td>
		</tr>		
	</c:if>
</table>
<input class="btn btn-default" type="submit" value="선택">
</form>

<br/><br/>


<%-- 3. 도서 상세정보 등록을 최종적으로 진행하기 위한 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/registerBookDetail"
	  name="registerBookDetailForm" method="post"
	  onsubmit="return sumbitRegisterBookDetailForm();">
<c:if test="${not empty metaInfo}">
<table class="table">
	<thead class="thead-dark">
	<tr>
		<td colspan="2">
			${metaInfo.title}
			<input type="hidden" name="metaBookNo" value="${metaInfo.metaBookNo}">
		</td>
	</tr>
	</thead>
	<tr>
		<th class="text-right">부제</th>
		<td class="text-left">
			${metaInfo.subTitle}
		</td>
	</tr>
	<tr>
		<th class="text-right">자료유형</th>
		<td class="text-left">
			${metaInfo.bookType}
		</td>
	</tr>
	<tr>
		<th class="text-right">자료분류</th>
		<td class="text-left">
			${metaInfo.ddc}
		</td>
	</tr>
	<tr>
		<th class="text-right">개인저자</th>
		<td class="text-left">
			${metaInfo.author}
		</td>
	</tr>
	<tr>
		<th class="text-right">발행사항</th>
		<td class="text-left">
			${metaInfo.publisher}, ${metaInfo.publishYear}
		</td>
	</tr>
	<tr>
		<th class="text-right">페이지</th>
		<td class="text-left">
			${metaInfo.page}
		</td>
	</tr>
	<tr>
		<th class="text-right">ISBN</th>
		<td class="text-left">
			${metaInfo.isbn}
		</td>
	</tr>
</table>
</c:if>

<c:if test="${not empty regBookDetail}">
<table class="table">
	<thead class="text-center">
	<tr>
		<td><strong>등록번호</strong></td>
		<td><strong>청구기호</strong></td>
		<td><strong>복본</strong></td>
		<td colspan="2"><strong>소장처</strong></td>
		<td><strong>용도</strong></td>
	</tr>
	</thead>
	<c:if test="${not empty bookDetails}">
		<c:forEach var="bookDetail" items="${bookDetails}">
			<tr>
				<td class="text-center">${bookDetail.BOOKDETAILNO}</td>
				<td class="text-left">${bookDetail.APPLICATIONMARK}</td>
				<td class="text-center">${bookDetail.DUPLICATE}</td>
				<td class="text-left">${bookDetail.LOCATIONNAME}</td>
				<td class="text-left">${bookDetail.DETAILLOCATIONNAME}</td>
				<td class="text-left">${bookDetail.PURPOSE}</td>
			</tr>
		</c:forEach>
	</c:if>
	<tr>
		<td class="text-center">자동생성</td>
		<td>
			<input type="text" name="applicationMark" required="required"
				   class="form-control"
				   value="${regBookDetail.regApplicationMark}"
				   placeholder="처음 청구기호 임의설정">
		</td>
		<td>
			<input type="text" name="duplicate" required="required"
				   class="form-control"
				   value="${regBookDetail.regDuplicate}">
		</td>
		<td colspan="2">
			<select class="form-control" id="locationSelect" onchange="changeItem(this.value)" required="required">
				<option disabled="disabled" selected="selected">선택</option>
				<c:forEach var="locationInfo" items="${locationInfo}">
					<option value="${locationInfo.LOCATIONNO}">${locationInfo.LOCATIONNAME}</option>
				</c:forEach>
			</select>
			<select class="form-control" id="detailLocationSelect" name="detailLocationNo" required="required">
				<option disabled="disabled">소장처를 선택하세요</option>
			</select>
		</td>
		<td>
			<select class="form-control" name="purpose">
				<option value="일반도서" selected="selected">일반도서</option>
				<option value="전공도서">전공도서</option>
				<option value="참고도서">참고도서</option>
				<option value="업무용">업무용</option>
				<option value="지정도서">지정도서</option>
			</select>
		</td>
	</tr>
</table>
<%-- 1번 2번 폼에 지속적으로 표시되는데 필요한 값들을 유지해줄 table 태그 --%>
<table>
	<%-- 1번 폼을 위해 유지될 값들. --%>
	<%-- 추가 대상 목록 --%>
	<c:if test="${not empty unRegisteredBookList}">
		<c:forEach var="unRegisteredOne" items="${unRegisteredBookList}">
			<tr class="table-borderless">
				<td><input type="hidden" name="formOneNum" value="${unRegisteredOne.num}"></td>
				<td><input type="hidden" name="formOneCheckUpIsbn" value="${unRegisteredOne.checkUpIsbn}"></td>
				<td><input type="hidden" name="formOneTitle" value="${unRegisteredOne.title}"></td>
				<td><input type="hidden" name="formOneAuthor" value="${unRegisteredOne.author}"></td>
				<td><input type="hidden" name="formOnePublisher" value="${unRegisteredOne.publisher}"></td>
			</tr>
		</c:forEach>
	</c:if>
	<%-- 선택된 대상 --%>
	<c:if test="${not empty checkedUnRegisterOne}">
		<tr class="table-borderless">
			<td><input type="hidden" name="formOneChNum" value="${checkedUnRegisterOne.num}"></td>
			<td><input type="hidden" name="formOneChCheckUpIsbn" value="${checkedUnRegisterOne.checkUpIsbn}"></td>
			<td><input type="hidden" name="formOneChTitle" value="${checkedUnRegisterOne.title}"></td>
			<td><input type="hidden" name="formOneChAuthor" value="${checkedUnRegisterOne.author}"></td>
			<td><input type="hidden" name="formOneChPublisher" value="${checkedUnRegisterOne.publisher}"></td>
		</tr>		
	</c:if>
	
	<%-- 2번 폼을 위해 유지될 값들 --%>
	<%-- 선택 대상 목록 --%>
	<c:if test="${not empty preRegisterDetailList}">
		<c:forEach var="preRegisterDetailOne" items="${preRegisterDetailList}">
			<tr class="table-borderless">
				<td><input type="hidden" name="formTwoCheckUpListNo" value="${preRegisterDetailOne.checkUpListNo}"></td>
				<td><input type="hidden" name="formTwoCheckUpIsbn" value="${preRegisterDetailOne.checkUpIsbn}"></td>
				<td><input type="hidden" name="formTwoTitle" value="${preRegisterDetailOne.title}"></td>
				<td><input type="hidden" name="formTwoAuthor" value="${preRegisterDetailOne.author}"></td>
				<td><input type="hidden" name="formTwoPublisher" value="${preRegisterDetailOne.publisher}"></td>
				<td><input type="hidden" name="formTwoCheckUpResult" value="${preRegisterDetailOne.checkUpResult}"></td>
				<td><input type="hidden" name="formTwoMetaBookNo" value="${preRegisterDetailOne.metaBookNo}"></td>
			</tr>
		</c:forEach>
	</c:if>
	<%-- 등록중인 대상 --%>
	<c:if test="${not empty checkedPreRegisterOne}">
		<tr class="table-borderless">
			<td><input type="hidden" name="formTwoChCheckUpListNo" value="${checkedPreRegisterOne.checkUpListNo}"></td>
			<td><input type="hidden" name="formTwoChCheckUpIsbn" value="${checkedPreRegisterOne.checkUpIsbn}"></td>
			<td><input type="hidden" name="formTwoChTitle" value="${checkedPreRegisterOne.title}"></td>
			<td><input type="hidden" name="formTwoChAuthor" value="${checkedPreRegisterOne.author}"></td>
			<td><input type="hidden" name="formTwoChPublisher" value="${checkedPreRegisterOne.publisher}"></td>
			<td><input type="hidden" name="formTwoChCheckUpResult" value="${checkedPreRegisterOne.checkUpResult}"></td>
			<td><input type="hidden" name="formTwoChMetaBookNo" value="${checkedPreRegisterOne.metaBookNo}"></td>
		</tr>		
	</c:if>
</table>
<div class="row">
	<div class="col-md-2 offset-md-10" >
		<input class="btn btn-primary" type="submit" value="도서상세 등록">
	</div>
</div>
</c:if>
</form>

</div>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>