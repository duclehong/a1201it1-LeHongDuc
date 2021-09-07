<%--
  Created by IntelliJ IDEA.
  User: duckbui
  Date: 9/3/2021
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body >
<div align="center container w-75 p3">
    <div class="container pt-4 ">
        <div class="row">
            <div class="col-sm-4">
                <form class="form-inline" method="get" action="/customer">
                    <input type="hidden" id="action" name="action" value="find">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="findId">
                    <button type="submit" class="btn btn-outline-primary"> Find By ID</button>
                </form>
            </div>
            <div class="col-sm">
                <a href="${pageContext.request.contextPath}/customer">
                    <button type="button " class="btn btn-outline-info">List All Customer</button>
                </a>
            </div>

            <div class="col-sm">
                <a href="/customer?action=create">
                    <button type="button o" class="btn btn-outline-info">Create Customer</button></a>
            </div>
            <div class="col-sm">
                <a href="/services?action=create">
                    <button type="button " class="btn btn-outline-info">Create Service</button></a>
            </div>
            <div class="col-sm">
                <a href="/employee">
                    <button type="button " class="btn btn-outline-info">List Employee</button></a>
            </div>
            <div class="col-sm">
                <a href="/customer?action=create">
                    <button type="button " class="btn btn-outline-info">Create Customer</button></a>
            </div>
        </div>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Type</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>ID Card</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach var="customer" items="${listCutomers}">
            <tr>
                <td><c:out value="${customer.id}"/></td>
                <td><c:out value="${customer.getType()}"/></td>
                <td><c:out value="${customer.getName()}"/></td>
                <td><c:out value="${customer.getBirthday()}"/></td>
                <td><c:out value="${customer.getGender()}"/></td>
                <td><c:out value="${customer.getIdCard()}"/></td>
                <td><c:out value="${customer.getPhone()}"/></td>
                <td><c:out value="${customer.getEmail()}"/></td>
                <td><c:out value="${customer.getAddress()}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/customer?action=edit&id=${customer.id}">
                    <button class="btn btn-outline-primary" >Edit</button>
                    </a>
                     <a href="${pageContext.request.contextPath}/customer?action=delete&id=${customer.id}">
                    <button type="button btn-outline-dark" class="btn btn-secondary">Delete</button>
                </a>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
