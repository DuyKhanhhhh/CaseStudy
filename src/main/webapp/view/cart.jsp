<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: titdzvl
  Date: 10/10/2023
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<html>
<head>
    <title>Cart</title>
    <style>
        .box {
            width: 80%;
            height: 100%;
            margin: 0 auto;
        }

        th {
            text-align: center;
        }

        img {
            width: 150px;
            height: 150px;
        }

        td {
            vertical-align: middle;
            text-align: center;
        }
    </style>
</head>
<body>
<a href="/product">
    <button type="button" class="btn btn-info">Back</button>
</a>
<h1 align="center" style="color: green">🎊Giỏ Hàng🎊</h1>
<div class="box">
    <table class="table table-bordered border-secondary ">
        <tr>
            <th>Ảnh</th>
            <th>Tên Sản Phẩm</th>
            <th>Giá</th>
            <th>Mua Hàng</th>
        </tr>

        <c:forEach var="product" items="${sessionScope['list']}">
            <tr>
                <td><img src="${product.getImg()}"></td>
                <td><h2>${product.getName()}</h2></td>
                <td><h2>${product.getPrice()}</h2></td>
                <td>
                    <a href="view/buy.jsp">
                        <button type="button" class="btn btn-success">Buy</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
