package com.example.demo.dto;

import java.util.List;
import java.util.Set;

import com.example.demo.domain.entity.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;

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
