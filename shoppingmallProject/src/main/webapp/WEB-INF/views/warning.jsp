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
<title>잘못된 접근입니다.</title>
<!-- favicon -->
 <%@include file="headerfooter/favicon.jsp"%> 
<!-- favicon -->
<link rel=" shortcut icon" href="https://pbs.twimg.com/media/FHRQ9rRagAESgC_?format=png&name=small">
<link rel="icon" href="https://pbs.twimg.com/media/FHRQ9rRagAESgC_?format=png&name=small">
<style>
#card-body {
	flex: 1 1 auto;
	padding: 1rem 1rem;
	margin: 0px 50px 0px 50px;
	text-align: center;
}

.button {
	flex: 1 1 auto;
	text-align: center;
	width: 150px;
	font-family: 'IBM Plex Sans KR', sans-serif;
	font-size: 15px;
}

.forcenter {
	
	flex: 1 1 auto;
	padding: 1rem 1rem;
	padding: 10px 10px;
}

#middleTitle {
	font-family: 'IBM Plex Sans KR', sans-serif;
	font-size: 20px;
}

.img {
	width:50px;
	height:50px;
	text-align:center;
}

</style>
</head>
<body>
	<!-- header -->
	<%@include file="headerfooter/header.jsp"%>
	<div>
		<div class="card text-black bg-light my-5 py-4 text-center"
			id="card-body">
			<div class="forcenter">
			<img src="https://pbs.twimg.com/media/FHRQ9rRagAESgC_?format=png&name=small" alt=""warning" class="img">
			</div>
			<hr>
			<h3 id="middleTitle">잘못된 요청입니다!</h3>
			<div class="forcenter">
				<input type="button" class="button"
					onclick='location.href="/shop"' value="홈페이지로 돌아가기">
			</div>
		</div>
	</div>
	<!-- Footer-->
	<%@include file="headerfooter/footer.jsp"%>
</body>
</html>