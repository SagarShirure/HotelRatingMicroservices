package com.lcwd.user.service.Payload;

import lombok.*;
import org.springframework.http.HttpStatus;


@Data
@Builder
public class ApiResponse {
    private String message;
    private  boolean sucess;
    private HttpStatus status;
}
