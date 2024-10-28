package com.roomoder.model;

public class RoomOrderVO implements java.io.Serializable{

	private Integer roomOrderId;
	private Integer roomTypeId;
	private Integer planOrderId;
	private String roomTypeName;
	private Integer roomPrice;
	private Integer orderQty;
	public RoomOrderVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoomOrderVO(Integer roomOrderId, Integer roomTypeId, Integer planOrderId, String roomTypeName,
			Integer roomPrice, Integer orderQty) {
		super();
		this.roomOrderId = roomOrderId;
		this.roomTypeId = roomTypeId;
		this.planOrderId = planOrderId;
		this.roomTypeName = roomTypeName;
		this.roomPrice = roomPrice;
		this.orderQty = orderQty;
	}
	public Integer getRoomOrderId() {
		return roomOrderId;
	}
	public void setRoomOrderId(Integer roomOrderId) {
		this.roomOrderId = roomOrderId;
	}
	public Integer getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public Integer getPlanOrderId() {
		return planOrderId;
	}
	public void setPlanOrderId(Integer planOrderId) {
		this.planOrderId = planOrderId;
	}
	public String getRoomTypeName() {
		return roomTypeName;
	}
	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}
	public Integer getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}
	public Integer getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(Integer orderQty) {
		this.orderQty = orderQty;
	}
}
