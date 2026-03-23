package task.java;

/*
// 반복문 - do while문 (파이썬엔 x 코틀린엔 동일하게 존재함)
    보기 불편해서 잘 쓰진 않음

    do {
        반복 실행 문장;
    } while(조건식);

*/

import java.util.Scanner;

public class JavaTask14 {

    // 1. 문자열 반복 출력
    public static void main(String[] ar) {
        int i =1;
        do {
            System.out.println(i+"do-while문 문장출력");
            i++;
        } while (i<=10);

        System.out.println();
        main2(ar);
    }

    // 2. 1~100까지의 홀수 짝수 합 구하기
    public static void main2(String[] ar) {
        int i =1, oddSum = 0, evenSum=0;
        do {
            if (i%2==0) {
                oddSum += i;
            } else {
                evenSum += i;
            }
            i++;
        } while (i<=100);

        System.out.println(oddSum);
        System.out.println(evenSum);

        System.out.println();
        main3(ar);
    }

    // 3. 종료 키워드 q가 입력 될 때까지 사용자 입력을 반복처리하는
    // 대화형태 에코 프로그램 작성하기
    public static void main3(String[] ar) {
        System.out.println("메시지를 입력하세요. (종료 키워드: q");
        Scanner sc = new Scanner(System.in);

        String input;

        do {
            System.out.println(">");
            input = sc.nextLine();
            System.out.println("입력 메시지: "+input);
        } while (!input.equals("q"));

        System.out.println("프로그램 종료");
    }
}

/*
대화형 출력 시 - ars 개념

    메시지를 입력하세요. (종료 키워드: q
    >
    가나다라
    입력 메시지: 가나다라
    >
    반복
    입력 메시지: 반복
    >
    q
    입력 메시지: q
    프로그램 종료

 */
