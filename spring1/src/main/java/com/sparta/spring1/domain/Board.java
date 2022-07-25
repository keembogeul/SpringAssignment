package com.sparta.spring1.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Board extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String password;

    public Board(String title, String author, String contents, String password) {
        this.title = title;
        this.author = author;
        this.contents = contents;
        this.password = password;
    }

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }
    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }
}
