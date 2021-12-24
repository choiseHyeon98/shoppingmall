<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="icon" type="image/png" href="http://example.com/myicon.png">

<title>상품상세</title>

<script>
	function info_chk() {
		return true;
	}

	function info_chk2(frm) {
		if (confirm("찜하시겠습니까?")) {
			frm.action = '/shop/s/mypage/addCartList';
			frm.submit();
			return true;
		}
	}
</script>

<!-- Core theme CSS (includes Bootstrap)-->
<style>
.card-body {
	flex: 1 1 auto;
	padding: 1rem 1rem;
	margin: 0px 30px 0px 30px;
}

#card-body {
	flex: 1 1 auto;
	padding: 1rem 1rem;
	margin: 0px 30px 0px 30px;
}

.anone {
	display: none;
}

.widforsc {
	width: 30%;
}
</style>

<!-- favicon -->
<%@include file="headerfooter/favicon.jsp"%>
</head>
<body>
	<!-- header -->
	<%@include file="headerfooter/header.jsp"%>

	<!-- 상품 이미지, 상품 주문form -->
	<div class="card-body">
		<div class="container px-4 px-lg-5">
			<!-- Heading Row-->
			<div class="row gx-4 gx-lg-5 align-items-center my-5">
				<div class="col-lg-7">
					<img class="img-fluid rounded mb-4 mb-lg-0"
						src="https://pbs.twimg.com/media/FGiPOEFUYAQqmiz?format=jpg&name=large"
						alt="제품이미지상세뷰900*400" />
				</div>
				<div class="col-lg-5">
					<form action="/shop/s/product/orderList"
						onsubmit='return info_chk()' method="post">
						<h1>${Product[0].proName }</h1>
						<p>${Product[0].proContent }</p>
						<p>색상: ${Product[0].colorOption }</p>
						
						<p name="price" value="${Product[0].price }">
						가격:
							${Product[0].price }</p>
						<p name="delprice" value="${Product[0].delprice }">
						배송비:
							${Product[0].delprice }</p>
						사이즈: <select name="sizeOption" class="widforsc">
							<c:choose>
								<c:when test="${!empty Product}">
									<c:forEach var="Product" items="${Product }" varStatus="status">
										<option>${Product.sizeOption }</option>
									</c:forEach>
								</c:when>
							</c:choose>
						</select> <br> 
						색상: <select name="colorOption" class="widforsc"> 
							<c:choose>  
								<c:when test="${!empty Product}">
									<c:forEach var="Product" items="${Product }" varStatus="status">
										<option>${Product.colorOption }</option>
									</c:forEach>
								</c:when>
							</c:choose>
						</select> <br> 
						수량 : <input type="number" name="countProNum"
							style="width: 50%" class="widforn" min="1" max="99" required>
						<br>
						<!-- hidden -->
						<input type="text" value="${Product[0].proNum }" name="proNum"
							class="anone"><br> <input type="text"
							value="${Product[0].price }" name="price" class="anone"><br>
						<!-- submit -->
						<input type="submit" value="구매하기"> <input type="button"
							value='찜하기' onclick='return info_chk2(this.form);' value="찜하기">
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 상품상세 -->
	<div class="card-body">
		<div class="card text-white bg-light my-5 py-4 text-center">
			<ul>
				<li><a href="#proDetails" class="m_link">상품설명</a></li>
				<li>| <a href="#proSpecification" class="m_link">제품규격</a></li>
				<li>| <a href="#refundPolicy" class="m_link">환불규정</a></li>
				<li>| <a href="#review" class="m_link">리뷰</a></li>
			</ul>
			<hr>

			<!-- 상품 상세 -->
			<p class="text-dark m-0" style="text-align: left;">
				<a name="proDetails">상품상세설명</a>
			</p>
			<hr>
			<p class="text-dark m-0">${Product[0].proDetails }</p>
			<hr>

			<!-- 제품규격 -->
			<p class="text-dark m-0" style="text-align: left;">
				<a name="proSpecification">제품규격 </a>
			</p>
			<hr>
			<p class="text-dark m-0">${Product[0].proSpecification }</p>
			<hr>

			<!-- 환불규정 상세내용 -->
			<p class="text-dark m-0" style="text-align: left;">
				<a name="refundPolicy">환불규정 </a>
			</p>
			<hr>
			<p class="text-dark m-0">${Product[0].refundPolicy }</p>
			<hr>
		</div>
	</div>
	<!-- 리뷰 -->
	<div class="card-body">
		<div class="card text-white bg-light my-5 py-4 text-center">
			<!-- 리뷰 -->
			<p class="text-dark m-0" style="text-align: left;">
				<a name="review">리뷰</a>
			</p>
			<hr>
			<table class="text-dark m-0">
				<tr>
					<td width=20%>아이디</td>
					<td width=50%>리뷰</td>
					<td width=50%>작성일</td>
				</tr>
				<c:choose>
					<c:when test="${!empty review}">
						<c:forEach var="review" items="${review }" varStatus="status ">
							<tr>
								<td>${review.id }</td>
								<td>${review.reviewContent }</td>
								<td>${review.reviewDate }</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
			<hr>
		</div>
	</div>
	<!-- Footer-->
	<%@include file="headerfooter/footer.jsp"%>
</body>
</html>
