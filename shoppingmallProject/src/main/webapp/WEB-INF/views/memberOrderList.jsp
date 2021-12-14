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
<title>Insert title here</title>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
    <script type="text/javascript" >
    	function fn_remove(url,orderNum){
    		var yesno = confirm(orderNum + "를 진짜 삭제하시겠습니까? ");
    	       
            if(yesno == true) { 
               location.href=url+'?orderNum='+orderNum;
           } else { 
              
           }
    		
    	}
    	
    	function fn_mod(obj){
    		obj.action="update";
    		obj.submit();
    		
    	}
    </script>
</head>
<body>
<form name="memberOrder" method="post" action="update">
	<table border="1" width="500px" align="center">
		<tr>
			<th>주문번호</th>
			<th>상품번호</th>
			<th>주문취소</th>
			<th>주분취소 버튼</th>
			<th>배송상태</th>
			<th>배송상태 변경</th>
		</tr>
		
		<c:forEach items ="${orderList }" var="OrderListVO">
			<tr>
				<td align="center">${OrderListVO.orderNum }</td>
				<td>${OrderListVO.proNum }</td>
				<td>${OrderListVO.cancleOrder }</td>
				<td><input type = "button" value="취소하기" onClick="fn_remove('./cancle',${OrderListVO.orderNum })" /></td>
				<td><input type = "text" value=${OrderListVO.delStatus } name="delStatus" /></td>
				<td><input type = "button" value="배송상태변경" onClick="fn_mod(this.form)" /></td>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>