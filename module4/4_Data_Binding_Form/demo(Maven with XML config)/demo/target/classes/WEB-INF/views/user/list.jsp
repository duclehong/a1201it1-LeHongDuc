<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List User</title>
</head>
<body>
	<h1>List User</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Password</th>
			<th>Detail</th>
			<th>Update</th>
		</tr>
		<c:forEach items="${listUser }" var="user">
			<tr>
				<td>${user.userId }</td>
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td><a href="${pageContext.request.contextPath}/detailUser/${user.username }">Detail</a></td>
				<td><a href="${pageContext.request.contextPath}/updateUser/${user.username }">Update</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="createUser">Create new User</a>
</body>
</html>