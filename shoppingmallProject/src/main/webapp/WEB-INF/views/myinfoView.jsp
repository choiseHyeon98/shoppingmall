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
<title>Insert title here</title>
</head>
<body>
<table style="width:100%">
  <tr>
    <th>id</th>
    <td>${login.id }</td>
  </tr>
  <tr>
  	<th>pw</th>
    <td>${login.pw }</td>
  </tr>
  <!-- id/pw는 수정할때 readonly -->
  <tr>
    <th>name</th>
    <td><input type=text value="${login.name }" name="name" id="i_name" disabled /></td>
  </tr>
  <tr>
    <th>phone</th>
    <td><input type=text value="${login.phone }" name="phone" id="i_phone" disabled /></td>
  </tr>
  <tr>
  	<th>address</th>
    <td><input type=text value="${login.address }" name="address" id="i_address" disabled /></td>
  </tr>
  <tr>
    <th>email</th>
    <td><input type=text value="${login.email }" name="email" id="i_email" disabled /></td>
  </tr>
  <tr>
    <th>rank</th>
    <td>${login.rank }</td>
  </tr>
</table>
</body>
</html>