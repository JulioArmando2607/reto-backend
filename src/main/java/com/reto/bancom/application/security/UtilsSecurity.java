package com.reto.bancom.application.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Slf4j
public class UtilsSecurity {

    public static Long getUserId() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            log.debug("Security Contexto Sin información de autenticación.");
            return null;
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUser customUser) {
            log.info(customUser.getUserId().toString());
            return customUser.getUserId();
        }

        return null;
    }
}
