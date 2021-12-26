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
<title>내 문의 상세 보기</title>

<style>
table {
	border: 1px solid #444444;
	border-collapse: collapse;
	text-align: center;
	justify-content: center;
	width: 100%;
	height: 450px;
}

td {
	border: 1px solid #444444;
}
.card-body {
	background-color: #fffef5;
	margin: 0 50px 0 50px;
	flex: 1 1 auto;
	padding: 1rem 1rem;
	justify-content: center;
	display: flex;
}
</style>

   <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
   <script type="text/javascript" >
     function backToList(obj){
       obj.action="/board/askList";
       obj.submit();
     }
 
    
 </script>

</head>
<body>

	<div class="card-body">
		<div class="container px-4 px-lg-5">
			<div class="row gx-4 gx-lg-5 align-items-center my-5">
				<div class="col-lg-4" style="text-align: left;">

<form name="frmArticle" method="post"  action="update"  >
  <table border=0  align="center">
  <tr>
   <td width=150 align="center">
      문의번호
   </td>
   <td >
    <input type="text"  value="${ask.askNum }"  disabled />
   </td>
  </tr>
  <tr>
    <td width="150" align="center">
      작성자 아이디
   </td>
   <td >
    <input type=text value="${ask.id }" name="writer"  disabled />
   </td>
  </tr>
  <tr>
    <td width="150" align="center">
      제목 
   </td>
   <td>
    <input type=text value="${ask.askTitle }"  name="title"  id="i_title" disabled />
   </td>   
  </tr>
  <tr>
    <td width="150" align="center">
      내용
   </td>
   <td>
    <textarea rows="20" cols="40"  name="content"  id="i_content"  disabled />${ask.askContent }</textarea>
   </td>  
  </tr>
 

  <tr   id="tr_btn_modify"  >
      <td colspan="2"   align="center" >
           <input type=button value="취소"  onClick="backToList(frmArticle)">
      </td>   
  </tr>
    
  <tr  id="tr_btn"    >
   <td colspan="2" align="center">
       <input type=button value="리스트로 돌아가기"  onClick="backToList(this.form)">
      
   </td>
  </tr>
 </table>
 </form>
 </div>
 </div>
 </div>
 </div>
 

</body>
</html>