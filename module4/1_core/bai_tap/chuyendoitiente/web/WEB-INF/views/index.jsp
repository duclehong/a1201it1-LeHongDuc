<%--
  Created by IntelliJ IDEA.
  User: duckbui
  Date: 9/17/2021
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Converter</title>
</head>
<body>
<form action="/usd" method="post">
  <label>Rate: </label>
  <input type="text" name="rate" value="22000" placeholder="Rate"/><br>
  <label>USD: </label>
  <input type="text" name="usd" placeholder="USD" value="0"/><br>
  <input type="submit" id="submit" value="Converter"/>
</form>
</body>
</html>