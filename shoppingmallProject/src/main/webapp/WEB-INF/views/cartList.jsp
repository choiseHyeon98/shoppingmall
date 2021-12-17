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
<title>찜 목록</title>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function muldelete() {

	// form을 넘김

	var form = document.getElementsByName("muldelForm");

	form[0].submit();

	return true;

}

	
</script>
</head>

<body>
	무엇에 내가 하트를 눌러놨나아아
<form name="muldelForm" action="muldelete">


<table>
		<tr>
			<th>체크박스</th>
			<th>상품이미지</th>
			<th>상품이름/가격/수량/옵션</th>
		</tr>
<c:choose>
	<c:when test="${empty cartList}">
		<span>찜한 상품이 없습니다</span>
	</c:when>
	<c:when test="${!empty cartList}">
	  <c:forEach var="cartList" items="${cartList }" varStatus="proNum">
		  <td><input type="checkbox" name="chkbox" value="${cartList.proNum }"></td>
		  <td>${productVO.topImage }</td>
		  <td>${cartList.sizeOption }, ${cartList.colorOption }</td>
	  </c:forEach> <br>
	</c:when>

</c:choose>


</table>
		<!--   <button onclick='getCheckboxValue()'>확인</button>
  <input type="submit" value="주문하기" onClick="location.href='/mypage/orderList'"> <br>
 -->
		<input type="button" onclick="getCheckboxValue()"  value="주문하기">
		<input type="button" onclick="return muldelete()"  value="삭제">
</form>
</body>
</html>