package com.practice.securedrest.service;

import com.practice.securedrest.model.AuthenticationRequest;

public interface AuthenticationService {
    String authenticate(AuthenticationRequest authenticationRequest) throws Exception;

    String getUserName();
}
