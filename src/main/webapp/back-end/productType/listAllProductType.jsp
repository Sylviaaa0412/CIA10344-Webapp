<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.producttype.model.*"%>
<%
    ProductTypeService pdtTypeSvc = new ProductTypeService();
    List<ProductTypeVO> list = pdtTypeSvc.getAll();
    pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>所有商品類別 - listAllProductType.jsp</title>
    <style>
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
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }
        th, td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: #fff;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        input[type="submit"] {
            padding: 8px 16px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-weight: bold;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .button-container {
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 50px;
            margin-top: 20px;
        }
        .button-link {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            border-radius: 4px;
            font-weight: bold;
            text-decoration: none;
            display: inline-block;
            border: none;
            cursor: pointer;
        }
        .button-link:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div id="header">商品類別管理</div>
    <div id="sub-header">類別總覽</div>

    <table>
        <tr>
            <th>類別編號</th>
            <th>類別名稱</th>
            <th>類別描述</th>
            <th>編輯</th>
            <th>刪除</th>
        </tr>
        <c:forEach var="productTypeVO" items="${list}">
            <tr>
                <td>${productTypeVO.pdtTypeId}</td>
                <td>${productTypeVO.pdtTypeName}</td>
                <td>${productTypeVO.pdtTypeDesc}</td>
                <td>
                    <form action="<%=request.getContextPath()%>/productType/productType.do" method="post">
                        <input type="submit" value="編輯">
                        <input type="hidden" name="pdtTypeId" value="${productTypeVO.pdtTypeId}">
                        <input type="hidden" name="action" value="getOne_For_Update">
                    </form>
                </td>
                <td>
                    <form action="<%=request.getContextPath()%>//productType/productType.do" method="post">
                        <input type="submit" value="刪除">
                        <input type="hidden" name="pdtTypeId" value="${productTypeVO.pdtTypeId}">
                        <input type="hidden" name="action" value="delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="button-container">
        <a href='select_page.jsp' class="button-link">查詢商品類別</a>
    </div>
</body>
</html>
