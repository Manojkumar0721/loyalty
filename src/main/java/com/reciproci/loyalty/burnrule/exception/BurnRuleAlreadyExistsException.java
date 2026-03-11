package com.reciproci.loyalty.burnrule.exception;

public class BurnRuleAlreadyExistsException extends RuntimeException {
    public BurnRuleAlreadyExistsException(String message) {
        super(message);
    }
}