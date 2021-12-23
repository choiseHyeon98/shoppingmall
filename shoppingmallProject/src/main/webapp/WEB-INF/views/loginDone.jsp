<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
<!-- favicon -->
<link rel=" shortcut icon" href="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small">
<link rel="icon" href="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small">
<!-- script -->
<script type="text/javascript">
function backToList(obj){
    obj.action="/shop/";
    obj.submit();
  }
</script>
<!-- style -->
<style type="text/css">
#sform {
	width : 350px;
    height : 210px;
    border : 1px solid black;
    display : inline-block;
    text-align: center;
	padding: 70px 25px 10px 25px;
}
.forCenter{
	text-align:center;
}
</style>
</head>
<body>
<div style="text-align:center; margin: 31px auto;">
<a href="/shop" class="forcenter" style=" "><img src="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small" alt="logo" style="width: 50px; height=50px;" ></a>
</div>
<div class="forCenter">
<div id="sform">
	<p>
	<h2> ${login.name } 님! 반갑습니다!</h2>
	
	<!-- 메인 홈페이지로 가는 URL 버튼 -->
	<input type="button" value="상품 보러가기" onClick="location.href='/shop/'" style="width:250px; height: 30px">
	</p>
</div>

</div>
</body>
</html>