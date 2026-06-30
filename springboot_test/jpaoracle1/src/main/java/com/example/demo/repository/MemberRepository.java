package springboot_test.jpaoracle1.src.main.java.com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* 	Repository 구조

	Repository 				   : 최상위 레파지토리. 아무런 기능이 없기 때문에 잘 사용하지 않는다.
	CrudRepository 			   : 기본적인 CRUD 기능을 제공해주는 레파지토리
	PagingAndSortingRepository : CrudRepository 인터페이스 기능에 페이징 및 정렬 기능이 추가된 인터페이스
	JpaRepository 			   : PagingAndSortingRepository 인터페이스 기능뿐만 아니라 JPA에 특화된 기능까지 추가된 인터페이스
 
 	상속 구조는
 	CrudRepository extends Repository
	PagingAndSortingRepository extends CrudRepository
	JpaRepository extends PagingAndSortingRepository
	
	Repository (최상위 부모 인터페이스. 부모 인터페이스인 만큼 기능 없음, 마커 인터페이스)
	   ↑
	CrudRepository (CRUD 기능 추가)
	   ↑
	PagingAndSortingRepository (+페이징/정렬 추가)
	   ↑
	JpaRepository (+ JPA 특화 기능)  ← 실무에서는 이거 하나만 씀. 자식인터페이스, 가장 기능 많음
  
 
 */

// JpaRepository<Member, String>을 extends하는 순간
// Spring Data JPA가 이미 구현해놓은 기본 CRUD 메소드들(save, findById, delete, findAll, count 등)을 자동으로 다 가져다 씀
// 직접 인터페이스 안에 따로 선언 안 해도 이미 부모(JpaRepository → PagingAndSortingRepository → CrudRepository)에
// 다 정의되어 있어서 상속만으로 그 기능이 그대로 따라오는 거

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
	// MemberRepository extends JpaRepository<Member, String> 이 한 줄이 하단 3줄을 모두 갖고 있어서
	// 레파지토리 내부 코드 주석처리해도 알아서 작동함(컨트롤러나 서비스 코드는 별도로 적어야하고)
	
	// public Member save(Member member);           // 회원가입, 정보수정
	// public Optional<Member> findById(String id); // 로그인, 수정폼
	// public void delete(Member member);           // 회원탈퇴
	
}

/* JpaRepository 하나로 다 쓰면 예시 코드는 이런 식.
 save(), findById(), delete(), count() 같은 기본 CRUD  → JpaRepository가 다 상속받아 가지고 있음 (CrudRepository 기능)
 findAll(Pageable pageable) 같은 페이징 처리 			→ 이것도 다 포함 (PagingAndSortingRepository 기능)
 saveAll(), flush(), getById() 같은 JPA 특화 기능 		→ JpaRepository에서 추가됨

package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    // 1. 메소드 이름으로 자동 쿼리 생성 (Query Method) - 실무에서 제일 많이 씀
    Optional<Member> findByEmail(String email);
    List<Member> findByNameContaining(String name);
    boolean existsByEmail(String email);

    // 2. JPQL이 필요할 때만 @Query 사용
    @Query("SELECT m FROM Member m WHERE m.name = :name AND m.email = :email")
    Optional<Member> findByNameAndEmail(@Param("name") String name, @Param("email") String email);

    // 3. 복잡한 통계/네이티브 쿼리만 nativeQuery 사용
    @Query(value = "SELECT COUNT(*) FROM members WHERE regdate >= :date", nativeQuery = true)
    int countByRegdateAfter(@Param("date") String date);
}
 
 */
