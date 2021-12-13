<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		.cls1{
			text-decoration: none;
		}
		.cls2{
			text-align:center;
			font-size:30px;
		}
	</style>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
    <script type="text/javascript" >
    
    function fn_remove_article(url,orderNum){

        var yesno = confirm(orderNum + "를 진짜 삭제하시겠습니까? ");
       
          if(yesno == true) { 
             location.href=url+'?orderNum='+orderNum;
         } else { 
            
         }
    }
    
    function fn_enable(obj){
    	obj.action="update";
    	obj.submit();
    	
    }
    </script>
</head>
<body>
<form name="memberOrderList" method="post">
	<table align="center" border="1" width="80%">
		<tr height="10" align="center" bgcolor="lightgray">
			<td>선택</td>
			<td>글번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>작성일</td>
		</tr>
		<c:choose>
			<c:when test="${!empty orderList }">
				<c:forEach var="orderList" items="${orderList }" varStatus="orderNum">
					<tr align="center">
						<td width="5%">${orderList.orderNum }</td>
						<td width="10%">${orderList.id }</td>
						<td align="left" width="35%">
							<span style="padding-right:30px"></span>
							<c:choose>
								<c:when test="${orderList.orderNum>1 }">
									<c:forEach begin="1" end="${orderList.orderNum }" step="1">
										<span style="padding-left:20px"></span>
									</c:forEach>
									 <tr  id="tr_btn" >
  										<td colspan="2" align="center">
  										  <a class='cls1' href="cancel?orderNum=${orderList.orderNum}">${orderList.proNum}</a>
       									  <input type=button value="삭제하기" onClick="fn_remove_article('./cancle', ${orderList.orderNum})">
   										</td>
   										<td><input type=text value=${orderList.delStatus } name="delStatus">
   										<input type=button value="수정하기" onClick="fn_enable(memberOrderList)">
   										</td>
   									</tr>	
                   						 
								</c:when>
						
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
</form>
	
</body>
</html>