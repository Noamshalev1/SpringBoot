package com.example.demo.exception;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    /**
     * Handles IllegalArgumentException and IllegalStateException exceptions
     * @param ex      The RuntimeException that was thrown, typically IllegalArgumentException or IllegalStateException.
     * @param request The current web request in which the exception occurred.
     * @return A ResponseEntity containing a custom error message, headers, and the HTTP status code.
     */
    @ExceptionHandler(value
            = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "An error occurred: " + ex.getMessage();
        return new ResponseEntity<>(bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT);
    }
    /**
     * In case there is a problem with the player details
     * @param ex the exception
     * @return a relevant response to client
     */
    @ExceptionHandler(PlayerNotFoundException.class)
    protected ResponseEntity<Object> handlePlayerNotFound(PlayerNotFoundException ex, WebRequest request) {
        String bodyOfResponse = "Player not found: " + ex.getMessage();
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicatePlayerException.class)
    protected ResponseEntity<Object> handlePlayerNotFound(DuplicatePlayerException ex, WebRequest request) {
        String bodyOfResponse = "Duplicate Player: " + ex.getMessage();
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.NOT_FOUND);
    }

    //fallback
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception e){
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

