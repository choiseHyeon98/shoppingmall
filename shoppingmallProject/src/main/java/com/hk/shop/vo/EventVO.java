package com.hk.shop.vo;

import org.springframework.web.multipart.MultipartFile;

public class EventVO {
	// 이건 VO
	private int eventNum;
	private String eventTitle;
	private String eventImg;
	private String eventContent;
	private MultipartFile uploadEventImage;
	
	public int getEventNum() {
		return eventNum;
	}
	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	public String getEventImg() {
		return eventImg;
	}
	public void setEventImg(String eventImg) {
		this.eventImg = eventImg;
	}
	public String getEventContent() {
		return eventContent;
	}
	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}
	
	
	public MultipartFile getUploadEventImage() {
		return uploadEventImage;
	}
	public void setUploadEventImage(MultipartFile uploadEventImage) {
		this.uploadEventImage = uploadEventImage;
	}
	@Override
	public String toString() {
		return "EventVO [eventNum=" + eventNum + ", eventTitle=" + eventTitle + ", eventImg=" + eventImg
				+ ", eventContent=" + eventContent + ", uploadEventImage=" + uploadEventImage + "]";
	}
	
}
