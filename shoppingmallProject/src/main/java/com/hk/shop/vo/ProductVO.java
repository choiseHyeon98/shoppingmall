package com.hk.shop.vo;

public class ProductVO {
	// 이건 VO
	
	int proNum;
	String proName;
	String proContent;
	String proDetails;
	String proSpecification;
	String refundPolicy;
	String topImage;
	int price;
	int delprice;
	String dailyDel;
	String proCon;
	String proCate;
	public int getProNum() {
		return proNum;
	}
	public void setProNum(int proNum) {
		this.proNum = proNum;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProContent() {
		return proContent;
	}
	public void setProContent(String proContent) {
		this.proContent = proContent;
	}
	public String getProDetails() {
		return proDetails;
	}
	public void setProDetails(String proDetails) {
		this.proDetails = proDetails;
	}
	public String getProSpecification() {
		return proSpecification;
	}
	public void setProSpecification(String proSpecification) {
		this.proSpecification = proSpecification;
	}
	public String getRefundPolicy() {
		return refundPolicy;
	}
	public void setRefundPolicy(String refundPolicy) {
		this.refundPolicy = refundPolicy;
	}
	public String getTopImage() {
		return topImage;
	}
	public void setTopImage(String topImage) {
		this.topImage = topImage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDelprice() {
		return delprice;
	}
	public void setDelprice(int delprice) {
		this.delprice = delprice;
	}
	public String getDailyDel() {
		return dailyDel;
	}
	public void setDailyDel(String dailyDel) {
		this.dailyDel = dailyDel;
	}
	public String getProCon() {
		return proCon;
	}
	public void setProCon(String proCon) {
		this.proCon = proCon;
	}
	public String getProCate() {
		return proCate;
	}
	public void setProCate(String proCate) {
		this.proCate = proCate;
	}
	public String getSoldOut() {
		return soldOut;
	}
	public void setSoldOut(String soldOut) {
		this.soldOut = soldOut;
	}
	String soldOut;
	
	@Override
	public String toString() {
		return "ProductVO [proNum=" + proNum + ", proName=" + proName + ", proContent=" + proContent + ", proDetails="
				+ proDetails + ", proSpecification=" + proSpecification + ", refundPolicy=" + refundPolicy
				+ ", topImage=" + topImage + ", price=" + price + ", delprice=" + delprice + ", dailyDel=" + dailyDel
				+ ", proCon=" + proCon + ", proCate=" + proCate + ", soldOut=" + soldOut + "]";
	}
}
