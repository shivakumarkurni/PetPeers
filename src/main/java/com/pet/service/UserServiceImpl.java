package com.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.model.PetUser;
import com.pet.model.Pets;
import com.pet.repository.PetsRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	PetsRepository petRepo;

	@Override
	public String buyPet(int id,int userId) {

		System.out.println(petRepo.findById(id));
		if("Optional.empty".contains(""+petRepo.findById(id))) {
			return "Pet you are looking for doesn't exists";

		}else {

			Pets pet = petRepo.findById(id).get();

			if(pet.getStatus() != null && !pet.getStatus().isEmpty() && pet.getStatus().equalsIgnoreCase("sold")) {
				return "Pet is already sold,Sorry";
			}else {
				PetUser petUser = new PetUser();
				petUser.setId(userId);
				pet.setStatus("Sold");
				pet.setPetUser(petUser);
				if(petRepo.save(pet) != null)
					return "Pet bought successfully";
				else
					return "internal error,try again later";
			}
		}

	}

	@Override
	public List<Pets> myPets(int id) {
		return petRepo.findAll(id);
	}

}
