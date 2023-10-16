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
<style>
    .box{
        width: 90%;
        margin: 0 auto;
    }
    td {
        vertical-align: middle;
        font-size: 24px;
    }
    th{
        font-size: 30px;
    }
</style>
<body>
<a href="/product">
    <button type="button" class="btn btn-info">Back</button>
</a>
<a href="/product?action=create">
    <input type="button" class="btn btn-success" value="Create">
</a>
<div class="box">
    <h1 align="center">Giao Diện Admin</h1>
    <table class="table table-Info table-striped-columns">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Img</th>
            <th>Action</th>
        </tr>

        <c:forEach var="list" items="${listProduct}">
            <tr>
                <td>${list.getId()}</td>
                <td>${list.getName()}</td>
                <td>${list.getPrice()}</td>
                <td><img width="100px" height="100px" src="${list.getImg()}"></td>
                <td>
                    <a href="/product?action=edit&id=${list.id}"><button class="btn btn-light">EDIT</button></a>
                    <a href="/product?action=delete&id=${list.id}"><button class="btn btn-light">DELETE</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
