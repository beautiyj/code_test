package springboot_test.jpaoracle3.src.main.java.com.example.demo.repository;

import com.example.demo.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// JpaRepository<Board, Integer>를 상속받으면 해당 레파지토리 안에
// save, count, delete 같은 기본 CRUD 메소드는 이미 다 구현되어있음(내장된 기능)
public interface BoardRepository extends JpaRepository<Board, Integer> {
//	public Board save(Board board);		// 글작성, 글수정
//	public long count(); 				// 글 개수
//	public void delete(Board board);	// 글삭제	
	public Board findByNo(int no); // 상세 정보 - 내장된 기능이 아니라서 만들어줘야함(findById는 내장기능)
	// long형 count(): 전체 글 개수 / JPQL: 검색 데이터 개수
	@Query(value = """
			SELECT COUNT(*) FROM boards
			WHERE
				CASE
					WHEN :search = 'subject' THEN subject
					WHEN :search = 'content' THEN content
					WHEN :search = 'writer' THEN writer
				END LIKE '%' || :keyword || '%'
			""", nativeQuery = true)
	// 검색기능 추가
	public int searchCount(@Param("search") String search, @Param("keyword") String keyword);
	// 전체 글 개수 가져오기 (오라클 페이징 처리에 사용)
	@Query(value = "SELECT COUNT(*) FROM boards", nativeQuery = true)
	public int getCount();
	// 검색 조건에 맞는 리스트 가져오기 (검색 페이징용)
	@Query(value = """
			SELECT * FROM boards
			WHERE
				CASE
					WHEN :search = 'subject' THEN subject
					WHEN :search = 'content' THEN content
					WHEN :search = 'writer' THEN writer
				END LIKE '%' || :keyword || '%'
			""", nativeQuery = true)
	public List<Board> searchList(@Param("search") String search, @Param("keyword") String keyword);
	// 기존 페이징 번호 유지용
	// 해당 방식을 많이 씀
	// ROW_NUMBER() : no컬럼으로 내림차순 정렬된 데이터에 순번(1,2,3,...)을 부여해주는 함수
	@Query(value = """
			SELECT * FROM (
				SELECT b.*, ROW_NUMBER() OVER (ORDER BY no DESC) AS rn
				FROM boards b
			)
			WHERE rn BETWEEN :start AND :end
			""", nativeQuery = true)
	public List<Board> getList(@Param("start") int start, @Param("end") int end);
}