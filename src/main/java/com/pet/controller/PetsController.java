package com.pet.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pet.model.Pets;
import com.pet.service.PetService;

@RestController
public class PetsController {

	@Autowired
	private PetService petService;

	@GetMapping("/pets")
	public List<Pets> getAllPets() {

		return petService.getAllPets();
	}
	
	@GetMapping("/pets/petDetail/{id}")
	public Pets getPetById(@PathVariable("id") int id) {
		return petService.getPetById(id);
	}
	
	@PostMapping("/pets/addPet")
	public String addPet(@RequestBody Pets pets) {
		if(petService.addPet(pets)!= null)
		return "saved succesfully!";
		else
			return "something went worng...Please try later!";	
	}
	

	
	

}
