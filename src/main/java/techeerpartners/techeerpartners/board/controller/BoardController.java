package techeerpartners.techeerpartners.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techeerpartners.techeerpartners.board.dto.BoardResponse;
import techeerpartners.techeerpartners.board.dto.CreateBoardRequestDto;
import techeerpartners.techeerpartners.board.dto.FixBoardRequestDto;
import techeerpartners.techeerpartners.board.service.BoardService;
import techeerpartners.techeerpartners.common.CustomApiResponse;

import java.util.List;

@Tag(name = "Board", description = "게시판 API")
@RequestMapping("/Board")
@RestController
@AllArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @Operation(summary = "할 일 추가", description = "새로운 할 일을 추가합니다.")
    @PostMapping("/tasks")
    public ResponseEntity<CustomApiResponse> createTask(@RequestBody CreateBoardRequestDto createBoardRequestDto) {
        boardService.addBoard(createBoardRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(CustomApiResponse.onSuccess("일정 추가됌"));
    }
    @Operation(summary = "할 일 수정", description = "할 일과,완료여부가 수정되었습니다.")
    @PatchMapping("/tasks/{id}")
    public ResponseEntity<CustomApiResponse> fixTask(@PathVariable Long id, @RequestBody FixBoardRequestDto fixBoardRequestDto) {
        boardService.updateBoard(id,fixBoardRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(CustomApiResponse.onSuccess("할 일이 수정됌."));
    }
    @Operation(summary = "할 일 삭제", description = "할 일이 삭제되어있습니다.")
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<CustomApiResponse> deleteTask(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body(CustomApiResponse.onSuccess("할 일이 삭제됌."));
    }
    @Operation(summary = "완료된 일 조회", description = "true인 일들을 조회합니다.")
    @GetMapping("/tasks/completed")
    public ResponseEntity<CustomApiResponse<List<BoardResponse>>> completedTasks() {
        List<BoardResponse> checkBoardResult = boardService.getAllCompletedTasks();
        return ResponseEntity.status(HttpStatus.OK).body(CustomApiResponse.onSuccess(checkBoardResult));
    }
    @Operation(summary = "모든 일 조회", description = "모든 일들을 조회합니다.")
    @GetMapping("/all/tasks")
    public ResponseEntity<CustomApiResponse<List<BoardResponse>>> getAllTasks() {
        List<BoardResponse> checkBoardResult = boardService.getAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(CustomApiResponse.onSuccess(checkBoardResult));
    }


}
