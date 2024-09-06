<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User5::list</title>
</head>
<body>
	<h3>User5 목록</h3>
	<a href="/ch05/">처음으로</a>
	<a href="/ch05/user5/register">등록</a>
	<table border="5">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>성별</th>
			<th>나이</th>
			<th>주소</th>
			<th>관리</th>
		</tr>
        <c:forEach var="user" items="${users}">
        <tr>
			<td>${user.seq}</td>
			<td>${user.name}</td>
			<td>${user.gender}</td>
			<td>${user.age}</td>
			<td>${user.addr}</td>
			<td>
				<a href="/ch05/user5/modify?uid=${user.seq}">수정</a>
				<a href="/ch05/user5/delete?uid=${user.seq}">삭제</a>
			</td>
		</tr>
        </c:forEach>
	</table>
</body>
</html>





