package com.example.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.domain.entity.Token;
import com.example.demo.dto.LoginDto;
import com.example.demo.jwt.TokenProvider;
import com.example.demo.repository.TokenRepository;
import com.example.demo.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.*;
import java.util.*;

@Service
public class AuthService {

    @Value("${jwt.secret}")
    String secret;

    @Autowired
    private TokenRepository tokenRepository;

    public String verifyToken(String token) {
        DecodedJWT decodedJWT = getDecodedToken(token);

        String username = decodedJWT.getClaim("username").asString();
        return username;
    }

    public DecodedJWT getDecodedToken(String token){
        token = token.replaceAll("Bearer ", "");
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(Base64.getDecoder().decode(secret)))
                .build()
                .verify(token);
        return decodedJWT;
    }

    public void deleteToken(String token){
        //tokenRepository.deleteByTokenName(token);
        Token token1=tokenRepository.findByTokenName(token);
        tokenRepository.delete(token1);


    }

}
