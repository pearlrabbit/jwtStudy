package com.example.demo.controller;

import com.example.demo.domain.entity.Article;
import com.example.demo.service.ArticleService;
import com.example.demo.service.AuthService;
import com.example.demo.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/user")
public class ArticleController {

    private final UserService userService;

    private final AuthService authService;

    private final ArticleService articleService;

    public ArticleController(UserService userService, AuthService authService, ArticleService articleService) {
        this.userService = userService;
        this.authService = authService;
        this.articleService = articleService;
    }


    @PostMapping("/board/write")
    @PreAuthorize("hasAnyRole('USER')")
    public void insertArticle(/*@RequestHeader(value = "Authorization") String token, @Validated @RequestBody CreateNoticeRequestDTO requestDto*/){

        System.out.println("난 유저고 게시판 글쓰기까지 왔다");
//        Article article = Article.builder()
//                        .user(userService.findByUsername(authService.verifyToken(token)))
//                                .title()
//                                        .content()
//                                                .boardId()
//                                                        .createdDate(new Date())
//                build();

//        ArticleService.

    }

}
