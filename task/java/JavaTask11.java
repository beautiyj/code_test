package task.java;

// switch case문
// = 코틀린의 when문, 파이썬의 match-case문과 흡사하나 자바는 가장 구리고 귀찮고...
// when문도 당연히 사용가능하며, 파이썬 match-case문 역시 자바와 달리 조건식도 사용 가능하다.

/*
키보드로 입력한 정수가 어느 학점에 해당하는지 판별하는 프로그램
90점 이상  A
80점 이상  B
70점 이상  C
60점 이상  D
60점 미만  F

 */

import java.util.Scanner;

public class JavaTask11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("점수를 입력해주세요.");
        int n = sc.nextInt();
        System.out.println("점수를 입력해주세요.");
        int m = sc.nextInt();

        // 고정값의 경우
//        int s = 90;

        // 대신 이 경우 case 숫자와 동일하게 들어와야 가능하다
        switch (n) {
            case 90:
                System.out.println("A학점");
                break;
            case 80:
                System.out.println("B학점");
                break;
            case 70:
                System.out.println("C학점");
                break;
            case 60:
                System.out.println("D학점");
                break;
            default:
                System.out.println("F학점");
        }

        // case문 안에 조건식을 넣을 수 없음.
        // 대신 나누기 등을 통해 십의 자리 숫자만 추출하는 형태로 범위 추출 가능.
        switch (m / 10) {
            case 10: // 100점일 경우
            case 9:  // 90~99점일 경우
                System.out.println("A학점");
                break;
            case 8:  // 80~89점
                System.out.println("B학점");
                break;
            case 7:  // 70~79점
                System.out.println("C학점");
                break;
            case 6:  // 60~69점
                System.out.println("D학점");
                break;
            default: // 60점 미만
                System.out.println("F학점");
        }

    }
}
