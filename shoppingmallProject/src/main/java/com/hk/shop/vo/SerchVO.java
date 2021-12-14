package com.hk.shop.vo;

public class SerchVO {
//검색관련 VO
	String serch;
	String serchType;
	public String getSerch() {
		return serch;
	}
	public void setSerch(String serch) {
		this.serch = serch;
	}
	public String getSerchType() {
		return serchType;
	}
	public void setSerchType(String serchType) {
		this.serchType = serchType;
	}
	@Override
	public String toString() {
		return "SerchVO [serch=" + serch + ", serchType=" + serchType + "]";
	}
	
}
