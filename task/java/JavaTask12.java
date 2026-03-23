package task.java;

// 반복문 - for문

import java.util.Scanner;

public class JavaTask12 {

    // 1. 메시지 10번 숫자+문자열 반복출력
    public static void main(String[] ar) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "문자열반복출력");
        }
        System.out.println("출력종료");
        System.out.println();

        main2(ar);
    }

    // 2. 1~10까지의 합을 구하기
    public static void main2(String[] ar) {

        int result = 0;
        for (int i = 1; i <= 10; i++) {
            result += i;
        }
        System.out.println(result);
        System.out.println();

        main3(ar);
    }

    // 3. 1~100까지의 홀수, 짝수의 합 구하기
    public static void main3(String[] ar) {

        int oddSum = 0;
        int evenSum = 0;

        for (int i = 1; i <= 100; i += 2) {
            oddSum += i;
            evenSum += (i + 1);
        }
        /*  if 조건판별로도 가능함
        for (int i = 1; i <= 100; i++) {
        if (i % 2 == 0) {
            evenSum += i; // 짝수일 때
        } else {
            oddSum += i;  // 홀수일 때
        }
         */

        /*  가장 간단하게 하려면 스트림 방식
        int evenSum = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0).sum();
        int oddSum = IntStream.rangeClosed(1, 100).filter(n -> n % 2 != 0).sum();
         */
        System.out.println(oddSum);
        System.out.println(evenSum);
        System.out.println();

        main4(ar);
    }

    // 4. 키보드로 입력한 숫자의 단을(구구단. ex 3 입력 시 3단 출력) 출력하기
    public static void main4(String[] ar) {
        Scanner sc = new Scanner(System.in);

        System.out.println("정수 하나를 입력하세요");

        int n = sc.nextInt();
        for (int i = 1; i <= 9; i++) {
            System.out.println(n + "*" + i + "=" + (n * i));
        }
    }

}
