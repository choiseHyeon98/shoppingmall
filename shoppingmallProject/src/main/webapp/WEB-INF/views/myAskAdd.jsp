<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새로 문의하기</title>
<!-- favicon -->
<link rel=" shortcut icon"
	href="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small">
<link rel="icon"
	href="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small">
</head>
<style>
.forCenter {
	text-align: center;
	
}
</style>
<body style="background-color: #fffef5;">
	<div style="text-align: center; margin: 31px auto;">
		<a href="/shop" class="forcenter" style=""><img
			src="https://pbs.twimg.com/media/FGeTy0CVEAAK7j9?format=png&name=small"
			alt="logo" style="width: 50px;"></a>
	</div>
	<div class="forCenter">
		<div style="display: inline-block;">
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
							<td><input type="text" class="form-control"
								placeholder="글 제목" name="askTitle" maxlength="50"
								style="width: 450px;"></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용"
									name="askContent" maxlength="2048"
									style="height: 350px; width: 500px;"></textarea></td>
						</tr>
					</tbody>
				</table>
				<!-- 글쓰기 버튼 생성 -->
				<input type="submit" value="문의 등록">
			</form>
		</div>
	</div>
</body>
</html>