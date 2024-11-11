<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.producttype.model.*"%>
<%
	ProductTypeVO productTypeVO = (ProductTypeVO)request.getAttribute("productTypeVO");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>類別資料 - listOneProductType.jsp</title>
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
	        margin-top: 0;
	        border-radius: 5px;
	        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	    }
	    table {
	        width: 80%;
	        margin: 20px auto;
	        border-collapse: collapse;
	        background-color: #fff;
	        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	        border-radius: 5px;
	    }
	    th, td {
	        padding: 12px;
	        text-align: left;
	        border-bottom: 1px solid #ddd;
	    }
	    th {
	        background-color: #007bff;
	        color: white;
	        font-weight: bold;
	        text-align: center;
	    }
	    td {
	        font-size: 16px;
	        text-align: center;
	    }
	    .button-container {
	        display: flex;
	        justify-content: center;
	        margin-top: 20px;
	    }
	    .button-link {
	        background-color: #28a745;
	        color: white;
	        padding: 10px 20px;
	        border-radius: 4px;
	        font-weight: bold;
	        text-decoration: none;
	        border: none;
	        cursor: pointer;
	        font-size: 16px;
	        margin-right:20px;
	    }
	    .button-link:hover {
	        background-color: #218838;
	    }
	    input[type="submit"] {
           	padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            font-weight: bold;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
	</style>
</head>
<body>
	<div id="header">商品類別管理</div>
	<div id="sub-header">類別資料</div>
	<table>
		<tr>
			<th>類別編號</th>
			<th>類別名稱</th>
			<th>類別描述</th>
		</tr>
		<tr>
			<td><%=productTypeVO.getPdtTypeId() %></td>
			<td><%=productTypeVO.getPdtTypeName() %></td>
			<td><%=productTypeVO.getPdtTypeDesc() %></td>
		</tr>
	</table>
	<div class="button-container">
	    <a href='select_page.jsp' class="button-link">商品類別查詢</a>
	    <form action="productType.do" method="post">
            <input type="submit" value="編輯">
            <input type="hidden" name="pdtTypeId" value="${productTypeVO.pdtTypeId}">
            <input type="hidden" name="action" value="getOne_For_Update">
        </form>
	</div>
</body>
</html>