package com.productimg.model;

public class ProductImgVO {

	private Integer pdtImgId;
	private Integer pdtId;
	private String pdtImgName;
	private byte[] pdtImg;
	public Integer getPdtImgId() {
		return pdtImgId;
	}
	public void setPdtImgId(Integer pdtImgId) {
		this.pdtImgId = pdtImgId;
	}
	public Integer getPdtId() {
		return pdtId;
	}
	public void setPdtId(Integer pdtId) {
		this.pdtId = pdtId;
	}
	public String getPdtImgName() {
		return pdtImgName;
	}
	public void setPdtImgName(String pdtImgName) {
		this.pdtImgName = pdtImgName;
	}
	public byte[] getPdtImg() {
		return pdtImg;
	}
	public void setPdtImg(byte[] pdtImg) {
		this.pdtImg = pdtImg;
	}
	public ProductImgVO(Integer pdtImgId, Integer pdtId, String pdtImgName, byte[] pdtImg) {
		super();
		this.pdtImgId = pdtImgId;
		this.pdtId = pdtId;
		this.pdtImgName = pdtImgName;
		this.pdtImg = pdtImg;
	}
	public ProductImgVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
