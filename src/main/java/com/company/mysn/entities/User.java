package com.company.mysn.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    @NotNull
    public Long userId;
    
    @NotBlank
    @Column(name="nickname")
    public String nickname;

    @NotBlank
    @Column(name="first_name")
    public String firstName;

    @NotBlank
    @Column(name="last_name")
    public String lastName;

    @NotBlank
    @Column(name="email")
    public String email;

    @NotBlank
    @Column(name="password_hash")
    public String passwordHash;
}
