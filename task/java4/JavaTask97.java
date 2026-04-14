package task.java4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// INSERT, UPDATE, DELETE, SELECT 쿼리를 이용해
// customer 테이블에 레코드 추가, 수정, 삭제, 조회하는 프로그램 작성
// 인텔리제이 유료버전만 쿼리 실행이 가능해서 .SQL파일의 코드 그대로 디비버에서 실행함.

 /*
 이클립스에서 DB 뷰어 띄우기 (Data Source Explorer) - 직접 테이블 데이터를 보고 싶을 때 사용하는 설정
상단 메뉴 Window -> Show View -> Other... 클릭.
검색창에 Data Source Explorer 입력 후 선택하여 오픈.
Database Connections 폴더 우클릭 -> New... 클릭.
Oracle 선택 후 이름 입력 (예: MyOracle).
드라이버 설정 (Driver Definitions): * 오른쪽의 + 버튼(New Driver Definition) 클릭.
Oracle Thin Driver (버전 상관없음) 선택.
Jar List 탭에서 기존에 등록된 건 제거(Remove JAR)하고, 방금 우리가 쓴 ojdbc11.jar를 다시 추가(Add JAR) 해줍니다.
접속 정보 입력: URL: jdbc:oracle:thin:@localhost:1521:xe (또는 orcl)
User ID: scott
Password: tiger
Test Connection: 성공하면 완료!
  */


// createStatement 버전
class JDBC_Insert {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        Connection con = null;          // 데이터베이스 접속 객체
        Statement stmt = null;          // SQL문 실행 객체
        // ResultSet  rs   = null;      // SELECT 쿼리문 실행 후 결과를 저장하는 객체.
                                        // 데이터 조회된 뭉치를 리턴하는 객체라서 셀렉트에서만 쓴다고 보면 됨
        String sql;
        String name, email, tel, no;

        try {
            Class.forName(driver);      // JDBC 드라이버 로딩
            con = DriverManager.getConnection(url, "scott", "tiger");
            stmt = con.createStatement();       // SQL문 실행 객체 생성

            //---JDBC_Insert 추가된 내용-------
            // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(" customer 테이블에 값 입력하기 .....");
            System.out.print(" 번호 입력: ");
            no = br.readLine();
            System.out.print(" 이름 입력: ");
            name = br.readLine();            //테이블에 추가할 name 필드 값을 입력 받음
            System.out.print(" 이메일 입력: ");
            email = br.readLine();             //테이블에 추가할 email 필드 값을 입력 받음
            System.out.print(" 전화번호 입력: ");
            tel = br.readLine();               //테이블에 추가할 tel 필드 값을 입력 받음

            // INSERT 쿼리문을 작성
            sql = "INSERT into customer(no, name, email, tel) values ";
            sql += "(" + no + ",'" + name + "','" + email + "','" + tel + "')";     // 문자열은 따옴표로 감싸줘야 하므로 name, email, tel은 각각 따옴표로 감싸줌
                    // (no,'name','email','tel') 형태로 쿼리문이 완성됨

            //Statement 객체의 executeUpdate(sql) 메서드를 이용해 영향을 받은 행(row)의 개수 리턴함.
            int res = stmt.executeUpdate(sql);  //데이터베이스 파일에 새로운 값을 추가시킴

            if (res == 1) {
                System.out.println(" Data insert success!! ");
            } else {
                System.out.println(" Data insert failed ");
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 실패!");
        } finally {
            try {
                //       if( rs != null )   rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class JDBC_Update {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        Connection con = null;
        Statement stmt = null;

        String sql;
        int no = 0;
        String name, email, tel;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "scott", "tiger");
            stmt = con.createStatement();

            //---JDBC_Insert 추가된 내용-------
            // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(" customer 테이블에 값 갱신하기 .....");
            System.out.print("수정할 회원번호를 입력 하세요?");
            no = Integer.parseInt(br.readLine());
            System.out.print("변경할 이름을 입력하세요: ");
            name = br.readLine();            //테이블에 추가할 name 필드 값을 입력 받음
            System.out.print("변경할 이메일 입력: ");
            email = br.readLine();             //테이블에 추가할 email 필드 값을 입력 받음
            System.out.print("변경할 전화번호 입력: ");
            tel = br.readLine();               //테이블에 추가할 tel 필드 값을 입력 받음

            // INSERT 쿼리문을 작성
            sql = "UPDATE customer SET email='" + email;
            sql += "' , tel='" + tel + "', name='" + name + "' WHERE no = " + no;

            //Statement 객체의 executeUpdate(sql) 메서드를 이용해
            int result = stmt.executeUpdate(sql);  //데이터베이스 파일의 내용을 변경시킴
            if (result == 1) {
                System.out.println("데이터 수정 성공");
            } else {
                System.out.println("데이터 수정 실패");
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 실패!");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class JDBC_Delete {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        Connection con = null;
        Statement stmt = null;
        String sql;
        int no;
        String name, email, tel;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "scott", "tiger");
            stmt = con.createStatement();

            //---JDBC_Delete 변경된 내용-------
            // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(" customer 테이블에서 레코드 삭제하기 .....");
            System.out.print("삭제할 회원번호를 입력하세요: ");
            no = Integer.parseInt(br.readLine());     //테이블에서 삭제할 name 필드 값을 입력 받음

            // DELETE 쿼리문을 작성
            sql = "DELETE FROM customer WHERE no =" + no;

            //Statement 객체의 executeUpdate(sql) 메서드를 이용해
            int result = stmt.executeUpdate(sql);  //데이터베이스 파일에서 레코드 삭제시킴
            if (result == 1) {
                System.out.println("회원삭제 성공");
            } else {
                System.out.println("회원삭제 실패");
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 실패!");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class JDBC_Select {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        Connection con = null;
        Statement stmt = null;
        //---JDBC_Select 추가된 내용 -------
        ResultSet rs = null;        // 리턴 받은 레코드 뭉치를 저장할 객체 선언!(셀렉스 sql문으로 검색한 데이터를 관리하는 객체)
        int no = 0;
        String name, email, tel;  //데이터베이스에서 얻어온 필드값 저장할 변수 선언
        String sql;               //SQL문을 저장할 변수 선언
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "scott", "tiger");
            stmt = con.createStatement();
            //---JDBC_Select 추가된 내용 -------
            sql = "SELECT * FROM customer";
            System.out.printf("번호 \t 이름 \t\t 이메일 \t\t 전화번호 \n");
            System.out.printf("-----------------------------------------------------------------\n");
            rs = stmt.executeQuery(sql);  //얻어진 레코드를 가져옴. 리턴받는 객체 뭉치(ResultSet)에 저장됨

            // boolean형 반환 next() 메서드: ResultSet 객체에서 다음 레코드가 존재하는지 체크하는 메서드.
            // 다음 레코드가 있으면 true, 없으면 false 리턴
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
            try {//rs, stmt, con 객체를 close() 메서드를 호출해 해제
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


public class JavaTask97 {
    public static void main(String[] args) {
//        JDBC_Insert.main(args);
//        JDBC_Select.main(args);
        JDBC_Update.main(args);
//        JDBC_Delete.main(args);
    }
}


/*
이클립스 (Data Source Explorer)
이클립스에서 New Driver Definition을 설정하고 프로퍼티에서 localhost를 잡는 과정은
해당 DB 서버에 대한 출입증을 만드는 것과 같습니다.
한 번만 하면 되는 경우: 동일한 오라클 서버(xe)의 동일한 계정(scott)을 사용할 때는 저장된 설정을 계속 재사용하면 됩니다.
다시 해야 하는 경우: 다른 컴퓨터의 DB에 접속하거나, 아예 다른 종류의 DB(MySQL 등)를 추가할 때는 새로 만들어야 합니다.

인텔리제이 (Database 탭)
인텔리제이 유료 버전이나 플러그인을 쓸 때도 원리는 같습니다.
최초 1회 설정: 오른쪽 Database 탭에서 + 버튼을 눌러 Host: localhost, User: scott 등을 입력해두면
             프로젝트를 껐다 켜도 정보가 유지됩니다.
프로젝트별 공유: 인텔리제이는 이 설정을 '프로젝트 단위'로 저장할지, '전체 설정'으로 공유할지 선택할 수 있습니다.
               보통은 한 번 잡아두면 다른 클래스를 만들 때마다 다시 할 필요가 전혀 없습니다.

 */