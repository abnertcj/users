package br.com.datainfo.users.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.datainfo.functions.repository.UserFunction;

@Entity
@Table(name = "usuario_externo")
public class User implements Serializable {

	private static final long serialVersionUID = 1888373495601785330L;
	
	@Id
	@Column(name = "nu_cpf")
	private String cpf; //nu_cpf varchar(11) NOT NULL, --Número do cpf do usuário
	
	@Column(name = "no_usuario")
	private String name; //no_usuario varchar(60) NOT NULL, -- Nome do Usuário
	
	@Column(name = "de_email")
	private String email;//de_email varchar(255) NOT NULL, -- email do usuário
	
	@Column(name = "ic_situacao")
	private String situation;//	ic_situacao varchar(1) NOT NULL, -- Situação, onde: A-Ativo, I-Inativo
	
	@Column(name = "ic_perfil_acesso")
	private Long profile;//	ic_perfil_acesso smallint NOT NULL, -- Perfil do usuário: 0-Aluno, 1-Gestor Municipal, 2-Gestor Estadual, 3-Gestor Nacional
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "co_funcao")
	private UserFunction function;//	co_funcao smallint NOT NULL,-- Código único da funcao do usuário externo
	
	@Column(name = "nu_telefone")
	private String phone;//	nu_telefone varchar(11)-- número do telefone

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

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public Long getProfile() {
		return profile;
	}

	public void setProfile(Long profile) {
		this.profile = profile;
	}

	public UserFunction getFunction() {
		return function;
	}

	public void setFunction(UserFunction function) {
		this.function = function;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((function == null) ? 0 : function.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result + ((situation == null) ? 0 : situation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (situation == null) {
			if (other.situation != null)
				return false;
		} else if (!situation.equals(other.situation))
			return false;
		return true;
	}

}
