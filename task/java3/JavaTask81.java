package task.java3;

// throw, throws 예외처리 예제
// throw new 예외 클래스로 객체 생성, throw new ArrayIndexOutOfBoundsException();로 예외 발생시킬 시점 조절 가능.

class ThrowException {
    public static void excute(String[] args) {
        ThrowException te = new ThrowException();
        try {
            te.exceptionMethod();
        } catch (ArrayIndexOutOfBoundsException ab) {
            System.out.println("배열의 index를 초과했습니다.");
            ab.printStackTrace();
        }
    }

    public void exceptionMethod() throws ArrayIndexOutOfBoundsException {
        // 배열 선언
        int[] intA = {1, 2, 3, 4};
        // 배열의 저장된 값을 출력
        for (int i = 0; i < 10; i++) {
            // 예외를 던짐(프로그래머가 예외를 발생시킴)  -  예외가 발생할 시점을 조절할 수 있음. i=2일때 i=4일때 예외발생하도록 조절 가능
//            if( i == 4 ) throw new ArrayIndexOutOfBoundsException();
            if (i == 2) throw new ArrayIndexOutOfBoundsException();
            System.out.println(intA[i]);
        }
    }
}

// p482
class CatchOrderEx {
    public static void excute(String[] args) {
        try {
            String data1 = args[0];
            String data2 = args[1];
            int value1 = Integer.parseInt(data1);
            int value2 = Integer.parseInt(data2);
            int result = value1 + value2;

            System.out.println(data1 + "+" + data2+"=" + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("실행 매개값의 수가 부족합니다.");
        } catch (Exception e) {
            System.out.println("실행에 문제가 있습니다.");
        } finally {
            System.out.println("다시 실행하세요.");
        }
    }
}
// p484
class ThrowsEx{
    public static void excute() {
        try {
            findClass();        // 메소드 호출
        } catch (ClassNotFoundException e) {
            System.out.println("클래스가 존재하지 않습니다.");
        }
    }
    // 메소드 호출한 곳에 예외처리 떠넘기기
    public static void findClass() throws ClassNotFoundException {
        Class clazz = Class.forName("java.lang.String81");      // 실제로 존재하지 않는 이름
//        Class clazz = Class.forName("java.lang.String");    // 에러 없이 완료됨
    }
}

public class JavaTask81 {
    public static void main(String[] args) {
//        ThrowException.execute(args);
//        CatchOrderEx.execute(args);
        ThrowsEx.excute();
    }
}
