package com.example.demo.service;

import com.example.demo.domain.entity.Token;
import com.example.demo.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TokenService {
    //@Autowired
    private TokenRepository tokenRepository;

    //@Autowired
    private UserService userService;

//    public Token findTokenByUserId(long userId) {
//        User user = this.userService.findUserById(userId);
//        Optional<Token> token = this.tokenRepository.findByUserId(user.getUserId());
//        if (token.isPresent()) {
//            return token.get();
//        } else {
//            throw new CustomException(ErrorCode.TOKEN_NOT_FOUND);
//        }
//    }
}
