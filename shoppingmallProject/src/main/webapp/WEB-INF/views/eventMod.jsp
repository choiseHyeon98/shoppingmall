<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
   <meta charset="UTF-8">
   <title>eventMod</title>
   <style>
     #tr_btn_modify{
       display:none;
     }
   
   </style>
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
   <script type="text/javascript" >
     function backToList(obj){
       obj.action="../managerHome";
       obj.submit();
     }
 
   
    function fn_modify_article(obj){
       obj.action="mod";
       obj.submit();
    }
    
    function fn_remove_article(obj){
    	 
   	      var r = confirm("삭제하시겠습니까?");
    	  if (r == true) {
    	    obj.action="del";
    	    obj.submit();
    	  } else {
    	    
    	  }

    }
    
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#preview').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }  
    
    function deleteImg(obj) {
    	
    	obj.action="fileDel";
    	obj.submit();
    }
    
    
   
 </script>
 <!-- favicon -->
<%@include file="manager/favicon.jsp"%>
</head>
<body>
<!-- header -->
	<%@include file="manager/header.jsp"%>
<h1 align="center">${event.eventTitle}</h1>
  <form name="eventMod" action="mod" method="post"  enctype="multipart/form-data">
 
	<div>
 		<input type="hidden" name="eventNum" value="${event.eventNum}"  />
	</div>
 <c:if test="${not empty event.eventImg && event.eventImg!='null' }">  
   
   <div align="center" >
      이미지
  </div>
  <div align="center">
   <input type="hidden"  name="eventImg" value="${event.eventImg }" />
    <img src="/shop/fileDownload?eventImg=${event.eventImg}" id="preview" src="#" width=200 height=200  /><br>
    <input type="button" value="파일삭제" onClick="deleteImg(eventMod)" />
   </div>   

  </c:if>
  <c:if test="${event.eventImg =='null' }">
   
  <div align="center" >
      <p>이미지</p>
   <input type="hidden"  name="eventImg" value="${event.eventImg }" />
   <img src="/shop/fileDownload?eventImg=${event.eventImg}" id="preview" src="#" width=200 height=200  />
   <input type="file"  name="uploadEventImage" id="eventImg" onchange="readURL(this);" />
 </div>
</c:if>
  <div align="center" > 
   <p>제목</p>
    <input type=text value="${event.eventTitle }" name="eventTitle"  id="eventTitle" />
  </div>  
    <div align="center" >
      <p>내용</p>
    <textarea name="eventContent"  id="eventContent" rows="30" cols="50"/>${event.eventContent }</textarea>
   </div>  
      <div align="center" >
     	  
          <input type="button" value="수정반영하기" onClick="fn_modify_article(eventMod)">
          <input type="button" value="취소" onClick="backToList(eventMod)">
          <input type="button" value="삭제" onClick="fn_remove_article(eventMod)">
          
      </div>
  

 <!-- footer -->
<%@include file="manager/footer.jsp"%>
 </form>
</body>
</html>