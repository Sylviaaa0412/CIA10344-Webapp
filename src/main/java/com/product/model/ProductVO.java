package com.product.model;

//@Entity
//@Table(name = "Product")
//@NamedQuery(name = "getAllPdt", query = "from Product where pdtId > :pdtId order by pdtId desc")

public class ProductVO implements java.io.Serializable{
	
	private Integer pdtId;
	private Integer pdtTypeId;
	private Integer pdtStat;
	private String pdtName;
	private String pdtDesc;
	private Integer pdtPrice;
	public ProductVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductVO(Integer pdtId, Integer pdtTypeId, Integer pdtStat, String pdtName, String pdtDesc,
			Integer pdtPrice) {
		super();
		this.pdtId = pdtId;
		this.pdtTypeId = pdtTypeId;
		this.pdtStat = pdtStat;
		this.pdtName = pdtName;
		this.pdtDesc = pdtDesc;
		this.pdtPrice = pdtPrice;
	}

	public Integer getPdtId() {
		return pdtId;
	}
	public void setPdtId(Integer pdtId) {
		this.pdtId = pdtId;
	}
	public Integer getPdtTypeId() {
		return pdtTypeId;
	}
	public void setPdtTypeId(Integer pdtTypeId) {
		this.pdtTypeId = pdtTypeId;
	}
	public Integer getPdtStat() {
		return pdtStat;
	}
	public void setPdtStat(Integer pdtStat) {
		this.pdtStat = pdtStat;
	}
	public String getPdtName() {
		return pdtName;
	}
	public void setPdtName(String pdtName) {
		this.pdtName = pdtName;
	}
	public String getPdtDesc() {
		return pdtDesc;
	}
	public void setPdtDesc(String pdtDesc) {
		this.pdtDesc = pdtDesc;
	}
	public Integer getPdtPrice() {
		return pdtPrice;
	}
	public void setPdtPrice(Integer pdtPrice) {
		this.pdtPrice = pdtPrice;
	}
	
	
}
