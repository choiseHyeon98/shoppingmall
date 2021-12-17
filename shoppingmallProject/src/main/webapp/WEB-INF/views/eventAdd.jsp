<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<meta charset="UTF-8">
<title>글쓰기창</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
   function readURL(input) {
      if (input.files && input.files[0]) {
         var reader = new FileReader();
         reader.onload = function (e) {
           $('#preview').attr('src', e.target.result);
          }
         reader.readAsDataURL(input.files[0]);
      }
  }  
  function backToList(obj){
    obj.action="managerHome";
    obj.submit();a
  }
</script>
 <title>새글 쓰기 창</title>
	<!-- favicon -->
	<%@include file="headerfooter/favicon.jsp"%>
</head>
<body>
<!-- header -->
<%@include file="manager/header.jsp"%>

<h1 style="text-align:center">이벤트 등록</h1>
  <form name="eventForm" method="post" action="add" enctype="multipart/form-data">
    <table border="0" align="center">
    <tr>
      <td align="right" valign="top">이벤트제목: </td>
      <td colspan=2><textarea name="eventTitle" rows="1" cols="65" maxlength="20" required></textarea> </td>
     </tr>
    <tr>
      <td align="right" valign="top">이벤트 설명: </td>
      <td colspan=2><textarea name="eventContent" rows="10" cols="65" maxlength="3000" required></textarea> </td>
     </tr>
     <tr>
        <td align="right">이미지파일 첨부:  </td>
        <td> <input type="file" name="uploadEventImage"  onchange="readURL(this);" /></td>
         <td><img  id="preview" src="#"   width=200 height=200/></td>
    </tr>
    <tr>
       <td align="right"> </td>
       <td colspan="2">
          <input type="submit" value="글쓰기" />
          <input type=button value="목록보기" onClick="backToList(this.form)" />
       </td>
     </tr>
    </table>
  </form>
  <!-- footer -->
	<%@include file="headerfooter/footer.jsp"%>
</body>
</html>