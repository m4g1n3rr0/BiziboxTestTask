package com.example.DataReceiving.exceptions;

public class PhoneCallNotFoundException extends RuntimeException {

    public PhoneCallNotFoundException(String message) {
      
    	super(message);
   
    }

    public PhoneCallNotFoundException(String message, Throwable cause) {
   
    	super(message, cause);
   
    }

}
