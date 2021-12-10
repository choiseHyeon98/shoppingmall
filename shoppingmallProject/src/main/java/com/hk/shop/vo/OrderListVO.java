package com.hk.shop.vo;

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
	
	
	@Override
	public String toString() {
		return "OrderListVO [orderNum=" + orderNum + ", proNum=" + proNum + ", id=" + id + ", sizeOption=" + sizeOption
				+ ", colorOption=" + colorOption + ", tprice=" + tprice + ", delNum=" + delNum + ", payment=" + payment
				+ "]";
	}
	
	

}
