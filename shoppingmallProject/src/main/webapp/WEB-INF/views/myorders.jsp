<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 주문 기록</title>
</head>
<body>

나는 그동안 뭘 시켰나아아

<table>

 <tr>
    <th>상품이미지</th><th>상품이름/가격/수량/옵션</th><th>배송현황</th><th>리뷰작성</th>
  </tr>
  <tr>
  	
    
    
    <td>${myOrders.orderNum }</td>
	<td>${myOrders.sizeOption }, ${myOrders.colorOption }</td>
	<td>${myOrders.delStatus }</td>
	<input type="button" value="리뷰작성" onClick="location.href=''">
    </td>
  </tr>
  <tr>
  	<td>${myOrders.orderNum }</td>
	<td>${myOrders.sizeOption }, ${myOrders.colorOption }</td>
	<td>${myOrders.delStatus }</td>
	<input type="button" value="리뷰작성" onClick="location.href=''">
    </td>
  </tr>
  <tr>
  <td>${myOrders.orderNum }</td>
	<td>${myOrders.sizeOption }, ${myOrders.colorOption }</td>
	<td>${myOrders.delStatus }</td>
	<input type="button" value="리뷰작성" onClick="location.href=''">
    </td>
  </tr>
  <tr>
  	<td>${myOrders.orderNum }</td>
	<td>${myOrders.sizeOption }, ${myOrders.colorOption }</td>
	<td>${myOrders.delStatus }</td>
	<input type="button" value="리뷰작성" onClick="location.href=''">
    </td>
  </tr>

</table>



</body>
</html>