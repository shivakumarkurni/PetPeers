package com.pet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pet.model.Pets;

@Service
public interface UserService {
	
	public String buyPet(int id,int userId);

	public List<Pets> myPets(int id);

}
