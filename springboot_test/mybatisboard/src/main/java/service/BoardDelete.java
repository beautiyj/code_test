package springboot_test.mybatisboard.src.main.java.service;

import java.io.PrintWriter;

import dao.BoardDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BoardBean;

public class BoardDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardDelete");
		
		response.setContentType("text/html; charset=utf-8"); 
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		String board_pass  = request.getParameter("board_pass");
				
		BoardDAO dao = BoardDAO.getInstance();
		BoardBean old = dao.getContent(board_num);
		
		if(old.getBoard_pass().equals(board_pass)) { //비번 일치시
			dao.delete(board_num);
			
			
		}else {	// 비번 불일치시
	
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();

			return null;			
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/BoardListAction.do?page="+page);
		
		return forward;
	}

}
