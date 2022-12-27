package com.spring.ideafestivalbackend.domain.user.entity;

import com.spring.ideafestivalbackend.global.entity.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Builder.Default
    private String uuid = UUID.randomUUID().toString();

    private String email;

    @Column(length = 60)
    private String password;

    public void updatePassword(String password){
        this.password = password;
    }


}
