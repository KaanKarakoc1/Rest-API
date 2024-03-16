package com.example.demo.security.service.impl;

import com.example.demo.security.repository.UserRepository;
import com.example.demo.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {//Only method loadUserByUserName
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {//Transform the email
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User is not exists"));
            }
        };
    }
}
