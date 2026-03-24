package com.company.mysn.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.mysn.entities.User;
import com.company.mysn.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(User user){
        if (findUserByNickname(user.nickname).isPresent()){
            return;
        }
        userRepository.save(user);
    }

    public Optional<User> findUserByNickname(String name){
        return userRepository.findUserByNickname(name);
    }
}
