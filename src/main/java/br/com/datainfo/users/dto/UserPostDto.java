package br.com.datainfo.users.dto;

import java.io.Serializable;

public class UserPostDto implements Serializable {
	
	private static final long serialVersionUID = -591134419179354863L;
	
	private String email;
	private String name;
	private String cpf;
	private String phone;
	private Integer code;
	private Long profile;
	private boolean situation;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Long getProfile() {
		return profile;
	}

	public void setProfile(Long profile) {
		this.profile = profile;
	}

	public boolean getSituation() {
		return situation;
	}

	public void setSituation(boolean situation) {
		this.situation = situation;
	}
	
}
