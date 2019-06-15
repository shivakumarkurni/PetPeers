package com.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.model.Pets;

public interface PetRepository extends JpaRepository<Pets, Integer>{

}
