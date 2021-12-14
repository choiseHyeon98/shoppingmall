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
  	<td><id="orderNum" name="주문번호1" value="주문번호1"></td>
    <td><label for="proNum">고객이 선택한 옵션 값을 여기에</label></td>
    <td> ${orderList.delStatus } </td>
    <td>배송완료 되면 리뷰 작성 버튼 생긴다
    <input type="button" value="리뷰작성" onClick="location.href=''">
    </td>
  </tr>
  <tr>
  	<td><id="orderNum" name="주문번호12" value="주문번호2"></td>
    <td><label for="proNum">고객이 선택한 옵션 값을 여기에</label></td>
    <td> ${orderList.delStatus } </td>
    <td>배송완료 되면 리뷰 작성 버튼 생긴다
    <input type="button" value="리뷰작성" onClick="location.href=''">
    </td>
  </tr>
  <tr>
  	<td><id="orderNum" name="주문번호3" value="주문번호3"></td>
    <td><label for="proNum">고객이 선택한 옵션 값을 여기에</label></td>
    <td> ${orderList.delStatus } </td>
    <td>배송완료 되면 리뷰 작성 버튼 생긴다
    <input type="button" value="리뷰작성" onClick="location.href=''">
    </td>
  </tr>
  <tr>
  	<td><id="orderNum" name="주문번호4" value="주문번호4"></td>
    <td><label for="proNum">고객이 선택한 옵션 값을 여기에</label></td>
    <td> ${orderList.delStatus } </td>
    <td>배송완료 되면 리뷰 작성 버튼 생긴다
    <input type="button" value="리뷰작성" onClick="location.href=''">
    </td>
  </tr>

</table>



</body>
</html>