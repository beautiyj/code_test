package task.java3;

// 예외처리

// try-catch 구문 try { 예외 발생 가능한 문장}
// 서식           catch(Exception(예외클래스명) e(매개변수) ) { 예외메시지 }
// 예외가 발생하지 않으면 try 구문의 블록만 실행된다
// 그리고 예외 클래스 종류가 엄청 많아서 잘 모르겠다 싶으면 Exception 쓰는 게...

/*
 	int b = 20;
	int a = 0;

	// 두 수의 나눗셈 결과를 구한다
	int c = b/a;        // 이부분이 예외 발생인데 예외처리 안하면 그대로 에러남!
	int total = a + b;
	int sub = b-a;

	System.out.println( c );

 */

// 1. 산술 예외 처리 (특정 예외 지정)
class DivideZeroExceptionHandling1 {
    public static void execute() {
        // int type의 변수 선언
        int b = 20, a = 0, c = 0;

        // 두 수의 나눗셈 결과를 구한다
        try {
            c = b / a;            // 예외 발생. 무한대돼서 에러
        } catch (ArithmeticException ae) {      // 산술예외
            System.out.println("ArithmeticException - 0으로 나눌 수 없습니다.");
            System.out.println("Log: " + ae.getMessage());
            a = 2;
            c = b / a;
        }
        System.out.println("결과 1: " + c);
    }
}

// 2. 모든 예외 처리 (부모 클래스 Exception 사용)
class DivideZeroExceptionHandling2 {
    public static void execute() {
        int b = 20, a = 0, c = 0;
        try {
            c = b / a;
        } catch (Exception e) {
            System.out.println("Exception - 0으로 나눌 수 없습니다.");
            System.out.println("Log: " + e.getMessage()); // / by zero라고 정해진 메시지 출력됨
            a = 2;
            c = b / a;
        }
        System.out.println("결과 2: " + c);
    }
}

// 3. 예외 정보 상세 출력 (printStackTrace 등)
class DivideZeroExceptionHandling3 {
    public static void execute() {
        int b = 20, a = 0, c = 0;
        try {
            c = b / a;
        } catch (Exception e) {
            e.printStackTrace();      // printStackTrace()는 빨간글씨의 에러부분 표시
//            log.error("Logback 활용한 에러 로그", e);      // Logback 로 활용 많이 하는데 그래들 없어서 추가안함
            System.out.println("getMessage() 메시지: " + e.getMessage());
            System.out.println("toString 메시지: " + e.toString());

            System.out.println("printStackTrace() 메시지: ");
            /* 출력결과는
            java.lang.ArithmeticException: / by zero
            at task.java3.DivideZeroExceptionHandling3.execute(JavaTask77.java:62)
            at task.java3.JavaTask77.main(JavaTask77.java:77)
            메시지: / by zero
            toString 메시지: java.lang.ArithmeticException: / by zero

            printStackTrace는 에러종류 + 위치 + 이유, toString()은 에러종류 + 이유, getMessage는 에러 이유만 출력해준다.
            printStackTrace()는 Logback활용이 아니더라도 가장 많이 쓰이고 getMessage()는 간단히 에러 이유만 알고 싶을 때 많이 쓰임
             */

        }
    }
}

public class JavaTask77 {
    public static void main(String[] args) {
        // 공부하고 싶은 메서드만 주석을 풀어서 실행하세요.

//         DivideZeroExceptionHandling1.execute();
//         DivideZeroExceptionHandling2.execute();
        DivideZeroExceptionHandling3.execute();
    }
}