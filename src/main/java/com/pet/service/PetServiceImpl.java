package com.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.model.Pets;
import com.pet.repository.PetsRepository;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetsRepository petsRepository;

	@Override
	public String savePet(Pets pet) {

		if (petsRepository.save(pet) != null)
			return "Pet details saved successfully";
		else
			return "Something went wrong please try again";
	}

	@Override
	public List<Pets> getAllPets() {

		return petsRepository.findAll();

	}

	@Override
	public Pets getPetById(int id) {
		return petsRepository.findById(id).get();

	}

	@Override
	public Pets addPet(Pets pets) {
		pets.setStatus("buy");
		return petsRepository.save(pets);
	}



}
