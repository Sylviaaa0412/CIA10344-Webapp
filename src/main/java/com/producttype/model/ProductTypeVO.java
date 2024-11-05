package com.producttype.model;

public class ProductTypeVO {

	private Integer pdtTypeId;
	private String pdtTypeName;
	private String pdtTypeDesc;
	
	public Integer getPdtTypeId() {
		return pdtTypeId;
	}
	public void setPdtTypeId(Integer pdtTypeId) {
		this.pdtTypeId = pdtTypeId;
	}
	public String getPdtTypeName() {
		return pdtTypeName;
	}
	public void setPdtTypeName(String pdtTypeName) {
		this.pdtTypeName = pdtTypeName;
	}
	public String getPdtTypeDesc() {
		return pdtTypeDesc;
	}
	public void setPdtTypeDesc(String pdtTypeDesc) {
		this.pdtTypeDesc = pdtTypeDesc;
	}
	public ProductTypeVO(Integer pdtTypeId, String pdtTypeName, String pdtTypeDesc) {
		super();
		this.pdtTypeId = pdtTypeId;
		this.pdtTypeName = pdtTypeName;
		this.pdtTypeDesc = pdtTypeDesc;
	}
	public ProductTypeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
