package com.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pet.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/buyPet/{petId}/{userId}")
	public String buyPet(@PathVariable int petId,@PathVariable int userId) {
		
		return userService.buyPet(petId,userId);
	}
}
