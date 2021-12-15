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

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
    
     </script>

</head>
<body>

		리뷰 작성해라

		<tr>
			<td width=150 align="center" bgcolor=#FF9933>리뷰번호</td>
			<td><input type="text" value="${ask.askNum }" disabled />
				<input type="hidden" name="articleNO" value="${ask.askNum}" />
			</td>
		</tr>
		<tr>
			<td width="150" align="center" bgcolor="#FF9933">작성자 아이디</td>
			<td><input type=text value="${ask.id }" name="writer"
				disabled /> <input type=text value="${member.name }" name="writer"
				disabled /></td>
		</tr>
		<tr>
			<td width="150" align="center" bgcolor="#FF9933">내용</td>
			<td><textarea rows="20" cols="60" name="content" id="i_content"
					disabled />${ask.askContent }</textarea></td>
		</tr>
		
		이미지 첨부  +  이미지 추가
		
		<input type="submit" value="리뷰 등록하기">

		

</body>
</html>