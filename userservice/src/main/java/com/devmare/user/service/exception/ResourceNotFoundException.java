package com.devmare.user.service.exception;

public class ResourceNotFoundException extends RuntimeException {
    ResourceNotFoundException() {
        super("Resource not found on server!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
