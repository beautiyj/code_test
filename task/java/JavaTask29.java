package task.java;

// static 정적멤버사용 예제
// +) 정적 메소드는 객체 없이도 실행 가능한 특성이 있어서
// 선언시 내부에 인스턴스필드나 메소드 사용 줄가, this 자신참조도 사용 불가.
/*
int f1;         // 이런 인스턴스필드를 정적메소드에 넣을 때
void m1;
static int f2;
static void m2;

static void m3() {
    this.f1= 10;        // X    사용하려면 객체 먼저 생성해야함
    this.m1();          // X
    f2 = 10;            // 정적필드는 가능
    m2();               // 정적메소드도 가능.
 */


class Calculator29 {
    static double pi = 3.14159;

    static int plus(int x, int y) {
        return x + y;
    }

    static int minus(int x, int y) {
        return x - y;
    }

}

public class JavaTask29 {
    public static void main(String[] args) {

        double result1 = 10 * 1 * Calculator29.pi;

        int result2 = Calculator29.plus(10, 20);
        int result3 = Calculator29.minus(10, 20);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        // Math 클래스는 정적필드+정적메소드로 구성되어있어서 객체 생성 필요 없음(컴파일오류)
        // 사용 시 new 필요 없이 바로 Math.변수; 혹은 Math.메소드(); 가능.
        // 보통 배열, Math, 컬렉션 등은 정적메소드(static)

        // 반대로 객체 생성(new)이 필요한 내장 클래스들은 캘린더, ArrayList 가변리스트,
        // 키-값 저장하는 HashMap, 스캐너, Random, 문자열조작 StringBuilder 등이 있음.

        System.out.println(Math.E); // 오일러 상수
        System.out.println(Math.PI); // 원주율
        System.out.println(Math.abs(-10));  // 10  절댓값구하기
        System.out.println(Math.ceil(3.14));  // 4.0 올림 기능(반환 자료형 double)
        System.out.println(Math.round(10.5));  // 11 반올림 기능.
                 // f round 선택하면 int반환 double round는 long반환
        // 보통 double 쓰고 int로 캐스팅해서 씀 (long으로 바로 받기도 가능)
        System.out.println(Math.floor(10.9));  // 10.0 내림 기능.(반환 자료형 double)
        System.out.println(Math.max(10,20));   // 3개 숫자 비교는 커스텀 필요...
        System.out.println(Math.min(10,20));
        System.out.println(Math.pow(2,3));  // 거듭제곱 구하기. 2,3 = 2의 3승 (더블반환)
        System.out.println(Math.random());  // 0.0 <= <1.0 사이의 난수 발생
        System.out.println(Math.sqrt(4));  // 제곱근(루트) 구하기. (더블반환)

    }

}
