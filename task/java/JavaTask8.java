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

import lombok.Getter;
import lombok.Setter;

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

// Lombok 롬복 라이브러리 임포트해서 쓰는 어노테이션 세터게터 메소드 방식(덜귀찮고간결함)
// 세터는 쓰기 전용 클래스라서 출력하려면 display()메소드 써야하는 건 동일함.(데이터주입필요)
@Setter // 어노테이션을 클래스 레벨에 붙이면 모든 변수의 setter가 자동으로 생성됨!
class MemberInfo3 {
    private String name;
    private int age;
    private String email;
    private String address;

    // 출력용 메소드는 직접 만들기 (또는 @ToString 사용 가능)
    public void display() {
        System.out.println("\n=== 입력된 회원 정보 ===");
        System.out.println("성명: " + name);
        System.out.println("나이: " + age);
        System.out.println("이메일: " + email);
        System.out.println("주소: " + address);
    }
}

// 롬복 라이브러리 사용 + 게터세터 모두 사용 시 출력 유연성 높고 외부 데이터 활용도 가능함.
// 세터만 있으면 - 데이터 넣기 가능, member.getName() 데이터꺼내쓰는 모든 출력계산디비저장불가
// 게터만 있으면 - 데이터 읽기 가능, 나중에 사용자가 데이터 수정하는 기능은 만들 수 없음
@Getter @Setter
class MemberInfo4 {
    private String name;
    private int age;
    private String email;
    private String address;
    // @Getter가 있으면 굳이 display()를 만들지 않아도 외부에서 데이터 출력 가능함!!
}

public class JavaTask8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        // 입력된 회원 정보 출력     - 그룹3도 2와동일방식임
        member.display();


        // 세터 게터 모두 사용할 경우 세터만 쓸 때와 달리
        // 원하는 데이터들을 각각 꺼내서 출력 가능하고 계산같은 로직에서 활용 가능.
        MemberInfo4 member4 = new MemberInfo4();
        System.out.print(" getter 방식 사용 시 ------------------------------ ");
        System.out.print("성명: ");
        member4.setName(scanner.nextLine());

        System.out.print("나이: ");
        member4.setAge(scanner.nextInt());
        scanner.nextLine(); // 버퍼 비우기

        System.out.print("이메일: ");
        member4.setEmail(scanner.nextLine());

        System.out.print("주소: ");
        member4.setAddress(scanner.nextLine());

        System.out.println(member4.getName() + " 님의 나이는 "
                                + member4.getAge() + "세입니다.");
        System.out.println("연락처: " + member4.getEmail());
        System.out.println("거주지: " + member4.getAddress());


        // Scanner 객체 닫기
        scanner.close();
    }
}

/*
과제 7: "재료 다 가져와, 한꺼번에 만든다!"
모든 재료(name, age 등)를 먼저 변수에 다 받아놓은 다음,
마지막에 생성자라는 입구에 한꺼번에 털어 넣습니다.

// 1. 재료 먼저 수집
String n = sc.nextLine();
int a = sc.nextInt();
// 2. 마지막에 조립 (생성자 호출)
MemberInfo member = new MemberInfo(n, a, e, ad);


과제 8: "일단 몸체부터 만들고, 하나씩 끼워 넣자!"
재료가 있든 없든 일단 객체(member)부터 만들어 놓습니다. 그 후 입력받는 족족 세터라는 빨대를 꽂아서 하나씩 주입합니다.

// 1. 빈 통부터 생성
MemberInfo2 member = new MemberInfo2();
// 2. 그때그때 주입 (Setter 호출)
member.setName(sc.nextLine());
member.setAge(sc.nextInt());


**생성자(과제 7)**는 **"필수 데이터"**를 강제할 때 좋습니다.
이름 없는 회원이 생기면 안 될 때, 생성자에 이름을 무조건 넣게 만들면 실수를 방지할 수 있죠.

**세터(과제 8)**는 **"선택적 데이터"**나 **"나중에 바뀔 데이터"**를 다룰 때 좋습니다.
회원 가입 후 나중에 주소만 바꾸고 싶을 때 생성자를 다시 부를 순 없으니 세터를 쓰는 겁니다.

 */