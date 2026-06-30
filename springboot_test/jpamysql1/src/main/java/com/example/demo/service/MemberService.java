package springboot_test.jpamysql1.src.main.java.com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

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
