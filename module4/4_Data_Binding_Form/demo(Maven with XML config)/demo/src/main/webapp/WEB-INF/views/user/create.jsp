<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new user</title>
</head>
<body>
	<h1>Create new user</h1>
	
	<form:form action="createUser" modelAttribute="user" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password"/></td>
			</tr>
			<tr>
				<td colspan="2"><form:button>Submit</form:button> </td>
			</tr>
		</table>
	</form:form>
</body>
</html>