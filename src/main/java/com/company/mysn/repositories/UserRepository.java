package com.company.mysn.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.mysn.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByNickname(String nickname);
}
