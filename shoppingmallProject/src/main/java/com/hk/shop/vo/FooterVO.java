package com.hk.shop.vo;

public class FooterVO {
	// 이건 VO
	private String compInfo;
	private String tems;
	private String privacy;
	
	public String getCompInfo() {
		return compInfo;
	}
	public void setCompInfo(String compInfo) {
		this.compInfo = compInfo;
	}
	public String getTems() {
		return tems;
	}
	public void setTems(String tems) {
		this.tems = tems;
	}
	public String getPrivacy() {
		return privacy;
	}
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	@Override
	public String toString() {
		return "FooterVO [compInfo=" + compInfo + ", tems=" + tems + ", privacy=" + privacy + "]";
	}
	
}
