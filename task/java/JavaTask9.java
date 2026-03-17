package task.java;

import java.util.ArrayList;
import java.util.List;

/*
과제9

1~45사이의 숫자를 6개 추출하는 프로그램 만들기
(단, 중복된 숫자는 1번만 출력되도록 한다)

조건
Math.random() 함수를 이용
0.0 <= Math.random() < 1.0
 */
public class JavaTask9 {
    public static void main(String[] args) {

        System.out.println("=== 1. 배열 방식 결과 ===");
        int[] numbers = new int[6];

        for (int i = 0; i < 6; i++) {
            // 1~45 사이의 숫자 추출, 서식은 아래에.
            numbers[i] = (int) (Math.random() * 45) + 1;

            // 중복검사
            for (int j = 0; j < i; j++) {
                if (numbers[j] == numbers[i]) {
                    i--; // 중복 시 현재 칸(i)을 다시 뽑기 위해 i를 줄여야 함
                    break;
                }
            }
        }

        System.out.print("추출된 숫자: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n");


        // 다른 방식: 간단하게 리스트 활용
        System.out.println("=== 2. 리스트 방식 결과 ===");
        List<Integer> lotto = new ArrayList<>();

        while (lotto.size() < 6) {
            int num = (int) (Math.random() * 45) + 1;

            if (!lotto.contains(num)) {
                lotto.add(num);
            }
        }

        System.out.println("리스트 간략 결과: " + lotto);
    }
}

/*
파이썬과 달리 랜덤(6) 이런 거 안됨,,,
자바에서의 Math.random() 서식 및 설명

 Math.random() * 45
    원래 범위는 0.0~0.99인데 곱하기를 통해 0.0~44.99 로 증가
 (int)
    강제 형변환. 소수점 제거 후 정수화. 범위는 0~44
 +1
    범위는 0~44에서 1~45로 증가
*/