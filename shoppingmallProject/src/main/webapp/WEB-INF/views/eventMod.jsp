<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
   <meta charset="UTF-8">
   <title>글보기</title>
   <style>
     #tr_btn_modify{
       display:none;
     }
   
   </style>
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
   <script type="text/javascript" >
     function backToList(obj){
       obj.action="list";
       obj.submit();
     }
 
    function fn_enable(obj){
       document.getElementById("eventTitle").disabled=false;
       document.getElementById("eventContent").disabled=false;
       //document.getElementById("i_imageFileName").disabled=false;
       document.getElementById("tr_btn_modify").style.display="block";
       document.getElementById("tr_btn").style.display="none";
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
  <form name="frmArticle" method="post"  action="mod" >
  <table  border=0  align="center">
  <tr>
    <td width="150" align="center" bgcolor="#FF9933">
      이벤트 번호
   </td>
   <td>
    <input type=text value="${eventVO.eventNum }"  name="eventNum"  readonly />
   </td>   
  </tr>
  
  <tr>
    <td width="150" align="center" bgcolor="#FF9933">
      제목 
   </td>
   <td>
    <input type=text value="${eventVO.eventTitle }"  name="eventTitle"  id="eventTitle" disabled />
   </td>   
  </tr>
  <tr>
    <td width="150" align="center" bgcolor="#FF9933">
      내용
   </td>
   <td>
    <textarea rows="20" cols="60"  name="eventContent"  id="eventContent"  disabled />${eventVO.eventContent }</textarea>
   </td>  
  </tr>
 
<c:if test="${not empty eventVO.eventImg && eventVO.eventImg!='null' }">  
<tr>
    <td width="150" align="center" bgcolor="#FF9933"  rowspan="2">
      이미지
   </td>
   <td>
     <input  type= "hidden"   name="eventImg" value="${eventVO.eventImg }" />
    <img src="${contextPath}/download.do?articleNO=${eventVO.eventNum}&imageFileName=${eventVO.eventImg}" id="preview"  /><br>
       
   </td>   
  </tr>  
  <tr>
    <td>
       <input  type="file"  name="eventImg " id="eventImg"   disabled   onchange="readURL(this);"   />
    </td>
  </tr>
 </c:if>
 
  <tr id="tr_btn_modify"  >
      <td colspan="2"   align="center" >
          <input type=button value="수정반영하기" onClick="fn_modify_article(frmArticle)"  >
           <input type=button value="취소"  onClick="backToList(frmArticle)">
      </td>   
  </tr>
    
  <tr  id="tr_btn"    >
   <td colspan="2" align="center">
       <input type=button value="수정하기" onClick="fn_enable(this.form)">
       <input type=button value="삭제하기" onClick="fn_remove_article(this.form)">
       
   </td>
  </tr>
 </table>
 </form>
</body>
</html>