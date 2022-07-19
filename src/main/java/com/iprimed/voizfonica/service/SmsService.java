package com.iprimed.voizfonica.service;

import java.text.ParseException;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.iprimed.voizfonica.controller.storeOtp;
import com.iprimed.voizfonica.model.SmsPojo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Component
public class SmsService {
private   final String aid="AC3e0fc0ebd685503e1d90e459a3851f5a";
private  final String at= "cf5b8ca6baf6c3c33c3e2da821f04b85";
private final String  ph="+19377173386";
public  void   send(SmsPojo  sms) throws   ParseException
{
        Twilio.init(aid, at);
        int min=100000;
        int max=999999;
        int number=(int)(Math.random()*(max-min+1)+min);
        String msg="your OTP - " +number+
                "   pls varify  this OTP in your application by Mr Ankit";
        Message message=Message.creator(new PhoneNumber(sms.getPhoneNo()),
                new PhoneNumber(ph),msg).create();
storeOtp.setOtp(number);
}
public  void  receieve(MultiValueMap<String,String> smlscallback)
{

}
}
