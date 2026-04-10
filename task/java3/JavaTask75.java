package task.java3;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 콘솔로 게시판 만들기 - 롬복 활용한 간략 버전
/* 보통은 인터페이스를 규청 -> 인터페이스 구현체에서 상속받아서 커스텀제작.
// 1. 인터페이스: "이 게시판은 반드시 이 기능들이 있어야 한다"는 규칙
interface BoardService {
    void writeArticle(Scanner sc);
    void listArticles();
    void removeArticle(Scanner sc);
    void modifyArticle(Scanner sc);
}
// 2. 구현체: 인터페이스의 규칙을 받아서 실제 'ArrayList'로 기능을 구현함
class BoardServiceImpl implements BoardService {
    private final List<BoardVO75> boardList = new ArrayList<>();
    @Override
    public void writeArticle(Scanner sc) {  로직 생략 }
    @Override
    public void listArticles() { 로직 생략 }
    그리고 modifyArticle 수정로직을 받아서 -> 수정 선택 (1.제목 2.내용 3.작성자아이디)
    -> 선택에 따라 article.setRegister(newId) 또는 article.setSubject(newSub) 호출 하는게 일반적. 인터페이스 많아지면 무거워지니까
// 3. 실행부: 인터페이스 타입으로 변수를 선언함 (다형성)
    // "나중에 구현 클래스가 바뀌어도 이 코드는 그대로 쓸 수 있음"
    BoardService boardService = new BoardServiceImpl();
*/

@Getter     // 읽기 전용 통로 게터. 데이터를 가져올 때는 겟변수명()
@Setter     // 수정 전용 통로 세터. 데이터를 저장할 때는 셋변수명(새로운변수)
// 이런 걸 데이터의 추상화라고 부름(데이터를 몰라도 규칙 설정해두면 로직 돌아가고)

@Builder                // 빌더 패턴. 객체 생성 시에 필드별로 값을 지정할 수 있는 빌더 메서드 생성. 이름표를 붙여서 값을 넣음
                        // 예시: BoardVO75.builder().register("작성자").subject("제목").build();
                        // 원래 빌더가 있으면 알아서 생성자도 만들어주는데, 관례 상 : AllArgsConstructor과 같이 생성자를 명시적으로 만들어주면 빌더는 생성자에 맞춰서 만들어짐
@AllArgsConstructor     // 모든 필드를 다 채우는 생성자 생성
@NoArgsConstructor      // 파라미터가 없는 기본 생성자 생성   이건 프레임워크 요구용?? JSON변환 JPA 등에서 객체 생성할 때 필요할 수 있음

class BoardVO75 {
    private String register;
    private String subject;
    private String email;
    private String content;
    private String passwd;

    @Override
    public String toString() {
        return "작성자:" + register + ",이메일:" + email + ",제목:" + subject + ",글내용:" + content;
    }
}

class BoardSVC75 {
    private final List<BoardVO75> boardList = new ArrayList<>();

    public void writeArticle(Scanner sc) {
        System.out.println("게시판에 글을 작성 하세요?");
        System.out.print("작성자:"); String register = sc.next();
        System.out.print("이메일:"); String email = sc.next();
        System.out.print("비밀번호:"); String passwd = sc.next();
        System.out.print("제목:"); String subject = sc.next();
        System.out.print("글내용:"); String content = sc.next();

        boardList.add(BoardVO75.builder()
                .register(register)
                .subject(subject)
                .email(email)
                .content(content)
                .passwd(passwd)
                .build());
    }

    public void listArticles() {
        if (boardList.isEmpty()) {
            System.out.println("등록된 글이 없습니다.");
            return;
        }
        boardList.forEach(System.out::println);
    }

    public void removeArticle(Scanner sc) {
        if (boardList.isEmpty()) {
            System.out.println("작성된 글이 존재하지 않습니다.");
            return;
        }
        System.out.println("저장할 글의 작성자와 비밀번호를 입력 하세요?");
        System.out.print("작성자:"); String register = sc.next();
        System.out.print("비밀번호:"); String passwd = sc.next();

        boolean removed = boardList.removeIf(article ->
                article.getRegister().equals(register) && article.getPasswd().equals(passwd));

        if (!removed) {
            System.out.println("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.");
        }
    }

    public void modifyArticle(Scanner sc) {
        if (boardList.isEmpty()) {
            System.out.println("작성된 글이 존재하지 않습니다.");
            return;
        }
        System.out.println("수정할 글의 작성자와 비밀번호를 입력 하세요?");
        System.out.print("작성자:"); String register = sc.next();
        System.out.print("비밀번호:"); String passwd = sc.next();

        for (BoardVO75 article : boardList) {
            if (article.getRegister().equals(register) && article.getPasswd().equals(passwd)) {
                System.out.print("새 제목:"); String newSubject = sc.next();
                System.out.print("새 글내용:"); String newContent = sc.next();
                article.setSubject(newSubject);
                article.setContent(newContent);
                System.out.println("글이 수정되었습니다.");
                return;
            }
        }
        System.out.println("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.");
    }

    public void modifyPw(Scanner sc) {
        System.out.println("비밀번호 변경하기: 작성자와 비밀번호 입력 하세요?");
        System.out.print("작성자:"); String register = sc.next();
        System.out.print("비밀번호:"); String passwd = sc.next();

        for (BoardVO75 article : boardList) {
            if (article.getRegister().equals(register) && article.getPasswd().equals(passwd)) {
                System.out.print("새 비밀번호:"); String newPasswd = sc.next();
                article.setPasswd(newPasswd);
                System.out.println("비밀번호 수정되었습니다.");
                return;
            }
        }
        System.out.println("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.");
    }

}

public class JavaTask75 {
    public static void main(String[] args) {
        BoardSVC75 boardSVC = new BoardSVC75();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("메뉴를 입력 하세요?");
                System.out.println("1.게시판 글쓰기");
                System.out.println("2.글 목록 보기");
                System.out.println("3.글 삭제");
                System.out.println("4.글 삭제");
                System.out.println("5.비밀번호 변경");
                System.out.println("6.종료");

                String menu = sc.next();

                if ("6".equals(menu)) break;

                switch (menu) {
                    case "1" -> boardSVC.writeArticle(sc);
                    case "2" -> boardSVC.listArticles();
                    case "3" -> boardSVC.removeArticle(sc);
                    case "4" -> boardSVC.modifyArticle(sc);
                    case "5" -> boardSVC.modifyPw(sc);
                    default -> System.out.println("잘못된 메뉴입니다. 다시 입력해주세요.");
                }
            }
        }
    }
}