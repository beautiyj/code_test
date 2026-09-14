package java_ex_test;

//1. 부모 클래스에 있는 필드를 자식 클래스에서 재정의(동일한 이름의 변수)하면,
//   자식 클래스에서 재정의한 필드만 사용 가능하다.
//2. 부모 클래스의 필드는 더 이상 상속이 되지 않기 때문에 은닉변수가 된다.
//3. 자식 클래스에서 x, y를 재 정의하면 부모 클래스의 x, y는 은닉 변수가 된다.

class Point2D03 {						// 부모 클래스
	protected int x = 10;       // 은닉 변수        
	protected int y = 20; 
}

class Point3D03 extends Point2D03 {		// 자식 클래스
	protected int x = 40; 		// 부모 클래스의 필드를 재정의
	protected int y = 50; 

	protected int z = 30;

	// 자식 클래스에서 새로 정의한 x, y만 사용된다.
	public void print() {
		System.out.println(x + ", " + y + ", " + z); //40, 50, 30
	}
}

class SuperTest03 {
	public static void main(String[] args) {
		Point3D03 pt = new Point3D03();
		pt.print();
	}
}