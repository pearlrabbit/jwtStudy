package com.example.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.domain.entity.Token;
import com.example.demo.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class AuthService {

//    @Value("${jwt.secret}")
//    String secret;
//
//    @Autowired
//    private TokenRepository tokenRepository;
//
//    public String verifyToken(String token) {
//        DecodedJWT decodedJWT = getDecodedToken(token);
//
//        String username = decodedJWT.getClaim("username").asString();
//        return username;
//    }
//
//    private DecodedJWT getDecodedToken(String token){
//        token = token.replaceAll("Bearer ", "");
//        DecodedJWT decodedJWT = JWT.require(Algorithm.HMA512(secret))
//                .build()
//                .verify(token);
//        return decodedJWT;
//    }

}
