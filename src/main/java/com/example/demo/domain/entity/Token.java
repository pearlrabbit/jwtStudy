package com.example.demo.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "token")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tokenId;
    @Column(name = "token_name")
    private String tokenName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

//    @Temporal(TemporalType.TIMESTAMP)
//    private Date expiredDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;
}
