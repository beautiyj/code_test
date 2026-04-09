package task.java3;

// Vector 벡터 클래스
// vector 클래스는 동기화된 메소드로 구성되어 있어서 스레드에 안전
// 하지만 전부 동기화 되어있어서 무거움. 잘 안쓴다
// 요즘은 멀티스레드 방식으로 Collections.synchronizedList()나 CopyOnWriteArrayList 씀

// 벡터클래스의 출력물은 어레이리스트랑 차이가 없지만 스레드, 속도면에서 다름.

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
        List<Board> list = new Vector<>();          // 업캐스팅

//       list.add("보드 안의 객체가 아닐 경우 에러.")
//       보드 메소드는 매개변수3개라서 무조건 생성자규칙 따라야함.
//       자바에선 명시적 매개변수처럼 활용하려면 생성자 하나 더 만드는 오버로딩이나, 빌더패턴(자주씀) 써야함
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
