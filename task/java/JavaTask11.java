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
        /*
        최신 방식 - 코틀린처럼 화살표 방식 존재, 조건식 입력 가능, 브레이크문 필요 없음
        String grade = switch (n) {
            case 90 -> "A학점";
            case 80 -> "B학점";
            case 70 -> "C학점";
            case 60 -> "D학점";
            default -> "F학점";
        };

        // if문은 여전히 넣을 수 없으나 범위지정 가능 (대신 가장 위의 조건을 기준으로 범위가 지정됨)
        String grade = switch (m) {
            case Integer s when s >= 90 -> "A학점";
            case Integer s when s >= 80 -> "B학점";
            case Integer s when s >= 70 -> "C학점";
            case Integer s when s >= 60 -> "D학점";
            default -> "F학점";
        };

        System.out.println(grade);
         */

        // 기존의 case문 안에 조건식을 넣을 수 없음.
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

        // yield 키워드 활용해서 조건 추가하기. 일드 키워드는 예외처리같은 개념임
        // 람다함수의 서식처럼 보이지만 실제 람다함수는 아님
        /*
        String result = switch (score) {
            case Integer s when s >= 90 -> {
                // 여기서부터는 일반 자바코드 입력 가능
                if (s == 100) {
                    System.out.println("만점자 보너스 지급!");
                }
                yield "A학점"; // 최종 결과값 반환
            }
            case Integer s when s >= 80 -> "B학점"; // 한 줄일 땐 중괄호/yield 생략
            default -> "F학점";
        };
         */


    }
}
