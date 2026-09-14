package springboot_test.mybatismember.src.main.java.service;

import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class Idcheck implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Idcheck");
		
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		System.out.println("id:"+ id);
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.idcheck(id);
		System.out.println("result:"+ result);	// 1 :  중복ID
												// -1 : 사용가능한 ID
		out.println(result);	// 브라우저에 출력되는 값이 callback함수로 리턴된다.
		
		return null;
	}

}
