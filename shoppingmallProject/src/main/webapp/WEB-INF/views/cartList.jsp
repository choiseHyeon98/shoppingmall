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

<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
   <script type="text/javascript" >

   $("input:checkbox[id='${product.proNum }']").prop("checked", true) // 체크박스 체크
   $("input:checkbox[id='${product.proNum }']").prop("checked", false) // 체크박스 해제

   //체크된 값 가져오기
   $("input:checkbox[id='${product.proNum }'']:checked").each(function() {
	   val checkVal = $(this).val();
	   consol.log(checkVal);
   })
   
   function deleteRow(ths){
	    var ths = $(ths);
	    
	    ths.parents("tr").remove();
	}
   </script>
</head>

<body>

무엇에 내가 하트를 눌러놨나아아
<form name='frm' method='post' action="location.href='/mypage/orderList'">

<table>

 <tr>
    <th>체크박스</th><th>상품이미지</th><th>상품이름/가격/수량/옵션</th>
  </tr>
  <tr>
  	<td><input type="checkbox"></td>
  	<td><id="${product.proNum }" name="${product.proName }" value="상품1"></td>
    <td><label for="proNum">${product.proDetails }</label></td>
  </tr>
  <tr>
    <td><input type="checkbox"></td>
  	<td><id="${product.proNum }" name="${product.proName }" value="상품2"></td>
    <td><label for="proNum">${product.proDetails }</label></td>
  </tr>
  <tr>
    <td><input type="checkbox"></td>
  	<td><id="${product.proNum }" name="${product.proName }" value="상품3"></td>
    <td><label for="proNum">${product.proDetails }</label></td>
  </tr>
  <tr>
  	<td><input type="checkbox"></td>
  	<td><id="${product.proNum }" name="${product.proName }" value="상품4"></td>
    <td><label for="proNum">${product.proDetails }</label></td>
  </tr>

</table>
<!--   <button onclick='getCheckboxValue()'>확인</button>
  <input type="submit" value="주문하기" onClick="location.href='/mypage/orderList'"> <br>
 -->
  <input type="button" value="" onclick='getCheckboxValue()'>주문하기
 <input type="button" value="" onclick="deleteRow(this);">삭제

</form>
</body>
</html>