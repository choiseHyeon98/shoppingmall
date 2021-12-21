<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그 아웃</title>
</head>
<body>
<!-- 
	<h1> ${login.name } 님! 안녕히 가십시오!</h1>
	 <h1>3초 후 메인 페이지로 이동합니다.</h1>
	<script>
         setTimeout(function() {
            location.href = "/shop";
         }, 3000);
      </script>
 -->      
      <script>
	 alert("${login.name } 님! 안녕히 가십시오! \n 메인 페이지로 이동합니다.");
	 document.location.href="/shop";
	 
	 </script>
</body>
</html>