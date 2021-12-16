<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새로 문의하기</title>
</head>
<body>

	<form method="post">
		<table class="table table-striped"
			style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="2"
						style="background-color: #eeeeee; text-align: center;">문의하기</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" class="form-control" placeholder="글 제목"
						name="askTitle" maxlength="50"></td>
				</tr>
				<tr>
					<td><textarea class="form-control" placeholder="글 내용"
							name="askContent" maxlength="2048" style="height: 350px;"></textarea></td>
				</tr>
			</tbody>
		</table>
		<!-- 글쓰기 버튼 생성 -->
		<input type="submit" value="문의 등록">
	</form>



</body>
</html>