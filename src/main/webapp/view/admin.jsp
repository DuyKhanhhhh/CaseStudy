<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: titdzvl
  Date: 11/10/2023
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CRUD</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<a href="/product">
    <button type="button" class="btn btn-info">Back</button>
</a>
<a href="/product?action=create">
    <input type="button" class="btn btn-success" value="Create">
</a>
<table class="table table-dark table-striped-columns">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Img</th>
        <th>Action</th>
    </tr>
    <c:forEach var="list" items="${listProduct}">
        <tr>
            <td>${list.getName()}</td>
            <td>${list.getPrice()}</td>
            <td><img src="${list.getImg()}"></td>
            <td>
                <a href="/product?action=edit&id=${list.id}">Edit</a>
                <a href="/product?action=delete&id=${list.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
