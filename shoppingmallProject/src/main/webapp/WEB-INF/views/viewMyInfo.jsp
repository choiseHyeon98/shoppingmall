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
    height : 300px;
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

<head>
<meta charset="UTF-8">
<title>내 정보</title>

 <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
   <script type="text/javascript" >
     function backToList(obj){
       obj.action="/shop/";
       obj.submit();
     }
 
    function fn_enable(obj){
       document.getElementById("i_name").disabled=false;
       document.getElementById("i_phone").disabled=false;
       document.getElementById("i_address").disabled=false;
       document.getElementById("i_email").disabled=false;
       document.getElementById("tr_btn_modify").style.display="block";
       document.getElementById("tr_btn").style.display="none";
    }
    
    function fn_modify_article(obj){
       obj.action="update";
       obj.submit();
    }
    

 </script>


</head>
<body>


<div class="forCenter">
<div id = "sform">
<form name="frmArticle" method="post">
<h3>내 정보</h3>
<table style="width:100%">
  <tr>
    <th>id</th>
    <td><input type="text" value="${login.id }" name="id" readonly></td>
  </tr>
  <tr>
  	<th>pw</th>
    <td><input type="text" value="${login.pw }" name="pw" readonly></td>
  </tr>
  <!-- id/pw는 수정할때 readonly -->
  <tr>
    <th>name</th>
    <td><input type="text" value="${membeR[0].name }" name="name" id="i_name" disabled /></td>
  </tr>
  <tr>
    <th>phone</th>
    <td><input type="text" value="${membeR[0].phone }" name="phone" id="i_phone" disabled /></td>
  </tr>
  <tr>
  	<th>address</th>
    <td><input type="text" value="${membeR[0].address }" name="address" id="i_address" disabled /></td>
  </tr>
  <tr>
    <th>email</th>
    <td><input type="text" value="${membeR[0].email }" name="email" id="i_email" disabled /></td>
  </tr>
  <tr>
    <th>rank</th>
    <td>${membeR[0].rank }</td>
  </tr>
</table>
 
    
  <tr  id="tr_btn"    >
   <td colspan="2" align="center">
       <input type=button value="수정하기" onClick="fn_enable(this.form)">
       <input type=button value="홈페이지로"  onClick="backToList(this.form)">
   </td>
  </tr><br>
 
  <tr   id="tr_btn_modify"  >
      <td colspan="2"   align="center" >
          <input type=button value="수정반영하기"   onClick="fn_modify_article(frmArticle)"  >
           <input type=button value="취소"  onClick="backToList(frmArticle)">
      </td>   
  </tr>
 
</form>
</div>
</div>
</body>
</html>