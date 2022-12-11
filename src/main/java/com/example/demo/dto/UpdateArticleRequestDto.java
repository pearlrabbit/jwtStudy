package com.example.demo.dto;

import lombok.Getter;

@Getter
public class UpdateArticleRequestDto {
    private Long id;
    private String title;
    private String content;
}
