package com.iprimed.voizfonica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iprimed.voizfonica.model.AdminRegistration;
import com.iprimed.voizfonica.model.User;
import com.iprimed.voizfonica.repository.AdminRegistrationRepository;


@Service
public class AdminRegistrationService {

	@Autowired
	public AdminRegistrationRepository repo;
	
	public AdminRegistration saveUser(AdminRegistration user) {
		return repo.save(user);
		
	}
	
	
	public AdminRegistration fetchUserByEmail(String email) {
		return repo.findByEmail(email);
		
	}
	
	
	public AdminRegistration fetchUserByEmailAndPassword(String email,String password) {
		return repo.findByEmailAndPassword(email, password);
		
	}


//	public AdminRegistration fetchUserByEmail(String tempEmail) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}