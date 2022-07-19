package com.iprimed.voizfonica.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iprimed.voizfonica.model.SmsPojo;
import com.iprimed.voizfonica.service.SmsService;


@RestController

public class SmsController {

    @Autowired
    SmsService service;
    @Autowired
    SimpMessagingTemplate websocket;
    final String  topic_dest="/lesson/sms";
    @RequestMapping(value = "/mobileNo", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<String>  smsSubmit(@RequestBody  SmsPojo sms)
    {
        try {
            System.out.println("hello");
            service.send(sms);
            System.out.println("hello");
        }
        catch (Exception e) {
        return new 
        ResponseEntity<String>("something problem",
                HttpStatus.INTERNAL_SERVER_ERROR);

        }
        websocket.convertAndSend(topic_dest, getTimeStamp() + ": SMS has sent :"+
        sms.getPhoneNo()
        );
        return new ResponseEntity<String>("OTP sent successfully", HttpStatus.OK);
    }
   
	/*
	 * @RequestMapping(value = "/smscallback", method = RequestMethod.POST, consumes
	 * = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces =
	 * MediaType.APPLICATION_JSON_VALUE) public void smsCallback(@RequestBody
	 * MultiValueMap<String,String> map) { service.receieve(map);
	 * websocket.convertAndSend(topic_dest, getTimeStamp() +
	 * ": Twilio has made a callback request Here are the Contents :"+
	 * map.toString() );
	 * 
	 * }
	 */

    private String  getTimeStamp()
    {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .format(LocalDateTime.now());
    }
   
}