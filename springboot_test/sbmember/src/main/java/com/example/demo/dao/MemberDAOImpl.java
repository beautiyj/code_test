package springboot_test.sbmember.src.main.java.com.example.demo.dao;

import com.example.demo.model.MemberBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAOImpl {
	// 회원가입
	public abstract void insertMember(MemberBean member) throws Exception;
	// 로그인 인증, 아이디 중복 체크
	public MemberBean userCheck(String id) throws Exception;
	// 비번찾기
	public MemberBean findpwd(MemberBean member) throws Exception;
	// 회원수정
	public void updateMember(MemberBean member) throws Exception;
	// 회원삭제
	public void deleteMember(MemberBean member) throws Exception;
}
