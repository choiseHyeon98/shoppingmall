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
<!-- favicon -->
<link rel=" shortcut icon" href="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small">
<link rel="icon" href="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small">
<style>
#sform {
	width : 350px;
    height : 250px;
    border : 1px solid black;
    display : inline-block;
    text-align: center;
	padding: 30px 25px 10px 25px;
}

.forCenter {
	text-align:center;
}
</style>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<body>
<div style="text-align:center; margin: 31px auto;">
<a href="/shop" class="forcenter" style=" "><img src="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small" alt="logo" style="width: 50px; height=50px;" ></a>
</div>
<div class="forCenter">
<div id = "sform">
<form name="loginForm" action="login" method="post">
<h3> LOGIN </h3>
   <input type="text" name="id" maxlength="10" class="text-field" placeholder="ID"> <br>
   <input type="password" name="pw" maxlength="10" class="text-field" placeholder="PW"> <br><br>

   <input type="submit" value="LOGIN" style="width:254px;"> <br> 

   
   <input type="button" value="REGISTER" onClick="location.href='/shop/member/register'"  style="width:125px;">
   <input type="button" value="FIND ID/PW" onClick="location.href='/shop/member/findIdPw'" style="width:125px;">
   </form>

</div>
</div>
</body>
</html>