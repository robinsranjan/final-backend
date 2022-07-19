package com.iprimed.voizfonica.model;

public class OtpGenerator {
String email;
String otp;
float expirydate;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getOtp() {
	return otp;
}
public void setOtp(String otp) {
	this.otp = otp;
}
public float getExpirydate() {
	return expirydate;
}
public void setExpirydate(float expirydate) {
	this.expirydate = expirydate;
}
public OtpGenerator(String email, String otp, float expirydate) {
	super();
	this.email = email;
	this.otp = otp;
	this.expirydate = expirydate;
}
public OtpGenerator() {
	super();
}
@Override
public String toString() {
	return "OtpGenerator [email=" + email + ", otp=" + otp + ", expirydate=" + expirydate + "]";
}

}
