package techeerpartners.techeerpartners.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import techeerpartners.techeerpartners.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
