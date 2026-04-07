package task.java2;

// 인터페이스 간의 상속 (Interface Inheritance) - AbstractTest06 예제
// 인터페이스끼리는 다중 상속(extends A, B)이 가능합니다.
interface InterfaceHello59 {
    int a = 10; // public static final 생략됨(인터페이스는 상수를 가짐)
    public abstract void sayHello(String name);
}

interface InterfaceGoodBye59 {
    public abstract void sayGoodBye(String name);
}

// 인터페이스끼리 상속을 받을 때는 extends로 상속을 받아야함, 다중 상속 허용
// ITotal은 IHello와 IGoodBye의 모든 규격을 물려받고 자신의 규격을 추가함
interface InterfaceTotal extends InterfaceHello59, InterfaceGoodBye59 {
    public abstract void greeting(String name);
}

// 인터페이스 -> 추상 클래스 -> 일반 클래스 계층 구조
interface IColor {
    int RED = 1;         // 상수 (public static final)
    int GREEN = 2;
    int BLUE = 3;

    int getColor();

    void setColor(int c); // 추상 메소드 (public abstract)
}

// ---------------------------------------------------------------------------------------------

// ITotal을 구현하는 클래스는 상위 인터페이스들의 모든 메소드를 오버라이딩해야 함
class SubClass59 implements InterfaceTotal {
    @Override
    public void sayHello(String name) {
        System.out.println(name + "씨 안녕하세요!");
    }

    @Override
    public void sayGoodBye(String name) {
        System.out.println(name + "씨 안녕히 가세요!");
    }

    @Override
    public void greeting(String name) {
        System.out.println(name + ", 안녕!");
    }
}

// 추상 클래스(AbsColor)는 인터페이스를 구현(implements)할 때 일부 메소드만 미리 구현할 수 있음
abstract class AbsColor implements IColor {
    int color = GREEN; // 추상 클래스는 일반 변수(필드)를 가질 수 있음

    @Override
    public void setColor(int c) { // 구현된 메소드도 가질 수 있음
        color = c;
    }
    // getColor()는 아직 구현하지 않았으므로 추상 메소드로 남아있음
}

// 일반 클래스(SubClass07)는 남은 추상 메소드를 최종적으로 구현함
class SubClassTask59 extends AbsColor {
    @Override
    public int getColor() {
        return color;
    }
}

// ----------------------------------------------------------------------------------

public class JavaTask59 {
    public static void main(String[] args) {

        System.out.println("=== [예제 06] 인터페이스 다중 상속 테스트 ===");
        SubClass59 test = new SubClass59();
        test.sayHello("홍길동");
        test.sayGoodBye("홍길동");
        test.greeting("홍길동");
        System.out.println(InterfaceHello59.a);     // 10
        // 인터페이스 내엔 상수라서 값 불변. 바꿀 수 없음
//        InterfaceHello59.a = 30;

        System.out.println("\n=== [예제 07] 인터페이스-추상클래스 계층 테스트 ===");
        SubClassTask59 test07 = new SubClassTask59();
        test07.setColor(IColor.RED); // 부모(추상클래스)가 구현한 메소드 호출
        System.out.println("현재 색상 값: " + test07.getColor()); // 본인이 구현한 메소드 호출

        /*
           [핵심 포인트]
           1. 인터페이스 간 상속: interface A extends B, C { ... } (다중 상속 가능)
           2. 추상 클래스의 역할: 인터페이스의 모든 메소드를 구현하기 부담스러울 때,
                               일부만 미리 구현하여 자식 클래스의 부담을 덜어주는 "중간 다리" 역할.
        */
    }
}