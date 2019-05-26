package br.com.datainfo.users.dto;

import java.io.Serializable;

public class UserGetDto implements Serializable {
	
	private static final long serialVersionUID = -5107279257553761016L;
	
	private String email;
	private String name;
	private Long profile;
	private boolean situation;
	private String cpf;
	private String phone;
	private Integer code;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getSituation() {
		return situation;
	}

	public void setSituation(boolean situation) {
		this.situation = situation;
	}

	public Long getProfile() {
		return profile;
	}

	public void setProfile(Long profile) {
		this.profile = profile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
