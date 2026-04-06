package task.java2;

// Wrapper 랩퍼 클래스
// 박싱과 언박싱 (데이터 저장소 옯기는 형변환이라고 생각하면 됨)

// 박싱: 기본 자료형의 값을 포장 객체로 만드는 과정. (보통 기본자료형들은 스택메모리에 존재)
// heap메모리를 박스로 생각하고 stack메모리에 저장된 데이터를 heap메모리에 복사하는 것
// 박싱은 기본형 -> 참조형, 기본 자료형(스택에 있는 값) 복사해서 힙메모리에 새 객체 생성

// 언박싱: 포장 객체에서 기본 자료형의 값을 얻어내는 과정 (스트링 등은 힙메모리에 존재)
// heap메모리에 있는 데이터를 stack메모리로 가져오는 것. int i = obj; (자동 언박싱)


class WrapperTest1 {
    public void wrapperTest1() {
        // int형 변수의최대 최소
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        // String형을 int형으로 형변환
        int n = Integer.parseInt("20");
        System.out.println(n);      // 20
        System.out.println(n + 10);   // 30 산술연산 가능(정수형 변환 완)

        // 10진수 -> 2진수 변환
        System.out.println(Integer.toBinaryString(10)); //1010
        // 8진수 변환
        System.out.println(Integer.toOctalString(10));  // 12
        // 16진수 변환
        System.out.println(Integer.toHexString(10));    // a

        System.out.println();
    }
}

// 박싱, 언박싱
class WrapperTest2 {
    public void wrapperTest2() {
        // Integer num = new Integer();     // 오류발생

        int n = 10;                        // 지역변수(stack영역에 저장)

        // 박싱
        Integer num1 = new Integer(n);    // 박싱(boxing) 구버전
        Integer newNumber1 = Integer.valueOf(n); // 현재는 valueOf로 박싱함!

        // 언박싱
        int n1 = num1.intValue();
        int new1 = newNumber1;                  // 마찬가지로 자동언박싱이 최신 방식!

        // 자료형 변환 : "20" --> 20
        String s = "20";
        Integer num2 = new Integer(s);    // 박싱(boxing)
        int n2 = num2.intValue();        // 언박싱(unboxing)
    }
}

class WrapperTest3 {
    public void wrapperTest3() {
        // 박싱(boxing)
        Integer obj1 = new Integer(10);         // 새 객체를 생성(메모리 낭비, 현재는 쓰지 않음)
        Integer obj2 = new Integer("200");
        Integer obj3 = Integer.valueOf("300");      // 이걸 축약한 게 현재의 자동 박싱 형태

        // 자동 박싱(Auto-boxing): 실무에서 가장 많이 쓰는 형태
        Integer newObj1 = 10;           //         Integer newObj1 = "10"; 이건 오류.

        Integer newObj2 = Integer.valueOf("200");  // 직접박싱이긴하다.
        Integer newObj3 = Integer.valueOf("300");

        // 언박싱(unboxing) - 객체생성이 없으니 메모리누수 없고, 역으로 가비지컬렉터(메모리청소) 도우미 역할이 됨
        int value1 = obj1.intValue();
        int value2 = obj2.intValue();    // 자료형 변환 : "200" -> 200
        int value3 = obj3.intValue();    // 자료형 변환 : "300" -> 300

        // 자동 언박싱(Auto-unboxing)
        int newValue1 = newObj1;
        int newValue2 = newObj2;
        int newValue3 = newObj3;

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);

        System.out.println();
    }
}

class WrapperTest4 {
    public void wrapperTest4() {
        Integer obj = 100;
        System.out.println("unboxing " + obj.intValue());
        System.out.println("auto-unboxing " + obj);

        int value1 = obj.intValue();
        int value2 = obj;

        int result = obj + 100;
        System.out.println("auto-unboxing (result) " + result);
        System.out.println();

    }
}

class WrapperTest5 {
    public void wrapperTest5() {

        // 박싱 자동박싱
        Double d1 = new Double(3.14);
        Double newD1 = d1;

        // 언박싱 자동언박싱
        double n1 = d1.doubleValue();
        double newNum1 = newD1;

        // 자료형 변환 문자열->실수 시 자동박싱 오류
        Double d2 = new Double("42.195");       // 구버전 방식은 가능한데
//      Double newD2 = d2; 자동박싱은 오류. 실수가 아닌 문자열을 변환중이라 자동 박싱 오류
        Double dddd = Double.valueOf("42.195");     // 이건 가능!(수동박싱)

        // 언박싱 자동언박싱
        double n2 = d2.doubleValue();
        double newNum2 = d2;

        // 자료형 변환 문자열->실수.   Double.parseDouble("42.195")는 문자열파싱임.
        double num = Double.parseDouble("42.195");  // 언박싱아님! 형변환임
        System.out.println("num = " + num);

        int number = Integer.parseInt("333");

        // valueOf는 객체 생성, parseDouble는 기본형 생성.
        // 문자열 숫자를 만났을 때
        // 객체타입이면 valueOf로 수동박싱을, 기본형타입이면 parseInt로 파싱을!
        System.out.println();

    }
}

class WrapperTest6 {
    public void wrapperTest6() {
        int value1 = Integer.parseInt("10");
        double value2 = Double.parseDouble("3.14");
        boolean value3 = Boolean.parseBoolean("true");
        boolean value4 = Boolean.parseBoolean("TRUE");  // 대문자 넣어도 출력 true

        // 논리값 아닌 걸 넣으면 false로 변환돼서 출력됨.
        boolean value5 = Boolean.parseBoolean("test");

        System.out.println("value1 = " + value1);
        System.out.println("value2 = " + value2);
        System.out.println("value3 = " + value3);
        System.out.println("value4 = " + value4);
        System.out.println("value5 = " + value5);

        System.out.println();
    }
}

public class JavaTask40 {
    public static void main(String[] args) {
        WrapperTest1 w1 = new WrapperTest1();
        w1.wrapperTest1();

        WrapperTest2 w2 = new WrapperTest2();
        w2.wrapperTest2();

        WrapperTest3 w3 = new WrapperTest3();
        w3.wrapperTest3();

        WrapperTest4 w4 = new WrapperTest4();
        w4.wrapperTest4();

        WrapperTest5 w5 = new WrapperTest5();
        w5.wrapperTest5();

        WrapperTest6 w6 = new WrapperTest6();
        w6.wrapperTest6();
    }
}
