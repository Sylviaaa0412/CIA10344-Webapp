<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.producttype.model.*"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>Product Type : Select</title>
	<style type="text/css">
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
        background-color: #e2e6ea; /* 背景色稍微與主標題不同 */
        color: #333;
        padding: 15px;
        text-align: center;
        font-size: 18px;
        font-weight: bold;
        margin-top: 0px;
        border-radius: 5px; /* 圓角效果 */
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 輕微的陰影 */
   		 }
	
	    h4 {
	        color: #333;
	        text-align: center;
	        margin-top: 20px;
	    }
	
	    /* 表單樣式 */
	    form {
	        display: flex;
	        align-items: center;
	        justify-content: center;
	        margin: 10px 0;
	    }
	
	    label {
	        margin-right: 10px;
	        font-weight: bold;
	        color: #333;
	    }
	
	    input[type="text"], select {
	        padding: 8px;
	        border: 1px solid #ccc;
	        border-radius: 4px;
	        width: 200px;
	    }
	
	    input[type="submit"] {
	        padding: 8px 16px;
	        background-color: #007bff;
	        color: white;
	        border: none;
	        border-radius: 4px;
	        cursor: pointer;
	        font-weight: bold;
	        margin-left: 10px;
	    }
	
	    input[type="submit"]:hover {
	        background-color: #0056b3;
	    }
	
	    /* 錯誤訊息樣式 */
	    .error-messages {
	        color: red;
	        text-align: center;
	        margin-top: 20px;
	    }
	
	    .error-messages ul {
	        list-style-type: none;
	        padding: 0;
	        color: red;
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
	
	    /* 調整內容列表樣式 */
	    ul {
	        list-style-type: none;
	        padding: 0;
	        margin: 0;
	    }
	
	    li {
	        text-align: left;
	        margin: 10px 0;
	    }
	
	</style>
</head>
<body>
	<div id="header">商品類別管理</div>
	<div id="sub-header">類別查詢</div>
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color:red">請修正以下錯誤:</font>
		<ul>
		    <c:forEach var="message" items="${errorMsgs}">
				<li style="color:red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	
	<ul>
	
	<li>
		<form method="post" action="productType.do">
			<label for="pdtTypeId_inp">輸入商品類別編號 (如:1) :
			<input type="text" name="pdtTypeId" id="pdtTypeId_inp">
			<input type="hidden" name="action" value="getOne_For_Display">
			<input type="submit" value="查詢">
		</form>
	</li>
	
	<jsp:useBean id="pdtTypeSvc" scope="page" class="com.producttype.model.ProductTypeService" />
	
	<li>
		<form method="post" action="productType.do">
		<label for="pdtTypeId_sel">選擇商品類別編號 :
		<select size="1" name="pdtTypeId" id="pdtTypeId_sel">
			<c:forEach var="productTypeVO" items="${pdtTypeSvc.all}">
				<option value="${productTypeVO.pdtTypeId}">${productTypeVO.pdtTypeId}
			</c:forEach>
		</select>
		<input type="hidden" name="action" value="getOne_For_Display">
		<input type="submit" value="查詢">
		</form>
	</li>
	
	<li>
		<form method="post" action="productType.do">
		<label for="pdtTypeName_sel">選擇商品類別名稱 :
		<select size="1" name="pdtTypeId" id="pdtTypeName_sel">
			 <c:forEach var="productTypeVO" items="${pdtTypeSvc.all}">
			 	<option value="${productTypeVO.pdtTypeId}">${productTypeVO.pdtTypeName}
			 </c:forEach>
		</select>
		<input type="hidden" name="action" value="getOne_For_Display">
		<input type="submit" value="查詢">
		</form>
	</li>
	</ul>
	
	<div class="button-container">
	    <a href='addProductType.jsp' class="button-link">新增商品類別</a>
	    <a href='listAllProductType.jsp' class="button-link">所有商品類別</a>
	</div>
	

</body>
</html>