package br.com.datainfo.functions.dto;

import java.io.Serializable;

public class UserFunctionGetDto implements Serializable {

	private static final long serialVersionUID = 7441155192427551805L;
	
	private Integer code;
	private String name;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
