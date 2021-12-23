<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="icon" type="image/png" href="http://example.com/myicon.png">

<title>새상품 등록</title>

<script>
	function readURL(input) {
	      if (input.files && input.files[0]) {
	         var reader = new FileReader();
	         reader.onload = function (e) {
	           $('#preview').attr('src', e.target.result);
	          }
	         reader.readAsDataURL(input.files[0]);
	      }
	  }  
	
	function readURLpro(input) {
	      if (input.files && input.files[0]) {
	         var reader = new FileReader();
	         reader.onload = function (e) {
	           $('#previewPro').attr('src', e.target.result);
	          }
	         reader.readAsDataURL(input.files[0]);
	      }
	  }  

	
	
	function addoption(obj) {
		
		var div = document.createElement('div');
		div.innerHTML = document.getElementById("option").innerHTML;
		document.getElementById('optionAdd').appendChild(div);
	
		
		}


	
	function deleteOption(obj) {
		 document.getElementById('optionAdd').removeChild(obj.parentNode);
		 
		}
	
	
</script>


<!-- Core theme CSS (includes Bootstrap)-->
<link rel="stylesheet" type="text/css" >
<style>
.card-body {
	flex: 1 1 auto;
	padding: 1rem 1rem;
	margin: 0px 30px 0px 30px;
}

#card-body {
	flex: 1 1 auto;
	padding: 1rem 1rem;
	margin: 0px 30px 0px 30px;
}

.anone {
	display: none;
}


</style>

<!-- favicon -->
<%@include file="manager/favicon.jsp"%>
</head>
<body>
	<!-- header -->
	<%@include file="manager/header.jsp"%>
	<h1 align="center">새 상품 등록</h1>
	<!-- 상품 이미지, 상품 주문form -->
	<div class="card-body">
		<div class="container px-4 px-lg-5">
			<!-- Heading Row-->
			<div class="row gx-4 gx-lg-5 align-items-center my-5">
				<div class="col-lg-7">
					<img  id="preview" src="#" width=300 height=300/>
				</div>
				<div class="col-lg-5">
					<form action="add"  method="post" enctype="multipart/form-data">
						제품명: <input type="text" name="proName"><br><br>
						상품간략설명: <input type ="text" name="proContent"><br><br>
						가격:   <input type="text" name="price"><br><br>
						배송비: <input type="text" name="delprice" ><br><br>
					
						색상: <input type="text" name="colorOption" size="10"><br><br>
						옵션 추가<button onClick="addoption(this)">+</button><br>
						<div id="option">
						사이즈: <input type="text" name="sizeOption" size="10">
						<button onClick="deleteOption(this)" id="delete" >-</button>
						</div>
						<div id="optionAdd">
						</div><br>
						 수량 : <input type="number" name="countProNum"
							size="10"min="0" max="99" required> <br><br>
						 concept option <select name="proCon" id="proCon">
						 		<option value="Causal" >Causal</option>
						 		<option value="Office" >Office</option>
						 		<option value="Feminine" >Feminine</option>
						 		<option value="Hip" >Hip</option>
						 		<option value="Vintage" >Vintage</option>
						 </select><br><br>
						  Kategorie <select name="proCate" id="proCate">
						 		<option value="top" >top</option>
						 		<option value="bottom" >bottom</option>
						 		<option value="shose" >shose</option>
						 		<option value="acc" >acc</option>
						 </select> <br><br>

						<!-- submit -->
						
						<input type="file" name="uploadFileTop" onchange="readURL(this);"/>
						
					
				</div>
			</div>
		</div>
	</div>

	<!-- 상품상세 -->
	<div class="card-body">
		<div class="card text-white bg-light my-5 py-4 text-center">
			<ul>
				<li><a href="#proDetails" class="m_link">상품설명</a></li>
				<li>| <a href="#proSpecification" class="m_link">제품규격</a></li>
				<li>| <a href="#refundPolicy" class="m_link">환불규정</a></li>
				<li>| <a href="#review" class="m_link">리뷰</a></li>
			</ul>
			<hr>

			<!-- 상품 상세 -->
			<p class="text-dark m-0" style="text-align: left;">
				<a name="proDetails">상품상세설명</a>
			</p>
			<hr>
			<input type="text" name="proDetails" />
			<img id="previewPro" src="#" width=300 height=300/>
			<input type="file" name="uploadFileDetail" onchange="readURLpro(this);"/>
			<hr>

			<!-- 제품규격 -->
			<p class="text-dark m-0" style="text-align: left;">
				<a name="proSpecification">제품규격 </a>
			</p>
			<hr>
			<input type="text" name="proSpecification" />
			<hr>

			<!-- 환불규정 상세내용 -->
			<p class="text-dark m-0" style="text-align: left;">
				<a name="refundPolicy">환불규정 </a>
			</p>
			<hr>
			<input type="text" name="refundPolicy">
			<hr>
		</div>
	</div>
	<input type="submit" value="상품등록" />
	</form>
	
	<!-- 리뷰 -->
	<div class="card-body">
		<div class="card text-white bg-light my-5 py-4 text-center">
			<!-- 리뷰 -->
			<p class="text-dark m-0" style="text-align: left;">
				<a name="review">리뷰</a>
			</p>
			<hr>
			<table class="text-dark m-0">
				<tr>
					<td width=20%>아이디</td>
					<td width=50%>리뷰</td>
					<td width=50%>작성일</td>
				</tr>
				<c:choose>
					<c:when test="${!empty review}">
						<c:forEach var="review" items="${review }" varStatus="status ">
							<tr>
								<td>${review.id }</td>
								<td>${review.reviewContent }</td>
								<td>${review.reviewDate }</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</table>
			<hr>
		</div>
	</div>

	<!-- footer -->
	<%@include file="manager/footer.jsp"%>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
