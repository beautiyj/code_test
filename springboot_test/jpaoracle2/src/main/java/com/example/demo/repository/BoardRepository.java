package springboot_test.jpaoracle2.src.main.java.com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Board;

// JpaRepository<Board, Integer>를 상속받으면 해당 레파지토리 안에
// save, count, delete 같은 기본 CRUD 메소드는 이미 다 구현되어있음(내장된 기능)

public interface BoardRepository extends JpaRepository<Board, Integer> {
//	public Board save(Board board);		// 글작성, 글수정
//	public long count(); 				// 글 개수
//	public void delete(Board board);	// 글삭제	
	public Board findByNo(int no);	 	// 상세 정보 - 내장된 기능이 아니라서 만들어줘야함(findById는 내장기능)

	// 마이바티스의 페이지네이션(페이징처리)처럼 10개씩 잘라주는 기능이 jpa에 내장되어있지 않아서 별도로 만들거나 마이바티스를 활용해야함.
	
	// JPQL : 전체 목록 검색, Java 엔티티 객체 기준 (테이블 X, 클래스/필드명)이고 오라클전용함수 사용 불가한 별도의 언어
	// JPQL 버전 (틀린 예시 - ROWNUM은 Oracle 전용이라 JPQL에서 못 씀)
	//			@Query("SELECT b FROM Board b ORDER BY b.no DESC")  
	// 			→ 페이징은 Pageable로 따로 처리해야 함, ROWNUM 직접 못 씀
	
	// nativeQuery = true : JPQL이 아니라 순수 SQL(Oracle 문법 그대로)라고 알려주는 표식
	// JPA에서 @Param("page") 를 참조한다는 의미로 SQL에서 :page 사용. (실제로는 int page라는 이름표 달린 값, 그걸 참조)
	@Query(value = "SELECT * FROM ("
			+ "  SELECT ROWNUM rnum, board.* "
			+ "  FROM (SELECT * FROM boards ORDER BY no DESC) board"
			+ ") "
			+ "WHERE rnum >= ((:page - 1) * 10 + 1) "
			+ "AND rnum <= (:page * 10)",
			nativeQuery = true)
	public List<Board> findAll(@Param("page") int page);

}

