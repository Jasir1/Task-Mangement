package com.taita.webapp.taskmanagement.exception;

public class AccessDeniedException extends RuntimeException{
    public AccessDeniedException(String exception){
        super(exception);
    }
}
