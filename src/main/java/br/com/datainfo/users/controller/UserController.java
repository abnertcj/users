package br.com.datainfo.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.datainfo.users.dto.UserGetDto;
import br.com.datainfo.users.dto.UserPostDto;
import br.com.datainfo.users.repository.User;
import br.com.datainfo.users.repository.UserRepository;
import br.com.datainfo.users.service.UserConverter;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
    private UserRepository repository;
	
	@Autowired
	private UserConverter converter;
	
	/*
     * GET
     */
    
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<UserGetDto> findById(@PathVariable("id") String cpf) {
    	User user = this.repository.findByCpf(cpf);
    	if (user != null) {
	        UserGetDto dto = converter.entityToGet(user);
	        return new ResponseEntity<UserGetDto>(dto, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<UserGetDto>(HttpStatus.OK);
    	}
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<UserGetDto>> findAll() {
        List<User> users = this.repository.findAll();
        List<UserGetDto> dtos = this.converter.entityListToGetList(users);
        return new ResponseEntity<List<UserGetDto>>(dtos, HttpStatus.OK);
    }

    /*
     * POST
     */
    
    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Integer> save(@RequestBody UserPostDto dto) {
        User user = this.converter.postToEntity(dto);
    	User savedUser = this.repository.save(user);
        return new ResponseEntity<Integer>(savedUser.getFunction().getCode(), HttpStatus.OK);
    }
    
    /*
     * PUT
     */
    
    @RequestMapping(value = "/users", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<User> update(@RequestBody UserPostDto dto) {
    	User savedUser = this.repository.findByCpf(dto.getCpf());
    	if (savedUser != null) {
	        User user = this.converter.postToEntity(dto);
	    	User updatedUser = this.repository.save(user);
	        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    	}
    }
    
    @RequestMapping(value = "/users/situation", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Boolean> updateSituation(@RequestBody UserPostDto dto) {
    	User savedUser = this.repository.findByCpf(dto.getCpf());
    	if (savedUser != null) {
	        User user = this.converter.postToEntity(dto);
	    	User updatedUser = this.repository.saveAndFlush(user);
	        return new ResponseEntity<Boolean>(dto.getSituation(), HttpStatus.OK);
    	} else {
    		return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
    	}
    }
    
    /*
     * DELETE
     */
    
    @RequestMapping(value = "/users", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Long> deleteAll(@RequestBody UserPostDto dto) {
    	User user = this.repository.findByCpf(dto.getCpf());
    	this.repository.delete(user);
        return new ResponseEntity<Long>(HttpStatus.OK);
    }
	
}
