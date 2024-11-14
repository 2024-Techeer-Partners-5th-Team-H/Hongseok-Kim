package techeerpartners.techeerpartners.board.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import techeerpartners.techeerpartners.board.dto.BoardRequestDto;
import techeerpartners.techeerpartners.board.entity.Board;
import techeerpartners.techeerpartners.board.repository.BoardRepository;

@Service
@AllArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    @Transactional
    public void addBoard(BoardRequestDto boardRequestDto) {
        Board board = new Board();
        board.setTitle(boardRequestDto.getTitle());
        board.setContent(boardRequestDto.getContent());

        // Board 엔티티를 DB에 저장
        boardRepository.save(board);


    }

}
