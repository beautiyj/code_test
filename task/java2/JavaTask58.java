package task.java2;

// 인터페이스 다중상속


// 클래스 상속(extends)과 인터페이스 구현(implements)을 동시에 사용하는 경우
interface InterfaceHello {
    public abstract void sayHello(String name);
}

// 두 개의 인터페이스를 동시에 구현하는 경우 (다중 구현)
interface InterfaceHello58 {
    public abstract void sayHello(String name);
}

interface InterfaceGoodBye58 {
    public abstract void sayGoodBye(String name);
}

// ----------------------------------------------------------------------------------

abstract class abstractGoodBye {
    public abstract void sayGoodBye(String name);
}

// 클래스 상속은 하나만 가능(extends GoodBye), 인터페이스는 추가 구현 가능(implements IHello)
// 클래스와 인터페이스 동시 상속 받을 때는 클래스 먼저 받고 그다음 인터페이스 상속받아야 에러 안남!!
                            // 클래스 먼저 받고            인터페이스 상속은 나중에. 순서 중요
class SubClass58 extends abstractGoodBye implements InterfaceHello {
    @Override
    public void sayHello(String name) {
        System.out.println(name + "씨 안녕하세요!");
    }

    @Override
    public void sayGoodBye(String name) {
        System.out.println(name + "씨 안녕히 가세요!");
    }
}

// 인터페이스는 콤마(,)를 이용해 여러 개를 동시에 구현할 수 있음
class SubClassTask58 implements InterfaceHello58, InterfaceGoodBye58 {
    @Override
    public void sayHello(String name) {
        System.out.println(name + "씨 안녕하세요!");
    }

    @Override
    public void sayGoodBye(String name) {
        System.out.println(name + "씨 안녕히 가세요!");
    }
}

// ----------------------------------------------------------------------------------

public class JavaTask58 {
    public static void main(String[] args) {

        System.out.println("=== [사례 1] 상속 + 인터페이스 구현 ===");
        SubClass58 test01 = new SubClass58();
        test01.sayHello("홍길동");
        test01.sayGoodBye("홍길동");

        System.out.println("\n=== [사례 2] 다중 인터페이스 구현 ===");
        SubClassTask58 test02 = new SubClassTask58();
        test02.sayHello("임꺽정");
        test02.sayGoodBye("임꺽정");

        /*
           [핵심 포인트]
           1. 클래스 상속(extends)은 '단 하나'만 가능합니다.
           2. 인터페이스 구현(implements)은 '여러 개'가 가능하여 다중 상속의 효과를 냅니다.
           3. 구현하는 클래스에서는 부모의 추상 메소드를 반드시 오버라이딩(@Override) 해야 합니다.
        */
    }
}