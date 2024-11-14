package techeerpartners.techeerpartners.board.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId; // 수정: boardId -> 기존 BoardId

    @Column
    private String title; // 수정: title -> 기존 Title

    @Column
    private String content; // 수정: content -> 기존 Content

    @Column(nullable = false)
    @Builder.Default
    private Boolean isDone = false; // 수정: isDone -> 기존 IsDone

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

}
