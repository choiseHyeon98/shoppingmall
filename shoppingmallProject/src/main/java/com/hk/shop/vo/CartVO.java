package com.hk.shop.vo;

public class CartVO {
	// 이건 VO
	private int cartNum;
	private String id;
	private int proNum;
	private String sizeOption;
	private String colorOption;
	private int price;
	private int countProNum;
	
	
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getProNum() {
		return proNum;
	}
	public void setProNum(int proNum) {
		this.proNum = proNum;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCountProNum() {
		return countProNum;
	}
	public void setCountProNum(int countProNum) {
		this.countProNum = countProNum;
	}
	
	
	@Override
	public String toString() {
		return "CartVO [cartNum=" + cartNum + ", id=" + id + ", proNum=" + proNum + ", sizeOption=" + sizeOption
				+ ", colorOption=" + colorOption + ", price=" + price + ", countProNum=" + countProNum + "]";
	}
	
	
}
