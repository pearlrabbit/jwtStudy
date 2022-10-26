package com.example.demo.service;

import com.example.demo.domain.entity.Article;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<PageResponseDto> allArticle(){
        List<Article> articles = articleRepository.findAll();
        return articles.stream().map(PageResponseDto::of).collect(Collectors.toList());
    }

}
