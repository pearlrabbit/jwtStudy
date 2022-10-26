package com.example.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "article")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long articleId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "text")
    private String content;

    @CreationTimestamp
    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    @Column
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(nullable = false)
    private int boardId;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    public static Article createArticle (String title, String content, User user, int boardId) {
        Article article = new Article();
        article.title = title;
        article.content = content;
        article.user = user;
        article.boardId = boardId;
        return article;
    }

    public static Article updateArticle (Article article, String title, String content) {
        article.title = title;
        article.content = content;

        return article;
    }

}
