package com.example.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Table(name = "user")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

        @JsonIgnore
        @Id
        @Column(name = "user_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long userId;

        @Column(name = "username", length = 50, unique = true)
        private String username;

        @JsonIgnore
        @Column(name = "password", length = 100)
        private String password;

        @Column(name = "nickname", length = 50)
        private String nickname;

        @JsonIgnore
        @Column(name = "activated")
        private boolean activated;

        @ManyToMany
        @JsonBackReference
        @JoinTable(
                name = "user_authority",
                joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
                inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
        private Set<Authority> authorities;

        @JsonBackReference
        @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        private Set<Token> tokens;
}
