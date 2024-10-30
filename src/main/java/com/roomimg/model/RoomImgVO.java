package com.roomimg.model;

public class RoomImgVO {

	private Integer roomImgId;
	private Integer roomTypeId;
	private String roomImgName;
	private byte[] roomImg;
	public Integer getRoomImgId() {
		return roomImgId;
	}
	public void setRoomImgId(Integer roomImgId) {
		this.roomImgId = roomImgId;
	}
	public Integer getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public String getRoomImgName() {
		return roomImgName;
	}
	public void setRoomImgName(String roomImgName) {
		this.roomImgName = roomImgName;
	}
	public byte[] getRoomImg() {
		return roomImg;
	}
	public void setRoomImg(byte[] roomImg) {
		this.roomImg = roomImg;
	}
	public RoomImgVO(Integer roomImgId, Integer roomTypeId, String roomImgName, byte[] roomImg) {
		super();
		this.roomImgId = roomImgId;
		this.roomTypeId = roomTypeId;
		this.roomImgName = roomImgName;
		this.roomImg = roomImg;
	}
	public RoomImgVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
