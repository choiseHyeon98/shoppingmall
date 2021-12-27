<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품주문페이지//상품상세-주문</title>
<style>
.outer {
	display: flex;
	justify-content: center;
}

#card-body {
	flex: 1 1 auto;
	padding: 1rem 1rem;
	margin: 0px 50px 0px 50px;
}
</style>
<!-- favicon -->
<%@include file="headerfooter/favicon.jsp"%>
</head>
<body>
	<!-- header -->
	<%@include file="headerfooter/header.jsp"%>

	<div class="card text-black bg-light my-5 py-4 text-center"
		id="card-body">
		<div class="outer">
			<div style="text-align: center;">
				<form method="post" action="/shop/kakaoPay">
					<table cellspacing="0" border="1" class="tb_list mgt">
						<thead>
							<tr>
								<td style="width: 100px;">상품이미지</td>
								<td style="width: 300px;">상품정보</td>
								<td style="width: 150px;">상품금액/수량</td>
								<td style="width: 100px;">배송비</td>
								<td style="width: 100px;">최종결제금액</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<div>
										<div class="thmb">
											<div class="img_center">
												<a href="#" target="_blank"> <img
													src="https://w.namu.la/s/fdeb18748079eec1a3b9e27dc1b5bea0e0a52e22d7517f2e405006d19bdb339d8c876f233afc7b6f42564b33846ca98483a44d9abbabcf5f9c89cd9957193c6f95f4085f292c3ddb48b4acef82c05005"
													alt="${Product.topImage}" style="width: 100px;">
												</a>
											</div>
										</div>
									</div>
								</td>
								<td>
									<div>
										<dl>
											<dt>${Product.proName }</dt>
											<dd name="colorOption">색상:${productOption.colorOption }</dd>
											<dd name="sizeOption">사이즈:${productOption.sizeOption }</dd>
										</dl>
									</div>
								</td>
								<td><em>${productOption.price }</em>원<br> 
									<span name="orderCount">${productOption.countProNum }개</span></td><!-- 상품수량 -->
								<td><em>${Product.delprice }</em>원</td> <!-- 상품 배송비 -->
								<td>총<em>${productOption.price + Product.delprice}</em>원</td> <!-- 상품 최종가격 -->
							</tr>
						</tbody>
					</table>
					<hr>
					<table class="outer">
						<tr>
							<td>배송지</td>
							<td style="width: 300px;"><input type="text"
								name="shippingAddress" value="${memberVO.address }"></td>
						</tr>
						<tr>
							<td>수령인</td>
							<td><input type="text" name="Recipient" value="${memberVO.name }"></td>
						</tr>
						<tr>
							<td>연락처</td>
							<td><input type="text" name="delPhone" value="${memberVO.phone }"></td>
						</tr>
						<tr>
							<td>배송메모</td>
							<td><input type="text" name="delMemo"></td>
						</tr>
						<tr>
							<td>결제수단</td>
							<td><input type="text" name="payment" value="카카오페이" disabled></td>
						</tr>
					</table>
					<!-- 보내는 정보값 -->
						<input type="text" name="proNum" value="${Product.proNum }" hidden>
						<input type="text" name="proName" value="${Product.proName }" hidden>
						<input type="text" name="tprice" value="${productOption.price + Product.delprice}" hidden>
						<input type="text" name="colorOption" value="${productOption.colorOption }" hidden>
						<input type="text" name="sizeOption" value="${productOption.sizeOption }" hidden>
						<input type="text" name="orderCount" value="${productOption.countProNum }" hidden>
						<input type="text" name="payment" value="kakaopay" hidden>
					<input type="submit" value="결제하기"> <input type="button"
						value="취소하기"
						onClick="location.href='/shop/product/detail?proNum=${Product.proNum}'">
				</form>
			</div>
		</div>
	</div>
	<!-- footer -->
	<%@include file="headerfooter/footer.jsp"%>
</body>
</html>