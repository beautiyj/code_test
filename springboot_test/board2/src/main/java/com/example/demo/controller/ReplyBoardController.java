package springboot_test.board2.src.main.java.com.example.demo.controller;

import com.example.demo.model.Board;
import com.example.demo.model.ReplyBoard;
import com.example.demo.service.BoardServiceImpl;
import com.example.demo.service.ReplyBoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ReplyBoardController {
	@Autowired
	private ReplyBoardServiceImpl rbs;
	@Autowired
	private BoardServiceImpl bs;

	@RequestMapping("/slist/num/{num}")
	public String slist(@PathVariable int num, Model model) {
		Board board = bs.select(num);
		List<ReplyBoard> slist = rbs.list(num);
		model.addAttribute("slist", slist);
		model.addAttribute("board", board);
		return "slist";
	}

	@RequestMapping("/sInsert")
	public String sInsert(ReplyBoard rb, Model model) {
		rbs.insert(rb);
		return "redirect:slist/num/" + rb.getBno();
	}

	@RequestMapping("/repDelete")
	public String delete(ReplyBoard rb, Model model) {
		rbs.delete(rb.getRno());
		return "redirect:slist/num/" + rb.getBno();
	}

	@RequestMapping("/repUpdate")
	public String repUpdate(ReplyBoard rb, Model model) {
		rbs.update(rb);
		return "redirect:slist/num/" + rb.getBno();
	}
}