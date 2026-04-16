package task.java4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

// ============================================================
// 시퀀스 사용 - 실무버전
// ============================================================

// ============================================================
// DBUtil : DB 연결/해제 공통 처리 클래스 (실무에서 중복 제거용)
// ============================================================
class DBUtil {
    private static final Properties props = new Properties();

    // static 블록 : 클래스 로딩 시 한번만 실행 → properties 파일 읽기
    static {
        // 실무에서는 db.properties 파일로 DB 정보를 외부에서 관리
        // resources/db.properties 파일에서 읽어옴
        try (InputStream is = DBUtil.class.getClassLoader()
                .getResourceAsStream("db.properties")) {
            if (is != null) {
                props.load(is);
            } else {
                // properties 파일 없을 경우 기본값 세팅 (개발/테스트용)
                props.setProperty("db.driver", "oracle.jdbc.driver.OracleDriver");
                props.setProperty("db.url",    "jdbc:oracle:thin:@localhost:1521:xe");
                props.setProperty("db.user",   "scott");
                props.setProperty("db.password","tiger");
            }
        } catch (IOException e) {
            throw new ExceptionInInitializerError("DB 설정 파일 로드 실패: " + e.getMessage());
        }
    }

    // DB 연결 반환
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(props.getProperty("db.driver"));
        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
        );
    }

    // 자원 해제 (rs, pstmt, con 순서로 닫음 - 실무 표준 순서)
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
        try { if (rs    != null) rs.close();    } catch (SQLException e) { System.err.println("RS 닫기 실패: "    + e.getMessage()); }
        try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { System.err.println("PSTMT 닫기 실패: " + e.getMessage()); }
        try { if (con   != null) con.close();   } catch (SQLException e) { System.err.println("CON 닫기 실패: "   + e.getMessage()); }
    }

    // ResultSet 없는 버전 오버로딩 (INSERT/UPDATE/DELETE 용)
    public static void close(PreparedStatement pstmt, Connection con) {
        close(null, pstmt, con);
    }
}

// ============================================================
// CustomerDTO : 데이터 전달 객체 (VO/DTO 패턴 - 실무 표준)
// DB 컬럼과 1:1 매핑, getter/setter로 캡슐화
// ============================================================
class CustomerDTO {
    private int    no;
    private String name;
    private String email;
    private String tel;
    private String address;
    private Timestamp regDate;

    // 기본 생성자
    public CustomerDTO() {}

    // INSERT용 생성자 (no 제외 - 시퀀스 자동 생성)
    public CustomerDTO(String name, String email, String tel, String address) {
        this.name    = name;
        this.email   = email;
        this.tel     = tel;
        this.address = address;
    }

    // UPDATE용 생성자 (no 포함)
    public CustomerDTO(int no, String name, String email, String tel, String address) {
        this.no      = no;
        this.name    = name;
        this.email   = email;
        this.tel     = tel;
        this.address = address;
    }

    // Getter / Setter
    public int       getNo()       { return no;      }

    public void setNo(int no)            { this.no      = no;      }

    public String    getName()     { return name;    }

    public void setName(String name)     { this.name    = name;    }

    public String    getEmail()    { return email;   }

    public void setEmail(String email)   { this.email   = email;   }

    public String    getTel()      { return tel;     }

    public void setTel(String tel)       { this.tel     = tel;     }

    public String    getAddress()  { return address; }

    public void setAddress(String addr)  { this.address = addr;    }

    public Timestamp getRegDate()  { return regDate; }

    public void setRegDate(Timestamp ts) { this.regDate = ts;      }
}

// ============================================================
// CustomerDAO : DB CRUD 처리 전담 클래스 (DAO 패턴 - 실무 표준)
// 비즈니스 로직과 DB 로직을 분리
// ============================================================
class CustomerDAO {

    // INSERT - 시퀀스 사용
    // auto_increment : 자동으로 번호를 1씩 증가시켜 주는 역할, 시퀀스인 오라클보다 더 간단!
    public boolean insert(CustomerDTO dto) {
        Connection        con   = null;
        PreparedStatement pstmt = null;

        // INSERT 쿼리문에 시퀀스 적용 및 물음표 개수 조정(5개)
        String sql = "INSERT INTO customer (no, name, email, tel, address, reg_date) " +
                "VALUES (customer_no_seq.nextval, ?, ?, ?, ?, sysdate)";
        // sysdate(오라클에만 있음) 사용버전(타임스탬프랑 동일)
        try {
            con   = DBUtil.getConnection();
            pstmt = con.prepareStatement(sql);
            // 시퀀스가 첫 번째 컬럼(no)을 채우므로, set은 1번부터 name을 바인딩합니다.
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getEmail());
            pstmt.setString(3, dto.getTel());
            pstmt.setString(4, dto.getAddress());
            // pstmt.setTimestamp(5, ts); // 타임스탬프 사용버전

            return pstmt.executeUpdate() == 1;

        } catch (Exception e) {
            System.err.println("INSERT 실패: " + e.getMessage());
            return false;
        } finally {
            DBUtil.close(pstmt, con);
        }
    }

    // UPDATE - sysDate로 바꾸면 밀리초는 안나옴
    public boolean update(CustomerDTO dto) {
        Connection        con   = null;
        PreparedStatement pstmt = null;

        String sql = "UPDATE customer SET name=?, email=?, tel=?, address=?, reg_date=sysdate WHERE no=?";

        try {
            con   = DBUtil.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getEmail());
            pstmt.setString(3, dto.getTel());
            pstmt.setString(4, dto.getAddress());
            pstmt.setInt(5,    dto.getNo());
            // pstmt.setTimestamp(5, ts);
            // pstmt.setInt(6, no);

            return pstmt.executeUpdate() == 1;

        } catch (Exception e) {
            System.err.println("UPDATE 실패: " + e.getMessage());
            return false;
        } finally {
            DBUtil.close(pstmt, con);
        }
    }

    // DELETE
    public boolean delete(int no) {
        Connection        con   = null;
        PreparedStatement pstmt = null;

        // DELETE 쿼리문을 작성
        String sql = "DELETE FROM customer WHERE no=?";

        try {
            con   = DBUtil.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, no);

            return pstmt.executeUpdate() == 1;

        } catch (Exception e) {
            System.err.println("DELETE 실패: " + e.getMessage());
            return false;
        } finally {
            DBUtil.close(pstmt, con);
        }
    }

    // SELECT - 시퀀스 사용 시 번호 순 정렬이 보기 좋음
    // 회원들의 가입 날짜를 연,월,일,시,분,초로 출력하기
    public List<CustomerDTO> selectAll() {
        Connection        con   = null;
        PreparedStatement pstmt = null;
        ResultSet         rs    = null;

        List<CustomerDTO> list = new ArrayList<>();
        // 날짜 포맷을 보기 좋게 바꿔주는 SimpleDateFormat 객체 생성
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");

        String sql = "SELECT * FROM customer ORDER BY no ASC";
        // sql = "SELECT * FROM customer ORDER BY no DESC"; // 내림차순정렬

        try {
            con   = DBUtil.getConnection();
            pstmt = con.prepareStatement(sql);
            rs    = pstmt.executeQuery(); // 얻어진 레코드를 가져옴

            while (rs.next()) {
                CustomerDTO dto = new CustomerDTO();
                dto.setNo(rs.getInt("no"));
                dto.setName(rs.getString("name"));
                dto.setEmail(rs.getString("email"));
                dto.setTel(rs.getString("tel"));
                dto.setAddress(rs.getString("address"));
                // ts = rs.getTimestamp("reg_date").toString();
                dto.setRegDate(rs.getTimestamp("reg_date"));
                list.add(dto);
            }
        } catch (Exception e) {
            System.err.println("SELECT 실패: " + e.getMessage());
        } finally {
            // rs, stmt, con 객체를 close() 메서드를 호출해 해제
            DBUtil.close(rs, pstmt, con);
        }
        return list;
    }
}

// ============================================================
// CustomerService : 사용자 입력 처리 및 출력 담당
// (실무에서 Service 레이어 - DAO와 View 사이의 비즈니스 로직)
// ============================================================
class CustomerService {

    private final CustomerDAO    dao = new CustomerDAO();
    private final BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");

    // INSERT
    // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
    public void insert() throws IOException {
        System.out.println(" customer 테이블에 값 입력하기 .....");
        // 번호는 시퀀스 사용하므로 입력 받지 않음
        System.out.print(" 이름 입력: ");
        String name    = br.readLine().trim(); // 테이블에 추가할 name 필드 값을 입력 받음
        System.out.print(" 이메일 입력: ");
        String email   = br.readLine().trim(); // 테이블에 추가할 email 필드 값을 입력 받음
        System.out.print(" 전화번호 입력: ");
        String tel     = br.readLine().trim(); // 테이블에 추가할 tel 필드 값을 입력 받음
        System.out.print(" 주소 입력: ");
        String address = br.readLine().trim();

        boolean result = dao.insert(new CustomerDTO(name, email, tel, address));
        System.out.println(result ? " Data insert success!! " : " Data insert failed ");
    }

    // UPDATE
    // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
    public void update() throws IOException {
        System.out.println(" customer 테이블에 값 갱신하기 .....");
        System.out.print(" 번호 입력: ");
        int no         = Integer.parseInt(br.readLine().trim());
        System.out.print(" 변경할 이름 입력: ");
        String name    = br.readLine().trim(); // 테이블에 추가할 name 필드 값을 입력 받음
        System.out.print(" 변경할 이메일 입력: ");
        String email   = br.readLine().trim(); // 테이블에 추가할 email 필드 값을 입력 받음
        System.out.print(" 변경할 전화번호 입력: ");
        String tel     = br.readLine().trim(); // 테이블에 추가할 tel 필드 값을 입력 받음
        System.out.print(" 변경할 주소 입력: ");
        String address = br.readLine().trim();

        boolean result = dao.update(new CustomerDTO(no, name, email, tel, address));
        System.out.println(result ? " 데이터 수정 성공!! " : " 데이터 수정 실패 ");
    }

    // DELETE
    // 테이블에 추가할 내용을 도스 콘솔 창에서 사용자의 입력을 받도록 한다.
    public void delete() throws IOException {
        System.out.println(" customer 테이블에서 레코드 삭제하기 .....");
        System.out.print(" 삭제할 회원 번호를 입력하세요: ");
        int no = Integer.parseInt(br.readLine().trim()); // 테이블에서 삭제할 no 필드 값을 입력 받음

        boolean result = dao.delete(no);
        System.out.println(result ? " 데이터 삭제 성공!! " : " 데이터 삭제 실패 ");
    }

    // SELECT 전체 출력
    public void selectAll() {
        System.out.printf("번호 \t 이름 \t\t 이메일 \t\t 전화번호 \t 주소\t 날짜\n");
        System.out.printf("-----------------------------------------------------------------\n");

        List<CustomerDTO> list = dao.selectAll();
        for (CustomerDTO dto : list) {
            // ts = rs.getTimestamp("reg_date").toString();
            String strDate = (dto.getRegDate() != null) ? sdf.format(dto.getRegDate()) : "날짜 없음";
            System.out.printf(" %d \t %s \t %s \t %s\t %s\t %s\t  \n",
                    dto.getNo(), dto.getName(), dto.getEmail(),
                    dto.getTel(), dto.getAddress(), strDate);
        }
    }
}

// ============================================================
// 메인 클래스 - 실행 진입점
// ============================================================
public class JavaTask102 {
    public static void main(String[] args) {
        CustomerService service = new CustomerService();
        try {
//            service.insert();
            service.update();
//            service.delete();
//            service.selectAll();
        } catch (IOException e) {
            System.err.println("입력 오류: " + e.getMessage());
        }
    }
}