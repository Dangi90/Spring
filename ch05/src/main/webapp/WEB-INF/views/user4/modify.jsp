<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User4::modify</title>
</head>
<body>
<h3>User4 수정</h3>

<a href="/ch05/">처음으로</a>
<a href="/ch05/user4/list">목록</a>

<form action="/ch05/user4/modify" method="post">
	<table border="4">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="uid" value="${user4DTO.uid}" readonly/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${user4DTO.name}"/></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="text" name="gender" value="${user4DTO.gender}"/></td>
		</tr>
		<tr>
			<td>휴대폰</td>
			<td><input type="number" name="age" value="${user4DTO.age}"/></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="hp" value="${user4DTO.hp}"/></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="addr" value="${user4DTO.addr}"/></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="수정하기"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>