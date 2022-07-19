package com.iprimed.voizfonica.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class verifyOtp {
@PostMapping("/otp")
@CrossOrigin(origins = "http://localhost:4200")
public String verify(@RequestBody TemporaryOtp sms )
{
	int a=sms.getOtp();
	if(a==storeOtp.getOtp())
		return "Otp verified Welcome ";
	else
		return "otp is Invalid";
}
}