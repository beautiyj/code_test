package java;

import java.util.Scanner;

/*
 * 5. 키보드를 이용해서 정수 5개를 입력 받은 후 int형 배열에 저장한다.
 * 배열에 저장된 값 중 최댓값, 최솟값을 구하는 프로그램
 */

public class JavaTask5 {

    public static void main(String[] ar) {

        Scanner sc = new Scanner(System.in);
        System.out.println("정수 5개를 입력하시오. 단, ',' 없이 숫자만 입력하시오.");
        int numbers[] = new int[5];

        // 파이썬, 코틀린과 달리 자바는 선언 따로 배열의 숫자 정수로 대입 따로 과정 필요
        // 파이썬은 선언이 없고 코틀린은 선언하면서 블록으로 대입처리 가능
        // Python: numbers = [int(input()) for _ in range(5)]
        // Kotlin: val numbers = IntArray(5) { readLine()!!.toInt() }
        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
        }

        int max = numbers[0];
        int min = numbers[0];

        for (int i = 1; i < 5; i++) {
            max = (numbers[i] > max) ? numbers[i] : max;
            min = (numbers[i] < min) ? numbers[i] : min;
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);

    }

}