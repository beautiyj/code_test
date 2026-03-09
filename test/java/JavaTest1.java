import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
* 역순출력
* 학생들의 점수 배열을 뒤에서부터 하나씩 출력할 때
*
* java
* */

public class JavaTest1 {
    public static void main(String[] args) {
        int[] scores = {80, 90, 100};

        System.out.println("기본 정석 출력 시\n");
        for (int i = scores.length - 1; i >= 0; i--) {
            System.out.printf("인덱스 %d번 점수: %d%n", i, scores[i]);
        }

        // 컬렉션 리버스 방식 (List로 변환 후 뒤집기)
        System.out.println("\n리버스 내장 기능(Collections) 사용\n");
        List<Integer> scoreList = Arrays.stream(scores)
                .boxed()
                .collect(Collectors.toList());
        Collections.reverse(scoreList);

        System.out.println(scoreList);  // 리스트는 [100, 90, 80]로 출력
        scoreList.forEach(System.out::println); // 숫자만 출력하고 싶다면

        // Stream API (인덱스 스트림 방식)
        // 파이썬의 range(len-1, -1, -1)와 유사한 스타일
        System.out.println("\nStream API 스트림 방식을 사용한 인덱스 역순 사용\n");
        IntStream.range(0, scores.length)           // 0, 1, 2 생성
                .map(i -> scores.length - 1 - i)   // 2, 1, 0으로 변환
                .forEach(i -> System.out.printf("인덱스 %d번 점수: %d%n", i, scores[i]));
    }
}

/*
** 출력 결과 **
기본 정석 출력 시

인덱스 2번 점수: 100
인덱스 1번 점수: 90
인덱스 0번 점수: 80

리버스 내장 기능(Collections) 사용

[100, 90, 80]
100
90
80

Stream API 스트림 방식을 사용한 인덱스 역순 사용

인덱스 2번 점수: 100
인덱스 1번 점수: 90
인덱스 0번 점수: 80
 */