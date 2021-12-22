<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
<title>Home</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style type="text/css">
  
  	.managerMenu {
  		float: right;
  	}
  	
  </style>
<!-- favicon -->
<%@include file="manager/favicon.jsp"%>
</head>
<body>
	<!-- header -->
	<%@include file="manager/header.jsp"%>
	<!-- 게시글 관리 버튼 -->
	<div class = "managerMenu" >
		<button type="button" class="btn btn-light" onClick="return muldelete()">게시글삭제</button>
		<button type="button" class="btn btn-light" onClick="fn_eventAdd(this.form)">이벤트배너 등록</button>
		<button type="button" class="btn btn-light" onClick="fn_productAdd(this.form)">새상품 등록</button>
		<button type="button" class="btn btn-light" onClick="return soldOut()">품절</button>
	 
	</div>
	<!-- 이벤트 배너 -->
	
	<c:choose>
		<c:when test="${!empty eventList}">
			<div class="w3-content w3-display-container" style="max-width: 400px">
				<!-- 슬라이드 이미지 -->
				<c:forEach var="eventList" items="${eventList }"
					varStatus="eventNum">
				
					<a
						href="../manager/event/mod?eventNum=${eventList.eventNum }&eventImg=${eventList.eventImg}">
						<img class="mySlides" src="../fileDownload?eventImg=${eventList.eventImg}"
						alt="${eventList.eventTitle }" style="width: 100%; height: 180px;">
					</a>
				</c:forEach>
				<!-- 버튼 위치 -->
				
				<div
					class="w3-center w3-container w3-section w3-large w3-text-white w3-display-bottommiddle"
					style="width: 50%">
					<!-- 슬라이드 좌우 버튼 -->
					<div class="w3-left w3-hover-text-khaki" onclick="plusDivs(-1)">&#10094;</div>
					<div class="w3-right w3-hover-text-khaki" onclick="plusDivs(+1)">&#10095;</div>
					<!-- 슬라이드 가운데 버튼 -->
				
				<input type="hidden"  name="eventImg" value="${event.eventImg }" />
				
					<c:forEach var="eventList" items="${eventList}"
						varStatus="eventNum">
						<span
							class="w3-badge demo w3-border w3-transparent w3-hover-white"
							onclick="currentDiv(${eventNum.count})"></span>
					</c:forEach>
				
				</div>
			</div>
		</c:when>
	</c:choose>
	<!-- 베스트 -->
<form name="FormList" >
	<hr>
	<div class="album py-3 bg-light">
		<h3>베스트 상품</h3>
		<c:choose>
			<c:when test="${!empty bestList}">
				<div>
					<div class="container">
						<div class="row">
							<c:forEach var="bestList" items="${bestList }"
								varStatus="status ">
								<div class="col-md-4">
									<div class="card mb-4 shadow-sm">
										<a href="product/detail?proNum=${bestList.proNum }"> <img
											src="https://imgscf.slidemembers.com/docs/1/1/45/free_ppt_sample_-_blackboard_and_children_education_44971.jpg"
											alt=" ${bestList.proName }" width="100%" height="240px"></a>
										<div class="card-body">
											<p class="card-text">${bestList.proName }</p>
											<hr>
										</div>
									</div>
									<input type="checkbox" name="chkbox" value="${bestList.proNum}">
								</div>
							</c:forEach>
							
						</div>
					</div>
				</div>
			</c:when>
		</c:choose>
	</div>
	<!-- 신상품 -->
	<hr>
	<div class="album py-3 bg-light">
		<h3>신상품</h3>
		<c:choose>
			<c:when test="${!empty newList}">
				<div class="album py-3 bg-light">
					<div class="container">
						<div class="row">
							<c:forEach var="newList" items="${newList}" varStatus="status ">
								<div class="col-md-4">
									<div class="card mb-4 shadow-sm">
										<a href="product/detail?proNum=${newList.proNum }"> 
										<img src="https://imgscf.slidemembers.com/docs/1/1/45/free_ppt_sample_-_blackboard_and_children_education_44971.jpg"
											alt=" ${newList.proName }" width="100%" height="240px"></a>
										<div class="card-body">
											<p class="card-text">${newList.proName }</p>
											
											<hr>
										</div>
									</div>
									<input type="checkbox" name="chkbox" value="${newList.proNum}">
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</c:when>
		</c:choose>
	</div>
	<!-- 오늘배송 -->
	<hr>
	<div class="album py-3 bg-light">
		<h3>오늘배송</h3>
		<c:choose>
			<c:when test="${!empty todayList}">
				<div class="album py-3 bg-light">
					<div class="container">
						<div class="row">
							<c:forEach var="todayList" items="${todayList}"
								varStatus="status ">
								<div class="col-md-4">
									<div class="card mb-4 shadow-sm">
										<a href="product/detail?proNum=${todayList.proNum }"> <img
											src="https://imgscf.slidemembers.com/docs/1/1/45/free_ppt_sample_-_blackboard_and_children_education_44971.jpg"
											alt=" ${todayList.proName }" width="100%" height="240px"></a>
										<div class="card-body">
											<p class="card-text">${todayList.proName }</p>
											<hr>
										</div>
									</div>
									<input type="checkbox" name="chkbox" value="${todayList.proNum}">
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</c:when>
		</c:choose>
	</div>
	<!-- 랜덤상품 -->
	<hr>
	<div class="album py-3 bg-light">
		<h3>상품 리스트</h3>
		<c:choose>
			<c:when test="${!empty allList}">
				<div class="album py-3 bg-light">
					<div class="container">
						<div class="row">
							<c:forEach var="allList" items="${allList}"
								varStatus="status ">
								<div class="col-md-4">
									<div class="card mb-4 shadow-sm">
										<a href="product/detail?proNum=${allList.proNum }"> <img
											src="https://imgscf.slidemembers.com/docs/1/1/45/free_ppt_sample_-_blackboard_and_children_education_44971.jpg"
											alt=" ${allList.proName }" width="100%" height="240px"></a>
										<div class="card-body">
											<p class="card-text">${allList.proName }</p>
											<hr>
										</div>
									</div>
									<input type="checkbox" name="chkbox" value="${allList.proNum}">
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</c:when>
		</c:choose>
	</div>
	<!-- footer -->
	<%@include file="manager/footer.jsp"%>
</form>
</body>
<script>
//slide 관련 script//
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function currentDiv(n) {
  showDivs(slideIndex = n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demo");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" w3-white", "");
  }
  x[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " w3-white";
}

//관리자 버튼
function fn_eventAdd(url){
	
	location.href="event/add";
	
}

function fn_productAdd(url){
	
	location.href="product/add";
	
}

function muldelete(){
	var form = document.getElementsByName("FormList");
	var r = confirm("삭제하시겠습니까?");
	
	if(r == true){
		form[0].action="muldelete";
		form[0].submit();
	} else {
		
	}
	
}

function soldOut(){
	var form = document.getElementsByName("FormList");
	var r = confirm("품절처리하시겠습니까?");
	
	if(r == true){
		form[0].action="mulSoldout";
		form[0].submit();
	} else {
		
	}
}
</script>
</html>
