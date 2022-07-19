package com.iprimed.voizfonica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iprimed.voizfonica.model.Postpaid;

import com.iprimed.voizfonica.repository.PostpaidRepo;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PostpaidController {
	
	
	
	@Autowired
	private PostpaidRepo postpaidrepo;
	
	@PostMapping("/addpostpaidplan")
	@CrossOrigin(origins="http://localhost:4200")
	public Postpaid createPostpaid(@RequestBody Postpaid plan) {
		return postpaidrepo.save(plan);
	}
	
	@GetMapping("/postpaidplans")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Postpaid> getAllPlans() {
		return postpaidrepo.findAll();
	}
	
	

}
