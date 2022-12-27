package com.spring.ideafestivalbackend.GHC.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class User {
    //회원 Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_idx")
    private Long userIdx;

    @Column(name = "user_id")
    private String userId;
    //회원 Pw
    @Column(name = "user_pw")
    private String userPw;
    //회원 name
    @Column(name = "user_name")
    private String userName;
    //회원 mail
    @Column(name = "user_mail")
    private String userMail;


    public Long getUserIdx() {
        return userIdx;
    }
}
