package com.example.demo.security.service.impl;

import com.example.demo.security.dao.request.SignInRequest;
import com.example.demo.security.dao.request.SignUpRequest;
import com.example.demo.security.dao.response.JwtAuthenticationResponse;
import com.example.demo.security.entities.Role;
import com.example.demo.security.entities.User;
import com.example.demo.security.repository.UserRepository;
import com.example.demo.security.service.AuthenticationService;
import com.example.demo.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();  //bilgileri alıp role.USER nesnesine bastı
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);  //bilgilerden token oluşturdu
        return JwtAuthenticationResponse.builder().token(jwt).build();  //responseda token tutulup döndürüldü.
    }

    //if li bir cümle signupta generate token eşitse databasedekine sign ini yap yeni token oluştur
    @Override
    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));//bilgileri eşledi
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();//problem çıkmazsa tokeni oluşturdu.
    }
}
