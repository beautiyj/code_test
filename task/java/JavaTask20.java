package task.java;

// 메소드

public class JavaTask20 {
    // static: 정적 메소드
    // void 넣으면 리턴값이 없다는 의미
    static void check() {
        System.out.println("메소드 호출 성공\n");
    }   // 리턴 생략 가능함 (return;은 가능, 리턴값을 넣는 건 불가능)

    // 값 전달에 의한 Call by Value 메소드 호출 방식 - 값 자체가 전달됨
    static void check(int a) {
        System.out.println(a);
        System.out.println();
    }

    static void check(int a, double d) {
        double result = a + d;
        System.out.println(result);
        System.out.println();
    }

    static void check(char c) {
        System.out.println(c);
        System.out.println();
    }

    static void check(boolean b) {
        System.out.println(b);
        System.out.println();
    }

    // 주소값 전달에 의한 Call bY Reference 방식 - 데이터가 들어있는 주소값 전달
    static void check(String s) {
        System.out.println(s);
        System.out.println();
    }

    static int check1() {
        System.out.println("return\n");
        return 50;
    }

    static double check2(int a, double d) {
        double result = a + d;
        System.out.println();
        return result;
    }


    public static void main(String[] args) {
        JavaTask20.check();     // 그냥 check()만 해도 알아듣긴 한다
        check(30);
        check(10, 20.5);
        check('A');
        check(true);
        check("java");
        check(new String("python"));

        check1();                   // 출력은 return\n
        int result = check1();
        System.out.println(result); // 출력은 return값으로 입력했던 50
        System.out.println(check1());   // 선언 귀찮으면 이렇게/
                                        // 출력은 return\n50 이 된다. 행위+리턴 모두 출력

        double result2 = check2(50, 3.14);
        System.out.println(result2);    // 53.14
    }

}
