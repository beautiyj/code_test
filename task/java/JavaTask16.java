package task.java;

import java.util.Scanner;

// 배열
public class JavaTask16 {
    public static void main(String[] args) {

        // 배열 형식 1. 배열에 저장될 값이 정해지지 않은 경우 (자료형에 따른 초기화)
        // 서식: 자료형[] 변수 = 연산자 자료형[배열크기]
        int[] scores = new int[3];
        System.out.println(scores[0]);      // 0        자동 0으로 초기화
        scores[0] = 10;
        System.out.println(scores[0]);      // 10

        double[] d = new double[3];
        System.out.println(d[0]);           // 0.0      자동 0.0으로 초기화

        char[] c = new char[3];            // char형은 자동 초기화가 없음.
        System.out.println(c[0]);           // 아무것도 안뜸. null아니고 공백인데 다름

        boolean[] b = new boolean[3];
        System.out.println(b[0]);           // false    자동으로 f초기화(코틀린 동일)

        String[] str = new String[3];         // 참조형은 대문자로 시작
        System.out.println(str[0]);           // null     자동으로 null로 초기화
        System.out.println();


        // 배열 형식 2. 배열 선언과 동시에 초기화하는 경우 (배열에 할당될 값 정해진 게 대다수)
        int[] s = {80, 90, 100};                  // 이렇게 써도 알아먹는다
        int[] s1 = new int[]{80, 90, 100};       // 원래 정석 문법
        System.out.println("배열 크기: " + s.length);     //3
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i] + "\t");
        }
        System.out.println();

        double[] dd = {3.14, 10.5, 42.195, 50};
        for (int i = 0; i < dd.length; i++) {
            System.out.println(dd[i] + "\t");
        }

        char[] cc = {'j', 'a', 'v', 'a', 'c', 'd'};
        for (int i = 0; i < cc.length; i++) {
            System.out.println(cc[i] + "\t");
        }

        boolean[] bb = {true, false, true};
        for (int i = 0; i < bb.length; i++) {
            System.out.println(bb[i] + "\t");
        }

        String[] str1 = {"aa", "bb", "cc", "dd"};
        String[] str2 = new String[]{"aa", "bb", "cc", "dd"};   // 이게정석문법
        for (int i = 0; i < str1.length; i++) {
            System.out.println(str1[i] + "\t");
        }
        System.out.println();

// ============================================================================

        // 예제1 - 점수의 평균값을 소수점 둘째 자리까지 출력하기
        System.out.println("예제1");
        int[] score = {83, 90, 87};
        int sum = 0;
        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }
        double avg = (double) sum / 3.0;
        System.out.println("총합: " + sum + " 평균: " + avg);
        System.out.printf("총합: %d, 평균: %.2f", sum, avg);
        System.out.println();

// ============================================================================

        // 예제2 - 키보드로 5과목 점수 입력받아 총점 & 평균 구하기
        System.out.println("예제2");
        Scanner sc = new Scanner(System.in);
        int[] s2 = new int[5];
        System.out.println("5과목 점수 입력하기");

        int sum2 = 0;
        for (int i = 0; i < s2.length; i++) {
            s2[i] = sc.nextInt();
            sum2 += s2[i];
        }
        double avg2 = (double) sum2 / s2.length;
        System.out.printf("총점: %d, 평균: %.2f", sum2, avg2);
        System.out.println();

// ============================================================================

        // 예제3 - 배열에 저장된 데이터 중 최대 최소 구하기 (실수 ver)
        System.out.println("예제3");
        double[] data = {9.5, 7.0, 13.6, 7.5, 10.5};

        double max, min;

        max = data[0];
        min = data[0];

        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
            if (data[i] < min) {
                min = data[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println();

// ============================================================================

        // 예제4. 사용자 정의 메소드를 활용하여 누적합계 구하기
        System.out.println("예제4");

        int[] sss;
        sss = new int[]{83, 90, 87};

        // 기본 for문으로 구하면 이거고
        int sum1 = 0;
        for (int i = 0; i < sss.length; i++) {
            sum1 += sss[i];
        }
        System.out.println(sum1);

        // 사용자 정의 메소드 add를 사용하는 경우
        int sum22 = add(new int[]{83, 90, 87});
        System.out.println(sum22);

    }

    // add 메소드
    public static int add(int[] sss) {
        int sum= 0;
        for (int i=0; i<3; i++) {
            sum += sss[i];
        }
        return sum;

    }

}

