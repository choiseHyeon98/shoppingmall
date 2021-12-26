package com.hk.shop.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class ReviewVO {
	private int reviewNum;
	private String id;
	private int proNum;
	private String reviewPhoto;
	private String reviewContent;
	private Date reviewDate;
	private String rereviewCont;
	private Date rereviewDate;
	private MultipartFile uploadReviewImage;
	
	// 이건 VO
	public int getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
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
	public String getReviewPhoto() {
		return reviewPhoto;
	}
	public void setReviewPhoto(String reviewPhoto) {
		this.reviewPhoto = reviewPhoto;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getRereviewCont() {
		return rereviewCont;
	}
	public void setRereviewCont(String rereviewCont) {
		this.rereviewCont = rereviewCont;
	}
	public Date getRereviewDate() {
		return rereviewDate;
	}
	public void setRereviewDate(Date rereviewDate) {
		this.rereviewDate = rereviewDate;
	}
	
	public MultipartFile getUploadReviewImage() {
		return uploadReviewImage;
	}
	public void setUploadReviewImage(MultipartFile uploadReviewImage) {
		this.uploadReviewImage = uploadReviewImage;
	}
	@Override
	public String toString() {
		return "ReviewVO [reviewNum=" + reviewNum + ", id=" + id + ", proNum=" + proNum + ", reviewPhoto=" + reviewPhoto
				+ ", reviewContent=" + reviewContent + ", reviewDate=" + reviewDate + ", rereviewCont=" + rereviewCont
				+ ", rereviewDate=" + rereviewDate + ", uploadReviewImage=" + uploadReviewImage + "]";
	}
	
	
	
	
}
