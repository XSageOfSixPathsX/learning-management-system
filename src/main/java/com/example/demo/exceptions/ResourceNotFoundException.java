package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(String resource, String fieldName, Long fieldValue){
        super(String.format("%s not found for %s - %s ", resource, fieldName, fieldValue));
    }

    public ResourceNotFoundException(String resource, String fieldName, String combinedFieldValues) {
        super(String.format("%s not found for %s - %s", resource, fieldName, combinedFieldValues));
    }
}