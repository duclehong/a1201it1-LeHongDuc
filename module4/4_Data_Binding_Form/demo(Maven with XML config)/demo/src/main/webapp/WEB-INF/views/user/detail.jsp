<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View detail User</title>
</head>
<body>
	Detail User
	<table>
		<tr>
			<td>ID</td>
			<td>${user.userId }</td>
		</tr>
		<tr>
			<td>User name</td>
			<td>${user.username }</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>${user.password }</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/listUser">Back to List User</a>
</body>
</html>