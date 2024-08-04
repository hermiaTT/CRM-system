package com.crmSystem.crm_backend.Exception;

public class CustomServiceException extends RuntimeException {
    public CustomServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
