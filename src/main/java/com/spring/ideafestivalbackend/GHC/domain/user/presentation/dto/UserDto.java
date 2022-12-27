package com.spring.ideafestivalbackend.GHC.domain.user.presentation.dto;

import com.spring.ideafestivalbackend.GHC.domain.user.entity.User;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class UserDto {
    //회원 ID
    private final String memberId;
    //회원 Password
    private final String memberPw;
    //회원 Name
    private final String memberName;
    //회원 Mail
    private final String memberMail;

    public User UserEntity(){
        return User.builder()
                .userId(this.memberId)
                .userPw(this.memberPw)
                .userName(this.memberName)
                .userMail(this.memberMail)
                .build();
    }
}
