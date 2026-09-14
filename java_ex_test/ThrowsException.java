package java_ex_test;

public class ThrowsException {

    public static void main( String[] args ) {
		// 객체를 생성
		ThrowsException te = new ThrowsException();

		// 메소드 호출
		te.occurException();
    }

    // 나눗셈을 구하는 메소드
    public void occurException() {
		int result = 3/0;
		System.out.println( result );
    }
}

