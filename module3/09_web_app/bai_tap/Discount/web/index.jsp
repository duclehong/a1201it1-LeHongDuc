<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 8/7/2021
  Time: 2:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Currency Converter</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Currency Converter</h2>
<form action="/convert" method="post">
  <label>Product Description: </label><br/>
  <input type="text" name="description" placeholder="description" /><br/>
  <label>List Price: </label><br/>
  <input type="text" name="price" placeholder="price" /><br/>
  <label>Discount Percent: </label><br/>
  <input type="text" name="discount" placeholder="USD" value="0"/><br/>
  <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>