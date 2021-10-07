<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update user</title>
</head>
<body>
	<h1>Update user</h1>

	<form:form action="${pageContext.request.contextPath}/updateUser" modelAttribute="user" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><form:button>Submit</form:button></td>
			</tr>
		</table>
		<form:hidden path="userId"/>
	</form:form>
</body>
</html>