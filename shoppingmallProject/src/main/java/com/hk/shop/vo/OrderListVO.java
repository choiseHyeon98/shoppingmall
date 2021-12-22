package com.hk.shop.vo;

import java.util.Date;

public class OrderListVO {
	// 이건 VO
	
	private int orderNum;
	private int proNum;
	private String id;
	private String sizeOption;
	private String colorOption;
	private int tprice;
	private int delNum;
	private String payment;
	private String cancleOrder;
	private String delStatus;
	private String token;
	private Date orderDate;
	private int orderCount;
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getProNum() {
		return proNum;
	}
	public void setProNum(int proNum) {
		this.proNum = proNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSizeOption() {
		return sizeOption;
	}
	public void setSizeOption(String sizeOption) {
		this.sizeOption = sizeOption;
	}
	public String getColorOption() {
		return colorOption;
	}
	public void setColorOption(String colorOption) {
		this.colorOption = colorOption;
	}
	public int getTprice() {
		return tprice;
	}
	public void setTprice(int tprice) {
		this.tprice = tprice;
	}
	public int getDelNum() {
		return delNum;
	}
	public void setDelNum(int delNum) {
		this.delNum = delNum;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	public String getCancleOrder() {
		return cancleOrder;
	}
	public void setCancleOrder(String cancleOrder) {
		this.cancleOrder = cancleOrder;
	}
	public String getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	@Override
	public String toString() {
		return "OrderListVO [orderNum=" + orderNum + ", proNum=" + proNum + ", id=" + id + ", sizeOption=" + sizeOption
				+ ", colorOption=" + colorOption + ", tprice=" + tprice + ", delNum=" + delNum + ", payment=" + payment
				+ ", cancleOrder=" + cancleOrder + ", delStatus=" + delStatus + ", token=" + token + ", orderDate="
				+ orderDate + ", orderCount=" + orderCount + "]";
	}
	
	

}
