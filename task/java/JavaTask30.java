package task.java;

// 로또 프로그램 만들기. 단, 중복은 없어야한다.

/*
입력값변수: 1~45 사이의 정수, 숫자 뽑는 횟수 6번, 숫자들 저장할 배열
출력값변수: 범위 내에서 6개의 랜덤 정수(중복없고)
행위: 중복방지, 6번뽑기 반복, 랜덤으로, 오름차순정렬하기
 */

// 랜덤 클래스는 정수 실수 불리언 등 난수범위 자유롭게 가능. (10)이면 0~9까지
// Math.랜덤은 무조건 0.0<= <1.0 실수 반환 방식

import java.util.Arrays;

class Lotto {

    // 중복체크
    boolean isTrue(int[] result, int count, int num) {
        for (int i = 0; i < count; i++) {
            if (result[i] == num) {
                return true;
            }
        }
        return false;
    }

    public int[] lotto() {
        int[] result = new int[6];
        int count = 0;

        // 6번 뽑기 전까지는 계속 반복
        while (count < 6) {
            // 뽑는 숫자는 1~45 사이
            int num = (int) (Math.random() * 45) + 1;

            // 배열 내의 숫자들이 다 잘 들어갔다면 인덱스에 각기 하나씩 매칭해서 배열에 넣기
            if (isTrue(result, count, num)) {
                result[count] = num;
                count++;

            }
        }

        Arrays.sort(result);
        return result;
    }
}


public class JavaTask30 {
    public static void main(String[] args) {

        Lotto lotto = new Lotto();
        int[] result = lotto.lotto();
        System.out.println(Arrays.toString(result));

    }
}
