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
<title>내 정보</title>
</head>
<body>
내 정보임
<form name="frmArticle" method="post"  action="update"  >
<table style="width:100%">
  <tr>
    <th>id</th>
    <td>${id}</td>
  </tr>
  <tr>
  	<th>pw</th>
    <td>${pw}</td>
  </tr>
  <!-- id/pw는 수정할때 readonly -->
  <tr>
    <th>name</th>
    <td>${name}</td>
  </tr>
  <tr>
    <th>phone</th>
    <td>${phone}</td>
  </tr>
  <tr>
  	<th>address</th>
    <td>${address}</td>
  </tr>
  <tr>
    <th>email</th>
    <td>${email}</td>
  </tr>
  <tr>
    <th>joinDate</th>
    <td>${joinDate}</td>
  </tr>
</table>

   <input type=button value="수정하기" onClick="fn_enable(this.form)"> <br>
   <input type=button value="적용하기" onClick="fn_modify_article(frmArticle)"  ><br> 
</form>
</body>
</html>