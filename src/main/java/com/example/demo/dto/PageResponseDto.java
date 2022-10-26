package com.example.demo.dto;

import com.example.demo.domain.entity.Article;
import lombok.Builder;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
@Builder
public class PageResponseDto {
    private Long articleId;
    private String title;
    private String username;
    private String createdAt;

    public static PageResponseDto of(Article article) {
        return PageResponseDto.builder()
                .articleId(article.getArticleId())
                .title(article.getTitle())
                .username(article.getUser().getUsername())
                .createdAt(article.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }
}