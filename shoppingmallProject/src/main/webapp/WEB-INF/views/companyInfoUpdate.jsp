<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
   <meta charset="UTF-8">
   <title>companyInfo</title>
   <style>
     #tr_btn_modify{
       display:none;
     }
     
     #i_compInfo {
     	height: 200px;
 		width: 100%;
     }
   
   </style>
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
   <script type="text/javascript" >
   
     function backToList(obj){
       obj.action="../managerHome";
       obj.submit();
     }
 
    function enable(obj){
       document.getElementById("i_compInfo").disabled=false;
       document.getElementById("tr_btn_modify").style.display="block";
       document.getElementById("tr_btn").style.display="none";
     
    }
    
    function fn_modify_article(obj){
       obj.action="./companyInfo";
       obj.submit();
    }
    

 </script>
<!-- favicon -->
<%@include file="manager/favicon.jsp"%>
</head>
<body>
	<!-- header -->
<%@include file="manager/header.jsp"%>
 <form name="companyInfo" method="post"  action="companyInfo" >
  
  	<table  border=3  align="center">
 
 		 <tr>
   		 <td width="70" align="center"  >
    		  회사정보 
  		 </td>
  		 <td width="700px">
    		<input type=text value="${footerVO.compInfo }" name="compInfo"  id="i_compInfo" disabled />
   		</td>   
  		</tr>
 	</table>
 		 <div id="tr_btn_modify" align="center" >
     		
        	   <input type=button value="수정반영하기" onClick="fn_modify_article(companyInfo)"  >
				<input type=button value="취소"  onClick="backToList(companyInfo)">
     		 
  		</div>
    
  		<div  id="tr_btn"  align="center"  >
  		
       		<input type=button value="수정하기" onClick="enable(this.form)">
       		<input type=button value="취소"  onClick="backToList(this.form)">
   		
 	 </div>
 	
  <%@include file="manager/footer.jsp"%>
 </form>
</body>
</html>