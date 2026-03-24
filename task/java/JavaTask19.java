package task.java;

// 2차원 배열 [][] 행(세로)과 열(가로)

public class JavaTask19 {
    public static void main(String[] args) {

        // 예제 1. 이차원 배열에 5명 학생의 3과목 점수를 각기 입력했을 때
        //        각 학생들의 점수를 정돈하여 출력하기 (행렬처럼)
        int [][]score = new int [5][3];

        score[0][0]=85;  score[0][1]=60;  score[0][2]=70;
        score[1][0]=90;  score[1][1]=95;  score[1][2]=80;
        score[2][0]=75;  score[2][1]=80;  score[2][2]=100;
        score[3][0]=80;  score[3][1]=70;  score[3][2]=95;
        score[4][0]=100; score[4][1]=65;  score[4][2]=80;

        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 3; col++) {
                System.out.print(" " + score[row][col]);
            }
            System.out.println("");
        }

//=============================================================================

        // 예제 2. 이차원 배열이 주어졌을 때, 각 과목별 총점과 학생별 총점 구하기
        //        이것도 다른 예제에 비슷한 거 있는데 키보드로 입력받냐 아니냐의 차이임

        int [][]scores = { { 85,  60,  70},
                { 90,  95,  80},
                { 75,  80, 100},
                { 80,  70,  95},
                {100,  65,  80}
        };

        int [] subject = new int[3];          //과목총점 저장
        int [] student = new int[5];          //학생의 총점 저장

        System.out.println("각 과목별 총점구하기 ");
        for(int c = 0; c < 3 ; c++) {         // 과목
            for(int r = 0; r < 5 ; r++) {     // 학생
                subject[c] += scores[r][c];
            }
            System.out.println(subject[c]);
        }

        System.out.println("학생별 총점구하기");
        for(int r = 0; r < 5 ; r++) {         // 학생
            for(int c = 0; c < 3 ; c++) {     // 과목
                student[r] += score[r][c];
            }
            System.out.println(student[r]);
        }

    }
}
