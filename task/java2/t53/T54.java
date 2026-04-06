package task.java2.t53;

import task.java2.JavaTask54;

// 자식 클래스
class SubOne extends JavaTask54 {
    void subPrn() {
        // System.out.println(a); // [1. Sub] private-X (에러)
        // System.out.println(b); // [2. Sub] 기본 접근 지정자-X (패키지가 달라 에러)
        System.out.println(c);    // [3. Sub] protected-O (상속 관계이므로 가능)
        System.out.println(d);    // [4. Sub] public-O
    }
}

// 제3의 클래스 (실행부)
public class T54 {
    public static void main(String[] args) {
        JavaTask54 at = new JavaTask54();
        at.print(); // 부모의 public 메소드를 통해 내부 필드 출력

        System.out.println("main");
        // System.out.println(at.a); // [1. main] private-X (에러)
        // System.out.println(at.b); // [2. main] 기본 접근 지정자-X (에러)
        // System.out.println(at.c); // [3. main] protected-X (상속 관계가 아닌 외부 클래스라 에러)
        System.out.println(at.d);    // [4. main] public-O

        System.out.println("--- SubOne 객체 실행 ---");
        SubOne so = new SubOne();
        so.subPrn();
    }
}