package com.somapait.domain;

import java.io.Serializable;

public class Active implements Serializable{
	
	private static final long serialVersionUID = 6209551703958164038L;
	private String code;
	private String desc;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
