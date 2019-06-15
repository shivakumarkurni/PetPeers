package com.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pet.model.Pets;

@Repository
public interface PetsRepository extends JpaRepository<Pets, Integer> {

}
