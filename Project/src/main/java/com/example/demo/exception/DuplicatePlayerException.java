package com.example.demo.exception;

/**
 * Unique class for an exception if there is a request to save an existing player
 */
public class DuplicatePlayerException extends RuntimeException{
    public DuplicatePlayerException(String message) {
        super(message);
    }
}