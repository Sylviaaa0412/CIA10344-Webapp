package com.producttype.model;

public class ProductTypeService {

	private ProductTypeDAO_interface dao;
	
	public ProductTypeService() {
		dao = new ProductTypeJDBCDAO();
	}
	
}
