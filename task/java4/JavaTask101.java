package task.java4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.SimpleDateFormat;

// 시퀀스 사용

// 1. JDBC_Insert02 클래스
class JDBC_Insert02 {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection con = null;
        PreparedStatement pstmt = null;
        // ResultSet  rs   = null;
        String sql;
        String name, email, tel, address; // no 변수 제거 (시퀀스 사용)

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "scott", "tiger");

            //---JDBC_Insert 추가된 내용-------
            // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(" customer 테이블에 값 입력하기 .....");
            // 번호는 시퀀스 사용하므로 입력 받지 않음
            System.out.print(" 이름 입력: ");
            name = br.readLine().trim();            //테이블에 추가할 name 필드 값을 입력 받음
            System.out.print(" 이메일 입력: ");
            email = br.readLine().trim();             //테이블에 추가할 email 필드 값을 입력 받음
            System.out.print(" 전화번호 입력: ");
            tel = br.readLine().trim();               //테이블에 추가할 tel 필드 값을 입력 받음
            System.out.println(" 주소 입력: ");
            address = br.readLine().trim();

//            Timestamp ts = new Timestamp(System.currentTimeMillis());

            // INSERT 쿼리문에 시퀀스 적용 및 물음표 개수 조정(5개)
            sql = "INSERT into customer (no, name, email, tel, address, reg_date)" +
                    "values (customer_no_seq.nextval, ?, ?, ?, ?, sysdate)";    // sysdate(오라클에만 있음) 사용버전(타임스탬프랑 동일)
//                    "values (customer_no_seq.nextval, ?, ?, ?, ?, ?)";        // 타임스탬프 사용버전

            pstmt = con.prepareStatement(sql);
            // 시퀀스가 첫 번째 컬럼(no)을 채우므로, set은 1번부터 name을 바인딩합니다.
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, tel);
            pstmt.setString(4, address);
//            pstmt.setTimestamp(5, ts);

            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println(" Data insert success!! ");
            } else {
                System.out.println(" Data insert failed ");
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 실패!");
            System.out.println(e.getMessage());
        } finally {
            try {
//        if( rs != null )   rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

// 2. JDBC_Update02 클래스
class JDBC_Update02 {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        Connection con = null;
        PreparedStatement pstmt = null;
        String sql;
        int no;
        String name, email, tel, address;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "scott", "tiger");

            //---JDBC_Insert 추가된 내용-------
            // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(" customer 테이블에 값 갱신하기 .....");
            System.out.println("번호 입력: ");
            no = Integer.parseInt(br.readLine());
            System.out.print("변경할 이름 입력: ");
            name = br.readLine();            //테이블에 추가할 name 필드 값을 입력 받음
            System.out.print("변경할 이메일 입력: ");
            email = br.readLine();             //테이블에 추가할 email 필드 값을 입력 받음
            System.out.print("변경할 전화번호 입력: ");
            tel = br.readLine();               //테이블에 추가할 tel 필드 값을 입력 받음
            System.out.println("변경할 주소 입력: ");
            address = br.readLine();

//            Timestamp ts = new Timestamp(System.currentTimeMillis());
//                                                                              sysDate로 바꾸면 밀리초는 안나옴
            sql = "UPDATE customer SET name = ?, email = ?, tel = ?, address = ?, reg_date = sysDate where no = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, tel);
            pstmt.setString(4, address);
//            pstmt.setTimestamp(5, ts);
//            pstmt.setInt(6, no);
            pstmt.setInt(5, no);
            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println(" 데이터 수정 성공!! ");
            } else {
                System.out.println(" 데이터 수정 실패 ");
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 실패!");
            System.out.println(e.getMessage());
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

// 3. JDBC_Delete02 클래스
class JDBC_Delete02 {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql;
        int no;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "scott", "tiger");

            //---JDBC_Delete 변경된 내용-------
            // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(" customer 테이블에서 레코드 삭제하기 .....");
            System.out.print("삭제할 회원 번호를 입력하세요: ");
            no = Integer.parseInt(br.readLine());     //테이블에서 삭제할 no 필드 값을 입력 받음

            // DELETE 쿼리문을 작성
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
            System.out.println(e.getMessage());
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

// 4. JDBC_Select02 클래스
class JDBC_Select02 {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection con = null;
        PreparedStatement pstmt = null;
        //---JDBC_Select 추가된 내용 -------
        ResultSet rs = null;
        int no = 0;
        String name = "", email = "", tel = "", address = ""/* , ts = "" */;  //데이터베이스에서 얻어온 필드값 저장할 변수 선언
        String sql;               //SQL문을 저장할 변수 선언

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "scott", "tiger");

            //---JDBC_Select 추가된 내용 -------
            sql = "SELECT * FROM customer ORDER BY no ASC"; // 시퀀스 사용 시 번호 순 정렬이 보기 좋음
//            sql = "SELECT * FROM customer ORDER BY no DESC"; // 내림차순정렬
            System.out.printf("번호 \t 이름 \t\t 이메일 \t\t 전화번호 \t 주소\t 날짜\n");
            System.out.printf("-----------------------------------------------------------------\n");
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();  //얻어진 레코드를 가져옴

            // 날짜 포맷을 보기 좋게 바꿔주는 SimpleDateFormat 객체 생성
            // 회원들의 가입 날짜를 연,월,일,시.,분,초로 출력하기
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");

            while (rs.next()) {
                no = rs.getInt("no");
                name = rs.getString("name");
                email = rs.getString("email");
                tel = rs.getString("tel");
                address = rs.getString("address");
//                ts = rs.getTimestamp("reg_date").toString();
                Timestamp ts = rs.getTimestamp("reg_date");
                String strDate = (ts != null) ? sdf.format(ts) : "날짜 없음";

                System.out.printf(" %d \t %s \t %s \t %s\t %s\t %s\t  \n", no, name, email, tel, address, strDate);
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 실패!");
        } finally {
            try {//rs, stmt, con 객체를 close() 메서드를 호출해 해제
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class JavaTask101 {
    public static void main(String[] args) {
//        JDBC_Insert02.main(args);
         JDBC_Update02.main(args);
        // JDBC_Delete02.main(args);
//        JDBC_Select02.main(args);
    }
}