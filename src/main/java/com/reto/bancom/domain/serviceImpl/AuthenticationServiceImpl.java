package com.reto.bancom.domain.serviceImpl;

import com.reto.bancom.application.security.CustomUserDetailsService;
import com.reto.bancom.application.dto.LoginDto;
import com.reto.bancom.domain.service.AuthenticationService;
import com.reto.bancom.domain.service.JwtService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final CustomUserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public String login(LoginDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userDetailsService.loadUserByUsername(request.getUsername());
        return jwtService.generateToken(user);
    }
}
