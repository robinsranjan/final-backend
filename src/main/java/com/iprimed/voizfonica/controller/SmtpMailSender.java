package com.iprimed.voizfonica.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SmtpMailSender {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void send(String to,String subject,String body)throws MessagingException{
		MimeMessage message=javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		helper=new MimeMessageHelper(message,true);
		
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body,true);
		
		javaMailSender.send(message);
	}
	
	public void sendMail(String to,String subject,String body) throws MessagingException {

		MimeMessage message=javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		helper=new MimeMessageHelper(message,true);
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body,true);
		ClassPathResource pdf = new ClassPathResource("static/file1.pdf");
		helper.addAttachment("invoice.pdf", pdf);
		javaMailSender.send(message);
	}
	

}
