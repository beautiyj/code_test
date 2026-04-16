package task.java4;

import java.sql.Connection;
import java.sql.DriverManager;

// JavaTask96의 JDBC_Connect02 코드와 동일함(MySQL 연동용)

class JDBC_Connect104{
    public static void main(String[] args)  {
//        ORACLE JDBC Driver Test
//        String driver = "oracle.jdbc.driver.OracleDriver";
//        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//        My-SQL JDBC Driver
//		  String driver = "com.mysql.jdbc.Driver";        // 5.x
		String driver = "com.mysql.cj.jdbc.Driver";     // 8.x버전으로 사용 예정
	    String url = "jdbc:mysql://localhost:3306/jsptest"; // 기본 포트 3306이면 생략가능함
        Connection con = null;

        try{
            Class.forName(driver);
//            ORACLE에서 Connection 객체
//            con = DriverManager.getConnection(url, "scott", "tiger" );
//            My-SQL에서 Connection 객체
            con = DriverManager.getConnection(url, "jspid", "jsppass" );
            System.out.println("데이터베이스 연결 성공~!!");
        } catch(Exception e){
            System.out.println("데이터베이스 연결 실패~!!");
            e.printStackTrace();
        } finally{
            try{
                if( con != null )         con.close();
            } catch(Exception e){
                System.out.println( e.getMessage( ));
            }
        }
    }
}

public class JavaTask104 {
    public static void main(String[] args) {
        JDBC_Connect02.main(args);
    }
}

/*  이클립스에서 MySQL JDBC 드라이버 연결하기
커넥터 파일(.jar) 준비하기
먼저 내 컴퓨터에 MySQL 커넥터 파일이 어디 있는지 확인합니다.
보통 C:\Program Files (x86)\MySQL\Connector J 8.x 폴더 안에 mysql-connector-j-8.x.x.jar 파일이 있습니다.
(파일이 없다면 MySQL 공식 홈페이지에서 Platform Independent 버전을 다운로드하세요.)

프로젝트에 라이브러리 추가하기 (Build Path)
이클립스 왼쪽 Package Explorer에서 해당 프로젝트 이름을 마우스 우클릭합니다.
[Build Path] → **[Configure Build Path...]**를 클릭합니다.
상단 탭에서 **[Libraries]**를 선택합니다.
오른쪽 버튼 중 **[Add External JARs...]**를 클릭합니다.
1번에서 확인한 .jar 파일을 선택하고 **[Open]**을 누릅니다.
**[Apply and Close]**를 눌러 설정을 마칩니다.

*[Window] → [Preferences] → [Data Management] → [Connectivity] → [Driver Definitions]**에서
새 드라이버를 등록할 때 New Driver Definition 설정 가이드
1. Name/Type 탭 (버전 선택)
여기서는 내가 어떤 종류의 DB를 쓸지 템플릿을 고르는 단계입니다.
Vendor Filter: MySQL을 선택하세요.
Available Driver Templates: 목록에 MySQL JDBC Driver가 여러 개 뜰 텐데, 현재 설치하신 MySQL 8.0 버전에 맞춰 MySQL JDBC Driver 8.0 (또는 가장 높은 버전)을 선택하시면 됩니다.
Driver Name: 이 드라이버의 이름을 정하는 건데, 기본값 그대로 두셔도 되고 알아보기 쉽게 MySQL8_Driver 정도로 수정하셔도 됩니다.

2. Jar List 탭 (파일 연결)
이클립스에게 실제 드라이버 파일(.jar)의 위치를 알려주는 가장 중요한 단계입니다.
처음에 느낌표(!)가 떠 있는 기본 파일명은 [Remove JAR/Zip] 버튼을 눌러 지워주세요.
[Add JAR/Zip...] 버튼을 눌러 아까 확인한 경로(C:\Program Files (x86)\MySQL\Connector J 8.x\mysql-connector-j-8.x.x.jar)의 파일을 선택해서 추가합니다.

3. Properties 탭 (접속 정보 설정)
여기는 자바 코드에서 URL, ID, PW를 적는 것과 똑같은 과정입니다. 실사용 DB명 & 계정정보.
Connection URL: jdbc:mysql://localhost:3306/jsptest (사용자님의 DB명 입력)
Database Name: jsptest
User ID: root (또는 생성한 계정 jspid)
Password: 설정하신 비밀번호 입력 (jsppass)
드라이버클래스에 cj없으면 넣어주기(8.x버전은 cj붙어야함)
Driver Class: com.mysql.cj.jdbc.Driver (8.x버전)
 */