import java.util.Scanner;

/*
 * 6. 2차원 배열을 이용해 5명 학생들의 국어, 영어, 수학 점수를 저장했을 때 과목별 총점과 학생별 총점을 출력하는 프로그램
 *
 * 조건: 과목명(국어, 영어, 수학)과 학생번호 출력
 *
 */

public class JavaTask6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int ar[][] = new int[5][3];

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

