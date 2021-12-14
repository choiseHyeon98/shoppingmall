package com.hk.shop.vo;

public class AskVO {
	// 이건 VO

	String id;
	String name;
	int orderNum;
	String email;
	String askPhoto;
	String askTitle;
	String askContent;
	String askWhether;
	int askNum;
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
	@Override
	public String toString() {
		return "AskVO [id=" + id + ", name=" + name + ", orderNum=" + orderNum + ", email=" + email + ", askPhoto="
				+ askPhoto + ", askTitle=" + askTitle + ", askContent=" + askContent + ", askWhether=" + askWhether
				+ ", askNum=" + askNum + "]";
	}
	
	
	
	
}
