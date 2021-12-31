<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성 창</title>

<!-- favicon -->
<link rel=" shortcut icon"
	href="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small">
<link rel="icon"
	href="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small"> 
	
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

function readURL(input) {
   if (input.files && input.files[0]) {
      var reader = new FileReader();
      reader.onload = function (e) {
        $('#preview').attr('src', e.target.result);
       }
      reader.readAsDataURL(input.files[0]);
   }
}  
function backToList(obj){
 obj.action="/shop";
 obj.submit();a
}

</script>

</head>

<style>
.forCenter {
	text-align: center;
}

.left {
	text-align: left;
}
</style>
<body>



		<div style="text-align: center; margin: 31px auto;">
		<a href="/shop" class="forcenter" style=""><img
			src="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small"
			alt="logo" style="width: 50px;"></a>
	</div>
	<div class="forCenter">
		<div style="display: inline-block; ">
			<form action="/shop/s/mypage/addReview" method="post">
				
                <table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">리뷰 작성하기</th>
						</tr>
					</thead>
					<tbody>
					<tr>
						<td><input type="text" class="form-control"
								value="${login.id }" id="id" name="id" readonly
								style="width: 450px;" ></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control"
								value="${review.proNum }" id="proNum" name="proNum" readonly 
								style="width: 450px;"></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="리뷰를 남겨주세요"
									id="reviewContent" name="reviewContent" maxlength="2048"
									style="height: 150px; width: 450px;"></textarea></td>
						</tr>
					
						<tr>
							<td style="text-align: left;">이미지파일 첨부:  </td>
                        </tr>
                        <tr>
       						<td><input type="file" id="reviewPhoto" name="reviewPhoto"  onchange="readURL(this);" /></td>
                        </tr>
                        <tr>
         					<td><img  id="preview" src="#"   width=200px height=200px/></td>
						</tr>
					
					</tbody>
				</table>
				<input type="submit" value="리뷰 등록하기">
				<input type=button value="홈으로" onClick="backToList(this.form)" />
			</form>
		</div>
	</div>

		

		

</body>
</html>