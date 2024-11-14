package techeerpartners.techeerpartners.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techeerpartners.techeerpartners.board.dto.CreateBoardRequestDto;
import techeerpartners.techeerpartners.board.dto.FixBoardRequestDto;
import techeerpartners.techeerpartners.board.service.BoardService;
import techeerpartners.techeerpartners.common.CustomApiResponse;

@Tag(name = "Board", description = "게시판 API")
@RequestMapping("/Board")
@RestController
@AllArgsConstructor
public class BoradController {
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



}
