package com.reto.bancom.application.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Slf4j
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class SecurityAuditorAware {
    @Bean
    public AuditorAware<Long> auditorProvider() {
        return () -> Optional.ofNullable(UtilsSecurity.getUserId());
    }
}
