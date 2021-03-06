package com.jsp.dto;

public class MenuVO {
	String mcode   ; // 메뉴 코드
	String mname   ; // 메뉴 이름
	String murl    ; // 메뉴 url
	String micon   ; // 메뉴 아이콘
	String jtext   ; // javaScript
	String upcode  ; // 상위메뉴 코드 
	int  mlevel  ; // 메뉴레벨

	
	public String getMcode() {
		return mcode;
	}
	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMurl() {
		return murl;
	}
	public void setMurl(String murl) {
		this.murl = murl;
	}
	public String getMicon() {
		return micon;
	}
	public void setMicon(String micon) {
		this.micon = micon;
	}
	public String getJtext() {
		return jtext;
	}
	public void setJtext(String jtext) {
		this.jtext = jtext;
	}
	public String getUpcode() {
		return upcode;
	}
	public void setUpcode(String upcode) {
		this.upcode = upcode;
	}
	public int getMlevel() {
		return mlevel;
	}
	public void setMlevel(int mlevel) {
		this.mlevel = mlevel;
	}
}
