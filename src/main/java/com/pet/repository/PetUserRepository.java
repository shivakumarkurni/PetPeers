package com.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pet.model.PetUser;

@Repository
public interface PetUserRepository extends JpaRepository<PetUser, Integer>{

	@Query(value = "select * from petsdb.pet_user where user_name = ?1 ",nativeQuery = true)
	public PetUser getUserDetails(String userName);

}
