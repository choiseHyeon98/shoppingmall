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

 <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
 <script type="text/javascript" >
 function writeForm() {
	 location.href="/shop/board/askAdd"
 }
 
 
 </script>
 

</head>
<body>

리스트
<table>
<tr>
    <th>글번호</th>
    <th>문의제목</th>
    <th>답변상태</th>
  </tr>
  
  
  <c:forEach items="${myAsklist}" var="askVO">
  <tr>
    <td>${ask.askNum }</td>
    <td>${ask.askTitle }</td>
    <td>${ask.askWhether }</td>

  </tr>
  </c:forEach>
  
  <input type="button" value="새로 문의하기" onClick="writeForm()">
  
</table>
</body>
</html>