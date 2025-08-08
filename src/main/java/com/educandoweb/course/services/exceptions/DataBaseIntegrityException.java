package com.educandoweb.course.services.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class DataBaseIntegrityException extends RuntimeException{
    public DataBaseIntegrityException(String msg){
        super(msg);
    }
}
