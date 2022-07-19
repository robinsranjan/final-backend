 package com.iprimed.voizfonica.controller;
 


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iprimed.voizfonica.model.usersMessage;
import com.iprimed.voizfonica.repository.usersMessageRepository;
import com.iprimed.voizfonica.Exception.resourceNotfound;
//
//import com.crud.exception.resourceNotfound;
//import com.crud.model.usersMessage;
//import com.crud.repository.usersMessageRepository;


@CrossOrigin(origins ="http://localhost:4200" )
@RestController
@RequestMapping("")
public class userMessageController {

	@Autowired
	private usersMessageRepository usersmessage;

	
	//get all users res Apis
	
	@GetMapping("/usersmessages")
	public List<usersMessage> getAllMessages()
	{
		return usersmessage.findAll();
	}
	
	
	//create users rest Apis 
	@PostMapping("/usersmessages")
	public usersMessage createMessages(@RequestBody usersMessage message)
	{
		return  usersmessage.save(message);
	}
	
	
	//delete employee
	
	@DeleteMapping("/usersmessages/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteMessage(@PathVariable Long id)
	{
		
		usersMessage  usermessage = usersmessage.findById(id)
				.orElseThrow(() -> new  resourceNotfound("message does not exist with id :" + id));
		
		usersmessage.delete(usermessage);
		
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
}





