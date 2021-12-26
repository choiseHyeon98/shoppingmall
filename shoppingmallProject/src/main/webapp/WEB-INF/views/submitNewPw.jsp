<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#sform {
	width : 350px;
    height : 200px;
    border : 1px solid black;
    display : inline-block;
    text-align: center;
	padding: 30px 25px 10px 25px;
}

.forCenter {
	text-align:center;
}

th {
	font-size: 15px;
}
</style>
<meta charset="UTF-8">
<title>비밀번호 재설정</title>
 <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
<script type="text/javascript">

	function passConfirm() {
		var pw = document.getElementById('pw').value;
		var btn = document.getElementById('btn');
		
		if (document.getElementById('pw').value==document.getElementById('pwConfirm').value) {
			
				document.getElementById('check').innerHTML='비밀번호 일치'
				document.getElementById('check').style.color='blue'
				btn.disabled=false;

			} else {
				document.getElementById('check').innerHTML='비밀번호 불일치'
				document.getElementById('check').style.color='red'
				btn.disabled=true;
			}
	}

    function fn_modify_article(obj){
       obj.action="/shop/ylhqlalfqjsghwotjdwjdfldzmwlfhd";
       obj.submit();
    }
    

 </script>
</head>
<body>
<div class="forCenter">
<div id = "sform">
<form name="frmArticle" action="/shop/ylhqlalfqjsghwotjdwjdfldzmwlfhd" method="post">
<h3>새로운 비밀번호를 입력해주세요</h3>
<table>
<tr>
  <th>새 비밀번호</th>
  <td> <input type="text" name="pw" id="pw" maxlength="10" onchange="passConfirm()" required ></td>
</tr>
<tr>
  <th>새 비밀번호 확인</th>
  <td> <input type="text" name="pwConfirm" id="pwConfirm" maxlength="10" onchange="passConfirm()" required>
  &nbsp;<br><span id="check"></span>
  </td>
</tr>

</table>

<tr   id="tr_btn_modify"  >
      <td colspan="2"   align="center" >
          <input type=button value="비밀번호 재설정" id="btn" onClick="fn_modify_article(frmArticle)" disabled="">
          
      </td>   
  </tr>
</form>

</div>
</div>

</body>
</html>