package com.sparta.spring1.controller;

import com.sparta.spring1.domain.Board;
import com.sparta.spring1.domain.BoardRepository;
import com.sparta.spring1.domain.BoardRequestDto;
import com.sparta.spring1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("/api/post")
    public List<Board> getBoardList() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        return boardRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
    }

    @GetMapping("boardList")
    public String getList() {
        return "boardList";
    }

    @GetMapping("/api/post/{id}")
    public BoardRequestDto getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    @PostMapping("/api/post")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

    @PutMapping("/api/post/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        boardService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/post/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return id;
    }
}
