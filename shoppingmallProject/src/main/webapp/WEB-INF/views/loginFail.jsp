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
<title>로그인 실패</title>

<h1>로그인에 실패하였습니다</h1>
<h1>ID/PW를 다시 확인해주세요</h1>

 <h1>3초 후 login 페이지로 이동합니다.</h1>

      <script>
         setTimeout(function() {
            location.href = "login";
         }, 3000);
      </script>
<!-- return "redirect:/login" -->

</head>
<body>

</body>
</html>