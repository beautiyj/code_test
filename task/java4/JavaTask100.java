package task.java4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 1. JavaInsert100 클래스 간략버전
class JavaInsert100 {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String sql = "INSERT into customer (no, name, email, tel) values (?, ?, ?, ?)";

        // try-with-resources: 소괄호() 안에 선언하면 작업 후 자동으로 close() 됨
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             Connection con = DriverManager.getConnection(url, "scott", "tiger");
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            Class.forName(driver);
            System.out.println("\n[1] customer 테이블에 값 입력하기 (PreparedStatement) .....");
            System.out.print(" 번호 입력: ");
            int ino = Integer.parseInt(br.readLine());
            System.out.print(" 이름 입력: ");
            String name = br.readLine();
            System.out.print(" 이메일 입력: ");
            String email = br.readLine();
            System.out.print(" 전화번호 입력: ");
            String tel = br.readLine();

            pstmt.setInt(1, ino);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, tel);

            int result = pstmt.executeUpdate();
            if (result == 1) System.out.println("데이터 입력 성공");

        } catch (Exception e) {
            System.out.println("데이터베이스 오류: " + e.getMessage());
        }
    }
}

// 2. JavaUpdate100 클래스
class JavaUpdate100 {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String sql = "UPDATE customer SET name=?, email = ?, tel = ? where no = ?";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             Connection con = DriverManager.getConnection(url, "scott", "tiger");
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            System.out.println("\n[2] customer 테이블에 값 갱신하기 .....");
            System.out.print("수정할 회원의 회원번호를 입력? ");
            int ino = Integer.parseInt(br.readLine());
            System.out.print("변경할 이름을 입력:");
            String name = br.readLine();
            System.out.print("변경할 이메일 입력: ");
            String email = br.readLine();
            System.out.print("변경할 전화번호 입력: ");
            String tel = br.readLine();

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, tel);
            pstmt.setInt(4, ino);

            int result = pstmt.executeUpdate();
            if (result == 1) System.out.println("데이터 수정 성공");
            else System.out.println("해당 번호의 회원이 없습니다.");

        } catch (Exception e) {
            System.out.println("데이터베이스 오류: " + e.getMessage());
        }
    }
}

// 3. JavaDelete100 클래스
class JavaDelete100 {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String sql = "DELETE FROM customer WHERE no = ?";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             Connection con = DriverManager.getConnection(url, "scott", "tiger");
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            System.out.println("\n[3] customer 테이블에서 레코드 삭제하기 .....");
            System.out.print("삭제할 회원의 회원번호를 입력하세요? ");
            int ino = Integer.parseInt(br.readLine());

            pstmt.setInt(1, ino);
            int result = pstmt.executeUpdate();
            if (result == 1) System.out.println("회원 삭제 성공");
            else System.out.println("삭제 실패 (번호 확인 필요)");

        } catch (Exception e) {
            System.out.println("데이터베이스 오류: " + e.getMessage());
        }
    }
}

// 4. JavaSelect100 클래스
class JavaSelect100 {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String sqlCount = "select count(*) from customer";
        String sqlSelect = "SELECT * FROM customer ORDER BY no ASC";

        try (Connection con = DriverManager.getConnection(url, "scott", "tiger");
             PreparedStatement pstmtCount = con.prepareStatement(sqlCount);
             PreparedStatement pstmtSelect = con.prepareStatement(sqlSelect);
             ResultSet rs01 = pstmtCount.executeQuery();
             ResultSet rs = pstmtSelect.executeQuery()) {

            if (rs01.next()) {
                System.out.println("\n[4] 총회원수:" + rs01.getInt(1));
            }

            System.out.printf("번호 \t 이름 \t\t 이메일 \t\t 전화번호 \n");
            System.out.println("-----------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf(" %d \t %s \t %s \t %s\n",
                        rs.getInt("no"), rs.getString("name"),
                        rs.getString("email"), rs.getString("tel"));
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 오류: " + e.getMessage());
        }
    }
}

// 메인 실행 클래스
public class JavaTask100 {
    public static void main(String[] args) {
        //순서대로 실행
        JavaInsert100.main(args);
        JavaUpdate100.main(args);
        JavaDelete100.main(args);
        JavaSelect100.main(args);
    }
}