<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="static/css/bootstrap.css">
</head>
<body>
<c:if test="${empty customerList}">
    <h2 style="color: brown">
        Customer List Empty
    </h2>
</c:if>
<c:if test="${not empty customerList}">
<table class="table">
    <thead>
    <tr>
        <th>name</th>
        <th>birth day</th>
        <th>address</th>
        <th>image</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td><c:out value="${customer.name}"/></td>
            <td>${customer.birthday}</td>
            <td>${customer.address}</td>
            <td>
                <img src="/static/img/${customer.image}" width="50" height="50"/>
            </td>
        </tr>
    </c:forEach>
    </c:if>
    </tbody>
</table>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
</body>
</html>
