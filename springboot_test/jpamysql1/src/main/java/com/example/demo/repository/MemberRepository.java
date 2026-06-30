package springboot_test.jpamysql1.src.main.java.com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
//	public Member save(Member member);					// 회원가입, 정보수정
//	public Optional<Member> findById(String id);		// 로그인, 수정폼
//	public void delete(Member member);					// 회원탈퇴
}