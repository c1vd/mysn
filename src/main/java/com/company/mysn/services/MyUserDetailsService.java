package com.company.mysn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.company.mysn.repositories.UserRepository;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findUserByNickname(username).orElseThrow(() -> new UsernameNotFoundException("username not found"));
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getNickname())
                .password(user.getPasswordHash())
                .build();
    }
}
