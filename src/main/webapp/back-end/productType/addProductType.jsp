<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.producttype.model.*"%>

<% 
   ProductTypeVO productTypeVO = (ProductTypeVO) request.getAttribute("productTypeVO");
%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>商品類別新增 - addProductType.jsp</title>
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
        form {
            width: 50%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            margin: 0 auto;
        }
        td {
            padding: 12px;
            text-align: left;
            font-size:16px;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-top: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
        }
        .button-container {
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 20px;
            margin-top: 20px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-weight: bold;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .button-link {
            background-color: #dc3545;
            color: white;
            padding: 10px 20px;
            border-radius: 4px;
            font-weight: bold;
            text-decoration: none;
            display: inline-block;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }
        .button-link:hover {
            background-color: #c82333;
        }
	</style>

</head>
<body>
	<div id="header">商品類別管理</div>
	<div id="sub-header">類別新增</div>
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color:red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color:red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	
	<form action="productType.do" method="post" name=form1>
		<table>
			<tr>
				<td>類別名稱:</td>
				<td><input type="text" name="pdtTypeName" value="<%=(productTypeVO==null)? "" : productTypeVO.getPdtTypeName()%>"></td>
			</tr>
			<tr>
				<td>類別描述:</td>
				<td><input type="text" name="pdtTypeDesc" value="<%=(productTypeVO==null)? "" : productTypeVO.getPdtTypeDesc()%>"></td>
			</tr>
		</table>
		<br>
		<div class="button-container">
			<input type="hidden" name="action" value="insert">
			<input type="submit" value="送出新增">
			<a href = "select_page.jsp" class="button-link">返回首頁</a>
		</div>
		
	</form>
</body>
</html>