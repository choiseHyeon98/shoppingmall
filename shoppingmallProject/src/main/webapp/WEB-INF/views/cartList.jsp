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

<style>
h2 {
text-align: center;
}
</style>

<meta charset="UTF-8">
<title>찜 목록</title>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	// form을 넘김
	function muldelete() {
		var form = document.getElementsByName("muldelForm");
		form[0].submit();
		return true;
	}
</script>
</head>
<!-- header -->
	<%@include file="headerfooter/header.jsp"%>
<body>
	


	<form name="muldelForm" action="muldelete">


		<div class="card-body">
			<div class="container px-4 px-lg-5">
				<div class="row gx-4 gx-lg-5 align-items-center my-5">
					<div class="col-lg-4" style="text-align: left;">
						<table align="center" border="1" width="80%">
							<h2>찜 목록</h2>
					</div>
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
						<input type="button" onclick="getCheckboxValue()" value="주문하기">
						<input type="button" onclick="return muldelete()" class="cls2"
							value="삭제하기">



					
				</div>
			</div>
		</div>
	</form>



	
</body>
<!-- footer -->
	<%@include file="headerfooter/footer.jsp"%>
</html>