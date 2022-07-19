package com.iprimed.voizfonica.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iprimed.voizfonica.model.AdminRegistration;
import com.iprimed.voizfonica.model.User;
import com.iprimed.voizfonica.repository.AdminRegistrationRepository;
import com.iprimed.voizfonica.service.AdminRegistrationService;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
public class AdminRegistrationController {
	
	@Autowired
	public AdminRegistrationRepository adminregistration;
	
	@Autowired
	public AdminRegistrationService service;
	
	
	@PostMapping("/registeradmin")
	@CrossOrigin(origins = "http://localhost:4200")
	public AdminRegistration registerUser(@RequestBody AdminRegistration user) throws Exception {
		String tempEmail = user.getEmail();

		if (tempEmail != null && !"".equals(tempEmail)) {

			AdminRegistration userobj = service.fetchUserByEmail(tempEmail);
			if (userobj != null) {
				throw new Exception("user with " + tempEmail + " already exists");
			}
		}
		AdminRegistration userObj = null;
		userObj = service.saveUser(user);
		return userObj;

}
	
	
	@PostMapping("/adminlogin")
	@CrossOrigin(origins = "http://localhost:4200")
	public AdminRegistration loginAdmin(@RequestBody AdminRegistration user) throws Exception {
		String tempEmail = user.getEmail();
		String tempPass = user.getPassword();
		AdminRegistration userObj = null;
		if (tempEmail != null && tempPass != null) {
			userObj = service.fetchUserByEmailAndPassword(tempEmail, tempPass);
		}
		if (userObj == null) {
			throw new Exception("This user does not exist");
		}
		return userObj;
	}
	
	
	
}