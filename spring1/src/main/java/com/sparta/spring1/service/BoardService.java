package com.sparta.spring1.service;

import com.sparta.spring1.domain.Board;
import com.sparta.spring1.domain.BoardRepository;
import com.sparta.spring1.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

//    @Transactional
//    public BoardRequestDto getBoard(Long id) {
//        Board board = boardRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("존재하지 않는 글입니다.")
//        );
//        return new BoardRequestDto(board);
//    }


    @Transactional
    public Long update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    }

//    @Transactional
//    public String checkPwd(Long id, String password) {
//        boolean result = false;
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("id", Long.toString(id));
//        map.put("password", password);
//        return map.get("password");
//    }
}
