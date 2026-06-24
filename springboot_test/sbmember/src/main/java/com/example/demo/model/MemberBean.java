package springboot_test.sbmember.src.main.java.com.example.demo.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("member")
public class MemberBean {

	private String join_id;
	private String join_pwd;
	private String join_name;
	private String join_zip;
	private String join_addr1;
	private String join_addr2;
	private String join_tel1;
	private String join_tel2;
	private String join_tel3;
	private String join_phone1;
	private String join_phone2;
	private String join_phone3;
	private String join_mailid;
	private String join_maildomain;
	private String join_profile;
	private String join_regdate;
	private int join_state;
	private String join_delcont;
	private String join_deldate;
	
}
