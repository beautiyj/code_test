package task.java2;

// 메소드 오버라이딩

/*
// 메소드 오버라이딩(Method Overriding)
// : 부모 클래스로 부터 상속받은 메소드를 자식 클래스에서 재정의 해서 사용하는 것.
// 1. 자식 클래스로 객체를 생성한 다음에 메소드를 호출하면, 메소드 오버라이된 메소드만
//    호출된다.
// 2. 부모 클래스에서 상속 해주는 메소드는 더 이상 사용할 수 없는 은닉 메소드가 된다.
// 3. 부모 클래스의 은닉 메소드를 자식 클래스에서 사용할때는 super.parentPrn()으로
//    호출할 수 있다.

 */
class Parent05 {
    public void parentPrn() {
        System.out.println("슈퍼클래싀 parentPrn 메소드");
    }
}

class Child05 extends Parent05 {
    @Override
    public void parentPrn() {
        super.parentPrn();
        System.out.println("서브클래스: parentPrn 메소드");
    }

    public void childPrn() {
//        super.childPrn(); // 오류
        System.out.println("서브클래스: childPrn 메소드");
    }
}


class Parent {                                 // 부모 클래스
    public void parentPrn() {
        System.out.println("부모 클래스 : ParentPrn 메서드");
    }
}

class Child extends Parent51 {                   // 자식 클래스
    public void parentPrn() {                  // 메서드 오버라이딩
        System.out.println("자식 클래스 : ParentPrn 메서드");
    }

    public void childPrn() {
        System.out.println("자식 클래스 : ChildPrn 메서드");
    }
}

public class JavaTask52 {
    public static void main(String[] args) {
        Child51 c = new Child51();
        c.parentPrn();                         // 재정의된 자식 클래스의 메서드 호출
        c.childPrn();

        Parent51 p = new Parent51();
        p.parentPrn();                         // 부모 클래스 자기 자신의 메서드 호출

        System.out.println("----------------------------------------------------------------");

        System.out.println("--- 자식 객체(Child05) 생성 및 호출 ---");
        Child05 cc = new Child05();

        // 오버라이딩된 메소드 호출 (부모 기능 + 자식 기능이 차례로 실행됨)
        cc.parentPrn();     // 슈퍼클래싀 parentPrn 메소드
        // 자식만의 새로운 메소드 호출
        cc.childPrn();      // 서브클래스: parentPrn 메소드

        System.out.println("\n--- 부모 객체(Parent05) 생성 및 호출 ---");
        Parent05 pp = new Parent05();
        // 부모는 오직 자신의 원본 로직만 수행함
        pp.parentPrn();     // 슈퍼클래싀 parentPrn 메소드
    }
}
