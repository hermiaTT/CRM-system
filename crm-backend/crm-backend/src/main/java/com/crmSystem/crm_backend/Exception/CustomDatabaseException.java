package com.crmSystem.crm_backend.Exception;

import org.springframework.cache.interceptor.CacheOperationInvoker;

public class CustomDatabaseException extends RuntimeException {
    public CustomDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
