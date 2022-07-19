package com.iprimed.voizfonica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iprimed.voizfonica.model.Dongle;
import com.iprimed.voizfonica.repository.DongleRepo;

import java.util.List;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class DongleController {
	
	
	@Autowired
	private DongleRepo donglerepo;
	
	
	@PostMapping("adddongleplan")
	@CrossOrigin(origins="http://localhost:4200")
	public Dongle createDongle(@RequestBody Dongle plan) {
		return donglerepo.save(plan);
	}
	
	@GetMapping("/dongleplans")
	public List<Dongle> getAllDongles(){
		return donglerepo.findAll();
	}
	
	

}
