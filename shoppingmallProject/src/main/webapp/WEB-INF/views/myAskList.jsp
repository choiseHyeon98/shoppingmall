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
</head>
<body>



<tr>
	<th style="background-color: #eeeeee; text-align: center;">문의번호</th>
	<th style="background-color: #eeeeee; text-align: center;">제목</th>
	<th style="background-color: #eeeeee; text-align: center;">답변상태</th>

</tr>



<tr>
	<td>${ask.askNum }</td>
	<!-- 게시글 제목을 누르면 해당 글을 볼 수 있도록 링크를 걸어둔다 -->
	<td><a href="myAskOne.jsp?asknNum=askNum"></a>${ask.askTitle }</td>
	<td>${askWhether }</td>

</tr>

	<br>
	<a class="cls1" href="/shop/board/askAdd">글쓰기</a>
	<br>
	<input type="button" value="상품 보러가기" onClick="location.href='/shop/'" style="width:250px; height: 30px">
	

</body>
</html>