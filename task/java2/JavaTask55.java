package task.java2;

// 추상클래스

// -----------------------------------------------------------------------------------------------

// [예제 1] 추상클래스의 기본 구조와 구현

abstract class AbstractClass01 {                // 부모클래스면서 추상클래스!
    abstract void Method01();   // 메소드 이름만 있고 내용은 존재하지 않는 추상메소드

    void Method02() {
        System.out.println("Method02: 추상클래스에서 구현");
    }
}

// 추상클래스를 상속받을 경우, 추상클래스 내부 추상메소드를 자식클래스에서 반드시 메소드 오버라이딩 해야함!!
class SubClass01 extends AbstractClass01 {      // 자식클래스
    @Override
    void Method01() {
        System.out.println("Method01: 서브클래스에서 구현된 추상메소드");
    }
}

class AbstractTest01 {
    public static void main(String args[]) {
        // 오류 - 추상클래스는 자체적으로 객체 생성 불가
//        AbstractClass01 abs = new AbstractClass01();

        // 추상클래스를 상속받은 자식 클래스는 일반 클래스라 객체 생성 가능함
        SubClass01 obj = new SubClass01();

        obj.Method01();     // 자식이 구현한 내용 실행: SubClass01 클래스의 메소드(오버라이딩한 메소드)
        obj.Method02();     // 부모가 물려준 일반 메소드 실행: AbstractClass01 클래스의 일반 메소드
    }
}

// -----------------------------------------------------------------------------------------------

// [예제 2] 추상클래스를 활용한 다형성 (도형 그리기)
// 하나의 부모클래스(추상클래스), 3개의 자식클래스(및 각기 다른 메소드 오버라이딩)
// 메소드의 다형성: 부모클래스를 상속받은 3개의 자식 클래스에서 메소드 오버라이딩한 draw()메소드는 같은 이름이지만 다른 행위임

abstract class ShapeClass {
    abstract void draw();
}

class Circ extends ShapeClass {
    @Override
    void draw() {
        System.out.println("원을 그린다");
    }
}

class Rect extends ShapeClass {
    @Override
    void draw() {
        System.out.println("사각형을 그린다");
    }
}

class Tria extends ShapeClass {
    @Override
    void draw() {
        System.out.println("삼각형을 그린다");
    }
}

class AbstractTest02 {
    public static void main(String args[]) {
        Circ c = new Circ();
        Rect r = new Rect();
        Tria t = new Tria();

        c.draw();
        r.draw();
        t.draw();

        // 부모 타입의 배열에 서로 다른 자식들을 몽땅 담을 수도 있음! 부모의 타입으로 자식을 선언 (= 다형성)
        // 부모의 탈을 쓰고 있지만, 실제로는 자식의 기능을 수행하는 성질.(하나만 호출해도 각기다른내용으로 다 알아서 해줌)
        ShapeClass[] shapes = { new Circ(), new Rect(), new Tria() };

        for (ShapeClass s : shapes) {
            s.draw(); // s가 원인지 사각형인지 몰라도 메소드 호출하면 각 메소드를 모두 호출함.
        }
        /*
        원을 그린다
        사각형을 그린다
        삼각형을 그린다
         */

    }
}

// -----------------------------------------------------------------------------------------------

// [예제 3] ★ 주의: 자바의 다중 상속 불가 사례

// 추상클래스와 추상메소드
abstract class GoodBye {
    public abstract void sayGoodBye(String name);
}

// 추상클래스와 추상메소드
abstract class Hello {
    public abstract void sayHello(String name);
}

// [에러 발생] 자바는 클래스 간 다중 상속(extends A, B)을 허용하지 않습니다.
// class SubClass03 extends GoodBye, Hello {    이거 불가능!
class SubClass03 extends Hello56 {
    @Override // 자식클래스에서 추상메소드 받아 쓰려면 메소드 오버라이딩 필요!
    public void sayHello(String name) {
        System.out.println(name + "씨 안녕하세요!");
    }

    // GoodBye를 상속받지 못하므로 독자적인 메소드로 정의하거나 인터페이스를 써야 함
    public void sayGoodBye(String name) {
        System.out.println(name + "씨 안녕히 가세요!");
    }
}

class AbstractTest03 {
    public static void main(String[] args) {
        SubClass03 test = new SubClass03();
        test.sayHello("홍길동");
        test.sayGoodBye("홍길동");
    }
}


// -----------------------------------------------------------------------------------------------

// [예제 4] 추상클래스의 계층적 상속

abstract class AbstractClass04 {
    abstract void Method01();

    void Method02() {
        System.out.println("Method02: 추상클래스에서 구현");
    }
}

// 중간 클래스에서 부모의 추상메소드를 미리 구현할 수도 있음
abstract class MiddleClass04 extends AbstractClass04 {
    @Override
    void Method01() {
        System.out.println("Method01: 중간 클래스에서 구현된 추상메소드");
    }

    public void Method03() {
        System.out.println("Method03: 추상클래스에서 구현");
    }
}

// 최종 구현 클래스에서 메소드 오버라이딩해도 무방함
class SubClass04 extends MiddleClass04 { /* 여기에 메소드 오버라이딩 진행해도 상관 없음 */ }

class AbstractTestB {
    public static void main(String args[]) {
        SubClass04 obj = new SubClass04();
        obj.Method01();
        obj.Method02();
        obj.Method03();
    }
}

// -----------------------------------------------------------------------------------------------


public abstract class JavaTask55 {
    int a = 10; // 필드 가능

    public static void main(String[] args) {
        System.out.println("=== 예제 1 실행 ===");
        AbstractTest01.main(null);

        System.out.println("\n=== 예제 2 실행 ===");
        AbstractTest02.main(null);

        System.out.println("\n=== 예제 3 실행 (다중상속 주의) ===");
        AbstractTest03.main(null);

        System.out.println("\n=== 예제 4 실행 ===");
        AbstractTestB.main(null);
    }

    void check() {
        System.out.println("일반메소드 호출 가능");
    }

    abstract void check2(); // 추상메소드 가능

}

/*

    === 예제 1 실행 ===
    Method01: 서브클래스에서 구현된 추상메소드
    Method02: 추상클래스에서 구현

    === 예제 2 실행 ===
    원을 그린다
    사각형을 그린다
    삼각형을 그린다

    === 예제 3 실행 (다중상속 주의) ===
    홍길동씨 안녕하세요!
    홍길동씨 안녕히 가세요!

    === 예제 4 실행 ===
    Method01: 중간 클래스에서 구현된 추상메소드
    Method02: 추상클래스에서 구현
    Method03: 추상클래스에서 구현

 */