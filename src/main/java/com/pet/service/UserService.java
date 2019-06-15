package com.pet.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	public String buyPet(int id,int userId);

}
