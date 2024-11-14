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
    private Long BoardId;

    @Column
    private String Title;

    @Column
    private String Content;

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "done", nullable = false)
    @Builder.Default  // 기본값을 빌더에서 사용하도록 명시
    private Boolean isDone = false;

}
