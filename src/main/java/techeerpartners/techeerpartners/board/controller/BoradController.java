package techeerpartners.techeerpartners.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techeerpartners.techeerpartners.board.dto.BoardRequestDto;
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
    public ResponseEntity<CustomApiResponse> createTask(@RequestBody BoardRequestDto boardRequestDto) {
        boardService.addBoard(boardRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(CustomApiResponse.onSuccess("일정 추가됌"));
    }



}
