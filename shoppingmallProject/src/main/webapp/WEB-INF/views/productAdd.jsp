<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글등록</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
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
 </script>
</head>
<body>
	<h1>글 쓰기</h1>
	<hr>
	<form name="addForm" action="add" method="post" enctype="multipart/form-data">
		
		<table border="1">
		
			<tr>
				<td bgcolor="orange" width="70">proNum</td>
				<td align="left"><input type="text" name="proNum" /></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">proName</td>
				<td align="left"><input type="text" name="proName" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">proContent</td>
				<td align="left"><input type="text" name="proContent" size="10" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">proDetails</td>
				<td align="left"><textarea name="proDetails" cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">topImage</td>
				<td align="left"><textarea name="topImage" cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">price</td>
				<td align="left"><textarea name="price" cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">delprice</td>
				<td align="left"><textarea name="delprice" cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">proCon</td>
				<td align="left"><textarea name="proCon" cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">proCate</td>
				<td align="left"><textarea name="proCate" cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">업로드</td><td align="left">
				<input type="file" name="uploadFile" onchange="readURL(this);" /></td>
				 <td><img id="preview" src="#" width=200 height=200/></td>
			</tr>
		
			<tr>
				<td colspan="2" align="center"><input type="submit" value="글 쓰기" /></td>
			</tr>
			
		</table>
	</form>
	<hr>
	<a href="getBoardList.do">글 목록 가기</a>
</body>
</html>