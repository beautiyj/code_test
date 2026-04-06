package task.java2;

// 상속, super, 생성자 호출 순서
// ---------------------------------------------------------
// [첫 번째 예제: super 키워드와 필드 재정의]
// ---------------------------------------------------------

// 부모 클래스의 은닉된 x, y를 자식 클래스에서 접근 하기 위해서는 super를 이용한다.
class Point2D04 {						// 부모 클래스
    protected int x = 10; 		// 은닉 변수
    protected int y = 20;
}

class Point3D04 extends Point2D04 {		// 자식 클래스
    protected int x = 40; 		// 부모 클래스의 필드를 재정의
    protected int y = 50;

    protected int z = 30;

    // 자식 클래스에서 새로 정의한 x, y만 사용된다.
    public void print() {
        System.out.println(x + ", " + y + ", " + z); // 40, 50, 30
    }

    // super
    // 1. super : 부모 클래스를 의미한다.
    // 2. super.x는 부모 클래스의 은닉된 필드를 접근할때 사용한다.
    // 3. super.x는 자식 클래스의 메소드 안에서만 사용할 수 있다.

//	 System.out.println(super.x); 	    // 에러 발생

    // 부모 클래스의 은닉 변수에 super.x로 접근해서 사용한다.
    public void print02() {
        System.out.println(super.x + ", " + super.y + ", " + z);
    }
}

class SuperTest04 {
//	public void print02() {
//		System.out.println(super.x + ", " + super.y + ", " + z);
//	}

    public static void main(String[] args) {
        Point3D04 pt = new Point3D04();
        pt.print();
        pt.print02();
    }
}

// ---------------------------------------------------------
// [두 번째 예제: 상속과 생성자 호출 순서]
// ---------------------------------------------------------

// 상속에서의 생성자
// 1. 생성자는 상속이 되지 않는다.
// 2. 자식클래스의 생성자(기본 생성자, 매개변수가 있는 생성자)가 호출되면
//    부모 클래스의 기본 생성자를 연쇄적으로 호출 해준다.
class Point2D05 {					// 부모 클래스
    protected int x = 10;
    protected int y = 20;

    public Point2D05() {			// 기본 생성자
        System.out.println("슈퍼 클래스인 Point2D 생성자 호출");
    }
}

class Point3D05 extends Point2D05 { // 자식 클래스
    protected int z = 30;

    // 자식클래스의 생성자(기본 생성자, 매개변수가 있는 생성자)가 호출되면
    // 부모 클래스의 기본 생성자를 연쇄적으로 호출 해준다.
    public Point3D05(int a) {
        System.out.println("서브 클래스인 Point3D 생성자 호출");
    }

    public void print() {
        System.out.println(x + ", " + y + "," + z);
    }
}

class SuperTest05 {
    public static void main(String[] args) {
        Point3D05 pt = new Point3D05(30);
//                          생성자 호출

        pt.print();
    }
}

// 전체 실행을 위한 메인 클래스
public class JavaTask46 {
    public static void main(String[] args) {
        System.out.println("--- SuperTest04 실행 ---");
        SuperTest04.main(null);

        System.out.println("\n--- SuperTest05 실행 ---");
        SuperTest05.main(null);
    }
}