package com.example.demo.repository;

import com.example.demo.domain.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
//    Token findByUserName(String username);
//
//    void deleteByUsername(String username);
}
