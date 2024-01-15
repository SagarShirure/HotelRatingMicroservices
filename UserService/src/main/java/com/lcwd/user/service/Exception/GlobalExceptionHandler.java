package com.lcwd.user.service.Exception;

import com.lcwd.user.service.Payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<ApiResponse> handlerResourceNotFound(ResourceNotFoundException resourceNotFoundException){
        String message=resourceNotFoundException.getMessage();
        ApiResponse response=ApiResponse.builder().message(message).sucess(true).status(HttpStatus.NOT_FOUND).build();
        return  new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
