package task.java2;

import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

// 기본 api클래스

public class JavaTask32 {
    public static void main(String[] args) {

        // 날짜 & 시간 관련 클래스
        /*
        패턴 문자       의미                        설명 (비고)
        -------------------------------------------------------------------------
        y              년                      연도를 4자리(yyyy) 또는 2자리(yy)로 표시
        M              월                      대문자 필수! (1~12월)
        d              일                      한 달 중의 날짜 (1~31일)
        D              월                      구분 없는 일,1년 중 몇 번째 날인지 (1~365일)
        E              요일                    화, 화요일 등 요일 명칭"
        a              오전/오후                AM/PM 구분
        w              년의 몇 번째 주          1년 중 몇 주차인지
        W              월의 몇 번째 주          이번 달 중 몇 주차인지
        H              시(0~23)               24시간제 (밤 12시는 0시)
        h              시(1~12)               12시간제 (오전/오후 'a'와 함께 사용)
        K              시(0~11)               시간대별 12시간제
        k              시(1~24)               24시간제 (밤 12시는 24시)
        m              분                      0~59분
        s              초                      0~59초
        S              밀리세컨드                1/1000초 단위

        월(Month)의 'M' 개수
        구형: M이나 MM이나 큰 차이 없이 숫자로 잘 나옵니다.
        신형: M 개수에 따라 출력이 확 달라집니다.
        M: 3 (한 자리)
        MM: 03 (두 자리 고정)
        MMM: 3월 (짧은 텍스트)
        MMMM: 3월 (긴 텍스트 - 한국어는 같지만 영어는 Mar/March 차이)

        요일(Day of Week)의 'E'
        구형: E만 써도 "화" 또는 "화요일"이 상황에 맞춰 나옵니다.
        신형: 개수에 따라 형식을 강제할 수 있습니다.
        E, EE, EEE: 화
        EEEE: 화요일
         */

        // Date : 간단한 날짜와 시간 처리
        // 출력 결과물은 Tue Mar 31 16:11:18 KST 2026 형태.
        // 직관적이지만 날짜 계산 기능이 약해 주로 출력용으로만 씀.
        Date date = new Date();
        System.out.println("Date 출력: " + date);

        System.out.println();

        // Timestamp : 시스템의 밀리초(1/1000초)를 받아와서 생성
        // 출력 결과물은 2026-03-31 16:17:19.182 형태.  (시/분/초/나노초)
        // 주로 데이터베이스(DB)에 게시글 등록 시간 등을 저장할 때 필수적으로 사용함.
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("Timestamp 출력: " + timestamp);

        System.out.println();

        // Calendar : 날짜 계산(더하기, 빼기)을 위해 등장했으나, 월(Month)이 0부터 시작하는 등 사용이 불편함.
        // 추상클래스라서 직접 new를 못 쓰고 getInstance()라는 정적 메소드로 객체를 생성해야 함.
        // 출력용보단 날짜 계산용임. 요일도 나오긴 하는데 숫자로 나와서 문자로 바꾸기 필요.
        Calendar calendar = Calendar.getInstance();
        System.out.println("Calendar 년: " + calendar.get(Calendar.YEAR));
        System.out.println("Calendar 월: " + (calendar.get(Calendar.MONTH)+1) );   // 월이 0부터 시작
        System.out.println("Calendar 일: " + calendar.get(Calendar.DATE));
        System.out.println("Calendar 일: " + calendar.get(Calendar.HOUR));
        System.out.println("Calendar 일: " + calendar.get(Calendar.HOUR_OF_DAY));

        System.out.println();

        // SimpleDateFormat : 구형 포맷 방식. 포맷 방식 이니셜은 대소문자 구분, 여러 개 있음.
        // 단독사용은 불가. 단독으로는 날짜 정보를 생성하지 못하며, 반드시 Date나 Timestamp 객체가 필요함.
        // Date나 Timestamp 같은 구형 날짜 객체를 원하는 문자열 형식으로 변환함.(가변, 멀티스레드 불안)
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
        System.out.println(simpleDateFormat2.format(calendar.getTime()));

        System.out.println();

        // LocalDateTime : 자바 8부터 도입된 현대적인 방식. 날짜와 시간 데이터를 모두 가짐.
        // Calendar의 단점(월이 0부터 시작 등)을 해결했고, 훨씬 직관적임.
        // 출력을 위해 'DateTimeFormatter'라는 짝꿍 포맷터가 필요함.
        // SimpleDateFormat보다 속도가 빠르고 멀티스레드 환경에서 안전함(Thread-safe).
        // 출력 결과물: 2026-03-31T16:35:19.928209. ZonedDateTime사용 세계시간으로도 표기됨.
        LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDateTime 기본 출력: " + now);

        System.out.println();

        // DateTimeFormatter : 신형 포맷 방식. LocalDateTime 전용 포맷터.
        // SimpleDateFormat보다 속도가 빠르고 안전함(Thread-safe).
        // SimpleDateFormat과 달리 ofPattern() 메소드로 형식을 지정함.
        // 데이터(now)에 도구(dtf)를 적용해서 문자열로 뽑아냄. (불변, 멀티스레드 안전)
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("신형 포맷 결과: " + now.format(dtf));

        System.out.println();

        // 그냥 인풋스트림은 한글이나 숫자 읽는게 어려워서 스캐너 변환을 자주 쓰는 거.
        InputStream inputStream = System.in;
        Scanner sc1 = new Scanner(System.in);   // InputStream타입의 정적필드가 in
        Scanner sc2 = new Scanner(inputStream);
//        Scanner sc3 = new Scanner(InputStream inputStream);

        Random random = new Random();
        int num1 = random.nextInt(45)+1;

    }

    public void c32() {
        System.out.println("32호출예시");
    }

}
