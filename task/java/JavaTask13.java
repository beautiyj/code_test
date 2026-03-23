package task.java;

import java.util.Scanner;

// 반복문 - while문
public class JavaTask13 {

    // 1. 문자열 반복 출력
    public static void main(String[] ar) {
        int i = 1;
        while (i <= 10) {
            System.out.println(i + "문자출력");
            i++;
        }
        System.out.println();
        main2(ar);
    }

    // 2. while문과 if-else문을 활용해 1~100까지의 홀.짝수 합 구하기
    public static void main2(String[] ar) {
        int i = 0, oddSum = 0, evenSum = 0;

        while (i <= 100) {

            if (i % 2 == 0) {
                oddSum += i;
            } else {
                evenSum += i;
            }

            i++;
        }
        System.out.println(oddSum);
        System.out.println(evenSum);
        System.out.println();

        main3(ar);
    }

    // 3. 키보드로 입력받은 숫자의 구구단을 출력하기
    public static void main3(String[] ar) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 하나를 입력하세요");
        int n = sc.nextInt();

        int i = 1;
        while (i <= 9) {
            System.out.println(n + "*" + i + "=" + (n * i));
            i++;
        }
        System.out.println();

        main4(ar);
    }

    // 4. 구구단 2~9단 출력하기
    public static void main4(String[] ar) {
        int n = 2, i;

        while (n <= 9) {
            System.out.println(n + "단");
            i = 1;

            while (i <= 9) {
                System.out.println(n + "*" + i + "=" + (n * i));
                i++;
            }

            n++;
        }

    }
}
