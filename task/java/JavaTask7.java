package task.java;

import java.util.Scanner;

/*
과제7
키보드를 통해서 각 회원들의 정보를 입력받는 클래스(MemberInput)를 작성한다.
이때 입력받는 회원의 정보는 성명, 나이, 이메일, 주소를 입력받는다.
그리고 키보드로 입력한 회원의 정보는 새로운 회원정보를 저장하는
클래스(MemberInfo)의 멤버변수에 저장시킨 후 출력하는 프로그램을 작성하시오.

제한 사항
MemberInfo 클래스의 멤버변수 초기화 방법은 생성자를 이용하세요.
1명의 회원정보를 입력받아서 처리한다. (가능하면 2명 이상의 회원 정보도 입력받아서 처리해 보자.)

클래스 구조 예시

MemberInput 클래스
public static void main(String[] args) {
    // 실행 로직 작성 구간
}

MemberInfo 클래스
private String name;
private int age;
private String email;
private String address;

    // 생성자
    public MemberInfo() {
        // 멤버변수 초기화 로직
    }

 */


// 자바는 무조건 클래스 안에 들어가야하는 형태인데,
// 실행클래스에 넣는 게 아니라 별도클래스 따로 서식잡아서 하는 게 일반적이라고 함(헷갈려~~)

class MemberInfo {
    // 변수선언
    private String name;
    private int age;
    private String email;
    private String address;

    // 생성자 작성
    public MemberInfo(String name, int age, String email, String address) {
        // 값 대입 (멤버변수들 초기화)
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    // private 변수를 안전하게 출력하기 위한 메서드
    public void display() {
        System.out.println("\n=== 입력된 회원 정보 ===");
        System.out.println("성명: " + name);
        System.out.println("나이: " + age);
        System.out.println("이메일: " + email);
        System.out.println("주소: " + address);
    }

}

// = MemberInput class 역할. 실제 실행코드.
public class JavaTask7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("회원의 이름을 입력하세요");
        String name = sc.nextLine();

        System.out.println("회원의 나이를 입력하세요");
        int age = sc.nextInt();
        // 중요: 숫자 입력 후 남은 엔터 키를 제거 (버퍼 비우기)
        // 파이썬코틀린과 달리 자바에선 숫자입력뒤 문자열이면 청소필요
        sc.nextLine();

        System.out.println("회원의 이메일을 입력하세요");
        String email = sc.nextLine();

        System.out.println("회원의 주소를 입력하세요");
        String address = sc.nextLine();

        // 클래스받아오는 참조변수(=객체변수) 멤버 = 새로객체생성하라 생성자호출. 지역변수임.
        // 생성자 = 초기화 (파이썬이나코틀린 init). String만 new생략가능이고 배열 리스트도 다 new연산자 써야함
        MemberInfo member = new MemberInfo(name, age, email, address);

        member.display();

        /*  // 여러명 출력 시 배열 활용하기 (사실 ArrayList방식이 더 많이 쓰이긴 함)
        MemberInfo[] members = new MemberInfo[2];
        // 리스트는 ArrayList<MemberInfo> memberList = new ArrayList<>();

        // 리스트를 동적으로 입력받으려면 아예 while문으로 진행하면 됨
        for (int i = 0; i < members.length; i++) {      // 리스트는 숫자넣거나 i<memberList.size()
            System.out.println((i + 1) + "번째 회원 정보 입력");

            System.out.print("이름: ");
            String name = sc.nextLine();
            System.out.print("나이: ");
            int age = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기
            System.out.print("이메일: ");
            String email = sc.nextLine();
            System.out.print("주소: ");
            String address = sc.nextLine();

            members[i] = new MemberInfo(name, age, email, address);
            // 리스트는 memberList.add(new MemberInfo(name, age, email, address));
        }

        // for (MemberInfo m : memberList) { 리스트도 반복문동일
        for (MemberInfo m : members) {
            m.display();
        }
         */
    }
}

// 자바에서 생성자는 함수(메소드) 전체, 코틀린에서는 파라미터가 변수이자 생성자... 정도로 이해하면 편함

/*
회원의 이름을 입력하세요
가나다
회원의 나이를 입력하세요
11
회원의 이메일을 입력하세요
11@11.com
회원의 주소를 입력하세요
서울시 마포구

=== 입력된 회원 정보 ===
성명: 가나다
나이: 11
이메일: 11@11.com
주소: 서울시 마포구
 */

/*
1. 생성자 중심으로 작성하는 경우
package task.java;

// [클래스 설계도]
class MemberConstructor {
    private String name;
    private int age;

    // 생성자: 객체 생성 시 데이터를 강제로 넣게 함 (데이터가 빠지는 걸 방지)
    public MemberConstructor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("[생성자 방식] 이름: " + name + ", 나이: " + age);
    }
}

// [실행부]
public class RunConstructor {
    public static void main(String[] args) {
        // 객체 생성과 동시에 데이터 주입 (new 할 때 다 넣어야 함)
        MemberConstructor m = new MemberConstructor("홍길동", 20);
        m.display();
    }
}


2. getter setter 활용하는 경우
package task.java;

// [클래스 설계도]
class MemberGetterSetter {
    private String name;
    private int age;

    // 기본 생성자 (내용물 없이 일단 틀만 만듦)
    public MemberGetterSetter() { }

    // Getter/Setter: 수동 노가다 작성
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

// [실행부]
public class RunGetterSetter {
    public static void main(String[] args) {
        MemberGetterSetter m = new MemberGetterSetter(); // 빈 객체 생성

        m.setName("이순신"); // 나중에 하나씩 주입 (Setter)
        m.setAge(30);

        // 직접 꺼내서 출력 (Getter)
        System.out.println("[게터세터 방식] 이름: " + m.getName() + ", 나이: " + m.getAge());
    }
}

3. Lombok 라이브러리 활용, 어노테이션 게터세터 방식의 경우

package task.java;

import lombok.*;

// [클래스 설계도]
@Getter @Setter              // 게터세터 자동 생성
@AllArgsConstructor          // 생성자 방식 자동 생성 (과제 7 해결)
@NoArgsConstructor           // 빈 생성자 자동 생성 (과제 8 해결)
@ToString                    // display() 대신 객체 내용을 한 번에 찍어주는 기능
** 해당 어노테이션 5개를 모두 적용하는 @Data 어노테이션이 있긴 한데 잉여방지용으로 그냥 5개 어노테이션으로
작성하는 경우들도 있고, 사실 5개도 다 안전빵으로 미리 적어두는 어노테이션이라고 함.

class MemberPro {
    private String name;
    private int age;
}

// [실행부]
public class RunLombokPro {
    public static void main(String[] args) {
        // 1. 생성자 방식으로 쓰기 (과제 7 스타일)
        MemberPro m1 = new MemberPro("강감찬", 40);

        // 2. 세터 방식으로 쓰기 (과제 8 스타일)
        MemberPro m2 = new MemberPro();
        m2.setName("유관순");

        // 3. 출력 (ToString 덕분에 메소드 없이도 객체 내용 확인 가능)
        System.out.println(m1); // 결과: MemberPro(name=강감찬, age=40)
        System.out.println(m2.getName() + "님 반갑습니다.");
    }
}
 */