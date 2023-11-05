package com.reto.bancom.application.security;

import com.reto.bancom.infrastructure.persistence.entity.UserEntity;
import com.reto.bancom.infrastructure.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.List;

@Component("userDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByName(username)
                .map(this::createUser)
                .orElseThrow(() -> new UsernameNotFoundException(username + " -> usuario no encontrado."));
    }

    private User createUser(UserEntity user) {
        List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority("USER"));
        return new User(user.getName(), user.getPassword(), grantedAuthorities);
    }
}
