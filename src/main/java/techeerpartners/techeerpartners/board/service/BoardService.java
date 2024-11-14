package techeerpartners.techeerpartners.board.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import techeerpartners.techeerpartners.board.dto.BoardResponse;
import techeerpartners.techeerpartners.board.dto.CreateBoardRequestDto;
import techeerpartners.techeerpartners.board.dto.FixBoardRequestDto;
import techeerpartners.techeerpartners.board.entity.Board;
import techeerpartners.techeerpartners.board.repository.BoardRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @Transactional
    public void deleteBoard(Long id) {
        Board board =boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID를 찾을 수없음"));
        boardRepository.delete(board);
    }
    @Transactional
    public List<BoardResponse> getAllCompletedTasks() {
        return boardRepository.findByIsDoneTrue().stream()
                .map(board -> BoardResponse.builder()
                        .id(board.getBoardId())
                        .title(board.getTitle())
                        .isDone(board.getIsDone())
                        .build())
                .collect(Collectors.toList());
    }
    @Transactional
    public List<BoardResponse> getAllTasks() {
        return boardRepository.findAll().stream()
                .map(board -> BoardResponse.builder()
                        .id(board.getBoardId())
                        .title(board.getTitle())
                        .isDone(board.getIsDone())
                        .build())
                .collect(Collectors.toList());
    }

}
