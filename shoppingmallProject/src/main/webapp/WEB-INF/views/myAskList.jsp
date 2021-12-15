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
<title>내 문의 내역</title>

리스트
<table>
<tr>
    <th>글번호</th><th>문의제목</th><th>답변상태</th>
  </tr>
  <tr>
  	<td><id="${ask.askNum }"></td>
  	<td><id="${product.proNum }" name="${ask.askTitle }" value="문의 1"></td>
    <td><label for="askWhether">${ask.askWhether }</label></td>
  </tr>
  <tr>
  	<td><id="${ask.askNum }"></td>
  	<td><id="${product.proNum }" name="${ask.askTitle }" value="문의 2"></td>
    <td><label for="askWhether">${ask.askWhether }</label></td>
  </tr>
  <tr>
  	<td><id="${ask.askNum }"></td>
  	<td><id="${product.proNum }" name="${ask.askTitle }" value="문의 3"></td>
    <td><label for="askWhether">${ask.askWhether }</label></td>
  </tr>
  <tr>
  	<td><id="${ask.askNum }"></td>
  	<td><id="${product.proNum }" name="${ask.askTitle }" value="문의 4"></td>
    <td><label for="askWhether">${ask.askWhether }</label></td>
  </tr>
  
</table>

<input type="button" value="새로 문의하기" onClick="location.href='/board/askAdd'">

</head>
<body>

</body>
</html>