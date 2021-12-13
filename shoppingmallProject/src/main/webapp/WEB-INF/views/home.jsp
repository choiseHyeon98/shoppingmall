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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.mySlides {display:none}
.w3-left, .w3-right, .w3-badge {cursor:pointer}
.w3-badge {height:13px;width:13px;padding:0}
</style>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	헤더위치//헤더에 로그인 세션 정보 받아서 로그인인지 아닌지에 따라 헤더 정보 바뀜.

	<h1>홈페이지</h1>
	<hr>
<!-- 이벤트 배너 -->
<c:choose>
	<c:when test="${!empty eventList}">
		<div class="w3-content w3-display-container" style="max-width: 400px">
			<!-- 슬라이드 이미지 -->
			<c:forEach var="eventList" items="${eventList }" varStatus="eventNum">
					<a href="http://localhost:8888/shop/event/eventList?eventNum=${eventList.eventNum }">
						<img class="mySlides" src="data:image/jpeg;base64,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" 
							alt="${eventList.eventTitle }" style="width: 100%; height:180px;">
					</a>
			</c:forEach>
			<!-- 버튼 위치 -->
			<div class="w3-center w3-container w3-section w3-large w3-text-white w3-display-bottommiddle" style="width: 50%">
				<!-- 슬라이드 좌우 버튼 -->
				<div class="w3-left w3-hover-text-khaki" onclick="plusDivs(-1)">&#10094;</div>
				<div class="w3-right w3-hover-text-khaki" onclick="plusDivs(+1)">&#10095;</div>
				<!-- 슬라이드 가운데 버튼 -->
				<c:forEach var="eventList" items="${eventList}" varStatus="eventNum">
					<span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(${eventNum.count})"></span>
				</c:forEach>
			</div>
		</div>
	</c:when>
</c:choose>
	<!-- 베스트 -->
	<hr>
	<div class="album py-3 bg-light">
	<h3>베스트 상품</h3>
	<c:choose>
		<c:when test="${!empty bestList}">
			<div >
				<div class="container">
					<div class="row">
						<c:forEach var="bestList" items="${bestList }" varStatus="status ">
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
						<c:forEach var="newList" items="${newList }" varStatus="status ">
							<div class="col-md-4">
								<div class="card mb-4 shadow-sm">
									<a href="product/detail?proNum=${newList.proNum }"> <img
										src="https://imgscf.slidemembers.com/docs/1/1/45/free_ppt_sample_-_blackboard_and_children_education_44971.jpg"
										alt=" ${newList.proName }" width="100%" height="240px"></a>
									<div class="card-body">
										<p class="card-text">${newList.proName }</p>
										<hr>
									</div>
								</div>
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
		<c:when test="${!empty dailyList}">
			<div class="album py-3 bg-light">
				<div class="container">
					<div class="row">
						<c:forEach var="dailyList" items="${dailyList}" varStatus="status ">
							<div class="col-md-4">
								<div class="card mb-4 shadow-sm">
									<a href="product/detail?proNum=${dailyList.proNum }"> <img
										src="https://imgscf.slidemembers.com/docs/1/1/45/free_ppt_sample_-_blackboard_and_children_education_44971.jpg"
										alt=" ${dailyList.proName }" width="100%" height="240px"></a>
									<div class="card-body">
										<p class="card-text">${dailyList.proName }</p>
										<hr>
									</div>
								</div>
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
		<c:when test="${!empty randomList}">
			<div class="album py-3 bg-light">
				<div class="container">
					<div class="row">
						<c:forEach var="randomList" items="${randomList}" varStatus="status ">
							<div class="col-md-4">
								<div class="card mb-4 shadow-sm">
									<a href="product/detail?proNum=${randomList.proNum }"> <img
										src="https://imgscf.slidemembers.com/docs/1/1/45/free_ppt_sample_-_blackboard_and_children_education_44971.jpg"
										alt=" ${randomList.proName }" width="100%" height="240px"></a>
									<div class="card-body">
										<p class="card-text">${randomList.proName }</p>
										<hr>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</c:when>
	</c:choose>
	</div>
	<%@include file ="headerfooter/footer.jsp" %>
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
</script>
</html>
