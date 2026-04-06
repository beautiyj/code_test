package task.java2;

// [예제 1] 상속에서의 필드 (기본 상속)
class Point2D_01 {                            // 부모 클래스
    protected int x = 10;
    protected int y = 20;
}

class Point3D_01 extends Point2D_01 {          // 자식 클래스
    protected int z = 30;
    public void print() {
        System.out.println(x + ", " + y + ", " + z);   // x와 y는 상속 받아 사용하는 필드
        // 10, 20, 30
    }
}

// [예제 2 & 3] 상속에서의 필드 (은닉 변수 및 super 이용)
// 예제 2와 3은 구조가 같으므로 super 활용 버전으로 통합하여 확인합니다.
class Point2D_02 {                            // 부모 클래스
    protected int x = 10; // 자식 클래스에서 x,y를 재정의하면 부모 클래스의 x,y는 은닉변수가 된다.
    protected int y = 20; // 은닉 변수 or 쉐도우 변수
}

class Point3D_02 extends Point2D_02 {          // 자식 클래스
    protected int x = 40; // 부모 클래스에 존재하는 멤버변수를 자식 클래스에 다시 한 번 정의함
    protected int y = 50;
    protected int z = 30;

    public void print() {
        System.out.println(x + ", " + y + ", " + z);   // 자식 클래스의 재정의된 x,y가 출력된다.
        // 40, 50, 30
    }

    public void print02() {
        System.out.println(super.x + ", " + super.y + ", " + z); // super를 이용해서 부모 클래스의 x,y출력
        // 10, 20, 30
    }
}

// [예제 4] 상속에서의 메소드
class Parent_04 {                            // 부모 클래스
    public void parentPrn() {
        System.out.println("부모 클래스의 메서드는 상속된다.");
    }
}

class Child_04 extends Parent_04 {           // 자식 클래스
    public void childPrn() {
        System.out.println("자식 클래스의 메서드는 부모가 사용할 수 없다.");
    }
}


public class JavaTask50 {
    public static void main(String[] args) {

        System.out.println("=== [예제 1] 기본 상속 테스트 ===");
        Point3D_01 pt1 = new Point3D_01();
        pt1.print();

        System.out.println("\n=== [예제 2 & 3] 은닉 변수 및 super 테스트 ===");
        // 자식클래스에서 부모클래스의 변수를 출력하려면 super붙이면 됨
        Point3D_02 pt2 = new Point3D_02();
        System.out.print("자식 변수 출력: ");
        pt2.print();   // 40, 50, 30
        System.out.print("부모 변수(super) 출력: ");
        pt2.print02(); // 10, 20, 30

        System.out.println("\n=== [예제 4] 메소드 상속 및 접근 제한 테스트 ===");
        // 자식클래스는 부모 자식 메소드 호출 가능, 부모클래스는 본인 메소드만 호출 가능
        Child_04 c = new Child_04();
        c.parentPrn(); // 상속받은 부모 메소드 호출
        c.childPrn();  // 자신의 메소드 호출(자식클래스의 메소드)

        Parent_04 p = new Parent_04();
        p.parentPrn(); // 부모 자신의 메소드 호출
        // p.childPrn(); // [컴파일 에러] 부모는 자식의 메소드에 접근할 수 없음
        System.out.println("부모 객체는 자식 메소드(childPrn)를 호출할 수 없음을 확인했습니다.");
    }
}