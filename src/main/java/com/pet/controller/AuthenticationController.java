package com.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.model.PetUser;
import com.pet.service.AuthenticationService;


@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
	
	
	@Autowired
	AuthenticationService authService;

	@PostMapping("/addUser/{userName}/{password}/{confirmPassword}")
	public String addUser(@PathVariable String userName,
			@PathVariable String password,
			@PathVariable String confirmPassword) {
		return authService.addUser(userName,password,confirmPassword);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody PetUser petUser) {
		
		return authService.login(petUser);
	}
	
}
