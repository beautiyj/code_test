package task.java;

import java.util.Scanner;

/*
 * 5. 키보드를 이용해서 정수 5개를 입력 받은 후 int형 배열에 저장한다.
 * 배열에 저장된 값 중 최댓값, 최솟값을 구하는 프로그램
 */

public class JavaTask5 {

    public static void main(String[] ar) {

        Scanner sc = new Scanner(System.in);
        System.out.println("정수 5개를 입력하시오. 단, ',' 없이 숫자만 입력하시오.");
        int[] numbers = new int[5];

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
/*

 다음처럼 로직분석해서 문제풀이가능.

분석 및 설계 확인
변수 (데이터):
입력값 - Scanner를 통해 들어올 정수 5개.
저장공간 - int[] arr = new int[5]; (정수 5개를 담을 int형 배열).
출력값 - max, min 변수.

행위 (제어):
입력 반복 - for문을 사용해 5번 입력을 받아 배열의 각 방(index)에 넣는 행위.
비교 반복 - for문으로 배열을 처음부터 끝까지 훑으며 max, min과 비교하는 행위.

로직 (해결 순서):
단계 1: 5번 반복하는 루프 안에서 arr[i] = scanner.nextInt();로 배열 채우기.
단계 2 (초기화): max와 min에 **배열의 첫 번째 값(arr[0])**을 미리 넣어두기.
               기준점이 있어야 비교가 가능
단계 3 (비교): 반복문을 돌며 "현재 방의 숫자가 내가 가진 max보다 큰가?"
             혹은 "min보다 작은가?"를 체크해서 변수 값을 업데이트하기.

💡 왜 '배열의 첫 번째 값'으로 초기화하나요?
만약 max를 그냥 0으로 초기화했는데,
사용자가 모두 음수(-10, -20...)만 입력했다면
결과가 0으로 나오는 오류가 생길 수 있습니다.
그래서 **"데이터 중 하나"**를 기준점으로 잡는 것이 배열 로직의 핵심입니다.

 */