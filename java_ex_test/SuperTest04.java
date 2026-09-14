package java_ex_test;

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
	
//	 System.out.println(super.x); 	   // 에러 발생	

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