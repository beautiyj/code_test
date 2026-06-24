package springboot_test.sbmember.src.main.java.com.example.demo.controller;

import com.example.demo.model.MemberBean;
import com.example.demo.service.MemberServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
public class MemberController {

	@Autowired
	private MemberServiceImpl memberService;

	// ID중복검사 ajax함수로 처리
	@RequestMapping(value = "/member_idcheck.do", method = RequestMethod.POST)
	@ResponseBody
	// 주석처리한 내용 + @ResponseBody 활용도 가능
//	public String member_idcheck(@RequestParam("memid") String id, Model model) throws Exception {
	public Integer member_idcheck(@RequestParam("memid") String id, Model model) throws Exception {
		System.out.println("id:"+id);
		
		int result = memberService.checkMemberId(id);
//		model.addAttribute("result", result);(리턴 result에선 주석처리 필요)

//		return "member/idcheckResult";
		return result;
	}

	// 로그인 폼
	@RequestMapping(value = "/member_login.do")
	public String member_login() {
		return "member/member_login";     
	}

	// 비번찾기 폼 
	@RequestMapping(value = "/pwd_find.do")
	public String pwd_find() {
		return "member/pwd_find";		
	}

	// 회원가입 폼
	@RequestMapping(value = "/member_join.do")
	public String member_join() {
		return "member/member_join";
	}
	
	// 비번찾기 : email로 전송
	@RequestMapping(value = "/pwd_find_ok.do", method = RequestMethod.POST)
	public String pwd_find_ok(@ModelAttribute MemberBean mem, Model model) throws Exception {

		MemberBean member = memberService.findpwd(mem);

		if (member == null) {
			return "member/pwdResult";

		} else {
			// Mail Server 설정
			String charSet = "utf-8";
			String hostSMTP = "smtp.naver.com";
			String hostSMTPid = "1111@naver.com";
			String hostSMTPpwd = "실제비밀번호"; 		// 비밀번호 입력해야함

			// 보내는 사람 EMail, 제목, 내용
			String fromEmail = "1111@naver.com";
			String fromName = "관리자";
			String subject = "비밀번호 찾기";

			// 받는 사람 E-Mail 주소
			String mail = member.getJoin_mailid()+"@"+member.getJoin_maildomain();

			try {
				/* ===== 실제 메일 발송 코드 (테스트모드라 주석처리) =====
				HtmlEmail email = new HtmlEmail();
				email.setDebug(true);
				email.setCharset(charSet);
				email.setSSL(true);
				email.setHostName(hostSMTP);
				email.setSmtpPort(587);

				email.setAuthentication(hostSMTPid, hostSMTPpwd);
				email.setTLS(true);
				email.addTo(mail, charSet);
				email.setFrom(fromEmail, fromName, charSet);
				email.setSubject(subject);
				email.setHtmlMsg("<p align = 'center'>비밀번호 찾기</p><br>" + 
								 "<div align='center'> 비밀번호:"+member.getJoin_pwd()+"</div>");
				email.send();
				===== 실제 메일 발송 코드 끝 ===== */
			} catch (Exception e) {
				System.out.println(e);
			}

			model.addAttribute("pwdok", "등록된 email을 확인 하세요~!!");
			return "member/pwd_find";

		}
	}

	
	// 회원 가입 
	@RequestMapping(value = "/member_join_ok.do", method = RequestMethod.POST)
	public String member_join_ok(@RequestParam("join_profile1") MultipartFile mf, 
								 MemberBean member,
								 HttpSession session,
								 HttpServletRequest request,
								 Model model) throws Exception {

		String filename = mf.getOriginalFilename();		// 첨부파일명
		int size = (int) mf.getSize(); 					// 첨부파일의 크기 (단위:Byte) 

//		String path = request.getRealPath("upload");
		String path = session.getServletContext().getRealPath("upload");
		System.out.println("mf=" + mf);
		System.out.println("filename=" + filename); 	// filename="Koala.jpg"
		System.out.println("size=" + size);
		System.out.println("Path=" + path);
		
		int result=0;		
		String newfilename = "";
	
	if(size > 0){	 		// 첨부파일이 전송된 경우	
		
		// 파일 중복문제 해결(여러 파일이 올라가면 중복되는 경우가 생김, 이를 방지하는 용도)
		String extension = filename.substring(filename.lastIndexOf("."), filename.length());
		System.out.println("extension:"+extension);  // extension: .jpg
		
		UUID uuid = UUID.randomUUID();
		
		// 확장자를 제외한 문자형의 난수 형태(중복될 일이 없는 고유한 난수 문자열)
		newfilename = uuid.toString() + extension;
		System.out.println("newfilename:"+newfilename);		
		
		if(size > 100000){				// 100KB
			result=1;
			model.addAttribute("result", result);
			
			return "member/uploadResult";
			
		}else if(!extension.equals(".jpg")  &&
				 !extension.equals(".jpeg") &&
				 !extension.equals(".gif")  &&
				 !extension.equals(".png") ){
			
			result=2;
			model.addAttribute("result", result);
			
			return "member/uploadResult";
		}
	}	

		if (size > 0) { 	// 첨부파일 전송
			mf.transferTo(new File(path + "/" + newfilename));
		}
		
		member.setJoin_profile(newfilename);

		memberService.insertMember(member);		// insert SQL문

		return "redirect:member_login.do";
	}

	
	// 로그인 : 회원인증 
	@RequestMapping(value = "/member_login_ok.do", method = RequestMethod.POST)
	public String member_login_ok(@RequestParam("id") String id, 
			                      @RequestParam("pwd") String pwd,
			                      HttpSession session, 
			                      Model model) throws Exception {
		int result=0;		
		MemberBean member = memberService.userCheck(id);

		if (member == null) {		// 등록되지 않은 회원일때			
			result = 1;
			model.addAttribute("result", result);
			
			return "member/loginResult";
			
		} else {				// 등록된 회원일때
			if (member.getJoin_pwd().equals(pwd)) {			// 비번이 같을때
				session.setAttribute("id", id);         	// 세션 설정

				String join_name = member.getJoin_name();
				String join_profile = member.getJoin_profile();

				model.addAttribute("join_name", join_name);
				model.addAttribute("join_profile", join_profile);

				return "member/main";
				
			} else {									// 비번이 다를때
				result = 2;
				model.addAttribute("result", result);
				
				return "member/loginResult";				
			}
		}

	}

	// 회원정보 수정 폼 
	@RequestMapping(value = "/member_edit.do")
	public String member_edit(HttpSession session, Model model) throws Exception {

		String id = (String) session.getAttribute("id");

		MemberBean editm = memberService.userCheck(id);

		model.addAttribute("editm", editm);

		return "member/member_edit";
	}

	
	// 회원정보 수정
	@RequestMapping(value = "/member_edit_ok.do", method = RequestMethod.POST)
	public String member_edit_ok(@RequestParam("join_profile1") MultipartFile mf, 
								 MemberBean member,
								 HttpSession session, 
								 HttpServletRequest request, 
								 Model model) throws Exception {
		
		String filename = mf.getOriginalFilename();
		int size = (int) mf.getSize();		
		
//		String path = request.getRealPath("upload");
		String path = session.getServletContext().getRealPath("upload");
		System.out.println("path:"+path);
		
		int result=0;		
		String newfilename = "";
		
	  if(size > 0){	 	// 첨부파일이 전송된 경우		
		
		// 파일 중복문제 해결
		String extension = filename.substring(filename.lastIndexOf("."), filename.length());
		System.out.println("extension:"+extension);
				
		UUID uuid = UUID.randomUUID();
				
		newfilename = uuid.toString() + extension;
		System.out.println("newfilename:"+newfilename);			
		
		if(size > 100000){		// 100KB
			result=1;
			model.addAttribute("result", result);
			
			return "member/uploadResult";
			
		}else if(!extension.equals(".jpg")  &&
				 !extension.equals(".jpeg") &&
				 !extension.equals(".gif")  &&
				 !extension.equals(".png") ){
			
			result=2;
			model.addAttribute("result", result);
			
			return "member/uploadResult";
		}	
     }
		
	  if (size > 0) {	// 첨부파일 전송. 새로 첨부한 파일이 있을 때만(size > 0) 실제 디스크에 파일을 저장
			mf.transferTo(new File(path + "/" + newfilename));
	  }		

		String id = (String) session.getAttribute("id");

		// 회원수정에서 프로필파일(첨부파일) 수정하지 않으면 기존 프로필 그대로 유지, 변경하면 변경값으로 전달.
		MemberBean db = this.memberService.userCheck(id);		
		
		// 위의 db코드가 없으면 null로 덮일 수도 있음
		if (size > 0 ) { 			// 첨부 파일이 수정되면
			member.setJoin_profile(newfilename);			
		} else { 					// 첨부파일이 수정되지 않으면
			member.setJoin_profile(db.getJoin_profile());
		}

		member.setJoin_id(id);		

		memberService.updateMember(member);		// update SQL문 

		model.addAttribute("join_name", member.getJoin_name());
		model.addAttribute("join_profile", member.getJoin_profile());

		return "member/main";
	}

	// 회원정보 삭제 폼 
	@RequestMapping(value = "/member_del.do")
	public String member_del(HttpSession session, Model model) throws Exception {

		String id = (String) session.getAttribute("id");
		MemberBean member = memberService.userCheck(id);
		model.addAttribute("join_id", id);
		model.addAttribute("join_name", member.getJoin_name());

		return "member/member_del";
	}

	// 회원정보 삭제
	@RequestMapping(value = "/member_del_ok.do", method = RequestMethod.POST)
	public String member_del_ok(@RequestParam("join_pwd") String join_pwd, 
							    @RequestParam("join_cont") String join_cont,
							    HttpSession session) throws Exception {

		String id = (String) session.getAttribute("id");
		MemberBean member = this.memberService.userCheck(id);

		if (!member.getJoin_pwd().equals(join_pwd)) {   // 비번 불일치시
			return "member/deleteResult";
			
		} else {										// 비번 일치시			
			String path = session.getServletContext().getRealPath("upload");
			String fname = member.getJoin_profile();
			System.out.println("path:"+path);
			
			// DB에 저장된 첩부파일명을 가져옴
			if (fname != null) {		// 첨부파일이 있으면
				File file = new File(path +"/"+fname);
				file.delete();			// 첨부파일 삭제
			}
			
			MemberBean db = new MemberBean();
			db.setJoin_id(id);
			db.setJoin_delcont(join_cont);

			memberService.deleteMember(db);	// delete SQL문 실행

			session.invalidate();				// 세션삭제

			return "redirect:member_login.do";
		}
	}

	// 로그아웃
	@RequestMapping("member_logout.do")
	public String logout(HttpSession session) {
		session.invalidate();

		return "member/member_logout";
	}

}