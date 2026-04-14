package task.java4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// PreparedStatement 버전 (?,?,?,?)로 처리하는 버전

// 1. JDBC_Insert01 클래스
class JDBC_Insert01 {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        Connection con = null;
        PreparedStatement pstmt = null;
        String sql;
        String name, email, tel, no;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "scott", "tiger");

            // ---JDBC_Insert 추가된 내용-------
            // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("\n[1] customer 테이블에 값 입력하기 .....");
            System.out.print(" 번호 입력: ");
            no = br.readLine();
            System.out.print(" 이름 입력: ");
            name = br.readLine(); // 테이블에 추가할 name 필드 값을 입력 받음
            System.out.print(" 이메일 입력: ");
            email = br.readLine(); // 테이블에 추가할 email 필드 값을 입력 받음
            System.out.print(" 전화번호 입력: ");
            tel = br.readLine(); // 테이블에 추가할 tel 필드 값을 입력 받음

            int ino = Integer.parseInt(no);

            // INSERT 쿼리문을 작성
            sql = "INSERT into customer (no, name, email, tel) values (?, ?, ?, ?)";

            // PreparedStatement 로 하면 따옴표 지옥: '" + name + "'" 없이 (?,?,?,?)로 처리 가능
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, ino);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, tel);
            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("데이터 입력 성공");
            } else {
                System.out.println("데이터 입력 실패");
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 실패!");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

// 2. JDBC_Update01 클래스
class JDBC_Update01 {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        Connection con = null;
        PreparedStatement pstmt = null;
        String sql;
        String name, email, tel;
        int ino;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "scott", "tiger");

            //---JDBC_Insert 추가된 내용-------
            // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\n[2] customer 테이블에 값 갱신하기 .....");
            System.out.print("수정할 회원의 회원번호를 입력? ");
            ino = Integer.parseInt(br.readLine());

            System.out.print("변경할 이름을 입력:");
            name = br.readLine();            //테이블에 추가할 name 필드 값을 입력 받음
            System.out.print("변경할 이메일 입력: ");
            email = br.readLine();             //테이블에 추가할 email 필드 값을 입력 받음
            System.out.print("변경할 전화번호 입력: ");
            tel = br.readLine();               //테이블에 추가할 tel 필드 값을 입력 받음

            // 인서트절을 제외한 나머지는 모두 웨어 조건절 99% 존재.    프라이머리 키는 하나니까 where no = ? 하나만 있으면 됨
            sql = "UPDATE customer SET name=?,email = ?, tel = ? where no = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, tel);
            pstmt.setInt(4, ino);
            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("데이터 수정 성공");
            } else {
                System.out.println("데이터 수정 실패");
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 실패!");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

// 3. JDBC_Delete01 클래스
class JDBC_Delete01 {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        Connection con = null;
        PreparedStatement pstmt = null;
        String sql;
        int ino;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "scott", "tiger");

            //---JDBC_Delete 변경된 내용-------
            // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\n[3] customer 테이블에서 레코드 삭제하기 .....");
            System.out.print("삭제할 회원의 회원번호를 입력하세요? ");
            ino = Integer.parseInt(br.readLine());     //테이블에서 삭제할 name 필드 값을 입력 받음

            // DELETE 쿼리문을 작성
            sql = "DELETE FROM customer WHERE no = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, ino);
            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("회원 삭제 성공");
            } else {
                System.out.println("회원 삭제 실패");
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 실패!");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

// 4. JDBC_Select01 클래스
class JDBC_Select01 {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;        // 총 회원 수를 가져오는 객체
        ResultSet rs01 = null;      // 전체 회원 목록 가져오는 객체. ResultSet는 가장 최근 결과만 가져오는 애라서 2개가 필요한 거.
        int no = 0;
        String name, email, tel;
        String sql;
        int cnt = 0;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "scott", "tiger");

            // count(*)는 총 데이터 개수를 가져오는 함수.
            // 전체 회원 수를 가져오는 쿼리문을 작성하여 실행한 후, ResultSet 객체에서 총 회원 수를 가져와 출력한다.
            String sql01 = "select count(*) from customer";
            pstmt = con.prepareStatement(sql01);
            rs01 = pstmt.executeQuery();
            if (rs01.next()) {
                cnt = rs01.getInt(1);
            }
            System.out.println("\n[4] 총회원수:" + cnt);

            // ---JDBC_Select 추가된 내용 -------
            sql = "SELECT * FROM customer";
            System.out.printf("번호 \t 이름 \t\t 이메일 \t\t 전화번호 \n");
            System.out.printf("-----------------------------------------------------------------\n");
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery(); // 얻어진 레코드를 가져옴

            while (rs.next()) {
                no = rs.getInt("no");
                name = rs.getString("name");
                email = rs.getString("email");
                tel = rs.getString("tel");
                System.out.printf(" %d \t %s \t %s \t %s\n", no, name, email, tel);
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 실패!");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

// 메인 실행 클래스
public class JavaTask99 {
    public static void main(String[] args) {
        // 인서트, 업데이트, 삭제, 셀렉트 순서대로 실행
        JDBC_Insert01.main(args);
//        JDBC_Update01.main(args);
//        JDBC_Delete01.main(args);
//        JDBC_Select01.main(args);
    }
}