package task.java2;

// 패키지
// 같은 패키지인 자바32는 임포트 필요 없음
// 다른 패키지인 자바30은 임포트 필요(퍼블릭이어야함)

import task.java.T33;

public class JavaTask33 {
    public static void main(String[] args) {

        // static없는 퍼블릭 인스턴스 메소드라 객체 생성 후 호출해줌. 정적메소드면 객체 생성 필요 없고
        JavaTask32 c32 = new JavaTask32();
        c32.c32();

        // 클래스도 메소드도 퍼블릭이어야 타 패키지 호출 가능.
        T33 t33 = new T33();
        t33.printSuccess();

    }

}
