<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
if(${ret}==1){
	alert("찜 완료!");
}else{
	alert("찜 실패!");
}

window.location.href = '/shop/product/detail?proNum=${proNum}';
</script>
<p>이페이지는 나오지 않습니다.</p>


</body>
</html>