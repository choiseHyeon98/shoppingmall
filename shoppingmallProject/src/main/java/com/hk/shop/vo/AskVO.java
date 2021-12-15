package com.hk.shop.vo;

import java.util.Date;

public class AskVO {
	// 이건 VO

	private String id;
	private String name;
	private int orderNum;
	private String email;
	private String askPhoto;
	private String askTitle;
	private String askContent;
	private String askWhether;
	private int askNum;
	private String askManagerContent;
	private Date askManagerDate;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAskPhoto() {
		return askPhoto;
	}
	public void setAskPhoto(String askPhoto) {
		this.askPhoto = askPhoto;
	}
	public String getAskTitle() {
		return askTitle;
	}
	public void setAskTitle(String askTitle) {
		this.askTitle = askTitle;
	}
	public String getAskContent() {
		return askContent;
	}
	public void setAskContent(String askContent) {
		this.askContent = askContent;
	}
	public String getAskWhether() {
		return askWhether;
	}
	public void setAskWhether(String askWhether) {
		this.askWhether = askWhether;
	}
	public int getAskNum() {
		return askNum;
	}
	public void setAskNum(int askNum) {
		this.askNum = askNum;
	}
	
	public String getAskManagerContent() {
		return askManagerContent;
	}
	public void setAskManagerContent(String askManagerContent) {
		this.askManagerContent = askManagerContent;
	}
	public Date getAskManagerDate() {
		return askManagerDate;
	}
	public void setAskManagerDate(Date askManagerDate) {
		this.askManagerDate = askManagerDate;
	}
	@Override
	public String toString() {
		return "AskVO [id=" + id + ", name=" + name + ", orderNum=" + orderNum + ", email=" + email + ", askPhoto="
				+ askPhoto + ", askTitle=" + askTitle + ", askContent=" + askContent + ", askWhether=" + askWhether
				+ ", askNum=" + askNum + ", askManagerContent=" + askManagerContent + ", askManagerDate="
				+ askManagerDate + "]";
	}
	
	
	
	
	
}
