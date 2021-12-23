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
<meta charset="UTF-8">
<title>ID/PW 찾기</title>
</head>
<body>

<h1>아이디 찾기</h1>
<form action="findId" method="post">
<table>
	<tr>
	  <th>name</th>
		<td><input type="text" name="name" maxlength="20" required><br>
		</td>
	</tr>
	<tr>
	  <th>email</th>
		<td><input type="text" name="email" maxlength="100" required>
		</td>
	  
	</tr>

  <input type="submit" value="내 아이디 찾기"><br>

 
</table>
</form>
	

 

<h1>비밀번호 찾기</h1>
<form action="resetPw" method="post">

<table>
	<tr>
	  <th>id</th>
		<td><input type="text" name="id" maxlength="10" required><br>
		</td>
	</tr>
	<tr>
	  <th>name</th>
		<td><input type="text" name="name" maxlength="20" required>
		</td>
	</tr>
	<tr>
	  <th>email</th>
		<td><input type="text" name="email" maxlength="100" required>
		</td>
	</tr>

  <input type="submit" value="내 비밀번호 찾기" ><br>

 
</table>
</form>



</body>
</html>