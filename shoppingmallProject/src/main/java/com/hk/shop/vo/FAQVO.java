package com.hk.shop.vo;

public class FAQVO {
	// 이건 VO
	
	int FAQNum;
	String id;
	String name;
	String FAQTitle;
	String FAQContent;
	String FAQType;
	
	public int getFAQNum() {
		return FAQNum;
	}
	public void setFAQNum(int fAQNum) {
		FAQNum = fAQNum;
	}
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
	public String getFAQTitle() {
		return FAQTitle;
	}
	public void setFAQTitle(String fAQTitle) {
		FAQTitle = fAQTitle;
	}
	public String getFAQContent() {
		return FAQContent;
	}
	public void setFAQContent(String fAQContent) {
		FAQContent = fAQContent;
	}
	public String getFAQType() {
		return FAQType;
	}
	public void setFAQType(String fAQType) {
		FAQType = fAQType;
	}
	@Override
	public String toString() {
		return "FAQVO [FAQNum=" + FAQNum + ", id=" + id + ", name=" + name + ", FAQTitle=" + FAQTitle + ", FAQContent="
				+ FAQContent + ", FAQType=" + FAQType + "]";
	}
	
	
}
