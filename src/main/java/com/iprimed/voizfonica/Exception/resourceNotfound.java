 package com.iprimed.voizfonica.Exception;
 


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class resourceNotfound extends   RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public resourceNotfound(String message)
	{
		super(message);
	}
	
	
}
