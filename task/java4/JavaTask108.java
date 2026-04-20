package task.java4;

// DTO(Data Transfer Object)
// DAO(Data Access Object)
// BoardService, BoardMain 통합 단일 파일

// MVC 게시판

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

// DTO(Data Transfer Object)
class Board2 {
    private int no;
    private String writer;
    private String passwd;
    private String subject;
    private String content;
    private Timestamp register;

    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Timestamp getRegister() {
        return register;
    }
    public void setRegister(Timestamp register) {
        this.register = register;
    }
}

// DAO(Data Access Object)
class BoardDAO {

    // 싱글톤: 객체 생성을 1번만 수행 하는것.
    private static BoardDAO instance = new BoardDAO(); //정적 필드
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";

    public static BoardDAO getInstance() {  // 정적 메소드
        return instance;
    }

    // db접속하는 메소드
    private Connection getConnection() throws Exception{
        Class.forName(driver);
        return DriverManager.getConnection(url, "scott", "tiger");
    }

    // 글작성
    public int insertBoard(Board2 board) {
        int result = 0;

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();

            String sql="insert into board2 ";
            sql+=" values(board2_seq.nextval,?,?,?,?,sysdate)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, board.getWriter());
            pstmt.setString(2, board.getPasswd());
            pstmt.setString(3, board.getSubject());
            pstmt.setString(4, board.getContent());

            result = pstmt.executeUpdate();  // insert sql문 실행

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    // 글갯수 구하기
    public int getCount() {
        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String sql="select count(*) from board2";

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();  // select sql문 실행

            if(rs.next()) {
                result = rs.getInt(1);
//				result = rs.getInt("count(*)");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    // 글목록
    public List<Board2> selectBoard() {
        List<Board2> list = new ArrayList<Board2>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String sql="select * from board2";

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();   // select sql문 실행

            // boolean next()
            while(rs.next()) {  // 데이터를 1개씩 가져온다.
                Board2 board = new Board2();

                int no = rs.getInt("no");
                board.setNo(no);
                board.setWriter(rs.getString("writer"));
                board.setPasswd(rs.getString("passwd"));
                board.setSubject(rs.getString("subject"));
                board.setContent(rs.getString("content"));
                board.setRegister(rs.getTimestamp("register"));

                list.add(board);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    // 글수정
    public int updateBoard(Board2 board) {
        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String db=null;

        try {
            con = getConnection();

            String sql="select * from board2 where no=?";

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, board.getNo());
            rs = pstmt.executeQuery();	// select sql문 실행

            if(rs.next()) {
                db = rs.getString("passwd");
            }

            // 비번 비교
            if(db.equals(board.getPasswd())) {   // 비번 일치시

                sql="update board2 set writer=?, subject=?,";
                sql+="content=?, register=sysdate where no=?";

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, board.getWriter());
                pstmt.setString(2, board.getSubject());
                pstmt.setString(3, board.getContent());
                pstmt.setInt(4, board.getNo());

                result = pstmt.executeUpdate(); // update sql문 실행

            }else {   // 비번 불일치시
                result = -1;
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    // 글삭제
    public int deleteBoard(Board2 board) {
        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String db = null;

        try {
            con = getConnection();

            String sql="select * from board2 where no=?";

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, board.getNo());
            rs = pstmt.executeQuery();	// select sql문 실행

            if(rs.next()) {
                db = rs.getString("passwd");
            }

            // 비번 비교
            if(db.equals(board.getPasswd())) {   // 비번 일치시
                sql="delete from board2 where no=?";

                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, board.getNo());
                result = pstmt.executeUpdate(); // delete sql문 실행

            }else {		// 비번 불일치시
                result = -1;
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}

class BoardService {
    // 글작성
    public void insertBoard() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("작성자 입력?");
            String writer = br.readLine();
            System.out.print("비밀번호 입력?");
            String passwd = br.readLine();
            System.out.print("제목 입력?");
            String subject = br.readLine();
            System.out.print("내용 입력?");
            String content = br.readLine();

            Board2 board = new Board2();
            board.setWriter(writer);
            board.setPasswd(passwd);
            board.setSubject(subject);
            board.setContent(content);

            BoardDAO dao = BoardDAO.getInstance();
            int result = dao.insertBoard(board);
            if(result == 1) {
                System.out.println("글작성 성공");
            }else {
                System.out.println("글작성 실패");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }

    }
    // 글목록
    public void selectBoard() {

        BoardDAO dao = BoardDAO.getInstance();

        int count = dao.getCount();
        System.out.println("글갯수:"+ count);
        System.out.println("--------------------------------------");

        List<Board2> list = dao.selectBoard();
//		System.out.println("list:"+ list);

        SimpleDateFormat sd =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE요일");

        if(list.size() == 0) {
            System.out.println("작성된 글이 없습니다.");
        }else {

            // Object get(int index)
            for(int i=0; i<list.size(); i++) {
                Board2 board = (Board2)list.get(i); // 다운 캐스팅

                System.out.print("번호:"+board.getNo()+"\t");
                System.out.print("작성자:"+board.getWriter()+"\t");
                System.out.print("비밀번호:"+board.getPasswd()+"\t");
                System.out.print("제목:"+board.getSubject()+"\t");
                System.out.print("내용:"+board.getContent()+"\t");
                System.out.print("날짜:"+sd.format(board.getRegister()));
                System.out.println();
            }

        }


    }
    // 글수정
    public void updateBoard() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("수정할 글번호를 입력 하세요?");
            int no = Integer.parseInt(br.readLine());
            System.out.print("작성자명을 입력 하세요?");
            String writer = br.readLine();
            System.out.print("비밀번호를 입력 하세요?");
            String passwd = br.readLine();
            System.out.print("제목을 입력 하세요?");
            String subject = br.readLine();
            System.out.print("내용을 입력 하세요?");
            String content = br.readLine();

            Board2 board = new Board2();
            board.setNo(no);
            board.setWriter(writer);
            board.setPasswd(passwd);
            board.setSubject(subject);
            board.setContent(content);

            BoardDAO dao = BoardDAO.getInstance();
            int result = dao.updateBoard(board);

            if(result == 1) {
                System.out.println("글수정 성공");
            }else {
                System.out.println("글수정 실패");
            }

        }catch(Exception e) {
            System.out.println("숫자만 입력 하세요.");
            e.printStackTrace();
        }

    }
    // 글삭제
    public void deleteBoard() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("삭제할 글번호를 입력 하세요.");
            int no = Integer.parseInt(br.readLine());
            System.out.print("비밀번호를 입력 하세요.");
            String passwd = br.readLine();

            Board2 board = new Board2();
            board.setNo(no);
            board.setPasswd(passwd);

            BoardDAO dao = BoardDAO.getInstance();
            int result = dao.deleteBoard(board);
            if(result == 1) {
                System.out.println("글삭제 성공");
            }else {
                System.out.println("글삭제 실패");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}

public class JavaTask108 {
    public static void main(String[] args) {

        BoardService bs = new BoardService();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.println("메뉴를 입력 하세요?");
            System.out.println("1.글작성");
            System.out.println("2.글목록");
            System.out.println("3.글수정");
            System.out.println("4.글삭제");
            System.out.println("5.종료");

            try {
                String menu = br.readLine();

                switch(menu) {
                    case "1" : bs.insertBoard();
                        break;
                    case "2" : bs.selectBoard();
                        break;
                    case "3" : bs.updateBoard();
                        break;
                    case "4" : bs.deleteBoard();
                        break;
                    case "5" : System.out.println("프로그램 종료");
//					           break;
                        return;
                    default : System.out.println("올바른 번호를 입력하세요");
                }

            }catch(Exception e) {
                e.printStackTrace();
            }

        }
    }
}