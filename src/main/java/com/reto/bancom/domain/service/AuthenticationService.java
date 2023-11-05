package com.reto.bancom.domain.service;

import com.reto.bancom.application.dto.LoginDto;

public interface AuthenticationService {
    String login(LoginDto request);
}
