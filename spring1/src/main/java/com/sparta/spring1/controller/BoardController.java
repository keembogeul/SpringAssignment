package com.sparta.spring1.controller;

import com.sparta.spring1.domain.Board;
import com.sparta.spring1.domain.BoardRepository;
import com.sparta.spring1.domain.BoardRequestDto;
import com.sparta.spring1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("/api/post")
    public List<Board> getBoardList() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        return boardRepository.findAllByCreatedAtBetweenOrderByCreatedAtDesc(start, end);
    }

    @GetMapping("/api/post/{id}")
    public Optional<Board> getBoard(@PathVariable Long id) {
        Optional<Board> board = boardRepository.findById(id);
        return board;
    }

    @PostMapping("/api/post")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

    @PostMapping("/api/post/{id}")
    public Boolean checkPwd(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) throws Exception {
        return boardService.checkPassword(id, requestDto.getPassword());
    }


    @PutMapping("/api/post/{id}")
    public Optional<Board> updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        boardService.update(id, requestDto);
        Optional<Board> board = boardRepository.findById(id);
        return board;
    }

    @DeleteMapping("/api/post/{id}")
    public Boolean deleteBoard(@PathVariable Long id) throws Exception {
        return boardService.deleteCheck(id);
    }
}
