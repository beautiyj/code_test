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

// DTO
@Getter @Setter
class MemberInput73 {
    private String name;
    private int age;
    private String email;
    private String address;

    public MemberInput73(String name, int age, String email, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    /* 알트+인서트 누르면 게터세터 생성도 됨. 이클립스기준 Alt + Shift + S
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     */

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

        // Try-with-Resources 문 서식은 try(리소스){}. 리소스는 AutoCloseable 인터페이스를 구현한 클래스(객체들)이어야함.
        // FileWriter fw = new FileWriter("result.txt"); <여러개는 ; 로 구분하면 됨
        // 불가능한 리소스: try (int a = 10; String s = "test") { ... } 이런건 close() 필요 없는 거라서 에러임
        try(Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("성명: ");
                String name = sc.nextLine();

                // 하단 유효성 검사를 위해 1차 문자열로 입력받음
                System.out.print("나이: ");
                String ageStr = sc.nextLine();

                System.out.print("이메일: ");
                String email = sc.nextLine();

                System.out.print("주소: ");
                String address = sc.nextLine();

                //                      여기서 age<=0 해도 되는데 정보 미입력 시 NumberFormatException 생김
                // 그래서 age 문자열로 입력 받은 뒤 -> 정수 변환
                if (name.isEmpty() || ageStr.isEmpty() || email.isEmpty() || address.isEmpty()) {
                    System.out.println("모든 회원 정보를 입력해주세요");
                }
                /* 람다와 스트림으로 유효성 검사 한 줄 압축 가능함. Arrays.asList로 묶어서 하나라도(anyMatch) 비어있으면(isEmpty) 즉시 통과
                if (Arrays.asList(name, ageStr, email, address).stream().anyMatch(String::isEmpty)) {
                    System.out.println("모든 회원 정보를 입력해주세요");
                    continue;
                }
                 */

                // 유효성 검사 후 정수 변환
                int age = Integer.parseInt(ageStr);

                // 간단하게 하려면 생성자 방식
                members.add(new MemberInput73(name, age, email, address));
                /* 세터로 하면
                MemberInput73 m = new MemberInput73(); // 일단 빈 객체 생성
                m.setName(name);
                m.setAge(age);
                m.setEmail(email);
                m.setAddress(address);
                members.add(m);
                 */

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

/* 해당 로직 롬복이나 트라이위드리소스문 없이 게터세터 정석으로 진행할 경우
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// [역할 1] 회원 정보를 저장할 설계도
class MemberInfo {
    private String name;
    private int age;
    private String email;
    private String address;

    // 기본 생성자 (빈 객체를 만들 때 사용)
    public MemberInfo() { }

    // [역할 2] 데이터 통로 (게터/세터)
    // 변수가 private이라 직접 못 만지니까 통로를 만들어줌
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}

public class BeginnerTask {
    public static void main(String[] args) {
        // [역할 3] 여러 명을 담을 수 있는 가변 길이 배열(List)
        List<MemberInfo> members = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // [역할 4] 무한 반복하며 입력받기
        while (true) {
            System.out.print("성명: "); String name = sc.nextLine();
            System.out.print("나이: "); String ageStr = sc.nextLine();
            System.out.print("이메일: "); String email = sc.nextLine();
            System.out.print("주소: "); String address = sc.nextLine();

            // [역할 5] 유효성 검사 (if-else)
            // 비어있으면 다시 처음(while 시작점)으로 돌려보냄
            if (name.isEmpty() || ageStr.isEmpty() || email.isEmpty() || address.isEmpty()) {
                System.out.println("정보를 모두 입력해야 합니다! 다시 입력하세요.");
            } else {
                // [역할 6] 문자열을 숫자로 변신시키고 객체에 하나씩 담기
                int age = Integer.parseInt(ageStr);

                MemberInfo m = new MemberInfo();
                m.setName(name); // 세터로 하나씩 주입
                m.setAge(age);
                m.setEmail(email);
                m.setAddress(address);

                members.add(m); // 리스트에 추가
            }

            System.out.print("계속 입력?(y/n): ");
            String choice = sc.nextLine();
            if (choice.equals("n")) { // n을 누르면 반복문 탈출
                break;
            }
        }

        // [역할 7] 결과 출력 (for문으로 하나씩 꺼내기)
        System.out.println("--- 결과 ---");
        for (int i = 0; i < members.size(); i++) {
            MemberInfo m = members.get(i);
            System.out.println("이름: " + m.getName() + ", 나이: " + m.getAge());
        }

        sc.close(); // [역할 8] 다 썼으니 직접 닫아줌
    }
}

 */