package com.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.model.PetUser;
import com.pet.repository.PetUserRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	PetUserRepository petUserRepo;

	@Override
	public String addUser(String userName,String password,String confirmPassword) {


		if(password.equalsIgnoreCase(confirmPassword)) {
			PetUser user =  petUserRepo.getUserDetails(userName);

			if(user != null) {

				return "User Already Exists";

			}else {
				PetUser petUser = new PetUser();
				petUser.setUserName(userName);
				petUser.setUserPassword(password);

				if(petUserRepo.save(petUser) != null) 
					return "User Registration successful";
				else 
					return "User registration failed try again"; }
			/*
			 * if(user.getUserName().equalsIgnoreCase(userName) &&
			 * user.getUserPassword().equalsIgnoreCase(password)){ return
			 * "login successful"; }else if(user.getUserPassword() != password) { return
			 * "Password entered is wrong"; }
			 */
			//return "User Name entered is wrong";
		}
		else {
			return "password validation failed";
		}
		/*
		 * if(petUserRepo.findById(petUser.getId()) != null){ return
		 * "User Already Exits"; }else {
		 * 
		 * if(petUserRepo.save(petUser) != null) return "User Registration successful";
		 * else return "User registration failed try again"; }
		 */
	}

	@Override
	public String login(PetUser petUser) {

		/*
		 * if(password == confirmPassword) { PetUser user =
		 * petUserRepo.getUserDetails(userName);
		 * 
		 * if(user != null) { if(user.getUserName().equalsIgnoreCase(userName) &&
		 * user.getUserPassword().equalsIgnoreCase(password)){ return
		 * "login successful"; }else if(user.getUserPassword() != password) { return
		 * "Password entered is wrong"; } }else { return "User Name entered is wrong"; }
		 * 
		 * }else { return "password validation failed"; }
		 */
		PetUser user =  petUserRepo.getUserDetails(petUser.getUserName());

		if(user != null) {
			if(user.getUserName().equalsIgnoreCase(petUser.getUserName()) &&
					user.getUserPassword().equalsIgnoreCase(petUser.getUserPassword())){
				return "login successful"; 
			}else if(user.getUserPassword() != petUser.getUserPassword()) {
				return "Password entered is wrong"; 
			}
		}else {
			return "User Name entered is wrong";
		}

		return null;

		/*
		 * if(petUserRepo.findById(petUser.getId()) != null){ return
		 * "User Already Exits"; }else {
		 * 
		 * if(petUserRepo.save(petUser) != null) return "User Registration successful";
		 * else return "User registration failed try again"; }
		 */

	}
}
