package springboot_test.jpaoracle1.src.main.java.com.example.demo.controller;

import com.example.demo.Jpaoracle1Application;
import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class MemberController {

	private final Jpaoracle1Application jpaoracle1Application;

	private final MemberService service;

	// 초기 요청
	@RequestMapping("/")
	public String main() {
		return "loginform";
	}

	// 회원 가입 폼
	@RequestMapping("memberform")
	public String memberform() {
		return "memberform";
	}

	// 회원가입
	@RequestMapping("member")
	public String member(@ModelAttribute Member member, Model model) {

		// 회원 1명 검색(ID중복 검사)
		Optional<Member> opt = service.findById(member.getId());

		int result = 0;
		if (opt.isPresent()) {
			if (opt.get() != null) { // 중복 id
				result = -1;
				model.addAttribute("result", result);
				return "insertresult";
			}
		}

		Member db = service.save(member); // insert sql문 실행
		if (db != null) {
			result = 1;
		}
		model.addAttribute("result", result);

		return "insertresult";
	}

	// 로그인 폼
	@RequestMapping("loginform")
	public String loginform() {
		return "loginform";
	}

	// 로그인
	@RequestMapping("login")
	public String login(@ModelAttribute Member member, HttpSession session, Model model) {

		// 1명의 정보 구하기(비번)
		Optional<Member> opt = service.findById(member.getId());

		int result = 0;
		// opt 안에 엔티티 객체가 존재할 경우
		// isPresent(): "값이 들어 있니?" (있으면 true, 비어 있으면 false)
		if (opt.isPresent()) {
			if (opt.get().getPasswd().equals(member.getPasswd())) {
				result = 1;
				session.setAttribute("id", member.getId()); // 세션 공유 설정
			} else {
				// 비번 불일치
				result = -1;
			} // 비번비교 끝
		}
		model.addAttribute("result", result);
		return "loginresult";
	}

	// 마이페이지로 이동
	@RequestMapping("mypage")
	public String mypage() {
		return "mypage";
	}

	// 로그아웃
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 삭제
		return "logout";
	}

	// 회원정보 수정 폼
	@RequestMapping("updateform")
	public String updateform(HttpSession session, Model model) {
		// 세션을 활용해서 id 가져오기
		String id = (String) session.getAttribute("id");
		// 회원 1명의 상세 정보
		Optional<Member> opt = service.findById(id);

		// 엔티티객체가 옵셔널 안에 있어서 get()으로 가져와야함
		model.addAttribute("member", opt.get());

		return "updateform";
	}

	// 회원정보 수정
	@RequestMapping("update")
	public String update(@ModelAttribute Member member, Model model) {

		// 비번 구하기
		Optional<Member> opt = service.findById(member.getId());

		int result = 0;
		if (opt.isPresent()) {
			if (opt.get().getPasswd().equals(member.getPasswd())) {
				Member db = service.save(member); // id가 DB에 이미 있으면 → 업데이트 sql문 실행. (UPDATE 실행)
				result = 1;
			} else {
				// 비번 불일치
				result = -1;
			} // 비번비교 끝
		}
		model.addAttribute("result", result);
		return "updateresult";
	}

	/*
	 * // 회원정보 수정 - 뎁스 줄이기(이프문 중첩 줄이기) 용도로 추천하는 구조
	 * 
	 * @RequestMapping("update") public String update(@ModelAttribute Member member,
	 * Model model) {
	 * 
	 * // 비번 구하기 Optional<Member> opt = service.findById(member.getId());
	 * 
	 * int result = 0;
	 * 
	 * if (opt.isEmpty()) { result = -1; // 회원 없음 model.addAttribute("result",
	 * result); return "updateresult"; }
	 * 
	 * if (!opt.get().getPasswd().equals(member.getPasswd())) { result = -1; // 비번
	 * 불일치 model.addAttribute("result", result); return "updateresult"; }
	 * 
	 * // 여기까지 왔다는 건 회원 존재 + 비번 일치 Member db = service.save(member); // 업데이트 sql문 실행
	 * result = 1;
	 * 
	 * model.addAttribute("result", result); return "updateresult"; }
	 */

	// 회원 탈퇴 폼
	@RequestMapping("deleteform")
	public String deleteform(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");

		Optional<Member> opt = service.findById(id);
		
		model.addAttribute("member", opt.get());

		return "deleteform";
	}

	// 회원 탈퇴
	@RequestMapping("delete")
	public String delete(@ModelAttribute Member member, HttpSession session, Model model) {

		// 비번 구하기
		Optional<Member> opt = service.findById(member.getId());

		int result = 0;
		if (opt.isPresent()) {
			if (opt.get().getPasswd().equals(member.getPasswd())) {
				// 레파지토리(JPA)의 delete(entity)가 실행(sql문)
				service.delete(member);
				session.invalidate();
				result = 1;
			} else {
				// 비번 불일치
				result = -1;
			} // 비번비교 끝
		}
		model.addAttribute("result", result);

		return "deleteresult";
	}

}
