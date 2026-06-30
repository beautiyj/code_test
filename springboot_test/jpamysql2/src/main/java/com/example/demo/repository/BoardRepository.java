package springboot_test.jpamysql2.src.main.java.com.example.demo.repository;

import com.example.demo.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
//	public Board save(Board board);		// 글작성, 글수정
//	public long count();				// 글 개수
//	public void delete(Board board);	// 글 갯수
	public Board findByNo(int no); // 상세 정보

	// JPQL : 전체 목록 검색
	@Query(value = """
	        SELECT * FROM boards 
	        ORDER BY no DESC 
	        LIMIT :start, 10
	        """, nativeQuery = true)
	public List<Board> findAll(@Param("start") int start);
}
