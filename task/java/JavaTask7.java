package task.java;

import java.util.Scanner;
// 자바는 무조건 클래스 안에 들어가야하는 형태인데,
// 실행클래스에 넣는 게 아니라 별도클래스 따로 서식잡아서 하는 게 일반적이라고 함(헷갈려~~)

class MemberInfo{
    private String name;
    private  int age;
    private String email;
    private String address;

    public MemberInfo(String name, int age, String email, String address) {
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
        sc.nextLine();

        System.out.println("회원의 이메일을 입력하세요");
        String email=sc.nextLine();

        System.out.println("회원의 주소를 입력하세요");
        String address=sc.nextLine();

        MemberInfo member=new MemberInfo(name,age,email,address);

        member.display();
    }
}

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