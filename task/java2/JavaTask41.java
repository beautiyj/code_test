package task.java2;

// Wrapper 클래스 응용 1 (기본형 제약 확인용)
class TestClass {
    private int member;                   // 필드
    public int getValue() { return member; }
    public void setValue(int value) { member = value; }
}

// Wrapper 클래스 응용 2 (Object를 이용한 범용성 확인용)
class TestClass2 {
    private Object member;
    public Object getValue() { return member; }
    public void setValue(Object value) { member = value; }
}

public class JavaTask41 {
    public static void main(String[] args) {
        JavaTask41 task = new JavaTask41();

        System.out.println("--- Test 01 시작 ---");
        task.runGenericTest01();
        System.out.println("\n--- Test 02 시작 ---");
        task.runGenericTest02();
    }

    // 첫 번째 예제 실행 메소드
    public void runGenericTest01() {
        TestClass obj01 = new TestClass();
        obj01.setValue(3);               // 정상적인 호출가능
        System.out.println("되돌리는 값은->" + obj01.getValue());     // 3

        // 아래 코드는 컴파일 에러가 발생하므로 주석 처리하여 흐름 유지
        // obj01.setValue(3.4);             // 에러발생.        변수는 int member; 정수 선언이라.
        // obj01.setValue("이해할 수 있다.");  // 에러발생        변수는 int member; 정수 선언이라.
        System.out.println("GenericTest01 실행 완료 (int 전용)");
    }

    // 두 번째 예제 실행 메소드
    public void runGenericTest02() {
        // 오류 수정: Task42Class2 -> TestClass2로 변경
        TestClass2 obj01 = new TestClass2();

        // Object value = new Integer(3);      업캐스팅 + 박싱이 이루어지고
        // Object value = 3;                  업캐스팅 + 자동박싱 과정으로 전개된다~
        obj01.setValue(3);
        System.out.println("되돌리는 값은->" + obj01.getValue());     // 3

        // 다운 캐스팅(자료형 복구) + 언박싱
        int n = ((Integer)(obj01.getValue())).intValue();
        // int n = obj01.getValue(); 자동언박싱은 오류. Object 타입이라 이게 정수형인지 문자형인지를 모르기땜시.
        // int n = (Integer)obj01.getValue(); 다운캐스팅만 해두면 자동언박싱 가능

        // Object value = new Double(3.14);    업캐스팅 + 박싱
        // Object value = 3.14;               업캐스팅 + 자동박싱
        obj01.setValue(3.4);
        System.out.println("되돌리는 값은->" + obj01.getValue());       // 3.4

        // 다운 캐스팅 + 언박싱
        double d = ((Double)(obj01.getValue())).doubleValue();
        // double d = (Double)obj01.getValue();  대신 이렇게 다운캐스팅해두면(=형변환 복구)알아서 자동언박싱해줌.

        // Object value = new String("이해할 수 있다."); 업캐스팅 + 박싱
        obj01.setValue("이해할 수 있다.");
        System.out.println("되돌리는 값은->" + obj01.getValue());       // 이해할 수 있다.

        // 다운 캐스팅(문자열은 객체타입이라 언박싱 과정 필요 없음)
        String str = (String)obj01.getValue();
        System.out.println("GenericTest02 실행 완료 (Object 범용)");
    }
}