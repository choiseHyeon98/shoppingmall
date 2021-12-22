<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
div {
	width : 400px;
    height : 300px;
    border : 1px solid black;
    posittion: absolute;
    left: 50%;
    top: 50%;
    margin-left: 150px;
    margin-top: 100px;
	text-align: center;
}

p {
	padding: 30px 25px 50px 25px;
}

</style>
<meta charset="UTF-8">
<title>로그인 성공</title>

<script type="text/javascript">
function backToList(obj){
    obj.action="/shop/";
    obj.submit();
  }
</script>

</head>
<body>
<div>
	<p>
	<h2> ${login.name } 님! 반갑습니다!</h2>
	
	<!-- 메인 홈페이지로 가는 URL 버튼 -->
	<input type="button" value="상품 보러가기" onClick="location.href='/shop/'" style="width:250px; height: 30px">
	<input type=button value=""  onClick="backToList(frmArticle)">
<!-- 	로그인 안된 상태에서 찜눌렀을때 로그인하고나서 상품상세로 돌아가기
	<script>
	alert("원래 페이지로 되돌아 갑니다.");
	document.location.href='/shop/product/detail?proNum=${proNum}';
	 
	</script>
 -->	
	</p>
</div>
</body>
</html>