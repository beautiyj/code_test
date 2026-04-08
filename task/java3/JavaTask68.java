package task.java3;

// Vector 벡터

import java.util.List;
import java.util.Vector;

class Board {
    String subject;
    String contect;
    String writer;

    public Board(String subject, String contect, String writer) {
        this.subject = subject;
        this.contect = contect;
        this.writer = writer;
    }
}

public class JavaTask68 {
    public static void main(String[] args) {

        // 클래스 객체를 제네릭 처리. 여기선 보드 클래스로 만든 객체만 저장 가능.
        List<Board> list = new Vector<>();

        list.add(new Board("제목1", "내용1", "글쓴이1"));
        list.add(new Board("제목2", "내용2", "글쓴이2"));
        list.add(new Board("제목3", "내용3", "글쓴이3"));
        list.add(new Board("제목4", "내용4", "글쓴이4"));
        list.add(new Board("제목5", "내용5", "글쓴이5"));

        list.remove(2);
        list.remove(3);

        for (int i = 0; i < list.size(); i++) {
            Board board = list.get(i);
            System.out.println(board.subject + "\t" + board.contect + "\t" + board.writer);
        }

    }
}
