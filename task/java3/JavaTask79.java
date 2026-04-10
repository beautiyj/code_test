package task.java3;

// 예외처리 try-catch-finally 구문
// 현재는 try(resource) {} (트라이위드리소스)형태로 자동 닫기 처리 가능한데 일단 try-catch-finally 개념 설명ㄱㄱ
// finally 구문은 주로 파일을 닫을 때나데이터베이스 연결 끊을 때 사용되는 구문.
// finally 안의 내용은 예외가 발생하든, 발생하지 않든 무조건 실행됨

class MultiExceptionHandling1 {
    public static void excute() {

        int value = 20;
//        int div = 0;
        int div = 10;

        int[] intArray = {1, 2, 3};

        try {
            // 두수의 나눗셈을 구함
            int result = value / div;
            System.out.println(result);

            // 배열의 특정 값을 저장
//            int arrayValue = intArray[4];
            int arrayValue = intArray[2];
            System.out.println(arrayValue);

        } catch (ArithmeticException ae) {
            System.out.println(ae.toString());

        } catch (ArrayIndexOutOfBoundsException ai) {
            ai.printStackTrace();

        } finally {
            System.out.println("예외가 발생했음!");        // 이건 예외든 아니든 무조건 실행됨

        }
    }
}

public class JavaTask79 {
    public static void main(String[] args) {
        MultiExceptionHandling1.excute();
    }
}
