package com.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pet.model.PetUser;

@Repository
public interface UserRepository extends JpaRepository<PetUser, Integer> {

}
