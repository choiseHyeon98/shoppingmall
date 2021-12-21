package com.hk.shop.vo;

public class DeliveryVO {
	// 이건 VO
	
	String id;	
	int orderNum;
	String Recipient;
	String shippingAddress;	
	String delPhone;	
	String delMemo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getRecipient() {
		return Recipient;
	}
	public void setRecipient(String recipient) {
		Recipient = recipient;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getDelPhone() {
		return delPhone;
	}
	public void setDelPhone(String delPhone) {
		this.delPhone = delPhone;
	}
	public String getDelMemo() {
		return delMemo;
	}
	public void setDelMemo(String delMemo) {
		this.delMemo = delMemo;
	}
	@Override
	public String toString() {
		return "DeliveryVO [id=" + id + ", orderNum=" + orderNum + ", Recipient=" + Recipient + ", shippingAddress="
				+ shippingAddress + ", delPhone=" + delPhone + ", delMemo=" + delMemo + "]";
	}
	
	
}
