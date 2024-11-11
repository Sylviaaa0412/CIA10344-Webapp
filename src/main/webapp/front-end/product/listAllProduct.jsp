<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.model.*"%>
<%-- <%  --%>
<% 
PdtService pdtSvc = new PdtService();
List<PdtVO> productList = pdtSvc.getAll();
pageContext.setAttribute("productList", productList);
%>
<%-- %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品列表</title>
<style type="text/css">
    /* 全局樣式 */
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
    }

    #header {
        background-color: #007bff;
        color: #fff;
        padding: 20px;
        text-align: center;
        font-size: 24px;
        font-weight: bold;
    }

    #sub-header {
        background-color: #e2e6ea;
        color: #333;
        padding: 15px;
        text-align: center;
        font-size: 18px;
        font-weight: bold;
        margin-top: 0px;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    /* 商品列表樣式 */
    .product-list {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        gap: 20px;
        padding: 20px;
    }

    .product-item {
        background-color: #fff;
        border: 1px solid #ddd;
        border-radius: 8px;
        width: 220px;
        text-align: center;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        padding: 15px;
    }

    .product-item h3 {
        font-size: 18px;
        color: #333;
        margin: 10px 0;
    }

    .product-item p {
        font-size: 14px;
        color: #666;
        margin: 5px 0;
    }

    .product-price {
        font-size: 16px;
        color: #007bff;
        font-weight: bold;
        margin: 10px 0;
    }

    .add-to-cart {
        padding: 8px 16px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-weight: bold;
    }

    .add-to-cart:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

    <div id="header">購物網站</div>
    <div id="sub-header">商品列表</div>

    <div class="product-list">
        <c:forEach var="product" items="${productList}">
            <div class="product-item">
                <h3>${pdtVO.pdtName}</h3>
                <p>${pdtVO.pdtDesc}</p>
                <div class="product-price">NT$ ${pdtVO.pdtPrice}</div>
                <form action="<%=request.getContextPath()%>/cart.do" method="post">
                    <input type="hidden" name="productId" value="${pdtVO.pdtId}">
                    <input type="hidden" name="action" value="addToCart">
                    <input type="submit" class="add-to-cart" value="加入購物車">
                </form>
            </div>
        </c:forEach>
    </div>

</body>
</html>
