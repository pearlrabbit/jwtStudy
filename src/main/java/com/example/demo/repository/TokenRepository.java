package com.example.demo.repository;

import com.example.demo.domain.entity.Token;
import com.example.demo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByUser(User user);
//
//    void deleteByUsername(String username);
    @Transactional
    void deleteByTokenName(String tokenName);

    Token findByTokenName(String tokenName);

}
