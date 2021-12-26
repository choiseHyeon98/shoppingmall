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
	function memberDel(obj) {
		 var r = confirm("정말 삭제 하시겠습니까?");
		  if (r == true) {
		  obj.action ="del";
		  obj.submit();
		  } else {
	      
	      }
	}
	
	function memberUpdate(obj) {
		 var r = confirm("회원정보를 수정하시겠습니까??");
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
						<a class="color-black" href="/shop/s/board/askAdd">> 주문관리</a> <br>
						<a class="color-black" href="/shop/s/board/askAdd">> 문의관리</a> <br>
						<a class="color-black" href="/shop/s/board/askAdd">> 리뷰관리</a> <br>
					</p>
				</div>
				<div class="col-lg-8">
					<div>      
						<b>회원 아이디</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>이름</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>전화번호</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>주소</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>이메일</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>등급</b>&nbsp;&nbsp;|&nbsp;&nbsp;
						<b>회원 삭제</b>
						<hr>
					</div>
					<form name="memberForm" method="post" >
					<div style="text-align: center; ">
						<div>
							<table style="margin-left: auto; margin-right: auto;">
								<c:choose>
									<c:when test="${!empty memberList}">
										<c:forEach var="memberList" items="${memberList }"
											varStatus="member">
											<tr>
												<td class="tdNum" style="width: 30px; text-align: center;">${member.count }</td>
												<td id="tdTitle" style="width: 120%; text-align:center;"><a
													class="color-black" ></a>
														${memberList.id }&nbsp;${memberList.name }&nbsp;${memberList.phone }&nbsp;${memberList.address }&nbsp;${memberList.email }&nbsp;
														<select name="rank" >
														<option value="new">new</option>
														<option value="vip">vip</option>
														<option value="vvip">vvip</option>
														<option value="blackList">blackList</option>
														</select>
														<input type="hidden" name="id" value="${memberList.id}" />
														<input type="button" value="회원삭제" onClick="memberDel(memberForm)">
												</td>
											</tr>
										</c:forEach>
									</c:when>
								</c:choose>
							</table>
						</div>
					</div>
					<input type="button" value="회원정보 수정" onClick="memberUpdate(memberForm)" align="center" />
					</form>
				</div>
			</div>
		</div>
	</div>

  <!-- footer -->
	<%@include file="manager/footer.jsp"%>
</body>
</html>