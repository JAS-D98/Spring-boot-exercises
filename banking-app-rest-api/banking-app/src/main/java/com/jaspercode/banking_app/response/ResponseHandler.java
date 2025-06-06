package com.jaspercode.banking_app.response;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.HashMap;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(String message, Boolean success, HttpStatus httpStatus, Object responseObject){
        
        Map<String,Object> response=new HashMap<>();

        response.put("message", message);
        response.put("success", success);
        response.put("httpStatus", httpStatus);
        response.put("data", responseObject);

        return new ResponseEntity<>(response, httpStatus);
        
    }
    
}
