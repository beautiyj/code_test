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

    }
}