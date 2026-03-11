package com.reciproci.loyalty.burnrule.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.reciproci.loyalty.tier.exceptions.TierValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BurnRuleAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleBurnRuleExists(BurnRuleAlreadyExistsException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", System.currentTimeMillis());
        response.put("message", ex.getMessage());
        // You can return 400 (Bad Request) or 409 (Conflict) 
        return new ResponseEntity<>(response, HttpStatus.CONFLICT); 
    }
    
//    // Optional: Handle other general exceptions
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
//        Map<String, Object> response = new HashMap<>();
//        response.put("timestamp", System.currentTimeMillis());
//        response.put("message", "An unexpected error occurred: " + ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
    
    @ExceptionHandler(TierValidationException.class)
    public ResponseEntity<Map<String, Object>> handleTierException(TierValidationException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Tier Qualification Error");
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
