package task.java4;

// borad 게시판 작성하기

/*
table borad(
    no number PRIMARY KEY,
    writer varchar2(20) not null,
    pw VARCHAR2(20) not null,
    subject VARCHAR2(100) not null,
    content VARCHAR2(1000) not null,
    reg_date TIMESTAMP
)
+ sequence borad_seq 시퀀스 생성
 */

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

class BoardTask103 {
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "scott";
    private static final String PASSWORD = "tiger";

    // 게시판 글 입력하기 (INSERT)
    public static class InsertBoard {
        public static void main(String[] args) {
            String sql = "INSERT INTO borad(no, writer, pw, title, content, reg_date) " +
                    "VALUES (borad_seq.nextval, ?, ?, ?, ?, sysdate)";

            try {
                Class.forName(DRIVER);
            } catch (Exception e) {
                System.out.println("데이터베이스 연결 실패: " + e.getMessage());
            }

            // close 필요 없이 리소스문 안에 입력받기 & 통로 생성(드라이버), PreparedStatement 생성까지 한 번에 처리하기
            try (Scanner sc = new Scanner(System.in);
                 Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = con.prepareStatement(sql)) {

                System.out.println("Writer: ");
                String writer = sc.nextLine();
                System.out.println("Password: ");
                String pw = sc.nextLine();
                System.out.println("title: ");
                String title = sc.nextLine();
                System.out.println("Content: ");
                String content = sc.nextLine();

                pstmt.setString(1, writer);
                pstmt.setString(2, pw);
                pstmt.setString(3, title);
                pstmt.setString(4, content);

                int result = pstmt.executeUpdate();
                if (result > 0) {
                    System.out.println("글 등록 성공!");
                } else {
                    System.out.println("글 등록 실패!");
                }

            } catch (SQLException e) {
                System.err.println("입력 오류: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    // 게시판 글 수정하기 (UPDATE)
    public static class UpdateBoard {
        public static void main(String[] args) {
            // 수정 시에는 어떤 글을 수정할지 확인 필요      이건 수정할 항목              이건 수정할 데이터 찾는 부분
            String sql = "UPDATE borad SET writer = ?, title = ?, content = ? WHERE no = ? AND pw = ?";

            try { Class.forName(DRIVER); } catch (Exception e) { }

            try (Scanner sc = new Scanner(System.in);
                 Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = con.prepareStatement(sql)) {

                System.out.print("수정할 글 번호: ");
                int no = Integer.parseInt(sc.nextLine());
                /* 만약 번호 들어오자마자 해당 번호에 해당하는 게 있는지 체크하고 싶으면 여기서 sql을 하나 더 만들어서 체크해야함.
                String checkSql = "SELECT COUNT(*) FROM borad WHERE no = ?";
                try (PreparedStatement pstmtCheck = con.prepareStatement(checkSql)) {
                    pstmtCheck.setInt(1, no);
                    ResultSet rs = pstmtCheck.executeQuery();
                    if (rs.next() && rs.getInt(1) == 0) {
                        System.err.println("없는 번호입니다! 다시 입력하세요.");
                        return;
                    }
                }
                 */
                System.out.print("비밀번호 확인: ");
                String pw = sc.nextLine();
                System.out.print("작성자명 수정: ");
                String writer = sc.nextLine();
                System.out.print("새 제목: ");
                String title = sc.nextLine();
                System.out.print("새 내용: ");
                String content = sc.nextLine();

                pstmt.setString(1, writer);
                pstmt.setString(2, title);
                pstmt.setString(3, content);
                pstmt.setInt(4, no);
                pstmt.setString(5, pw);

                int result = pstmt.executeUpdate();
                if (result > 0) {
                    System.out.println("글 수정 성공");
                } else {
                    System.out.println("글 수정 실패 (번호, 비밀번호 재확인)");
                }

            } catch (SQLException e) {
                System.err.println("수정 오류: " + e.getMessage());
            }
        }
    }

    public static class DeleteBoard {
        public static void main(String[] args) {
            String sql = "DELETE FROM borad WHERE no = ? AND pw = ?";

            try { Class.forName(DRIVER); } catch (Exception e) { }

            try (Scanner sc = new Scanner(System.in);
                 Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = con.prepareStatement(sql)) {

                System.out.print("삭제할 글 번호: ");
                int no = Integer.parseInt(sc.nextLine());
                System.out.print("비밀번호 확인: ");
                String pw = sc.nextLine();

                pstmt.setInt(1, no);
                pstmt.setString(2, pw);

                int result = pstmt.executeUpdate();
                if (result > 0) {
                    System.out.println("글 삭제 성공!");
                } else {
                    System.out.println("삭제 실패 (번호, 비밀번호 재확인)");
                }

            } catch (SQLException e) {
                System.err.println("삭제 오류: " + e.getMessage());

            }
        }

    }

    // 게시판 글 카운트 & 조회하기 (SELECT)
    public static class SelectBoard {
        public static void main(String[] args) {
            String sqlCount = "SELECT COUNT(*) FROM borad";
            String sqlList = "SELECT * FROM borad ORDER BY no ASC";

            try { Class.forName(DRIVER); } catch (Exception e) { System.err.println("드라이버 로딩 실패: " + e.getMessage()); }

            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

                // 총 데이터 개수 조회 (count): 전체 회원 수를 가져오는 쿼리문을 실행하여 ResultSet에서 값을 가져와 출력
                try (PreparedStatement pstmt1 = con.prepareStatement(sqlCount);
                     ResultSet rs01 = pstmt1.executeQuery()) {

                    int cnt = 0;
                    if (rs01.next()) {
                        cnt = rs01.getInt(1);
                    }
                    System.out.println("\n[ 총 데이터(회원) 수: " + cnt + " ]");
                    System.out.println("-----------------------------------------------------------------------------------------------------------------");
                }   // count try-with-resources 끝

                // 전체 목록 조회 (SELECT): 전체 정보를 가져와서 한 줄씩 반복하며(while) 출력 ++ 너비 지정해서 제목 출력하기
                System.out.printf("%-5s \t %-10s \t %-5s \t %-20s \t %-30s \t %-20s\n", "번호", "작성자", "비번", "제목", "내용", "날짜");
                System.out.printf("-----------------------------------------------------------------------------------------------------------------\n");

                try (PreparedStatement pstmt2 = con.prepareStatement(sqlList);
                     ResultSet rs02 = pstmt2.executeQuery()) {

                    while (rs02.next()) {
                        int no = rs02.getInt("no");
                        String writer = rs02.getString("writer");
                        String pw = rs02.getString("pw");
                        String title = rs02.getString("title");
                        String content = rs02.getString("content");
                        Timestamp regDate = rs02.getTimestamp("reg_date");

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초 EEE요일");
                        String strDate = (regDate != null) ? sdf.format(regDate) : "날짜 없음";
                        System.out.printf("%-5d \t %-10s \t %-5s \t %-20s \t %-30s \t %-20s\n", no, writer, pw, title, content, strDate);   // %-10s -> 10칸을 차지하고 왼쪽 정렬
                    }
                }// select try-with-resources 끝

            } catch (SQLException e) {
                System.err.println("조회 오류: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

}

public class JavaTask103 {
    public static void main(String[] args) {
//        BoardTask103.InsertBoard.main(args);
        BoardTask103.UpdateBoard.main(args);
//        BoardTask103.DeleteBoard.main(args);
//        BoardTask103.SelectBoard.main(args);
    }
}