<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<script>
	function muldelete() {
		// form을 넘김
		var form = document.getElementsByName("muldelForm");
		form[0].submit();
		return true;
	}
</script>

<meta charset="UTF-8">
<title>내 문의 내역</title>

<style>
table {
	border: 1px solid #444444;
	border-collapse: collapse;
	text-align: center;
	justify-content: center;
	width: 100%;
	height: 450px;
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
</style>
<!-- favicon -->
<%@include file="headerfooter/favicon.jsp"%>
</head>
<body>
	<!-- header -->
	<%@include file="headerfooter/header.jsp"%>
	<div class="card-body">
		<div class="container px-4 px-lg-5">
			
					<table align="center" border="1" width="80%">
						<h2>내 문의 내역</h2>
						<p>
							<a class="color-black" href="/shop/board/serviceCenter"> > 자주묻는질문</a> <br>
							<a class="color-black" href="/shop/s/board/askAdd"> > 문의하기</a> <br>
						</p>
							<tr>
								<th style="background-color: #eeeeee; text-align: center;">문의번호</th>
								<th style="background-color: #eeeeee; text-align: center;">제목</th>
								<th style="background-color: #eeeeee; text-align: center;">답변상태</th>

							</tr>
						<c:choose>
							<c:when test="${empty myAskList}">
								<p align="center">
									<span>문의 내역이 없습니다</span>
								</p>
							</c:when>
							
							<c:when test="${!empty myAskList}">
								<c:forEach var="myAskList" items="${myAskList }" varStatus="askNum">
									<tr align="center">
										<td>${myAskList.askNum }</td>
										<!-- 게시글 제목을 누르면 해당 글을 볼 수 있도록 링크를 걸어둔다 -->
										<td><a class="color-black" href="/shop/s/board/askOne?askNum=${myAskList.askNum }">${myAskList.askTitle }</a></td>
										<td>${myAskList.askWhether }</td>
										

									</tr>
								</c:forEach>
							</c:when>
						</c:choose>

					</table>

		</div>
	</div>


		<!-- footer -->
		<%@include file="headerfooter/footer.jsp"%>
</body>
</html>