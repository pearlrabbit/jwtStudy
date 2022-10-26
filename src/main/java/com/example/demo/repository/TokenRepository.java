package com.example.demo.repository;

import com.example.demo.domain.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TokenRepository extends JpaRepository<Token, Long> {
//    Token findByUserName(String username);
//
//    void deleteByUsername(String username);
    @Transactional
    void deleteByTokenName(String tokenName);

    Token findByTokenName(String tokenName);

}
