package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/managment")
public class AccountController {
	
	@GetMapping("/user")
	public String getData()
	{
		return "it is working";
	}

}
