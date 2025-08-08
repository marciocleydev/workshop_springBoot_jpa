package com.educandoweb.course.services.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Resource not found id: " + id);
    }
}
