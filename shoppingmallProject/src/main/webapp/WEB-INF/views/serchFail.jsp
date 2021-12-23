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
<%@include file="headerfooter/favicon.jsp"%>
<style>
.card-body {
	flex: 1 1 auto;
	padding: 1rem 1rem;
	margin: 0px 50px 0px 50px;
	font-family: 'IBM Plex Sans KR', sans-serif;
}
.img {
	width:100px;
	height:100px;
	text-align:center;
}
.forcenter {
	flex: 1 1 auto;
	padding: 1rem 1rem;
	padding: 10px 10px;
}
</style>
<body>
	<!-- body -->
	<!-- header -->
	<%@include file="headerfooter/header.jsp"%>
	<div class="card-body">
		<div class="album py-3 bg-light">
			<div>
				<div class="container">
					<div>
						<p>"${serch }"에 대한 검색 결과입니다.</p>
						<hr>
					</div>
					<div class="row">
						<div class="forcenter">
							<img
								src="https://pbs.twimg.com/media/FHRSRLlaMAQzgNr?format=png&name=small"
								alt="" warning" class="img">
								<br>
							<p>검색결과가 존재하지 않습니다.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<%@include file="headerfooter/footer.jsp"%>
</body>
</html>