package springboot_test.jpaoracle1.src.main.java.com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository repository;

	public Optional<Member> findById(String id) {
		return repository.findById(id);
	}

	public Member save(Member member) {
		return repository.save(member);
	}

	public void delete(Member member) {
		repository.delete(member);
	}
}
