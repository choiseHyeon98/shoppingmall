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
<meta charset="UTF-8">
<title>검색결과</title>
</head>
<!-- favicon -->
<%@include file ="favicon.jsp" %>
<body>
<!-- body -->
<!-- header -->
<%@include file ="header.jsp" %>
<div>
	<p>"${serch }"에 대한 검색 결과입니다.
</div>

<div class="album py-3 bg-light">
	<c:choose>
			<c:when test="${!empty Product}">
				<div>
					<div class="container">
						<div class="row">
							<c:forEach var="Product" items="${Product }" varStatus="status ">
								<div class="col-md-4">
									<div class="card mb-4 shadow-sm">
										<a href="product/detail?proNum=${Product.proNum }"> <img
											src="https://imgscf.slidemembers.com/docs/1/1/45/free_ppt_sample_-_blackboard_and_children_education_44971.jpg"
											alt=" ${Product.proName }" width="100%" height="240px"></a>
										<div class="card-body">
											<p class="card-text">${Product.proName }</p>
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
<%@include file ="footer.jsp" %>
</body>
</html>