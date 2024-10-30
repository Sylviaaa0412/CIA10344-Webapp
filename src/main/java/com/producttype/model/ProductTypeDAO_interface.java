package com.producttype.model;

import java.util.*;

public interface ProductTypeDAO_interface {
	
	public void insert(ProductTypeVO productTypeVO);
	public void update(ProductTypeVO productTypeVO);
	public void delete(Integer pdtTypeId);
	public ProductTypeVO findByPrimaryKey(Integer pdtTypeId);
	public List<ProductTypeVO> getAll();
	
	
}