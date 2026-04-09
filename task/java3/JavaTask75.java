package task.java3;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 콘솔로 게시판 만들기 - 롬복 활용한 간략 버전

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
                System.out.println("4.종료");

                String menu = sc.next();

                if ("4".equals(menu)) break;

                switch (menu) {
                    case "1" -> boardSVC.writeArticle(sc);
                    case "2" -> boardSVC.listArticles();
                    case "3" -> boardSVC.removeArticle(sc);
                }
            }
        }
    }
}