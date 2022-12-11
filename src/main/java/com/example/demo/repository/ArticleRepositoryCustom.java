package com.example.demo.repository;

import com.example.demo.dto.PageResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleRepositoryCustom {
    Page<PageResponseDto> searchAll(Pageable pageable);
}
