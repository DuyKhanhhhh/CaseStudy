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

    footer {
        background-color: #f8f8f8;
        padding: 40px 0;
        color: #666;
    }

    .container {
        max-width: 1170px;
        margin: 0 auto;
        padding: 0 15px;
    }

    .row {
        display: flex;
        flex-wrap: wrap;
        margin: -15px;
    }

    .col-md-6,
    .col-md-3 {
        padding: 15px;
    }

    h3 {
        color: #333;
        font-size: 18px;
        font-weight: bold;
        margin-bottom: 20px;
    }

    p {
        font-size: 14px;
        line-height: 1.5;
    }

    ul {
        list-style: none;
        padding: 0;
        margin: 0;
    }

    ul li {
        margin-bottom: 10px;
    }

    ul li a {
        color: #666;
        text-decoration: none;
    }

    ul li a:hover {
        color: #333;
    }

    i {
        margin-right: 10px;
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
                <a href="view/admin.jsp">
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
                <h1 style="background-color: whitesmoke; width: 163px; padding: 10px">Jordan</h1>
                <h2 style="background-color: whitesmoke; width: 320px; padding: 10px">Sell OFF Jordan</h2>
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
        <c:forEach var="list" items="${listProduct}">
            <div class="box">
                <a href="/product?action=add&id=${list.getId()}">
                    <img src="${list.getImg()}">
                </a>
                <h2>${list.getName()}</h2>
                <h2>${list.getPrice()}</h2>
            </div>
        </c:forEach>
    </div>
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h3>About Us</h3>
                    <p>Giày Jordan là dòng sản phẩm giày thể thao mang tên của Michael Jordan, với thiết kế đẳng cấp và
                        sự kết hợp giữa công nghệ và phong cách. Nó là biểu tượng của sự thể thao, thời trang và tinh
                        thần chiến đấu.</p>
                </div>
                <div class="col-md-3">
                    <h3>Quick Links</h3>
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Services</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </div>
                <div class="col-md-3">
                    <h3>Contact Us</h3>
                    <ul>
                        <li><i class="fas fa-map-marker-alt"></i> 207 Xuẩn Đỉnh, Bác Từ Liêm, Hà Nội</li>
                        <li><i class="fas fa-phone"></i> +8466668888</li>
                        <li><i class="fas fa-envelope"></i> vuduykhanhdzvl@gmail.com</li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
</div>
</body>
</html>