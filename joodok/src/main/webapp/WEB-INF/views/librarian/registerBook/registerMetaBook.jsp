<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
		   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 공통정보 등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<script type="text/javascript">
	$(document).ready(function() {
		var serverMsg = '${message}';
		if (serverMsg.length != undefined && serverMsg.length > 0) {
			alert(serverMsg);
		}
	});
	
	//[] <--문자 범위 [^] <--부정 [0-9] <-- 숫자  
	//[0-9] => \d , [^0-9] => \D
	var rgx1 = /\D/g;  // /[^0-9]/g 와 같은 표현
	var rgx2 = /(\d+)(\d{3})/; 

	function getNumber(obj){
		
	     var num01;
	     var num02;
	     num01 = obj.value;
	     num02 = num01.replace(rgx1,"");
	     num01 = setComma(num02);
	     obj.value =  num01;

	}

	function setComma(inNum){
	     
	     var outNum;
	     outNum = inNum; 
	     while (rgx2.test(outNum)) {
	          outNum = outNum.replace(rgx2, '$1' + ',' + '$2');
	      }
	     return outNum;

	}	
	
	function numkeyCheck(e) { 
		var keyValue = event.keyCode; 
		if( ((keyValue >= 48) && (keyValue <= 57)) ) {
			return true; 			
		}else {
			return false; 			
		}
	}
	
	function submitAddMetaBookForm() {
		var yes = true;
		
		checking = document.querySelector('.checkingNull');
		
		if(checking != null){
		}else{
			alert("등록할 도서가 없습니다.");
			yes = false;
		}
		return yes;	
	}
	
	function submitRegisterMetaBookForm() {

		yes = confirm("도서를 등록 하시겠습니까?");

		return yes;	
	}
	
</script>
</head>
<body>

<div class="container">
<h4>도서 공통정보 등록</h4>
<br/>
<%-- 도서 공통정보를 등록하려는 대상을 선택하는 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/addMetaBook"
	  name="addMetaBookForm" method="post"
	  onsubmit="return submitAddMetaBookForm();">
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
		<c:when test="${not empty unRegisteredMetaBook}">
			<c:forEach var="unRegisteredOne" items="${unRegisteredMetaBook}" varStatus="status">
				<tr>
					<td>
						<input type="radio" class="checkingNull" name="checkedAcquisitionNo" checked="checked" value="${unRegisteredOne.acquisitionNo}">
					</td>
					<td class="text-right">${status.index + 1}</td>
					<td class="text-center">
						${unRegisteredOne.acquisitionNo}
						<input type="hidden" class="checkingNull" name="acquisitionNo" value="${unRegisteredOne.acquisitionNo}">
					</td>
					<td class="text-center">
						${unRegisteredOne.category}
						<input type="hidden" name="category" value="${unRegisteredOne.category}">
						</td>
					<td class="text-center">
						${unRegisteredOne.acquisitionIsbn}
						<input type="hidden" name="acquisitionIsbn" value="${unRegisteredOne.acquisitionIsbn}">
					</td>
					<td class="text-center">
						${unRegisteredOne.registeredDate}
						<input type="hidden" name="registeredDate" value="${unRegisteredOne.registeredDate}">
					</td>
				</tr>		
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="6">등록 할 도서가 없습니다.</td>
			</tr>
		</c:otherwise>
	</c:choose>
	
	<%-- 이미 선택한 대상을 hidden 으로 유지한다. --%>
	<c:if test="${not empty checkedMetaBook}">
		<tr>
			<td><input type="hidden" name="chAcquisitionNo" value="${checkedMetaBook.acquisitionNo}"></td>
			<td><input type="hidden" name="chCategory" value="${checkedMetaBook.category}"></td>
			<td><input type="hidden" name="chAcquisitionIsbn" value="${checkedMetaBook.acquisitionIsbn}"></td>
			<td><input type="hidden" name="chRegisteredDate" value="${checkedMetaBook.registeredDate}"></td>
		</tr>		
	</c:if>
</table>
<input class="btn btn-default" type="submit" value="선택">
</form>

<br/><br/>

<%-- 위 폼에서 전달된 정보를 토대로 도서 공통정보 등록을 최종적으로 실행하기 위한 폼 --%>
<form action="${pageContext.request.contextPath}/librarian/registerMetaBook"
	  class="form-horizontal"
	  name="registerMetaBookForm" method="post"
	  onsubmit="return submitRegisterMetaBookForm();">

	<c:if test="${not empty checkedMetaBook}">
			
		<div class="row form-group">
			<div class="col-md-2">ISBN</div>
			<div class="col-md-6">
				<input class="form-control" type="text" name="isbn" onKeyPress="return numkeyCheck(event)"
				  	   id="inputIsbn"
				  	   value="${checkedMetaBook.acquisitionIsbn}"
				  	   readonly="readonly">
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-2">서명</div>
			<div class="col-md-6">
				<input class="form-control" type="text" name="title" required="required"
					   id="inputTitle">
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-2">부제목</div>
			<div class="col-md-6">
				<input class="form-control" type="text" name="subTitle" value=""
				       id="inputSubTitle">
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-2">권</div>
			<div class="col-md-6">
				<input class="form-control" type="text" name="volume" value="" onKeyPress="return numkeyCheck(event)"
				       id="inputVolume">
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-2">저자</div>
			<div class="col-md-6">
				<input class="form-control" type="text" name="author" required="required"
				       id="inputAuthor">
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-2">출판사</div>
			<div class="col-md-6">
				<input class="form-control" type="text" name="publisher" required="required"
				       id="inputPublisher">
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-2">출판년도</div>
			<div class="col-md-6">
				<input class="form-control" type="text" name="publishYear" value="" onKeyPress="return numkeyCheck(event)"
				       id="inputPublishYear">
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-2">쪽수</div>
			<div class="col-md-6">
				<input class="form-control" type="text" name="page" value="" onKeyPress="return numkeyCheck(event)"
				       id="inputPage">
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-2">정가</div>
			<div class="col-md-6">
				<input class="form-control" type="text" name="price" value="" 
					   onchange="getNumber(this);"
					   onkeyup="getNumber(this);"
					   onKeyPress="return numkeyCheck(event)"
					   id="inputPrice">
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-2">언어</div>
			<div class="col-md-6">
				<select class="form-control" name="language"
						id="inputLanguage">
					<option value="한국어">한국어</option>
					<option value="중국어">중국어</option>
					<option value="영어">영어</option>
					<option value="독어">독어</option>
					<option value="불어">불어</option>
					<option value="스페인어">스페인어</option>
					<option value="러시아어">러시아어</option>
					<option value="이탈리아어">이탈리아어</option>
					<option value="라틴어">라틴어</option>
					<option value="기타">기타</option>
				</select>
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-2">자료분류</div>
			<div class="col-md-6">
				<select class="form-control" name="ddc"
				        id="inputDdc">
					<option value="컴퓨터 과학, 정보 총류">컴퓨터 과학, 정보 총류</option>
					<option value="철학, 심리학">철학, 심리학</option>
					<option value="종교">종교</option>
					<option value="사회과학">사회과학</option>
					<option value="언어">언어</option>
					<option value="과학">과학</option>
					<option value="기술">기술</option>
					<option value="예술, 레크리에이션">예술, 레크리에이션</option>
					<option value="문학">문학</option>
					<option value="역사, 지리">역사, 지리</option>
				</select>
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-2">국내외구분</div>
			<div class="col-md-6">
				<select class="form-control" name="nationDivision"
					    id="inputNationDivision">
					<option value="국내서">국내서</option>
					<option value="국외서">국외서</option>
				</select>
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-2">도서 유형</div>
			<div class="col-md-6">
				<select class="form-control" name="bookType"
						id="inputBookType">
					<option value="단행본">단행본</option>
					<option value="시청각자료">시청각자료</option>
				</select>
			</div>
		</div>
		<div class="row form-group">
			<div class="col-md-2 offset-md-10">
				<input class="btn btn-primary" type="submit" value="등록">
			</div>
		</div>
			
	</c:if>
</form>

</div>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</body>
</html>