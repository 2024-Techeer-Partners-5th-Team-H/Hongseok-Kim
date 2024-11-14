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

    @Column(nullable = false)
    @Builder.Default
    private Boolean IsDone = false;

}
