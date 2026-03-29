package com.company.mysn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.mysn.entities.Article;
import com.company.mysn.entities.User;
import com.company.mysn.repositories.ArticleRepository;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findByUser(User user){
        return articleRepository.findArticlesByUser(user);
    }

    public List<Article> findByUserNickname(String nickname){
        return articleRepository.findArticlesByUserNickname(nickname);
    }

    public List<Article> last100(){
        return articleRepository.findTop100ByOrderByIdDesc();
    }

    public void save(Article article){
        articleRepository.save(article);
    }
}
