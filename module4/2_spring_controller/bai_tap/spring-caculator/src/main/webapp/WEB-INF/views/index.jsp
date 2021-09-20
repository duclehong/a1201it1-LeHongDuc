<%--
  Created by IntelliJ IDEA.
  User: PHONG VU
  Date: 9/18/2021
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h1>Caculator</h1>6
<form method="get" action="caculate">
    <input type="text" name="number1" value="${number1}">
    <input type="text" name="number2" value="${number2}">
    <p>
        <input type="submit" name="calculation" value="Addition(+)">
        <input type="submit" name="calculation" value="Subtraction(-)">
        <input type="submit" name="calculation" value="Multiplication(x)">
        <input type="submit" name="calculation" value="Division(/)">
    </p>
</form>
<h2>Resul of ${calcul} is : ${result}</h2>
</body>
</html>
