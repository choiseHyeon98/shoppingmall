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
	function orderDel(url,orderNum) {
	    var yesno = confirm(orderNum + "를 주문 취소 하시겠습니까? ");
	    
	      if(yesno == true) { 
	         location.href=url+'?orderNum='+orderNum;
	     } else { 
	      	 alert("취소하였습니다");
	     }
	}
	
	function orderUpdate(obj) {
		 var r = confirm("주문관리를 수정하시겠습니까??");
		  if (r == true) {
		  obj.action ="update";
		  obj.submit();
		  } else {
	      
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
						<a class="color-black" href="/shop/s/board/askAdd">> 문의관리</a> <br>
						<a class="color-black" href="/shop/s/board/askAdd">> 리뷰관리</a> <br>
					</p>
				</div>
				<div class="col-lg-8">
					<div>      
						<b>주문자 아이디</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>주문일자</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>주문번호</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>주문항목</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>주문금액</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>결제방법</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>주문현황</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>환불</b>
						<hr>
					</div>
					<form name="orderForm"  >
					<div style="text-align: center; ">
						<div>
							<table style="margin-left: auto; margin-right: auto;">
								<c:choose>
									<c:when test="${!empty orderList}">
										<c:forEach var="orderList" items="${orderList }"
											varStatus="order">
											<tr>
											
												<td class="tdNum" style="width: 30px; text-align: center;">${order.count }</td>
												<td id="tdTitle" style="width: 120%; text-align:center;"><a
													class="color-black" ></a>
													
													<c:if test="${orderList.cancleOrder eq 'c'}" >
													<strike style="color:lightgray">|&nbsp; ${orderList.id }&nbsp;|&nbsp;${orderList.orderDate }&nbsp;|&nbsp;${orderList.orderNum }&nbsp;|&nbsp;${orderList.proNum }&nbsp;|&nbsp;${orderList.tprice }&nbsp;|&nbsp;${orderList.payment }&nbsp;|&nbsp;
													</strike></c:if>
													
 													<c:if test= "${orderList.cancleOrder ne 'c'}" >
													|&nbsp; ${orderList.id }&nbsp;|&nbsp;${orderList.orderDate }&nbsp;|&nbsp;${orderList.orderNum }&nbsp;|&nbsp;${orderList.proNum }&nbsp;|&nbsp;${orderList.tprice }&nbsp;|&nbsp;${orderList.payment }&nbsp;|&nbsp;
 													</c:if>
														<select name="delStatus" >
														<option value=${orderList.delStatus }>${orderList.delStatus }</option>
														<option value="접수">접수</option>
														<option value="출고">출고</option>
														<option value="배송중">배송중</option>
														<option value="배송완료">배송완료</option>
														</select>
														
														<input type="button" value="주문취소" onClick="orderDel('cancle',${orderList.orderNum})">
												</td>
												
											</tr>
										</c:forEach>
									</c:when>
								</c:choose>
							</table>
						</div>
					</div>
					<input type="button" value="주문관리 저장" onClick="orderUpdate(orderForm)" align="center" />
					</form>
				</div>
			</div>
		</div>
	</div>

  <!-- footer -->
	<%@include file="manager/footer.jsp"%>
</body>
</html>