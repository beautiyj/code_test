package springboot_test.jpamysql3.src.main.java.com.example.demo.repository;

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
//	public void delete(Board board);	// 글 삭제
	public Board findByNo(int no); // 상세 정보

	// 검색 데이터 개수
	@Query(value = """
			SELECT COUNT(*) FROM boards
			WHERE
				CASE
					WHEN :search = 'subject' THEN subject
					WHEN :search = 'content' THEN content
					WHEN :search = 'writer' THEN writer
				END LIKE CONCAT('%', :keyword, '%')
			""", nativeQuery = true)
	public int searchCount(@Param("search") String search, @Param("keyword") String keyword);

	// 전체 글 개수
	@Query(value = "SELECT COUNT(*) FROM boards", nativeQuery = true)
	public int getCount();

	// 검색 조건에 맞는 리스트 가져오기 (검색 + 페이징)
//	WHERE		// 케이스문으로 하나 웨어절로 and 연결하나 동일함
//    (:search = 'writer' AND writer LIKE CONCAT('%', :keyword, '%')) OR
//    (:search = 'subject' AND subject LIKE CONCAT('%', :keyword, '%')) OR
//    (:search = 'content' AND content LIKE CONCAT('%', :keyword, '%'))

	@Query(value = """
			SELECT * FROM boards
			WHERE
				CASE
					WHEN :search = 'subject' THEN subject
					WHEN :search = 'content' THEN content
					WHEN :search = 'writer' THEN writer
				END LIKE CONCAT('%', :keyword, '%')
			ORDER BY no DESC
			LIMIT :start, 10
			""", nativeQuery = true)
	public List<Board> searchList(@Param("start") int start, @Param("search") String search, @Param("keyword") String keyword);

	// 전체 목록 페이징 (MySQL LIMIT 방식)
	@Query(value = """
			SELECT * FROM boards
			ORDER BY no DESC
			LIMIT :start, 10
			""", nativeQuery = true)
	public List<Board> getList(@Param("start") int start);

}