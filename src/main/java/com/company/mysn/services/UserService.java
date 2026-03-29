package com.company.mysn.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.mysn.dto.RegistrationDto;
import com.company.mysn.entities.User;
import com.company.mysn.repositories.UserRepository;

import jakarta.annotation.Nullable;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user){
        if (findUserByNickname(user.getNickname()).isPresent()){
            return;
        }
        userRepository.save(user);
    }

    public Optional<User> findUserByNickname(String name){
        return userRepository.findUserByNickname(name);
    }

    public boolean existsByNickname(String nickname){
        return userRepository.existsByNickname(nickname);
    }


    @Nullable
    public String register(RegistrationDto dto){
        if (existsByNickname(dto.username)) return "Пользователь с таким именем уже существует";

        var dtoCheckError = dto.check();
        if (dtoCheckError != null) return dtoCheckError;

        var user = new User();

        user.setNickname(dto.username);
        user.setPasswordHash(passwordEncoder.encode(dto.password));

        userRepository.save(user);

        return null;
    }
}
