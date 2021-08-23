<%--
  Created by IntelliJ IDEA.
  User: duckbui
  Date: 8/23/2021
  Time: 8:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<form>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form class="form-group" method="get" action="/users">
    <label>Input Country</label>
    <input type="text"
           class="form-control" name="findCountry" id="findCountry" aria-describedby="helpId" placeholder="">
    <input type="hidden" id="action" name="action" value="find">
    <input type="submit" value="find Country">
    </form>
    <form class="form-group" method="get" action="/users">
        <label>Sort Name</label>
        <input type="hidden" id="sortUser" name="action" value="sort">
        <input type="submit" value="Sort">
    </form>
</div>

</body>
</html>