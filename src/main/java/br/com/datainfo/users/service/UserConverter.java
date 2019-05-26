package br.com.datainfo.users.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.datainfo.users.dto.UserGetDto;
import br.com.datainfo.users.dto.UserPostDto;
import br.com.datainfo.users.repository.User;

@Component
public class UserConverter {
	
	public User postToEntity(UserPostDto dto) {
		User user = new User();
		user.setCpf(dto.getCpf());
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		user.setPhone(dto.getPhone());
		user.setProfile(dto.getProfile());
		user.setSituation(dto.getSituation() ? "A" : "I");
		user.setCode(dto.getCode());
		return user;
	}
	
	public UserGetDto entityToGet(User user) {
		UserGetDto dto = new UserGetDto();
		dto.setCpf(user.getCpf());
		dto.setEmail(user.getEmail());
		dto.setName(user.getName());
		dto.setPhone(user.getPhone());
		dto.setProfile(user.getProfile());
		dto.setSituation(user.getSituation().equals("A") ? true : false);
		return dto;
	}
	
	public List<UserGetDto> entityListToGetList(List<User> users) {
		List<UserGetDto> dtos = new ArrayList<UserGetDto>();
		for(User user : users) {
			dtos.add(this.entityToGet(user));
		}
		return dtos;
	}

}
