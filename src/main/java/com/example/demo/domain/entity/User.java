package com.example.demo.domain.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Set;

@Table(name = "user")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    private String nickname;

    private String email;

    private String password;

//    @ManyToMany
//    @JoinTable(
//            name = "user_authority",
//            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
//            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
//    private Set<Authority> authorities;

    private RoleType role;

}
