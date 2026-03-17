package task.java;

/*
과제8
키보드를 통해서 각 회원들의 정보를 입력받는 클래스(MemberInput)를 작성한다.
이때 입력받는 회원의 정보는 성명, 나이, 이메일, 주소를 입력받는다.
그리고 키보드로 입력한 회원의 정보는 새로운 회원정보를 저장하는
클래스(MemberInfo)의 멤버변수에 저장시킨 후 출력하는 프로그램을 작성하시오.

제한 사항
MemberInfo 클래스의 멤버변수 초기화 방법: 생성자x setter메소드 이용하기.
1명의 회원정보를 입력받아서 처리한다. (가능하면 2명 이상의 회원 정보도 입력받아서 처리해 보자.)
 */

import java.util.Scanner;

class MemberInfo2{
    // 변수선언
    private String name;
    private  int age;
    private String email;
    private String address;

    // setter 메서드 작성
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
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

public class JavaTask8 {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // MemberInfo 객체 생성
        MemberInfo2 member = new MemberInfo2();

        // 회원 정보 입력 받기
        System.out.print("성명: ");
        member.setName(scanner.nextLine());

        System.out.print("나이: ");
        member.setAge(scanner.nextInt());
        scanner.nextLine(); // 버퍼 비우기

        System.out.print("이메일: ");
        member.setEmail(scanner.nextLine());

        System.out.print("주소: ");
        member.setAddress(scanner.nextLine());

        // 입력된 회원 정보 출력
        member.display();

        // Scanner 객체 닫기
        scanner.close();
    }
}
