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

h3 {
    text-align: center;
}
</style>

<meta charset="UTF-8">
<title>회원 가입</title>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
<script type="text/javascript">

 /*
function fn_idCheck(form){
	alert(form);
    $.ajax({
      url : "/shop/member/register/idCheck?id=",
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

  function fn_idCheck(obj){
	 alert("obj"+obj);
	   
      if(yesno == true) { 
         location.href=url+id;
     } else { 
      
     }
  }

  function info_chk2(frm) {
      if (confirm("찜하시겠습니까?")) {
         frm.action = '/shop/s/mypage/addCartList';
         frm.submit();
         return true;
      }
   }

 <input type="button"
                     value='찜하기' onclick='return info_chk2(this.form);' value="찜하기">
  
  
*/

</script>
</head>
<body>

<div class="forCenter">
<div id = "sform">
<form name="frmLogin" action="register" method="post">
	<h3>회원가입</h3>
	<input type="text" name="id" maxlength="10" class="text-field" placeholder="ID" required>
	<button class="idCheck" type="button" name="idCheck" onclick="fn_idCheck(this.form);" value="N">중복체크</button><br>
	<input type="text" name="pw" maxlength="20" class="text-field" placeholder="PW" required><br>
	<input type="text" name="name" maxlength="20" class="text-field" placeholder="NAME" required><br>
	<input type="text" name="phone" maxlength="12" class="text-field" placeholder="PHONE" ><br>
	<input type="text" name="address" maxlength="100" class="text-field" placeholder="ADDRESS" required><br>
	<input type="text" name="email" maxlength="100" class="text-field" placeholder="EMAIL"><br> 
	
	<input type="submit" value="회원가입">
	<input type="reset" value="초기화">
</form>

</div>
</div>
</body>

</html>