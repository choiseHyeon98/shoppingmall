<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<html>
<title>ProductList</title>
<!-- favicon -->
<%@include file="./favicon.jsp"%>
<body>
	<!-- body -->
	<!-- header -->
	<%@include file="./header.jsp"%>

	<!-- 페이징 기능 미구현상태. -->

	<!-- 상품 리스트 -->
	<br>
	<br>

	<div class="album py-3 bg-light">
		<h3>${Name }</h3>
		<c:choose>
			<c:when test="${!empty Product}">
				<div>
					<div class="container">
						<div class="row">
							<c:forEach var="Product" items="${Product }" varStatus="status ">
								<div class="col-md-4">
									<div class="card mb-4 shadow-sm">
										<a href="/shop/manager/product/detail?proNum=${Product.proNum }"> <img
											src="/shop/fileDownloadPro?topImage=${Product.topImage}"
											alt=" ${Product.proName }" width="100%" height="240px"></a>
											
										<div class="card-body">
										<c:if test="${Product.soldOut eq 'so'}">
													<p style="color: red">[품절]</p>
													<strike style="color: lightgray"><p class="card-text">${Product.proName }</p></strike>
												</c:if>
												<c:if test="${Product.soldOut ne 'so'}">
													<p class="card-text">${Product.proName }</p>
												</c:if>
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

	<!-- footer -->
	<%@include file="./footer.jsp"%>
</body>