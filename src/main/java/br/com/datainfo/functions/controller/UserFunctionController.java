package br.com.datainfo.functions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.datainfo.functions.dto.UserFunctionGetDto;
import br.com.datainfo.functions.repository.UserFunction;
import br.com.datainfo.functions.repository.UserFunctionRepository;
import br.com.datainfo.functions.service.UserFunctionConverter;

@RestController
@RequestMapping(value = "/api")
public class UserFunctionController {
	
	@Autowired
    private UserFunctionRepository repository;
	
	@Autowired
	private UserFunctionConverter converter;
	
	/*
     * GET
     */
    
	@RequestMapping(value = "/functions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<UserFunctionGetDto>> findAll() {
        List<UserFunction> functions = this.repository.findAll();
        List<UserFunctionGetDto> dtos = this.converter.entityListToGetList(functions);
        return new ResponseEntity<List<UserFunctionGetDto>>(dtos, HttpStatus.OK);
    }

}
