package com.yourview.moview.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Resource is not found!");
    }

    public ResourceNotFoundException(String resource, Long id) {
        super(resource + " " + id + " not found!");
    }
}