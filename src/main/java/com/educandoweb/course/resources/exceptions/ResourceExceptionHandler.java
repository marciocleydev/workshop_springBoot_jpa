package com.educandoweb.course.resources.exceptions;

import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice //intercepta as excesao para que este objeto possa fazer o tratamento.
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) // Diz que esse método deve tratar a excessão do tipo ResourceNotFoundException.
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());//instanciando minha classe personalizada
        return ResponseEntity.status(status).body(err);
    }
}
