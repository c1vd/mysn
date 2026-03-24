package com.company.mysn.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private Long userId;
    
    @NotBlank
    @Column(name="nickname")
    private String nickname;

    @NotBlank
    @Column(name="first_name")
    private String firstName;

    @NotBlank
    @Column(name="last_name")
    private String lastName;

    @NotBlank
    @Column(name="password_hash")
    private String passwordHash;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name="posts")
    private List<Article> posts = new ArrayList<>();

    public void addPost(Article post) {
        posts.add(post);
        post.setUser(this);
    }

    public void removePost(Article post) {
        posts.remove(post);
        post.setUser(null);
    }
}
