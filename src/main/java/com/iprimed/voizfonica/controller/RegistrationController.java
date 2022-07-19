package com.iprimed.voizfonica.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iprimed.voizfonica.model.User;
import com.iprimed.voizfonica.repository.RegistrationRepository;
import com.iprimed.voizfonica.service.RegistrationService;
import com.iprimed.voizfonica.model.OtpGenerator;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

	@Autowired
	private RegistrationService service;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SmtpMailSender smtpMailSender;
	@Autowired
	private RegistrationRepository repo;

	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmail();

		if (tempEmail != null && !"".equals(tempEmail)) {

			User userobj = service.fetchUserByEmail(tempEmail);
			if (userobj != null) {
				throw new Exception("user with " + tempEmail + " already exists");
			}
		}
		User userObj = null;
		userObj = service.saveUser(user);
		smtpMailSender.send(tempEmail, "Congratulations your VoizFonica account has been created",
				"Hello " + user.getFirstName()
						+ " Welcome to VoizFonica buy the best internet data plans at lowest prices. Please find your account details:   "
						+ user.getEmail() + "   Password:   " + user.getPassword()
						+ "         Use this link to login: http://localhost:4200/login Thankyou! ");

		return userObj;
	}

	@PostMapping("/forgotpassword")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser1(@RequestBody User user) throws Exception {
		String tempEmail1 = user.getEmail();
		User userObj = null;


		return userObj;
	}

	

	
	@PostMapping("/updatepwd")
	@CrossOrigin("http://localhost:4200")
	public User updatepwd(@RequestBody User cust) {
		long phno = cust.getMobileNumber();
		String email=cust.getEmail();
		String pwd=cust.getPassword();
		System.out.println(phno);
		String query;
		String sql="UPDATE zebra.user SET password=? WHERE mobile_number=?";  
	    jdbcTemplate.update(sql, pwd,phno);
			

		return null;
	}
	

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmail();
		String tempPass = user.getPassword();
		User userObj = null;
		if (tempEmail != null && tempPass != null) {
			userObj = service.fetchUserByEmailAndPassword(tempEmail, tempPass);
		}
		if (userObj == null) {
			throw new Exception("This user does not exist");
		}
		return userObj;
	}
}
