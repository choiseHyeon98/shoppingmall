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

<style>

</style>

<meta charset="UTF-8">
<title>회원 가입</title>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
<script type="text/javascript">


function fn_idCheck(){
    $.ajax({
      url : "/shop/member/register/idCheck",
      type : "post",
      dataType : "json",
      data : {"id" : $("#id").val()},
      success : function(data){
        if(data != 0){
          alert("중복된 아이디입니다.");
        }else if(data == 0){
          $("#idCheck").attr("value", "Y");
          alert("사용가능한 아이디입니다.");
        }
      }
    })
  }

</script>
</head>
<body>



<form name="frmLogin" action="register" method="post">
	<input type="text" name="id" maxlength="10" class="text-field" placeholder="ID" required>
	<button class="idCheck" type="button" id="idCheck" onclick="fn_idCheck();" value="N">중복체크</button><br>
	<input type="text" name="pw" maxlength="20" class="text-field" placeholder="PW" required><br>
	<input type="text" name="name" maxlength="20" class="text-field" placeholder="NAME" required><br>
	<input type="text" name="phone" maxlength="12" class="text-field" placeholder="PHONE" ><br>
	<input type="text" name="address" maxlength="100" class="text-field" placeholder="ADDRESS" required><br>
	<input type="text" name="email" maxlength="100" class="text-field" placeholder="EMAIL"><br> 
	
	<input type="submit" value="회원가입">
	<input type="reset" value="초기화">
</form>
</body>

</html>