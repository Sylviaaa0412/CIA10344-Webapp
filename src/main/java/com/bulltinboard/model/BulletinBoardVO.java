package com.bulltinboard.model;

import java.sql.Date;

public class BulletinBoardVO implements java.io.Serializable{

	private Integer msgId;
	private String msgType;
	private String msgTitle;
	private String msgCon;
	private Integer postStat;
	private Date postTime;
	public BulletinBoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BulletinBoardVO(Integer msgId, String msgType, String msgTitle, String msgCon, Integer postStat,
			Date postTime) {
		super();
		this.msgId = msgId;
		this.msgType = msgType;
		this.msgTitle = msgTitle;
		this.msgCon = msgCon;
		this.postStat = postStat;
		this.postTime = postTime;
	}
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMsgTitle() {
		return msgTitle;
	}
	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}
	public String getMsgCon() {
		return msgCon;
	}
	public void setMsgCon(String msgCon) {
		this.msgCon = msgCon;
	}
	public Integer getPostStat() {
		return postStat;
	}
	public void setPostStat(Integer postStat) {
		this.postStat = postStat;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	
}
