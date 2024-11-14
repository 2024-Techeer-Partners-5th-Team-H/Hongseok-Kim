package techeerpartners.techeerpartners.board.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import techeerpartners.techeerpartners.board.dto.CreateBoardRequestDto;
import techeerpartners.techeerpartners.board.dto.FixBoardRequestDto;
import techeerpartners.techeerpartners.board.entity.Board;
import techeerpartners.techeerpartners.board.repository.BoardRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    @Transactional
    public void addBoard(CreateBoardRequestDto createBoardRequestDto) {
        Board board = new Board();
        board.setTitle(createBoardRequestDto.getTitle());
        board.setContent(createBoardRequestDto.getContent());
        boardRepository.save(board);
    }
    @Transactional
    public void updateBoard(Long id, FixBoardRequestDto fixBoardRequestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID를 찾을 수없음"));
        board.setContent(fixBoardRequestDto.getContent());
        board.setIsDone(fixBoardRequestDto.getIsDone());
    }

}
