package com.producttype.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.PdtService;
import com.producttype.model.ProductTypeService;
import com.producttype.model.ProductTypeVO;

/**
 * Servlet implementation class productTypeServlet
 */

public class ProductTypeServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if("getOne_For_Display".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
//			接受請求
			String str = req.getParameter("pdtTypeId");
			if(str == null || (str.trim().length() == 0)) {
				errorMsgs.add("請輸入商品類別編號");
			}
			
			if(!errorMsgs.isEmpty()) {
				RequestDispatcher failureView =req
						.getRequestDispatcher("/back-end/productType/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			
			Integer pdtTypeId = null;
			try {
				pdtTypeId=Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("商品類別編號格式不正確");
			}
			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/productType/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			
//			查詢資料
			ProductTypeService productTypeSvc = new ProductTypeService();
			ProductTypeVO productTypeVO = productTypeSvc.getOneProductType(pdtTypeId);
			if(productTypeVO == null) {
				errorMsgs.add("查無資料");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/productType/select_page.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
//			查詢完成
			req.setAttribute("productTypeVO", productTypeVO);
			String url = "/back-end/productType/listOneProductType.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
				
		}
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
			Integer pdtTypeId = Integer.valueOf(req.getParameter("pdtTypeId"));
				
				/***************************2.開始查詢資料****************************************/
				ProductTypeService productTypeSvc = new ProductTypeService();
				ProductTypeVO productTypeVO = productTypeSvc.getOneProductType(pdtTypeId);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("productTypeVO", productTypeVO);         // 資料庫取出的empVO物件,存入req
				String url = "/back-end/productType/update_productType_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_productType_input.jsp
				successView.forward(req, res);
		}
		
//		update
		if("update".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			Integer pdtTypeId = Integer.valueOf(req.getParameter("pdtTypeId").trim());
			String pdtTypeName = req.getParameter("pdtTypeName");
			String pdtTypeNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$"; //正則表達式:2~10中英數字
			
			if(pdtTypeName == null || pdtTypeName.trim().length() == 0) {
				errorMsgs.add("商品類別名稱請勿空白。");
			}else if(!pdtTypeName.trim().matches(pdtTypeNameReg)) {
				errorMsgs.add("商品類別名稱:請輸入長度為2~10位的中、英文字母、數字或_。");
			}
			String pdtTypeDesc = req.getParameter("pdtTypeDesc").trim();
			if(pdtTypeDesc == null ||pdtTypeDesc.trim().length() == 0) {
				errorMsgs.add("商品類別描述請勿空白。");
			}
			
			ProductTypeVO productTypeVO = new ProductTypeVO();
			productTypeVO.setPdtTypeId(pdtTypeId);
			productTypeVO.setPdtTypeName(pdtTypeName);
			productTypeVO.setPdtTypeDesc(pdtTypeDesc);
			
			if(!errorMsgs.isEmpty()) {
				req.setAttribute("productTypeVO", productTypeVO);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/productType/update_productType_input.jsp");
				failureView.forward(req, res);
				return;
			}
			ProductTypeService pdtTypeSvc = new ProductTypeService();
			productTypeVO = pdtTypeSvc.updateproductType(pdtTypeName,pdtTypeDesc,pdtTypeId);
			req.setAttribute("productTypeVO", productTypeVO);
			String url ="/back-end/productType/listOneProductType.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
//		insert
		if("insert".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
		String pdtTypeName = req.getParameter("pdtTypeName");
		String pdtTypeNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
		if(pdtTypeName == null || pdtTypeName.trim().length() == 0) {
			errorMsgs.add("商品類別名稱請勿空白。");
		}else if(!pdtTypeName.trim().matches(pdtTypeNameReg)) {
			errorMsgs.add("商品類別名稱:請輸入長度為2~10位的中、英文字母、數字或_。");
		}
		
		String pdtTypeDesc = req.getParameter("pdtTypeDesc").trim();
		if(pdtTypeDesc == null || pdtTypeDesc.trim().length() == 0) {
			errorMsgs.add("商品類別描述請勿空白");
		}
		
		ProductTypeVO productTypeVO = new ProductTypeVO();
		productTypeVO.setPdtTypeName(pdtTypeName);
		productTypeVO.setPdtTypeDesc(pdtTypeDesc);
			
		if(!errorMsgs.isEmpty()) {
			req.setAttribute("productTypeVO", productTypeVO);
			RequestDispatcher failureView = req
					.getRequestDispatcher("/back-end/productType/addProductType.jsp");
			failureView.forward(req, res);
			return;
		}
		
		ProductTypeService pdtTypeSvc = new ProductTypeService();
		productTypeVO = pdtTypeSvc.addproductType(pdtTypeName, pdtTypeDesc);
		
		String url = "/back-end/productType/listAllProductType.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);	
		}
		
//		delete
		if("delete".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			Integer pdtTypeId = Integer.valueOf(req.getParameter("pdtTypeId"));
			
			ProductTypeService pdtTypeSvc = new ProductTypeService();
			pdtTypeSvc.deleteProductType(pdtTypeId);
			
			String url = "/back-end/productType/listAllProductType.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req,res);
		}
		
	}

}
