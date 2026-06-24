package springboot_test.board2.src.main.java.com.example.demo.service;

import com.example.demo.dao.ReplyBoardDao;
import com.example.demo.model.ReplyBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyBoardServiceImpl {
	@Autowired
	private ReplyBoardDao rbd;

	public List<ReplyBoard> list(int num) {
		return rbd.list(num);
	}

	public void insert(ReplyBoard rb) {
		rbd.insert(rb);
	}

	public void delete(int rno) {
		rbd.delete(rno);
	}

	public void update(ReplyBoard rb) {
		rbd.update(rb);
	}
}