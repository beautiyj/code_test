package springboot_test.oracleboard.src.main.java.com.example.demo.dao;

import com.example.demo.model.Board;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// 클래스로 만들어두고 이후 인터페이스로 변환
@Repository
public class BoardDao {

	@Autowired
	private SqlSession session;

	public int insert(Board board) {
        return session.insert("boardns.insert", board);
    }

	public int count() {
		return session.selectOne("boardns.count");
	}

	public List<Board> list(int page) {
		return session.selectList("boardns.list", page);
	}

	public void updatecount(int no) {
		session.update("boardns.updatecount", no);
	}

	public Board content(int no) {
		return session.selectOne("boardns.content", no);
	}

	public int update(Board board) {
		return session.update("boardns.update", board);
	}

	public int delete(int no) {
		return session.delete("boardns.delete", no);
	}
}