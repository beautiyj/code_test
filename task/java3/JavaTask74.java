package task.java3;

import java.util.ArrayList;
import java.util.Scanner;

// 콘솔로 게시판 만들기

class BoardSVC {
    ArrayList<BoardVO> boardList;
    public BoardSVC(){ boardList =  new ArrayList<BoardVO>(); }

    // 글 입력  처리 메소드
    public void writeArticle(Scanner sc){
        System.out.println("게시판에 글을 작성 하세요?");
        System.out.print("작성자:"); String register=sc.next();
        System.out.print("이메일:"); String email=sc.next();
        System.out.print("비밀번호:"); String passwd=sc.next();
        System.out.print("제목:"); String subject=sc.next();
        System.out.print("글내용:"); String content=sc.next();
        BoardVO boardVO=new BoardVO(register,subject,email,content,passwd);
        addArticle(boardVO);
    }
    // 글 작성
    private void addArticle(BoardVO boardVO){
        boardList.add(boardVO);
    }
    // 글목록 출력
    public void listArticles(){
        if(boardList.size()>0){
            for(int i=0; i<boardList.size(); i++){
                System.out.println(boardList.get(i).toString());
            }
        }else{
            System.out.println("등록된 글이 없습니다.");
        }
    }
    // 삭제할 글의 작성자 및 비밀번호 입력하는 메소드
    public void removeArticle(Scanner sc){
        System.out.println("저장할 글의 작성자와 비밀번호를 입력 하세요?");
        System.out.print("작성자:"); String register=sc.next();
        System.out.print("비밀번호:"); String passwd=sc.next();
        removeArticle(register,passwd);
    }

    //글 삭제
    public void removeArticle(String register, String passwd){
        if(boardList.size()>0){
            int index=-1;
            for(int i=0; i<boardList.size(); i++){
                if(boardList.get(i).getRegister().equals(register)){
                    if(boardList.get(i).getPasswd().equals(passwd)){
                        boardList.remove(boardList.get(i));
                        index=i;
                    }
                }
            }
            if(index==-1){
                System.out.println("해당 작성자가 없거나 비밀번호가 일치하지 않습니다.");
                return;
            }
        }else{
            System.out.println("작성된 글이 존재하지 않습니다.");
        }
    }
}

// VO(Value Object) 클래스
// DTO(Data Transfer Object) 클래스
class BoardVO extends Object{
    //멤버변수
    private String register;
    private String subject;
    private String email;
    private String content;
    private String passwd;
    //생성자
    public BoardVO(String register, String subject, String email,
                   String content, String passwd) {
        super();
        this.register = register;
        this.subject = subject;
        this.email = email;
        this.content = content;
        this.passwd = passwd;
    }

    public String getRegister() { return register; }
    public void setRegister(String register) { this.register = register; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getPasswd() { return passwd; }
    public void setPasswd(String passwd) { this.passwd = passwd; }

    @Override
    public String toString() {
        return "작성자:"+register+",이메일:"+email+",제목:"+subject+",글내용:"+content;
    }

}

public class JavaTask74 {
    public static void main(String[] args) {
        boolean isStop = false;
        Scanner sc = new Scanner(System.in);
        BoardSVC boardSVC = new BoardSVC();
        do {
            System.out.println("메뉴를 입력 하세요?");
            System.out.println("1.게시판 글쓰기");
            System.out.println("2.글 목록 보기");
            System.out.println("3.글 삭제");
            System.out.println("4.종료");

            String menu = sc.next();

            switch (menu) {
                case "1":boardSVC.writeArticle(sc);
                    break;
                case "2":boardSVC.listArticles();
                    break;
                case "3":boardSVC.removeArticle(sc);
                    break;
                case "4":isStop = true;
            }
        } while (!isStop);
    }
}