package task.java;

// 메소드 예제 2

import java.util.Scanner;

public class JavaTask21 {


    // 예제 1. 1~n 까지의 합을 구하는 누적합계 메소드 작성하기
    static void sum(int n) {
        int hap = 0;
        for (int i=0; i<=n; i++) {
            hap += i;
        }
        System.out.println(hap);
    }

    // 예제 2. 키보드로 입력한 2개의 정수 중 max min 구하기
    static int max(int a, int b) {
        if (a>b) {
            return a;
        } else {
            return b;
        }
    }
    static int min(int a, int b) {
        if (a<b) {
            return a;
        } else {
            return b;
        }
    }

    // 예제 3. 값 비교, 주소 비교 메소드
    static void compareString(String s1, String s2) {
        if (s1 == s2) { // 다른주소
            System.out.println("결과: 같주소");
        } else {
            System.out.println("결과: 다른주소");
        }

        if (s1.equals(s2)) {    // 같은값
            System.out.println("결과: 같값");
        } else {
            System.out.println("결과: 다른값");
        }

        // 숫자 변환
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);

        System.out.println("MAX: " + max(n1, n2));
        System.out.println("MIN: " + min(n1, n2));
    }

    public static void main(String[] args) {
        System.out.println("예제1");
        sum(3);
        sum(100);

        System.out.println("예제2");
        int n1,n2,max_val,min_val;
        System.out.println("정수2개입력");
        Scanner sc = new Scanner(System.in);
        n1 = sc.nextInt();
        n2 = sc.nextInt();

        // 여기서 변수선언 따로 안하고 아예 max()함수를 출력해도 되긴 함
        max_val = max(n1,n2);
        min_val = min(n1,n2);
        System.out.println(max_val);
        System.out.println(min_val);

        System.out.println("예제3");
        // 리터럴("")로 생성하면 String Pool(문자열상수풀)땜시 주소가 같을 수 있음
        // = 자바에서 메모리 절약용땜시
        String str1 = "30";
        String str2 = new String("30"); // 강제로 다른 주소 생성
        compareString(str1, str2);
    }
}