package com.lcwd.gateway.model;

import lombok.Data;

import java.util.Collection;

@Data
public class AuthResponse {
    private String userID;
    private String accessToken;
    private String refreshToken;
    private long expireAt;
    private Collection<String> authorities;
}
