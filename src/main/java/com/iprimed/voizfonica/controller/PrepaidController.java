package com.iprimed.voizfonica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iprimed.voizfonica.model.Prepaid;
import com.iprimed.voizfonica.repository.PrepaidRepo;

@RestController
@CrossOrigin(origins="http://localhost:4200")

public class PrepaidController {
	
	@Autowired
	private PrepaidRepo prepaidrepo;
	
	@PostMapping("/addprepaidplan")
	@CrossOrigin(origins="http://localhost:4200")
	public Prepaid createPrepaid(@RequestBody Prepaid plan) {
		return prepaidrepo.save(plan);
	}
	
	@GetMapping("/plans")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Prepaid> getAllPlans() {
		return prepaidrepo.findAll();
	}
	
	
	
	
	

}
