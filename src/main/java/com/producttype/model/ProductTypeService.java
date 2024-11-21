package com.producttype.model;

import java.util.List;

public class ProductTypeService {

	private ProductTypeDAO_interface dao;
	
	public ProductTypeService() {
		dao = new ProductTypeJDBCDAO();
	}
	
//	新增
	public ProductTypeVO addproductType (String productTypeName, String productTypeDesc) {
		
		ProductTypeVO productTypeVO = new ProductTypeVO();
		
		productTypeVO.setPdtTypeName(productTypeName);
		productTypeVO.setPdtTypeDesc(productTypeDesc);
		dao.insert(productTypeVO);
		
		return productTypeVO;
	}
	
//	修改
	public ProductTypeVO updateproductType (String productTypeName, String productTypeDesc, Integer productTypeId) {
		
		ProductTypeVO productTypeVO = new ProductTypeVO();
		
		productTypeVO.setPdtTypeName(productTypeName);
		productTypeVO.setPdtTypeDesc(productTypeDesc);
		productTypeVO.setPdtTypeId(productTypeId);
		dao.update(productTypeVO);
		
		return productTypeVO;
	}
	
//	刪除
	public void deleteProductType (Integer productTypeId) {
		dao.delete(productTypeId);
	}
	
//	get one
	public ProductTypeVO getOneProductType(Integer productTypeId) {
		return dao.findByPrimaryKey(productTypeId);
	}
	
//	list all
	public List<ProductTypeVO> getAll(){
		return dao.getAll();
	}
	
}
