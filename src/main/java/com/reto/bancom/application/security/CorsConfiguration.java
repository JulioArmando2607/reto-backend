package com.reto.bancom.application.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfiguration {

   @Bean
   public CorsFilter corsFilter() {
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors.CorsConfiguration();
      config.setAllowCredentials(false);
      config.addAllowedOrigin("*");
      config.addAllowedHeader("*");
      config.addAllowedMethod("*");

      source.registerCorsConfiguration("/api/**", config);
      source.registerCorsConfiguration("/external/**", config);
      return new CorsFilter(source);
   }

}
