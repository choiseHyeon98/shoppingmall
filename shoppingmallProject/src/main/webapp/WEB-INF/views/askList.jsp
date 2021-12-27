<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
<title>management</title>
<style>
table {
	border-collapse: collapse;
	text-align: center;
	justify-content: center;
}

td {
	text-align: left;
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
.col-lg-4{
	text-align: left;
	padding:10px;
	width:80%;
}
</style>
<script>
function askComment(url,askNum) {
    var yesno = confirm("답글을 입력하시겠습니까? ");
    
      if(yesno == true) { 
         location.href=url+'?askNum='+askNum;
     } else { 
      	 alert("취소하였습니다");
     }
}
	
	
	
	
</script>
	

<!-- favicon -->
	<%@include file="manager/favicon.jsp"%>
</head>
<body>
<!-- header -->
<%@include file="manager/header.jsp"%>
<div class="card-body">
		<div class="container px-4 px-lg-5" >
			<div class="row gx-4 gx-lg-5 align-items-center my-5">
				<div class="col-lg-4" width="80%">
					<h2>관리 페이지</h2>
					<small>Manager Service</small>
					<p>
						<a class="color-black" href="/shop/manager/member/list">> 회원관리</a> <br> 
						<a class="color-black" href="/shop/manager/order/list">> 주문관리</a> <br>
						<a class="color-black" href="/shop/manager/ask/list">> 문의관리</a> <br>
						<a class="color-black" href="/shop/s/board/askAdd">> 리뷰관리</a> <br>
					</p>
				</div>
				<div class="col-lg-8">
					<div>      
						<b>문의 유형</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>문의 제목</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>회원아이디</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>현황</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>답변</b>
						<hr>
					</div>
					<form name="askForm" method="post" >
					<div style="text-align: center; ">
						<div>
							<table style="margin-left: auto; margin-right: auto;">
								<c:choose>
									<c:when test="${!empty askList}">
										<c:forEach var="askList" items="${askList }"
											varStatus="ask">
											<tr>
											<table>
											<tr>
												<td class="tdNum" style="width: 30px; text-align: center;">${ask.count }</td>
												<td id="tdTitle" style="width: 120%; text-align:center;"><a
													class="color-black" ></a>
														|&nbsp; ${askList.askContent }&nbsp;|&nbsp;${askList.askTitle }&nbsp;|&nbsp;${askList.id }&nbsp;|&nbsp;${askList.askWhether }&nbsp;|&nbsp;
														
														<input type="button" value="답글달기" onClick="askComment('comment','${askList.askNum}')">
												</td>
												</tr>
												</table>
											</tr>
										</c:forEach>
									</c:when>
								</c:choose>
							</table>
						</div>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>

  <!-- footer -->
	<%@include file="manager/footer.jsp"%>
</body>
</html>