package springboot_test.ch01.src.main.java.sample16;

import java.util.*;

public interface MemberDao {
	void insert(Member member);

	Member selectByEmail(String email);

	Collection<Member> list();

	void delete(String email);

	void update(Member member);
}