package task.java;

// 중첩 for문을 활용해 주어진 배열의 전체 항목 합, 평균값 구하기 (+2차원 배열)

/*
주어진 배열은 다음과 같다.

int[][] array = {
    {95,86},
    {83,92,96},
    {78,83,93,87,88}
};


변수: 입력값은 배열, 출력값은 배열의 sum avg,
행위: 중첩for문을 이용해서 sum, avg구하기
 */

import java.util.Arrays;

public class JavaTask23 {
    public static void main(String[] ar) {

        int[][] array = {
                {95, 86},
                {83, 92, 96},
                {78, 83, 93, 87, 88}
        };

        int sum = 0;
        int count = 0;    // 평균용 카운트

        // 누적합계
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];   // 누적합계(보이는 배열 데이터마다 다 넣고)
                count++;            // 데이터 더할 때마다 횟수 추가
            }
        }

        // 평균. count는 더한 횟수 = 데이터의 개수라는 뜻
        double avg = (double) sum / count;

        System.out.println(sum);
        System.out.println(avg);
        System.out.println(Arrays.toString(array[0]));  // 이래야 숫자 나옴
        System.out.println(array[0]);                   // 이러면 주소가 나옴
    }
}
