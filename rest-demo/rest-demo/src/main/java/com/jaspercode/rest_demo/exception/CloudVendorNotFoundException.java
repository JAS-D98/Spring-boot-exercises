package com.jaspercode.rest_demo.exception;

public class CloudVendorNotFoundException extends RuntimeException {
    
    //constructor
    public CloudVendorNotFoundException(String message){
        super(message);
    }

    public CloudVendorNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
