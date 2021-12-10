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
<title>찜 목록</title>
</head>
<body>

무엇에 내가 하트를 눌러놨나아아

<table>

 <tr>
    <th>체크박스</th><th>상품이미지</th><th>상품이름/가격/수량/옵션</th>
  </tr>
  <tr>
  	<td><input type="checkbox"></td>
  	<td><id="proNum" name="상품1" value="상품1"></td>
    <td><label for="proNum">고객이 선택한 옵션 값을 여기에</label></td>
  </tr>
  <tr>
    <td><input type="checkbox"></td>
  	<td><id="proNum" name="상품2" value="상품2"></td>
    <td><label for="proNum">고객이 선택한 옵션 값을 여기에</label></td>
  </tr>
  <tr>
    <td><input type="checkbox"></td>
  	<td><id="proNum" name="상품3" value="상품3"></td>
    <td><label for="proNum">고객이 선택한 옵션 값을 여기에</label></td>
  </tr>
  <tr>
  	<td><input type="checkbox"></td>
  	<td><id="proNum" name="상품4" value="상품4"></td>
    <td><label for="proNum">고객이 선택한 옵션 값을 여기에</label></td>
  </tr>

</table>

 <input type="submit" value="주문하기" onClick="location.href=''"> <br>
 <button type="button" onclick="deleteRow(this);">찜한 상품 삭제</button> 
 <!-- 스크립트 부분에 onclick 선언해야한다 -->

</body>
</html>