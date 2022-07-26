package com.sparta.spring1.service;

import com.sparta.spring1.domain.Board;
import com.sparta.spring1.domain.BoardRepository;
import com.sparta.spring1.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    }

    public Boolean checkPassword(Long id, String password) throws Exception {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return board.getPassword().equals(password);
    }

    public Boolean deleteCheck(Long id) throws Exception {
        boardRepository.deleteById(id);
        return true;
    }

}
