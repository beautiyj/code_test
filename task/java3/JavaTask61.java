package task.java3;

// 레퍼런스 형변환 예제 + 박싱언박싱
// 레퍼런스 형변환 : 2개의 클래스 사이에 상속 관계가 있어야 가능

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class JavaTask61 {
    public static void main(String[] args) {

//        예시 1 추상 클래스와 상속
//        Calendar(추상)는 직접 생성 불가. 업캐스팅 시 자식 전용 메소드(isLeapYear)는 다운캐스팅 후 사용 가능.

//        Calendar c = new Calendar();  이건에러. 캘린더는 추상클래스니까.
        Calendar c1 = Calendar.getInstance();

        Calendar c2 = new GregorianCalendar();          // 이게 업캐스팅
        GregorianCalendar c3 = new GregorianCalendar(); // 이건 일반 객체생성


        // 업캐스팅하면 부모클래스인캘린더가 상속해준 메소드를 사용할 수 있음.
        // 근데 isLeapYear() 메소드는 부모클래스가 준 게 아니라서 c2로는 접근 불가함! (자식클래스가 메소드 기능을 확장한 거.)
        // 원래 기능은 부모<자식 이다 상속의 개념이 부모의 것에 + 기능 확장한 자식 이라서...
        // 부모타입 변수 c2를 바로 쓰려면 다운캐스팅인 GregorianCalendar gc = (GregorianCalendar) c2; 후 gc 써야함
        if (c3.isLeapYear(2026)) {
            System.out.println("윤년");
        } else {
            System.out.println("평년");
        }

//--------------------------------------------------------------------------------------------------------------

//     예시 2 - 해당 방식들은 옛날 방식 / 인터페이스와 업캐스팅
//     현재는 List<String> list = new ArrayList<>();  제네릭 형태 활용함.
//        List(인터페이스)는 직접 생성 불가. ArrayList를 부모 타입으로 받으면 유지보수(유연성)가 좋아짐.

//        List 인터페이스는 자체적으로 객체 생성을 할 수 없다 (인터페이스와 추상클래스 둘 다)
//        List li = new List();  그래서 이건 에러
        List list = new ArrayList();    // 업캐스팅 - 부모클래스 List 메소드만 사용 가능
                                        // 보통 리스트의 규칙만을 다룰 때 쓴다
        ArrayList al = new ArrayList(); // 일반 객체 생성 - ArrayList 모든 기능 사용 가능

//--------------------------------------------------------------------------------------------------------------

//     예시 3 - 자동 박싱과 업캐스팅
//      add(Object e)는 만능 바구니. 기본형은 박싱+업캐스팅, String은 이미 객체라 업캐스팅만 발생.
//      boolean add(Object e) 객체가 들어가는 add 메소드
        list.add(10);       // Object e = new Integer(10) 자동박싱과 업캐스팅이 일어남
        list.add(3.14);     // Object e = new Double(3.14) 자동박싱과 업캐스팅이 일어남
        list.add('j');      // Object e = new Character('j') 자동박싱과 업캐스팅이 일어남
        list.add(true);     // Object e = new Boolean(true) 자동박싱과 업캐스팅이 일어남
        list.add("자바");    // Object e = String (10) 같은 객체니까 업캐스팅만 일어남

        System.out.println(list);

//--------------------------------------------------------------------------------------------------------------

//     예시 4 - 객체의 값 비교 (equals)
//      equals는 Object를 인자로 받음. 숫자/문자열이 인자로 들어갈 때 발생하는 자동 형변환 이해.
//      boolean equals(Object e)

//        Object e = String("java");
        String str1 = "java";
        String str2 = "java";
        if (str1.equals(str2)) {        // if ("java",equals("java"))의 실무버전
            System.out.println("같은값");
        } else {
            System.out.println("다른값");

        }

        if (Integer.valueOf(10).equals(Integer.valueOf(10))) {
            System.out.println("같은값");
        } else {
            System.out.println("다른값");
        }
        // 간략버전! 내부적으로 위와 똑같이 동작함 (자동 박싱 + 업캐스팅)
        if (((Integer)10).equals(10)) {
            System.out.println("같");
        }


        if (Double.valueOf(3.14).equals(Double.valueOf(3.14))) {
            System.out.println("같은 실수 값");
        } else {
            System.out.println("다른값");
        }
        // 간략버전(실무!)
        if (((Double)3.14).equals(3.14)) {
            System.out.println("같");
        }

//--------------------------------------------------------------------------------------------------------------

//     예시 5 - 리스트 데이터 추출과 형변환
//   제네릭 없는 리스트에서 데이터를 꺼내면 무조건 Object 타입. 원래 타입으로 쓰려면 다운캐스팅 필수.
        List l = new ArrayList();       // 업캐스팅(요즘은제네릭으로쓰고22)
        l.add("자바");
        l.add("오라클");
        l.add("문자들을저장하기");

//        Object get(int index)
        Object obj = l.get(0);
        System.out.println(obj);            // list [0] 인덱스인  자바 출력됨

        //        String s = l.get(0);          반환값이 문자열이면 오류남
        String s = (String) l.get(0);   // 다운캐스팅시켜야함 - 근데 이 방식 잘안씀 제네릭으로쓰지

        for (int i = 0; i < l.size(); i++) {
//            Object obj = l.get(i);
            String str = (String) l.get(i);      // 이건 다운캐스팅 방식
            System.out.println(str);
        }
//--------------------------------------------------------------------------------------------------------------

//      예시 6 - 반복문과 다운캐스팅, 언박싱
//      리스트 순회 시 Object를 int로 바꾸는 과정(다운캐스팅+언박싱). 향상된 for문 활용법.

        List ls = new ArrayList();

        ls.add(10);         // 자동박싱과 업캐스팅들  ~
        ls.add(200);
        ls.add(3000);
        ls.add(40000);
        ls.add(500000);

        for (int i=0; i<ls.size(); i++) {
            Integer num = (Integer) ls.get(i);      // 다운캐스팅
            int n = num.intValue();                 // 언박싱

            int nn = (int) ls.get(i);               // 다운캐스팅+언박싱 한줄로끝내기
        }

        // 향상된for문
        for (Object j : ls) {
            System.out.println(s);
        }

        // 연산진행하려면 다운캐스팅 필요
        for (Object k : ls) {
            // Object 타입을 Integer로 다운캐스팅 (그 후 자동 언박싱으로 int 계산 가능)
            int value = (int) k;        // 다운캐스팅+언박싱
            System.out.println(value + 100);
        }

    }
}
