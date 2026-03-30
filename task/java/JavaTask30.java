package task.java;

// 로또 프로그램 만들기. 단, 중복은 없어야한다.

/*
입력값변수: 1~45 사이의 정수, 숫자 뽑는 횟수
출력값변수: 범위 내에서 6개의 랜덤 정수


 */

import java.util.Arrays;

class Lotto {

    // 중복체크
    boolean isTrue(int[] result, int count, int num) {
        for (int i = 0; i<count; i++) {
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
        while (count<6) {
            // 뽑는 숫자는 1~45 사이
            int num = (int) (Math.random() * 45) +1;

            if (isTrue(result,count,num)) {
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
