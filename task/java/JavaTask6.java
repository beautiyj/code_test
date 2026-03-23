package task.java;

import java.util.Scanner;

/*
 * 6. 2차원 배열을 이용해 5명 학생들의 국어, 영어, 수학 점수를 저장했을 때
 * 과목별 총점과 학생별 총점을 출력하는 프로그램
 *
 * 조건: 과목명(국어, 영어, 수학)과 학생번호 출력
 *
 */

public class JavaTask6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] ar = new int[5][3];

        String[] scores = { "Korean", "English", "Math" };

        // 학생별 번호[5] + 점수 입력[3]
        for (int i = 0; i < ar.length; i++) { // 학생별 번호 1,2,3,4,5
            System.out.println("Student number: " + (i + 1));
            for (int j = 0; j < ar[i].length; j++) { // 학생[0]의 점수 입력 1,2,3
                System.out.print(scores[j] + ": ");
                ar[i][j] = sc.nextInt();
            }
        }

        System.out.println();

        // 학생별 총점
        System.out.println("Total Score (Student)");
        for (int i = 0; i < ar.length; i++) {
            int student_total = 0;
            for (int j = 0; j < ar[i].length; j++) {
                student_total += ar[i][j];		// 누적합계 형태
            }
            System.out.println("Student No." + (i + 1) + ": " + student_total);
        }

        System.out.println();

        // 점수별 총점
        System.out.println("Total Score (Subject)");
        for (int j = 0; j < 3; j++) {
            int score_total = 0;
            for (int i = 0; i < 5; i++) {
                score_total += ar[i][j];
            }
            System.out.println("Subject " + scores[j] + ": " + score_total);
        }

    }

}

/*
 * ** 출력결과 **
 *
Student number: 1
Korean: 50
English: 50
Math: 60
Student number: 2
Korean: 10
English: 10
Math: 20
Student number: 3
Korean: 36
English: 54
Math: 54
Student number: 4
Korean: 90
English: 90
Math: 90
Student number: 5
Korean: 78
English: 46
Math: 29

Total Score (Student)
Student No.1: 160
Student No.2: 40
Student No.3: 144
Student No.4: 270
Student No.5: 153

Total Score (Subject)
Subject Korean: 264
Subject English: 250
Subject Math: 253

 */

/*
1. 분석 및 설계 (변수 / 행위 / 로직)
변수 (데이터):
저장공간 (2차원 배열): int[][] scores = new int[5][3];
                    (5행 3열: 학생 5명 × 과목 3개).

학생별 총점: 각 행의 합계를 담을 변수.
과목별 총점: 각 열의 합계를 담을 변수 (배열로 int[3]을 만들면 관리하기 편합니다).
이름표 (문자열 배열): 과목명({"국어", "영어", "수학"})을 담은 배열.

입력값: int[][] scores (5행 3열의 점수판)
이름표: String[] subjects (국어, 영어, 수학)
출력값: int[] studentTotals (학생별 5개), int[] subjectTotals (과목별 3개)
-----
행위 (제어):
중첩 반복문 (이중 for문): 행(학생)을 돌면서 그 안에서 열(과목)을 하나씩 처리하는 행위.
누적 합산 (+=): 점수를 더해서 총점을 만드는 행위.

로직 (해결 순서):
입력: 이중 for문을 돌려 5명 학생의 3과목 점수를 배열에 채우기.
학생별 계산: 각 행(가로)을 한 줄씩 읽어서 합계를 구하고 출력.
과목별 계산: 각 열(세로)을 한 칸씩 내려가며 읽어서 합계를 구하고 출력.

행위 및 로직 (실행 순서 체크)
사용자님이 말씀하신 **"반복 출력"**의 순서가 이 문제의 핵심입니다.
[루프 안에서 바로 하는 일]
학생 번호 출력: 바깥쪽 for문이 시작되자마자 "1번 학생:"이라고 먼저 씁니다.
과목 점수 반복: 안쪽 for문에서 국어, 영어, 수학 점수를 옆으로 하나씩 출력합니다.
학생 총점 누적: 점수를 하나씩 읽을 때마다 그 학생의 전용 바구니에 더합니다.
과목 총점 누적: 동시에 그 점수를 '국어 바구니', '영어 바구니' 등
             과목별 바구니에도 던져 넣습니다.
학생 총점 출력: 안쪽 for문이 끝나면(3과목을 다 읽었으면)
              계산된 학생 총점을 출력하고 줄을 바꿉니다.
[모든 루프가 끝난 후 하는 일]
과목별 총점 반복 출력: 모든 학생의 점수 확인이 끝났으므로,
              아까 점수를 모아두었던 과목별 바구니 3개를 꺼내서 마지막 줄에 쭉 출력.

---

2. 핵심 포인트: 가로(행) 합계 vs 세로(열) 합계
이 문제에서 가장 헷갈리기 쉬운 로직을 시각적으로 이해하면 이렇습니다.

학생별 총점 (가로 합): scores[i][0] + scores[i][1] + scores[i][2]
과목별 총점 (세로 합): scores[0][j] + scores[1][j] + scores[2][j] + ...
 */