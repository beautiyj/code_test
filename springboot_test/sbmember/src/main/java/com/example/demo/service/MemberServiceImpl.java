package springboot_test.sbmember.src.main.java.com.example.demo.service;

import com.example.demo.dao.MemberDAOImpl;
import com.example.demo.model.MemberBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl {
	
	@Autowired
	private MemberDAOImpl memberDao;
	
	public void insertMember(MemberBean member) throws Exception{
		memberDao.insertMember(member);
	}
	
	public MemberBean userCheck(String id) throws Exception{
		return memberDao.userCheck(id);		
	}
	
	public int checkMemberId(String id) throws Exception{
		int result = -1;	   // 사용 가능한 ID
		MemberBean member = memberDao.userCheck(id);
		if(member != null)
		   result = 1; 	       // 중복 ID
		
		return result;
	}
	
	public MemberBean findpwd(MemberBean member)throws Exception {
		return memberDao.findpwd(member);
	}
	
	public void updateMember(MemberBean member) throws Exception{
		memberDao.updateMember(member);
	}
	
	public void deleteMember(MemberBean member) throws Exception{
		memberDao.deleteMember(member);
	}
}
