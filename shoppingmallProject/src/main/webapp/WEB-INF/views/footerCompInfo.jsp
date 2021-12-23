<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset="UTF-8">
<title>회사정보</title>
<style>
#tr_btn_modify {
	display: none;
}

#i_tems {
	height: 200px;
	width: 100%;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- favicon -->
<%@include file="headerfooter/favicon.jsp"%>
</head>
<body>
	<!-- header -->
	<%@include file="headerfooter/header.jsp"%>
	<div>
		<table border=3 align="center">
			<tr>
				<td width="50" align="center">${name }</td>
				<td width="700px"><input type=text value="${footerVO.compInfo }" name="tems" id="i_tems" disabled /></td>
			</tr>
		</table>
	</div>
		<!-- footer -->
		<%@include file="headerfooter/footer.jsp"%>

</body>
</html>