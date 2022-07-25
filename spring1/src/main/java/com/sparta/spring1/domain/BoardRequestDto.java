package com.sparta.spring1.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardRequestDto {
    private String title;
    private String author;
    private String contents;
    private String password;

    public BoardRequestDto(String title, String author, String contents, String password) {
        this.title = title;
        this.author = author;
        this.contents = contents;
        this.password = password;
    }

    public BoardRequestDto(Board board) {
        this.title = board.getTitle();
        this.author = board.getAuthor();
        this.contents = board.getContents();
        this.password = board.getPassword();
    }

}