package task.java2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 롬복 사용 시 간략하게 가능
@Getter @Setter @ToString
class Task42Class {
    private int member;
}

@Getter @Setter @ToString
class Task42Class2 {
    private Object member;
}

public class JavaTask42 {
    public static void main(String[] args) {
        JavaTask42 task = new JavaTask42();

        System.out.println("--- 롬복 기반 테스트 시작 ---");
        task.runGenericTest01();
        task.runGenericTest02();
    }

    public void runGenericTest01() {
        Task42Class obj01 = new Task42Class();
        // 롬복이 @Setter를 보고 setMember() 메소드를 몰래 만들어뒀습니다.
        obj01.setMember(3);
        System.out.println("값 확인: " + obj01.getMember());
    }

    public void runGenericTest02() {
        Task42Class2 obj01 = new Task42Class2();

        // Object 기반이므로 롬복을 써도 넣고 뺄 때 박싱/캐스팅 원리는 동일합니다.
        obj01.setMember(3.14);

        // 롬복 덕분에 코드가 비즈니스 로직에만 집중할 수 있게 됩니다.
        double result = (Double)obj01.getMember();
        System.out.println("롬복으로 꺼낸 실수: " + result);

        obj01.setMember("롬복은 편리하다");
        System.out.println("롬복으로 확인한 문자열: " + obj01.getMember());
    }
}