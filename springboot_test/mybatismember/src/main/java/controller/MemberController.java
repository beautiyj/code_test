package springboot_test.mybatismember.src.main.java.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.*;

import java.io.IOException;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();               
		String command = requestURI.substring(contextPath.length());  
		
		System.out.println("requestURI:"+requestURI);    // requestURI: /model2member/MemberInsert.do
		System.out.println("contextPath:"+contextPath);  // contextPath: /model2member
		System.out.println("command:"+command);          // command: /MemberInsert.do
		
		Action action = null;
		ActionForward forward = null;
		
		// 회원 가입
		if(command.equals("/MemberInsert.do")) {
			try {
				action = new MemberInsert();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 회원가입 폼	
		}else if(command.equals("/MemberForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./member/memberform.jsp");
			
		// ID중복 검사(ajax)	
		}else if(command.equals("/Idcheck.do")) {
			try {
				action = new Idcheck();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 로그인(회원인증)	
		}else if(command.equals("/Login.do")) {
			try {
				action = new Login();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 로그인 폼	
		}else if(command.equals("/LoginForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/loginform.jsp");	
			
		// 로그 아웃	
		}else if(command.equals("/Logout.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/logout.jsp");
			
		// 회원정보 수정폼	
		}else if(command.equals("/UpdateMember.do")) {
			try {
				action = new UpdateMember();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		// 회원정보 수정	
		}else if(command.equals("/Update.do")) {
			try {
				action = new Update();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		// 회원탈퇴 폼	
		}else if(command.equals("/DeleteMember.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/deleteform.jsp");
			
		// 회원탈퇴	
		}else if(command.equals("/Delete.do")) {
			try {
				action = new Delete();
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 포워딩 처리
		if(forward != null) {
			if(forward.isRedirect()) {		// redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			}else {							// dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}		
		
	}// doProcess() end	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
	
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		
		doProcess(request, response);		
	}

}
