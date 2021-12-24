package com.hk.shop.vo;

public class OptionVO {
	private int proNum;
	private String sizeOption;
	private String colorOption;
	// 이건 VO
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
	@Override
	public String toString() {
		return "OptionVO [proNum=" + proNum + ", sizeOption=" + sizeOption + ", colorOption=" + colorOption + "]";
	}
	
}
