package com.iprimed.voizfonica.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import com.iprimed.voizfonica.model.User;
import com.iprimed.voizfonica.repository.RegistrationRepository;
import com.iprimed.voizfonica.service.RegistrationService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ForgotController {
	Random random = new Random(1000);
	
//	@Autowired
//	private SmtpMailSender smtpMailSender;
	@Autowired
	private RegistrationService service;
	
	@Autowired
	private RegistrationRepository userRepsitory;
	
//	

	@PostMapping("/send-otp")
	@CrossOrigin(origins="http://localhost:4200")
	public User sendOTP(@RequestBody User user, HttpSession session ) throws Exception {
		
		String tempEmail1=user.getEmail();
		
		User userObj=null;
		
		
		
		System.out.println("Email id:" +tempEmail1);
		
		//generating otp of 4 digits
		
		
		int otp = random.nextInt(99999999);
		
		System.out.println("Your OTP is: "+ otp);
//		if(userObj == null) {
//			throw new Exception("Bad credintials");}
//		smtpMailSender.send(tempEmail1,"Reset your password","Your One Time password is: "+otp);
//		
		session.setAttribute("myotp", otp);
		session.setAttribute("email", tempEmail1);
		
		
		return userObj;
	}
	
//	@PostMapping("/registeruser")
//	@CrossOrigin(origins="http://localhost:4200")
//	public User registerUser(@RequestBody User user) throws Exception {
//		String tempEmail=user.getEmail();
//		
//		
//		if(tempEmail !=null &&  !"".equals(tempEmail)) {
//		
//			User userobj = service.fetchUserByEmail(tempEmail);
//			if (userobj != null) {
//				throw new Exception("user with "+tempEmail+"is already exist");
//			}
//		}
//		User userObj=null;
//		userObj=service.saveUser(user);
//		smtpMailSender.send(tempEmail, "Voizfonica Registration successfull", 
//				"Hello "+user.getFirstName()+" Welcome to voizfonica! Your registration was Successfull! EmailID:   "+user.getEmail()+"   Password:   "+user.getPassword()+"         Use this link to login: http://localhost:4200/login Thankyou! ");
//			
//		return userObj;
//	}
//	
	
	//verify otp
//		@PostMapping("/verify-otp")
//		public User verifyOtp(@RequestBody User user,HttpSession session,User otp) throws Exception
//		{
//			int myOtp=(int)session.getAttribute("myotp");
//			User userObj=otp;
//			System.out.println("User OTP "+otp);
//			System.out.println("Our OTP "+myOtp);
//			
////			String email=(String)session.getAttribute("email");
//			if(myOtp==otp)
//			{
//				//password change form 
////				User user = this.userRepsitory.getUserByUserName(email);
//				
////				if(user==null)
////				{
////					//send error message
////					session.setAttribute("message", "User does not exits with this email !!");
////					
////					return "forgot_email_form";
////				}else
////				{
////					//
////					//send change password form
////					
////				}
//				
//				
//				
//				return userObj;
//			}else
//			{
//				session.setAttribute("message", "You have entered wrong otp !!");
//				return userObj;
//			}
//		}
//
//}
}
