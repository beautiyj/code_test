package task.java4;

import java.sql.*;
import java.util.Scanner;

/**
 * 실무형 JDBC 예제
 * 1. PreparedStatement 사용 (보안 및 따옴표 처리 자동화)
 * 2. try-with-resources 사용 (자원 자동 해제)
 * 3. 코드의 모듈화 (기능별 메서드 분리)
 */
class JavaTask97Professional {

    // DB 접속 정보 (상수로 관리)
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "scott";
    private static final String PASS = "tiger";

    public static void main(String[] args) {
        try {
            Class.forName(DRIVER); // 드라이버 로딩은 처음 한 번만
        } catch (ClassNotFoundException e) {
            System.err.println("드라이버 로드 실패: " + e.getMessage());
            return;
        }

        Scanner sc = new Scanner(System.in);

        // 실무에서는 보통 메뉴를 만들어 사용합니다.
        while (true) {
            System.out.println("\n--- 회원 관리 프로그램 ---");
            System.out.println("1.입력  2.조회  3.수정  4.삭제  0.종료");
            System.out.print("선택: ");
            int menu = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            if (menu == 0) break;

            switch (menu) {
                case 1: insertMember(sc); break;
                case 2: selectMembers(); break;
                case 3: updateMember(sc); break;
                case 4: deleteMember(sc); break;
                default: System.out.println("잘못된 선택입니다.");
            }
        }
        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }

    // 1. 데이터 입력 (INSERT)
    private static void insertMember(Scanner sc) {
        String sql = "INSERT INTO customer(no, name, email, tel) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            System.out.print("번호: "); int no = sc.nextInt(); sc.nextLine();
            System.out.print("이름: "); String name = sc.nextLine();
            System.out.print("메일: "); String email = sc.nextLine();
            System.out.print("전화: "); String tel = sc.nextLine();

            // ? 자리에 순서대로 바인딩 (따옴표 처리를 자바가 알아서 함)
            pstmt.setInt(1, no);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, tel);

            int result = pstmt.executeUpdate();
            if (result > 0) System.out.println("회원 등록 성공!");

        } catch (SQLException e) {
            System.err.println("입력 오류: " + e.getMessage());
        }
    }

    // 2. 데이터 조회 (SELECT)
    private static void selectMembers() {
        String sql = "SELECT * FROM customer ORDER BY no ASC";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n번호\t이름\t이메일\t\t전화번호");
            System.out.println("----------------------------------------");
            while (rs.next()) {
                System.out.printf("%d\t%s\t%s\t%s\n",
                        rs.getInt("no"), rs.getString("name"),
                        rs.getString("email"), rs.getString("tel"));
            }

        } catch (SQLException e) {
            System.err.println("조회 오류: " + e.getMessage());
        }
    }

    // 3. 데이터 수정 (UPDATE)
    private static void updateMember(Scanner sc) {
        String sql = "UPDATE customer SET name=?, email=?, tel=? WHERE no=?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            System.out.print("수정할 회원 번호: "); int no = sc.nextInt(); sc.nextLine();
            System.out.print("새 이름: "); String name = sc.nextLine();
            System.out.print("새 메일: "); String email = sc.nextLine();
            System.out.print("새 전화: "); String tel = sc.nextLine();

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, tel);
            pstmt.setInt(4, no);

            int result = pstmt.executeUpdate();
            if (result > 0) System.out.println("수정 성공!");
            else System.out.println("해당 번호의 회원이 없습니다.");

        } catch (SQLException e) {
            System.err.println("수정 오류: " + e.getMessage());
        }
    }

    // 4. 데이터 삭제 (DELETE)
    private static void deleteMember(Scanner sc) {
        String sql = "DELETE FROM customer WHERE no = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            System.out.print("삭제할 회원 번호: "); int no = sc.nextInt();

            pstmt.setInt(1, no);

            int result = pstmt.executeUpdate();
            if (result > 0) System.out.println("삭제 완료!");
            else System.out.println("해당 번호의 회원이 없습니다.");

        } catch (SQLException e) {
            System.err.println("삭제 오류: " + e.getMessage());
        }
    }
}

public class JavaTask98 {
    public static void main(String[] args) {
        JavaTask97Professional.main(args);
    }
}
