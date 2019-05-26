package br.com.datainfo.functions.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.datainfo.functions.dto.UserFunctionGetDto;
import br.com.datainfo.functions.repository.UserFunction;

@Component
public class UserFunctionConverter {

	public UserFunctionGetDto entityToGet(UserFunction user) {
		UserFunctionGetDto dto = new UserFunctionGetDto();
		dto.setCode(user.getCode());
		dto.setName(user.getName());
		return dto;
	}
	
	public List<UserFunctionGetDto> entityListToGetList(List<UserFunction> users) {
		List<UserFunctionGetDto> dtos = new ArrayList<UserFunctionGetDto>();
		for(UserFunction user : users) {
			dtos.add(this.entityToGet(user));
		}
		return dtos;
	}
	
}
