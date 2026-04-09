package task.java3;

// 예외처리 try-catch-catch 구문 (멀티처리)
// try { 예외 발생 가능한 문장}
// catch(Exception(예외클래스명) e(매개변수) ) { 예외메시지 }
// catch(Exception(예외클래스명) e(매개변수) ) { 예외메시지 }
// 예외가 발생하지 않으면 try 구문의 블록만 실행된다. try 실행에 따라 catch 실행도 달라짐(캐치구문 동시실행되는 경우는 없음!)

class MultiExceptionHandling {
    public static void execute() {
        int value = 20;
        int div = 0;
        int[] intArray = {1, 2, 3};

        try {
//            int arrayValue = intArray[4];               // 이거 실행하면 ArrayIndexOutOfBoundsException 예외 실행됨
//            System.out.println(arrayValue);

            // 두수의 나눗셈을 구함
            int result = value / div;                     // 예외 발생
            System.out.println(result);

            // 배열의 특정 값을 저장                         // 만약 어레이밸루 이걸로 진행하면 위의 RESULT에서 예외가 나타나서 이건 실행X
            int arrayValue = intArray[4];
            System.out.println(arrayValue);

        } catch (ArithmeticException ae) {
            System.out.println("result 계산 중 예외 발생");
            System.out.println(ae.toString());            // java.lang.ArithmeticException: / by zero 오류메시지 이거 실행됨
        } catch (ArrayIndexOutOfBoundsException ai) {
            System.out.println("arrayValue 인덱스 예외 발생");
            ai.printStackTrace();
        }
    }
}

class ExceptionEx3 {
    public static void execute(String[] args) {
        int var = 50;
        try {
//            int data = Integer.parseInt(args[0]);     // Exception 실행됨
//            int data = Integer.parseInt("abc");       // NumberFormatException 실행됨
            int data = Integer.parseInt("0");        // ArithmeticException 실행됨

            System.out.println(var / data);

            // Exception 예외 클래스가 하위 예외 클래스들을
            // 모두 가지고 있기 때문에 먼저 정의해서는 안된다.
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닙니다.");
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌순 없죠?");
        } catch (Exception e) {
            System.out.println("Exception !!");
            System.out.println("프로그램 종료!");
        }
    }
}

public class JavaTask78 {
    public static void main(String[] args) {
//        MultiExceptionHandling.execute();
        ExceptionEx3.execute(args);
    }
}

