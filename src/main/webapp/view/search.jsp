<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/892d14366e.js" crossorigin="anonymous"></script>
    <title>WorK Shop</title>
</head>
<style>
    #head {
        width: 100%;
        height: 80px;
        margin-bottom: 10px;
    }

    #head-link {
        text-align: center;
        width: 100%;
        height: 350px;
        margin-bottom: 10px;
    }

    #content {
        width: 80%;
        height: 100%;
        margin-left: 10%;
        margin-right: 10%;
        margin-top: 5px;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;

    }

    #footer {
        width: 100%;
        background-color: black;
        padding-top: 10px;
    }

    #main {
        margin-left: auto;
        margin-right: auto;
        padding: 0;
        width: 100%;
    }

    #banner {
        width: 100%;
        height: 350px;
        padding: 40px 100px;
        text-align: left;
        color: black;
    }

    .box {
        width: 25%;
        padding: 20px;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
    }

    .box img {
        width: 100%;
    }

    .box img:hover {
        opacity: 0.5;
        box-shadow: 6px 6px 4px #888888;
    }

    .box h2 h2 button {
        word-wrap: normal;
        padding: 10px;
    }
</style>
<body>
<div id="main">
    <div id="head">
        <nav class=" navbar bg-body-tertiary">
            <div class="container">
                <a href="/product">
                    <img
                            src="https://d1csarkz8obe9u.cloudfront.net/posterpreviews/sneaker-store-logo-brand-logo-design-template-ea9c8040d69fa064feee3014cb8e9827_screen.jpg?ts=1645976739"
                            alt="Logo" width="100px" height="80px" style="float: left">
                </a>
                <form class="d-flex" method="post" action="/product?action=search">
                    <input name="name" size="70px" class="form-control me-2" type="search" placeholder="Search"
                           aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
                <a href="view/cart.jsp"><i class="fa-solid fa-cart-shopping" style="font-size: 25px"></i></a>
            </div>
        </nav>
    </div>

    <div id="head-link">
        <div id="banner"
             style="background-image:url(https://static.sneakerjagers.com/news/nl/2021/11/LandingPage_Banners_Sneaker-1440x416-1-1024x296.jpg)">
            <div id="bgColorBanner">
                <h1 style="background-color: whitesmoke; width: 163px; padding: 10px">Sneaker</h1>
                <h2 style="background-color: whitesmoke; width: 320px; padding: 10px">Sell OFF Chào Đông</h2>
                <p style="background-color: whitesmoke; width: 600px; padding: 10px">
                    Chuẩn bị cho mùa đông với những đôi giày thời trang và ấm áp tại cửa hàng của chúng tôi! Hãy nhanh
                    tay mua sắm ngay để có cơ hội nhận ưu đãi đặc biệt trong sự kiện 'Đại tiệc Sale Off Giày Đầu Đông'
                    của chúng tôi. Khám phá các lựa chọn thời trang và chất lượng với giá cực kỳ hấp dẫn. Đừng bỏ lỡ cơ
                    hội này!
                </p>
            </div>
        </div>
    </div>

    <div id="content">
        <c:forEach var="list" items="${searchProduct}">
            <div class="box">
                <a href="/product?action=add&id=${list.getId()}">
                    <img src="${list.getImg()}">
                </a>
                <h2>${list.getName()}</h2>
                <h2>${list.getPrice()}</h2>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>