package com.hk.shop.vo;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	// 이건 VO
	
	private int proNum;
	private String proName;
	private String proContent;
	private String proDetails;
	private String proSpecification;
	//파일 업로드를 위해 multipartfile 추가
	private MultipartFile uploadFileTop;
	private MultipartFile uploadFileDetail;
	private String refundPolicy;
	private String topImage;
	private int price;
	private int delprice;
	private String dailyDel;
	private String proCon;
	private String proCate;
	private String detailsImg;
	
	//상세보기 및 상품주문을 위한 VO정보들
	private String sizeOption;
	private String colorOption;
	private int countProNum;
	private String soldOut;
	
	public int getCountProNum() {
		return countProNum;
	}
	public void setCountProNum(int countProNum) {
		this.countProNum = countProNum;
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

	public MultipartFile getUploadFileTop() {
		
		return uploadFileTop;
	}
	public void setUploadFileTop(MultipartFile uploadFileTop) {
		this.uploadFileTop = uploadFileTop;
	}
	
	public MultipartFile getUploadFileDetail() {
		return uploadFileDetail;
	}
	public void setUploadFileDetail(MultipartFile uploadFileDetail) {
		this.uploadFileDetail = uploadFileDetail;
		
	}
	
	public String getDetailsImg() {
		return detailsImg;
	}
	public void setDetailsImg(String detailsImg) {
		this.detailsImg = detailsImg;
	}
	@Override
	public String toString() {
		return "ProductVO [proNum=" + proNum + ", proName=" + proName + ", proContent=" + proContent + ", proDetails="
				+ proDetails + ", proSpecification=" + proSpecification + ", uploadFileTop=" + uploadFileTop
				+ ", uploadFileDetail=" + uploadFileDetail + ", refundPolicy=" + refundPolicy + ", topImage=" + topImage
				+ ", price=" + price + ", delprice=" + delprice + ", dailyDel=" + dailyDel + ", proCon=" + proCon
				+ ", proCate=" + proCate + ", detailsImg=" + detailsImg + ", sizeOption=" + sizeOption
				+ ", colorOption=" + colorOption + ", countProNum=" + countProNum + ", soldOut=" + soldOut + "]";
	}
	
	
	
}
