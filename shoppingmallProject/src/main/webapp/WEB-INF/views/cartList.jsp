<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	// form을 넘김
	function muldelete() {
		var form = document.getElementsByName("muldelForm");
		form[0].submit();
		return true;
	}
</script>

<meta charset="UTF-8">
<title>찜 목록</title>

<style>
table {
	border: 1px solid #444444;
	border-collapse: collapse;
	text-align: center;
	justify-content: center;
	width: 100%;

}

td {
	border: 1px solid #444444;
}

.card-body {
	background-color: #fffef5;
	margin: 0 50px 0 50px;
	flex: 1 1 auto;
	padding: 1rem 1rem;
	justify-content: center;
	display: flex;
}

.color-black {
	color: black;
}

p {
	text-align: left;

}

h2 {
text-align: center;
}
</style>

<!-- favicon -->
<%@include file="headerfooter/favicon.jsp"%>

</head>

<body>
<!-- header -->
	<%@include file="headerfooter/header.jsp"%>


	<form name="muldelForm" action="muldelete">


		<div class="card-body">
			<div class="container px-4 px-lg-5">

						<table align="center" border="1" width="80%">
							<h2>찜 목록</h2>
					
							<tr>
								<th>체크박스</th>
								<th>상품이미지</th>
								<th>상품이름/가격/수량/옵션</th>
							</tr>
							<c:choose>
								<c:when test="${empty cartList}">
									<p align="center">
										<span>찜한 상품이 없습니다</span>
									</p>
								</c:when>
								<c:when test="${!empty cartList}">

									<c:forEach var="cartList" items="${cartList }"
										varStatus="cartNum">
										<tr align="center">
											<td><input type="checkbox" name="chkbox"
												value="${cartList.cartNum }"></td>
											<td>${productVO.topImage }</td>
											<td><a href='/shop/product/detail?proNum=${cartList.proNum}'">${cartList.sizeOption },${cartList.colorOption }</a></td>
										</tr>
									</c:forEach>
									<br>
								</c:when>
							</c:choose>


						</table>
						<!--   <button onclick='getCheckboxValue()'>확인</button>
  <input type="submit" value="주문하기" onClick="location.href='/mypage/orderList'"> <br>
 -->
						<input type="button" onclick="getCheckboxValue()" value="주문하기" align="center">
						<input type="button" onclick="return muldelete()" class="cls2"
							value="삭제하기" align="center">



					
				
			</div>
		</div>
	</form>


<!-- footer -->
	<%@include file="headerfooter/footer.jsp"%>
	
</body>

</html>