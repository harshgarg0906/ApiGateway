package com.example.demo.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CreateUserRequest;
import com.example.demo.model.ResposneModel;
import com.example.demo.model.UserDto;
import com.example.demo.service.UserService;
import com.netflix.discovery.converters.Auto;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private Environment env;
	
	@Autowired
	private UserService userService;

	@GetMapping("/status")
	public String getData() {
		return "workinng.." + env.getProperty("local.server.port");
	}
	@PostMapping("/insert")
	public ResponseEntity<ResposneModel> postData( @Valid @RequestBody CreateUserRequest userRequest)
	{
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto=modelMapper.map(userRequest, UserDto.class);
		UserDto u=userService.createUser(userDto); 
	    ResposneModel responseObject=modelMapper.map(u,ResposneModel.class);
		return new ResponseEntity(responseObject,HttpStatus.CREATED);
	}
}
