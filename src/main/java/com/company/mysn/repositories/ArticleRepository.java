package com.company.mysn.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.mysn.entities.Article;
import com.company.mysn.entities.User;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findArticlesByUser(User user);

    List<Article> findArticlesByUserNickname(String nickname);

    List<Article> findTop100ByOrderByIdDesc();
}
