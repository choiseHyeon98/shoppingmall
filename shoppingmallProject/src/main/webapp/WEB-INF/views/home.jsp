<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  request.setCharacterEncoding("UTF-8");
%>
<html>
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
						<img class="mySlides" src="https://imgscf.slidemembers.com/docs/1/1/45/free_ppt_sample_-_blackboard_and_children_education_44971.jpg" 
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
