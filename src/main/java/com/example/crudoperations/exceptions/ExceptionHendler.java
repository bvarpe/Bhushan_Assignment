package com.example.crudoperations.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHendler {

    @ExceptionHandler(DealNotCreatedException.class)
    public ResponseEntity<Map<String ,Object>> handleDealNotCreatedException(DealNotCreatedException dealEx){
        Map<String ,Object> map=new HashMap<String,Object>();
        map.put("message", dealEx.getMessage());
        map.put("Status", HttpStatus.NOT_IMPLEMENTED);

        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(map);
    }

    @ExceptionHandler(DealException.class)
    public ResponseEntity<Map<String ,Object>> handleDealNotFoundException(DealException dealEx){
        Map<String ,Object> map=new HashMap<String,Object>();
        map.put("message", dealEx.getMessage());
        map.put("Status", HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    @ExceptionHandler(MapperException.class)
    public ResponseEntity<Map<String ,Object>> handleDealNotFoundException(MapperException mapperException){
        Map<String ,Object> map=new HashMap<String,Object>();
        map.put("message", mapperException.getMessage());
        map.put("Status", HttpStatus.INTERNAL_SERVER_ERROR);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
    }

    @ExceptionHandler(DataException.class)
    public ResponseEntity<Map<String ,Object>> handleDealNotFoundException(DataException dataException){
        Map<String ,Object> map=new HashMap<String,Object>();
        map.put("message", dataException.getMessage());
        map.put("Status", HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    @ExceptionHandler(DealNotCreated.class)
    public ResponseEntity<Map<String ,Object>> handleDealNotFoundException(DealNotCreated dealNotCreated){
        Map<String ,Object> map=new HashMap<String,Object>();
        map.put("message", dealNotCreated.getMessage());
        map.put("Status", HttpStatus.NOT_IMPLEMENTED);

        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(map);
    }

    @ExceptionHandler(DealNotUpdated.class)
    public ResponseEntity<Map<String ,Object>> handleDealNotFoundException(DealNotUpdated dealNotUpdated){
        Map<String ,Object> map=new HashMap<String,Object>();
        map.put("message", dealNotUpdated.getMessage());
        map.put("Status", HttpStatus. NOT_IMPLEMENTED);

        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(map);
    }




}
