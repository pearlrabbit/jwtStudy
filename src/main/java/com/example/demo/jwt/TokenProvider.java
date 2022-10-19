package com.example.demo.jwt;

import com.example.demo.domain.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.io.Decoders;


import java.awt.*;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;


//토큰의 생성, 토큰의 유효성 검증 등을 담당
    public class TokenProvider /*implements InitializingBean*/ {
//    private final Logger logger = LoggerFactory.getLogger(TokenProvider.class);
//
//    private static final String AUTHORITIES_KEY = "auth";
//
//    private final String secret;
//    private final long tokenValidityInMilliseconds;
//    private Key key;
//
//    public TokenProvider(
//            @Value("${jwt.secret}") String secret,
//            @Value("${jwt.token-validity-in-seconds}") long tokenValidityInSeconds) {
//        this.secret = secret;
//        this.tokenValidityInMilliseconds = tokenValidityInSeconds * 1000;
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        byte[] keyBytes = Decoders.BASE64.decode(secret);
//        this.key = Keys.hmacShaKeyFor(keyBytes);
//    }
//
//    //Authentication 객체의 권한정보를 이용해서 토큰을 생성하는 createToken 메소드를 추가합니다.
//    //authenticaion 객체를 받아서 권한 설정을 하고, application.yml 에서 설정했던 토큰 만료시간을 설정하고 토큰을 생성합니다.
//    public String createToken(Authentication authentication) {
//        String authorities = authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(","));
//        System.out.println(authorities+": authorities");
//
//        long now = (new Date()).getTime();
//        Date validity = new Date(now + this.tokenValidityInMilliseconds);
//
//        return Jwts.builder()
//                .setSubject(authentication.getName())
//                .claim(AUTHORITIES_KEY, authorities)
//                .signWith(key, SignatureAlgorithm.HS512)
//                .setExpiration(validity)
//                .compact();
//    }
//
//    //token을 매개변수로 받아서, 토큰에 담긴 정보를 이용해 Authenticaion 객체를 리턴하는 메소드를 작성합니다.
//    //token으로 클레임을 만들고, 클레임에서 권한정보를 받아서 유저 객체를 만들어서 최종적으로 Authenticaion 객체를 리턴합니다.
//    //Claims : JWT 의 속성정보, java 에서 Claims 는 Json map 형식의 인터페이스임
//    public Authentication getAuthentication(String token) {
//        Claims claims = Jwts
//                .parserBuilder()
//                .setSigningKey(key)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//
//        Collection<? extends GrantedAuthority> authorities =
//                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());
//
//        //User principal = new User(claims.getSubject(), "", authorities);
//        //String id=claims.getId();
//        return new UsernamePasswordAuthenticationToken(claims.getId(), token, authorities);
//
////        // JWT 토큰에서 인증 정보 조회
////        public Authentication getAuthentication(String token) {
////            UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
////            return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
////        }
////
////        // 토큰에서 회원 정보 추출
////        public String getUserPk(String token) {
////            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
////        }
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
//            return true;
//        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
//            logger.info("잘못된 JWT 서명입니다.");
//        } catch (ExpiredJwtException e) {
//            logger.info("만료된 JWT 토큰입니다.");
//        } catch (UnsupportedJwtException e) {
//            logger.info("지원되지 않는 JWT 토큰입니다.");
//        } catch (IllegalArgumentException e) {
//            logger.info("JWT 토큰이 잘못되었습니다.");
//        }
//        return false;
//    }
}
