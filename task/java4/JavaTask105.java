package task.java4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.SimpleDateFormat;

// JavaTask101 코드의 MySQL버전
// 대상 테이블: customer (no, name, email, tel, address, reg_date)

// 1. JDBC_Insert105 클래스
class JDBC_Insert105 {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/jsptest?serverTimezone=UTC";
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql;
        String name, email, tel, address; // no 변수 제거 (AUTO_INCREMENT 사용)

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "jspid", "jsppass" );

            //---JDBC_Insert 추가된 내용-------
            // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(" customer 테이블에 값 입력하기 .....");
            // 번호는 AUTO_INCREMENT이므로 입력 받지 않음
            System.out.print(" 이름 입력: ");
            name = br.readLine().trim();            //테이블에 추가할 name 필드 값을 입력 받음
            System.out.print(" 이메일 입력: ");
            email = br.readLine().trim();             //테이블에 추가할 email 필드 값을 입력 받음
            System.out.print(" 전화번호 입력: ");
            tel = br.readLine().trim();               //테이블에 추가할 tel 필드 값을 입력 받음
            System.out.println(" 주소 입력: ");
            address = br.readLine().trim();

            // INSERT 쿼리문에 no를 제외 (MySQL이 자동으로 1씩 증가시킴)
            sql = "INSERT into customer (name, email, tel, address, reg_date) " +
                    "values (?, ?, ?, ?, now())";       // sysdate()도 가능. MySQL에선 () 괄호 들어가야함

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, tel);
            pstmt.setString(4, address);

            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println(" Data insert success!! ");
            } else {
                System.out.println(" Data insert failed ");
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 실패!");
            e.printStackTrace();
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

// 2. JDBC_Update105 클래스
class JDBC_Update105 {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/jsptest?serverTimezone=UTC";

        Connection con = null;
        PreparedStatement pstmt = null;
        String sql;
        int no;
        String name, email, tel, address;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "jspid", "jsppass");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(" customer 테이블에 값 갱신하기 .....");
            System.out.print("번호 입력: ");
            no = Integer.parseInt(br.readLine());
            System.out.print("변경할 이름 입력: ");
            name = br.readLine();
            System.out.print("변경할 이메일 입력: ");
            email = br.readLine();
            System.out.print("변경할 전화번호 입력: ");
            tel = br.readLine();
            System.out.println("변경할 주소 입력: ");
            address = br.readLine();

            sql = "UPDATE customer SET name = ?, email = ?, tel = ?, address = ?, reg_date = now() where no = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, tel);
            pstmt.setString(4, address);
            pstmt.setInt(5, no);
            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println(" 데이터 수정 성공!! ");
            } else {
                System.out.println(" 데이터 수정 실패 ");
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 실패!");
            e.printStackTrace();
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

// 3. JDBC_Delete105 클래스
class JDBC_Delete105 {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/jsptest?serverTimezone=UTC";
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql;
        int no;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "jspid", "jsppass");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(" customer 테이블에서 레코드 삭제하기 .....");
            System.out.print("삭제할 회원 번호를 입력하세요: ");
            no = Integer.parseInt(br.readLine());

            sql = "DELETE FROM customer WHERE no = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, no);
            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println(" 데이터 삭제 성공!! ");
            } else {
                System.out.println(" 데이터 삭제 실패 ");
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 실패!");
            e.printStackTrace();
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

// 4. JDBC_Select105 클래스
class JDBC_Select105 {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/jsptest?serverTimezone=UTC";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int no = 0;
        String name = "", email = "", tel = "", address = "";
        String sql;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "jspid", "jsppass");

            sql = "SELECT * FROM customer ORDER BY no ASC";
            System.out.printf("번호 \t 이름 \t\t 이메일 \t\t 전화번호 \t 주소\t 날짜\n");
            System.out.printf("-----------------------------------------------------------------\n");
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");

            while (rs.next()) {
                no = rs.getInt("no");
                name = rs.getString("name");
                email = rs.getString("email");
                tel = rs.getString("tel");
                address = rs.getString("address");
                Timestamp ts = rs.getTimestamp("reg_date");
                String strDate = (ts != null) ? sdf.format(ts) : "날짜 없음";

                System.out.printf(" %d \t %s \t %s \t %s\t %s\t %s\t  \n", no, name, email, tel, address, strDate);
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 실패!");
            e.printStackTrace();
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

public class JavaTask105 {
    public static void main(String[] args) {
//        JDBC_Insert105.main(args);
         JDBC_Update105.main(args);
        // JDBC_Delete105.main(args);
//         JDBC_Select105.main(args);
    }
}