package task.java2;

// 상속에서의 메소드
// 1. 부모 클래스의 메소드는 자식 클래스로 상속된다.
// 2. 부모 클래스에서 자식 클래스의 메소드는 접근 할 수 없다.

class Parent52 {						// 부모 클래스
    public void parentPrn() {
        System.out.println("슈퍼 클래스 메서드는 상속된다.");
    }
}

class Child52 extends Parent52 {		// 자식 클래스
    public void childPrn() {
        System.out.println("서브 클래스 메서드는 슈퍼가 사용 못한다.");
    }
}

public class JavaTask51 {
    public static void main(String[] args) {
        Child52 c = new Child52();
        c.parentPrn();      // 상속 받은 메소드 사용
        c.childPrn();       // 자식 클래스의 메소드 사용

        System.out.println("-------------------------------------->> ");
        Parent52 p = new Parent52();
        p.parentPrn();		// 자기 클래스(부모 클래스)의 메소드 사용
//		p.childPrn();       // 자식 클래스의 메소드는 접근 할 수 없다.
    }
}
