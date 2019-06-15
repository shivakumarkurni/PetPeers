package com.pet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pet.model.Pets;

@Repository
public interface PetsRepository extends JpaRepository<Pets, Integer> {
	
	@Query(value="select * from petsdb.pets where pet_user_id=?1",nativeQuery=true)
	List<Pets> findAll(int id);
}
