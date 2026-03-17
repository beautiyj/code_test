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

class MemberInfo{
    // 변수선언
    private String name;
    private  int age;
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
    public static void  main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("회원의 이름을 입력하세요");
        String name=sc.nextLine();

        System.out.println("회원의 나이를 입력하세요");
        int age=sc.nextInt();
        // 중요: 숫자 입력 후 남은 엔터 키를 제거 (버퍼 비우기)
        // 파이썬코틀린과 달리 자바에선 숫자입력뒤 문자열이면 청소필요
        sc.nextLine();

        System.out.println("회원의 이메일을 입력하세요");
        String email=sc.nextLine();

        System.out.println("회원의 주소를 입력하세요");
        String address=sc.nextLine();

        // 클래스받아오는 참조변수(=객체변수) 멤버 = 새로객체생성하라 생성자호출. 지역변수임.
        // 생성자 = 초기화 (파이썬이나코틀린 init)
        MemberInfo member=new MemberInfo(name,age,email,address);

        member.display();
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