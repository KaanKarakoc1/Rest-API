package com.example.demo.security.service;


import com.example.demo.security.dao.request.SignInRequest;
import com.example.demo.security.dao.request.SignUpRequest;
import com.example.demo.security.dao.response.JwtAuthenticationResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}
