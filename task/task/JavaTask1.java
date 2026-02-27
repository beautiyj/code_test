package task;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 과제 1 키보드로 3개의 정수를 입력받았을 때 max min 구하기
 *
 * 제한사항: 조건연산자 활용
 */

public class JavaTask1 {

    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 3개를 입력하시오.\n" + "단, ',' 없이 숫자만 입력하시오.");
        int n1 = sc.nextInt(); // 1
        int n2 = sc.nextInt(); // 2
        int n3 = sc.nextInt(); // 3

        int a, b, max, min;

        a = (n1 > n2) ? n1 : n2; // 1>2 에서 t1 f2
        max = (n3 > a) ? n3 : a; // 3>a 에서 t3 fa
        b = (n1 < n2) ? n1 : n2;
        min = (b < n3) ? b : n3;

        /* 중첩해서 사용도 가능
         * max = (n1>n2 && n1>n3)?n1:(n2>n3)?n2:n3;
         * min = (n1<n2 && n1<n3)?n1:(n2<n3)?n2:n3;
         *
         */

        System.out.println("max: " + max + " min: " + min);
        main2(ar);

    }

    // 다른 버전: 제한사항과는 다르나 배열사용하면 간단하게 풀 수 있음
    public static void main2(String[] ar) {

        Scanner sc = new Scanner(System.in);
        System.out.println("정수 3개를 입력하시오. 단, ',' 없이 숫자만 입력하시오.");

        int numbers[] = new int[3];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        int max = Arrays.stream(numbers).max().getAsInt();
        int min = Arrays.stream(numbers).min().getAsInt();

        System.out.println("max: " + max);
        System.out.println("min: " + min);
    }
}