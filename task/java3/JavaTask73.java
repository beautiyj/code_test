package task.java3;

/*
키보드를 통해서 각 회원들의 정보를 입력받는 클래스(MemberInput)를 작성한다.
이때 입력받는 회원의 정보는 성명, 나이, 이메일, 주소를 입력받는다.
그리고 키보드로 입력한 회원의 정보는 새로운 회원정보를 저장하는
클래스(MemberInfo)의 멤버변수에 저장시킨 후 출력하는 프로그램을 작성하시오.

제한 사항
2명 이상의 정보를 처리할 때 List 자료구조를 이용한다
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

 */

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter @Setter
class MemberInput73 {
    private String name;
    private String age;
    private String email;
    private String address;

    public MemberInput73(String name, String age, String email, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

//    public void display() {
//        System.out.println("성명: " + name);
//        System.out.println("나이: " + age);
//        System.out.println("이메일: " + email);
//        System.out.println("주소: " + address);
//    }

}

public class JavaTask73 {
    public static void main(String[] args) {
        List<MemberInput73> members = new ArrayList<>();

        try(Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("성명: ");
                String name = sc.nextLine();

                System.out.print("나이: ");
                String age = sc.nextLine();

                System.out.print("이메일: ");
                String email = sc.nextLine();

                System.out.print("주소: ");
                String address = sc.nextLine();

                if (name.isEmpty() || age.isEmpty() || email.isEmpty() || address.isEmpty()) {
                    System.out.println("모든 회원 정보를 입력해주세요");
                }
                members.add(new MemberInput73(name, age, email, address));

                System.out.println("y/n");
                String input = sc.nextLine().toLowerCase();

                if(input.equals("n")) {
                    break;
                }
            }

//            for (MemberInput73 m : members) {
//                m.display();
//            }

            // 리스트에서 포맷팅으로 바로 출력할 때 forEach 포맷팅 진행(게터필요)
            members.forEach(m -> {
                System.out.printf("성명: %s\t나이: %s\t이메일: %s\t주소: %s%n", m.getName(), m.getAge(), m.getEmail(), m.getAddress());
            });
        }

    }
}
