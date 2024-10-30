package com.producttype.model;

import java.util.List;

public class ProductTypeJDBCDAOTest {
	public static void main(String[] args) {
		
		ProductTypeJDBCDAO dao = new ProductTypeJDBCDAO();
		
//		新增
//		ProductTypeVO productTypeVO1 = new ProductTypeVO();
//		productTypeVO1.setPdtTypeName("特色伴手禮");
//		productTypeVO1.setPdtTypeDesc("世界各地的特色伴手禮");
//		dao.insert(productTypeVO1);
		
//		修改
//		ProductTypeVO productTypeVO2 = new ProductTypeVO();
//		productTypeVO2.setPdtTypeName("特色伴手禮");
//		productTypeVO2.setPdtTypeDesc("世界各地知名的特色伴手禮");
//		productTypeVO2.setPdtTypeId(4);
//		dao.update(productTypeVO2);
		
//		刪除
//		dao.delete(40);
		
//		查詢
		List<ProductTypeVO> list = dao.getAll();
		for(ProductTypeVO pdtType : list) {
			System.out.println(pdtType.getPdtTypeId());
			System.out.println(pdtType.getPdtTypeName());
			System.out.println(pdtType.getPdtTypeDesc());
			System.out.println("==========================");
		}
	}
}
