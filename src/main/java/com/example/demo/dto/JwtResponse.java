package com.example.demo.dto;

import java.util.List;

import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponse {
    private Long userId;
    //	private String username;
    private String email;

    private String tokenType;
    private String jwt;
    private Integer tokenExpirationMs;

    private List<String> roles;
}
