package com.spring.ideafestivalbackend.domain.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "username")
    private String userName;
    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;
    @Column(name = "kind")
    private String kind;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "board", fetch = FetchType.LAZY)
    private List<Comment> comment = new ArrayList<>();

    public void update(String content,String title,String userName){
        this.content=content;
        this.title=title;
        this.userName=userName;
    }
}
