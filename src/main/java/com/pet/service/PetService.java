package com.pet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pet.model.Pets;

@Service
public interface PetService {
	
	public String savePet(Pets pet);
	
	public List<Pets> getAllPets();
	
	public Pets getPetById(int id);

	public Pets addPet(Pets pets);
	

}
