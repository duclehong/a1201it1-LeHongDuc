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
<c:if test="${empty studentList}">
    <h2 style="color: brown">
        Customer List Empty
    </h2>
</c:if>
<c:if test="${not empty studentList}">
<table class="table">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>gender</th>
        <th>point</th>
        <th>image</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td><c:out value="${student.id}"/></td>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>${student.point}</td>
            <td>
                <img src="/static/img/${student.image}" width="50" height="50"/>
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
