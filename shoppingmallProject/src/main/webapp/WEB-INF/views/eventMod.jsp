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
      /*  var form = document.createElement("form");
       form.setAttribute("method", "get");
       form.setAttribute("action", url);
        var articleNOInput = document.createElement("input");
        articleNOInput.setAttribute("type","hidden");
        articleNOInput.setAttribute("name","articleNO");
        articleNOInput.setAttribute("value", articleNO);
       
        form.appendChild(articleNOInput);
        document.body.appendChild(form);
        form.submit();
     */
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
    
    
   
 </script>
</head>
<body>
<h1 align="center">${eventVO.eventTitle}</h1>
  <form name="eventMod" action="mod" method="post"  enctype="multipart/form-data">
  <table  border=0  align="center">
  <tr>
  	<td width="150" align="center">
  		이벤트 등록 번호
  	</td>
 	<td>
 		<input type="text" value="${event.eventNum }" disabled />
 		<input type="hidden" name="eventNum" value="${event.eventNum}"  />
 	</td>
 </tr>
   <tr>
    <td width="150" align="center" rowspan="2">
      이미지
   </td>
  <td>
   <input type="hidden"  name="eventImg" value="${event.eventImg }" />
    <img src="/shop/fileDownload?eventImg=${event.eventImg}" id="preview" src="#" width=200 height=200  /> 
   </td>     
  </tr>  
  <tr>
    <td>
       <input type="file"  name="uploadEventImage" id="eventImg" onchange="readURL(this);" />
    </td>
  </tr>
  <tr>
    <td width="150" align="center" >
      제목 
   </td>
   <td>
    <input type=text value="${event.eventTitle }" name="eventTitle"  id="eventTitle" />
   </td>   
  </tr>
  <tr>
    <td width="150" align="center" >
      내용
   </td>
   <td>
    <textarea rows="20" cols="60"  name="eventContent"  id="eventContent" />${event.eventContent }</textarea>
   </td>  
  </tr>
  <tr>
      <td colspan="2"  align="center" >
     	  
          <input type="button" value="수정반영하기" onClick="fn_modify_article(eventMod)">
          <input type="button" value="취소" onClick="backToList(eventMod)">
          
      </td>   
  </tr>
 </table>
 
 </form>
</body>
</html>