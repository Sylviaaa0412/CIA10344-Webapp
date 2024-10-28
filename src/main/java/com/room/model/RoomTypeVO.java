package com.room.model;

public class RoomTypeVO implements java.io.Serializable{
	
	private Integer roomTypeId;
	private String roomTypeName;
	private String roomTypeDesc;
	private Integer roomQty;
	private Integer roomPrice;
	private Integer occupancy;
	
	public Integer getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public String getRoomTypeName() {
		return roomTypeName;
	}
	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}
	public String getRoomTypeDesc() {
		return roomTypeDesc;
	}
	public void setRoomTypeDesc(String roomTypeDesc) {
		this.roomTypeDesc = roomTypeDesc;
	}
	public Integer getRoomQty() {
		return roomQty;
	}
	public void setRoomQty(Integer roomQty) {
		this.roomQty = roomQty;
	}
	public Integer getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}
	public Integer getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(Integer occupancy) {
		this.occupancy = occupancy;
	}
	public RoomTypeVO(Integer roomTypeId, String roomTypeName, String roomTypeDesc, Integer roomQty, Integer roomPrice,
			Integer occupancy) {
		super();
		this.roomTypeId = roomTypeId;
		this.roomTypeName = roomTypeName;
		this.roomTypeDesc = roomTypeDesc;
		this.roomQty = roomQty;
		this.roomPrice = roomPrice;
		this.occupancy = occupancy;
	}
	public RoomTypeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
