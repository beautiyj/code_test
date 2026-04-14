package task.java4;

// JDBC 드라이버 연결 테스트 프로그램

/*
인텔리제이에서 jdbc 드라이버 연결하기
1. 파일 -> 프로젝트 구조 -> 라이브러리 -> +
2. jdbc 드라이버 파일 선택 (예: mysql-connector-java-8.0.33.jar. ojdbc 11 연결했음)
3. 추가, 적용만 하면 끝! 이클립스에서 드라이버 경로 추가하는 건 15pdf 참고.

디비버는 마우스로 데이터 편하게 보는 데베연결용이고
인텔리제이는 라이브러리추가했으니 코딩해서 데베 제어 가능한 용도고


이클립스에서 jdbc 드라이버 연결하기
프로젝트 우클릭: 왼쪽 Package Explorer 창에서 해당 프로젝트 이름을 마우스 오른쪽 버튼으로 누릅니다.
Build Path 진입: 메뉴에서 Build Path -> Configure Build Path...를 클릭합니다.
Libraries 탭 클릭: 상단 탭에서 Libraries를 선택합니다.
파일 추가: * 중앙 목록에서 Classpath 항목을 먼저 클릭합니다. (이걸 선택해야 버튼이 활성화돼요!)
오른쪽의 Add External JARs... 버튼을 누릅니다.
드라이버 선택: 준비해둔 ojdbc11(혹은6).jar 파일을 찾아서 선택한 뒤, Apply and Close를 누르면 끝입니다!
강의에선 6으로연결했는데 현재 자바 17버전이라서 11최신버전으로 같이 연동함.

제대로 됐는지 확인하는 법
프로젝트 폴더 목록에 Referenced Libraries라는 항목이 생기고, 그 안에 ojdbc6(혹은11).jar가 들어있다면 성공입니다.


작업 내용               인텔리제이 (IntelliJ)                이클립스 (Eclipse)
설정 메뉴           Project Structure > Libraries       Build Path > Configure Build Path
파일 연결           + 버튼 눌러서 JAR 선택                Add External JARs... 눌러서 JAR 선택
최종 상태           External Libraries에 표시됨           Referenced Libraries에 표시됨
 */

import java.sql.Connection;
import java.sql.DriverManager;

class JDBC_Connect01 {
    public static void main(String[] args) {
//        ORACLE JDBC Driver Test
        String driver = "oracle.jdbc.driver.OracleDriver";
//        My-SQL JDBC Driver Test
//	String driver ="com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);  // JDBC 드라이버 로딩
            System.out.println("JDBC Driver Loading 성공~!!");
        } catch (Exception e) {
            System.out.println("JDBC Driver Loading 실패~!!");
            e.printStackTrace();
        }
    }
}

class JDBC_Connect02 {
    public static void main(String[] args) {
//        ORACLE JDBC Driver Test
        String driver = "oracle.jdbc.driver.OracleDriver";
//        String url = "jdbc:oracle:thin:@localhost:1521:orcl";  // 이건 오라클버전이고
        String url = "jdbc:oracle:thin:@localhost:1521:xe";     // 학습용 xe버전
//        My-SQL JDBC Driver Test
//		String driver = "com.mysql.jdbc.Driver";        // 5.x
//		String driver = "com.mysql.cj.jdbc.Driver";     // 8.x
//	    String url = "jdbc:mysql://localhost/academy";

        Connection con = null;

        try {
            Class.forName(driver);
//            ORACLE에서 Connection 객체                     데이터베이스 유저아이디랑 비번
            con = DriverManager.getConnection(url, "scott", "tiger");
//           My-SQL에서 Connection 객체
//	         con = DriverManager.getConnection(url, "totoro", "1234" );
            System.out.println("데이터베이스 연결 성공~!!");
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 실패~!!");
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class JavaTask96 {
    public static void main(String[] args) {
        JDBC_Connect01 obj = new JDBC_Connect01();
//        obj.main(args);

        JDBC_Connect02 obj2 = new JDBC_Connect02();
        obj2.main(args);
    }
}
