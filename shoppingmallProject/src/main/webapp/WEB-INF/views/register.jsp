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

<style>
#sform {
	width : 350px;
    height : 250px;
    border : 1px solid black;
    display : inline-block;
    text-align: center;
	padding: 30px 25px 10px 25px;
}

.forCenter {
	text-align:center;
}

h3 {
    text-align: center;
}
</style>

<meta charset="UTF-8">
<title>회원 가입</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script> 

/*id 중복입력 방지 function*/
$(document).ready(function() {
	//selector : css/Jpuery  .class, #id, tag, *
    $('#userId').change(function() {//event action .change
        $.ajax({
                type: 'POST',
                url: '/shop/dupId',
                dataType: "json",
                data: {"id": $('#userId').val()},
                success: function(data) {
                   // alert('성공:' + data.id);
                   if(data.id == 'false') { 
                	   alert('사용 가능한 아이디입니다. 아이디는 3자리 이상 10자리 이하로 작성해주세요. 한글을 사용할 수 없습니다.'); 
                	   $('#userId').css("background-color", "lightyellow");
					} else { 
                      alert('중복된 아이디입니다.');
                      // 입력한 값을 지우고 
                      // focus 를 다시 이동하고
                      $('#userId').val("");
                      $('#userId').focus();
                      $('#userId').css("background-color", "darkgray");
                   }
                }, 
                error: function(request,status,error) {
                   alert('에러!! : ' + request.responseText + ":"+error);
                }
         }); //end ajax 
    }); //end on 
});

function testId(obj){
    var a = $('#userId').val().replace(/ [가-힣] /gi, '');
    $('#userId').val(a);
    }
function testPw(obj){
    var a = $('#pw').val().replace(/ /gi, '');
    $('#pw').val(a);
    }
function testName(obj){
    var a = $('#name').val().replace(/ /gi, '');
    $('#name').val(a);
    }
    
function testPhone(obj){
    var a = $('#phone').val().replace(/ /gi, '');
    $('#phone').val(a);
    }
function testAddress(obj){
    var a = $('#address').val().replace(/ /gi, '');
    $('#address').val(a);
    }
function testEmail(obj){
    var a = $('#email').val().replace(/ /gi, '');
    $('#email').val(a);
    }

</script>

</head>
<body>

<div class="forCenter">
<div id = "sform">
<form name="frmLogin" action="register" method="post">
	<h3>회원가입</h3>
	<input type="text" name="id" id="userId" pattern="[a-zA-z0-9].{3,10}" title="아이디는 3자리 이상 10자리 이하로 작성해주세요. 한글을 사용할 수 없습니다."class="text-field" placeholder="ID" onkeyup="testId(this);" required><br>
	<input type="text" name="pw" id="pw" pattern="[a-zA-z0-9].{8,20}" title="비밀번호는 8자리 이상 20자리 이하로 작성해주세요." class="text-field" placeholder="PW" onkeyup="testPw(this);" required><br>
	<input type="text" name="name" id="name"  pattern="[가-힣].{1,20}" class="text-field" placeholder="NAME" title="아이디는 한글만, 최대 20자 입력 가능합니다." onkeyup="testName(this);" required><br>
	<input type="text" name="phone" id="phone"  pattern="[0-9].{10,20}" title="전화번호는 숫자만 입력해주세요." class="text-field" placeholder="PHONE" onkeyup="testPhone(this);" required><br>
	<input type="text" name="address" id="address" maxlength="100" class="text-field" placeholder="ADDRESS" onkeyup="testAddress(this);" required><br>
	<input type="text" name="email" id="email" maxlength="100" class="text-field" placeholder="EMAIL" onkeyup="testEmail(this);" required><br> 
	
	<input type="submit" value="회원가입">
	<input type="reset" value="초기화">
</form>

</div>
</div>
</body>

</html>